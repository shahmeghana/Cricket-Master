package com.nouhoun.springboot.jwt.integration.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nouhoun.springboot.jwt.integration.domain.Match;
import com.nouhoun.springboot.jwt.integration.domain.TeamList;
import com.nouhoun.springboot.jwt.integration.domain.TimeTable;
import com.nouhoun.springboot.jwt.integration.domain.Tournament;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.domain.UserDetails;
import com.nouhoun.springboot.jwt.integration.repository.SystemPropertyRepository;
import com.nouhoun.springboot.jwt.integration.repository.TeamListRepository;
import com.nouhoun.springboot.jwt.integration.repository.TimeTableRepository;
import com.nouhoun.springboot.jwt.integration.repository.TournamentReposiory;
import com.nouhoun.springboot.jwt.integration.repository.UserRepository;
import com.nouhoun.springboot.jwt.integration.service.MatchService;
import com.nouhoun.springboot.jwt.integration.util.MatchAdapter;
import com.nouhoun.springboot.jwt.integration.util.Output;
import com.nouhoun.springboot.jwt.integration.util.ResponseCode;

/**
 * Created by mshah on 03/08/20.
 */
@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TimeTableRepository timeTableRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
	TeamListRepository teamListRepository;
	@Autowired
	TournamentReposiory tournamentReposiory;
	@Autowired
	SystemPropertyRepository systemPropertyRepository;
	@Value("${cricket.punter.default.tournamentName}")
	private String tournamentName;
	@Value("${cricket.punter.default.tournamentDescription}")
	private String tournamentDescription;
	
    @Override
    public List<Match> getTimeTableForToday(Date date){
    	final List<Match> matches = new ArrayList<Match>();
    	List<TimeTable> timeTables = new ArrayList<TimeTable>();
    	if(date != null)
    	{
    		timeTables = timeTableRepository.findByEventDate(date);
    	}
    	timeTables = timeTableRepository.findByEventDate(new Date());
    	
    	for(TimeTable timeTable : timeTables)
    	{
    		TeamList team1 = teamListRepository.
    				findByIdAndTournamentId(timeTable.getTeam1Id(), timeTable.getTournamentId());
    		TeamList team2 = teamListRepository.
    				findByIdAndTournamentId(timeTable.getTeam2Id(), timeTable.getTournamentId());
    		
    		Optional<Tournament> tournament = tournamentReposiory.findById(timeTable.getTournamentId());
    		Tournament tournament1 = tournament.orElseGet(()->{Tournament tournament2 = new Tournament();
    									tournament2.setTournamentName(tournamentName);
    									tournament2.setDescription(tournamentDescription);
    									return tournament2;});
    		final MatchAdapter convertor = new MatchAdapter(timeTable);
    		final Match match = convertor.convertToMatch(team1,team2,tournament1);
    		matches.add(match);
    	}
    	
    	return matches;
    }

    @Override
    public List<Match> getTimeTableHistory(Date date){
    	final List<Match> matches = new ArrayList<Match>();
    	List<TimeTable> timeTables = new ArrayList<TimeTable>();
    	if(date != null)
    	{
    		timeTables = timeTableRepository.findAllByEventDateBefore(date);
    	}
    	timeTables = timeTableRepository.findAllByEventDateBefore(new Date());
    	
    	for(TimeTable timeTable : timeTables)
    	{
    		TeamList team1 = teamListRepository.
    				findByIdAndTournamentId(timeTable.getTeam1Id(), timeTable.getTournamentId());
    		TeamList team2 = teamListRepository.
    				findByIdAndTournamentId(timeTable.getTeam2Id(), timeTable.getTournamentId());
    		
    		Optional<Tournament> tournament = tournamentReposiory.findById(timeTable.getTournamentId());
    		Tournament tournament1 = tournament.orElseGet(()->{Tournament tournament2 = new Tournament();
    									tournament2.setTournamentName(tournamentName);
    									tournament2.setDescription(tournamentDescription);
    									return tournament2;});
    		final MatchAdapter convertor = new MatchAdapter(timeTable);
    		final Match match = convertor.convertToMatch(team1,team2,tournament1);
    		matches.add(match);
    	}
    	
    	return matches;
    }
 
    @Override
    public List<Match> getTimeTableUpcoming(Date date){
    	final List<Match> matches = new ArrayList<Match>();
    	List<TimeTable> timeTables = new ArrayList<TimeTable>();
    	if(date != null)
    	{
    		timeTables = timeTableRepository.findAllByEventDateAfter(date);
    	}
    	timeTables = timeTableRepository.findAllByEventDateAfter(new Date());
    	
    	for(TimeTable timeTable : timeTables)
    	{
    		TeamList team1 = teamListRepository.
    				findByIdAndTournamentId(timeTable.getTeam1Id(), timeTable.getTournamentId());
    		TeamList team2 = teamListRepository.
    				findByIdAndTournamentId(timeTable.getTeam2Id(), timeTable.getTournamentId());
    		
    		Optional<Tournament> tournament = tournamentReposiory.findById(timeTable.getTournamentId());
    		Tournament tournament1 = tournament.orElseGet(()->{Tournament tournament2 = new Tournament();
    									tournament2.setTournamentName(tournamentName);
    									tournament2.setDescription(tournamentDescription);
    									return tournament2;});
    		final MatchAdapter convertor = new MatchAdapter(timeTable);
    		final Match match = convertor.convertToMatch(team1,team2,tournament1);
    		matches.add(match);
    	}
    	
    	return matches;
    }

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public Output updateUser(String username, String password, String name, String email, String phone) {
    	Output out =  new Output();
		User user = findByUsername(username);
		if(password != null)
		{
	        String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
		}
		
		if(name != null)
		{
			user.setName(name);
		}
		
		if(email != null)
		{
			user.setEmail(email);
		}
		
		if(phone != null)
		{
			user.setPhone(phone);
		}
		
		try
		{
			saveUser(user);
	    	out.setResponseCode(ResponseCode.OK);
	    	out.setMessage("Profile saved successfully...");
		}
		catch(Exception e)
		{
			out.setMessage(e.getMessage());
			return out;
		}
		
		return out;
	}
	
	public User findByPhone(String phone) {
		return userRepository.findByPhone(phone);
	}

	@Override
	public Output register(UserDetails userDetails) {
		Output out =  new Output();
		
		if(userDetails.getUsername() == null)
		{
	    	out.setMessage("Invalid username...");
	    	return out;
		}
		User u = findByUsername(userDetails.getUsername());
		
		if(u != null)
		{
	    	out.setMessage("Username "+ userDetails.getUsername()+" already exist! Try another username.");
	    	return out;
		}
		
		if(userDetails.getPhone() == null)
		{
	    	out.setMessage("Invalid phone number...");
	    	return out;
		}
		u = findByPhone(userDetails.getPhone());
		
		if(u != null)
		{
	    	out.setMessage("User with number "+ userDetails.getPhone()+" already exist! Try another number.");
	    	return out;
		}
		
		if(userDetails.getName() != null && userDetails.getEmail() != null && userDetails.getPassword() != null)
		{
			try
			{
		        String encodedPassword = passwordEncoder.encode(userDetails.getPassword());
		        
		        User user = new User();
		        
		        user.setName(userDetails.getName());
		        user.setUsername(userDetails.getUsername());
		        user.setPassword(encodedPassword);
		        user.setEmail(userDetails.getEmail());
		        user.setPhone(userDetails.getPhone());

				saveUser(user);
				out.setResponseCode(ResponseCode.OK);
		    	out.setMessage("Profile created successfully...");
		    	return out;
			}
			catch(Exception e)
			{
		    	out.setMessage(e.getMessage());
		    	return out;
			}
		}
    	out.setMessage("Enter valid user details...");
    	return out;
	}
}
