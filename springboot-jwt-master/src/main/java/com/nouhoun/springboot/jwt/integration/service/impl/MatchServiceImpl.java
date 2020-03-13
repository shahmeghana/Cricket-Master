package com.nouhoun.springboot.jwt.integration.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nouhoun.springboot.jwt.integration.domain.Match;
import com.nouhoun.springboot.jwt.integration.domain.TeamList;
import com.nouhoun.springboot.jwt.integration.domain.TimeTable;
import com.nouhoun.springboot.jwt.integration.domain.Tournament;
import com.nouhoun.springboot.jwt.integration.repository.SystemPropertyRepository;
import com.nouhoun.springboot.jwt.integration.repository.TeamListRepository;
import com.nouhoun.springboot.jwt.integration.repository.TimeTableRepository;
import com.nouhoun.springboot.jwt.integration.repository.TournamentReposiory;
import com.nouhoun.springboot.jwt.integration.service.MatchService;
import com.nouhoun.springboot.jwt.integration.util.MatchAdapter;

/**
 * Created by mshah on 03/08/20.
 */
@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private TimeTableRepository timeTableRepository;
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
}
