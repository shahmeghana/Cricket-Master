package com.nouhoun.springboot.jwt.integration.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nouhoun.springboot.jwt.integration.domain.Bet;
import com.nouhoun.springboot.jwt.integration.domain.Score;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.domain.UserDetails;
import com.nouhoun.springboot.jwt.integration.repository.SystemPropertyRepository;
import com.nouhoun.springboot.jwt.integration.repository.UserRepository;
import com.nouhoun.springboot.jwt.integration.service.BetService;
import com.nouhoun.springboot.jwt.integration.service.GenericService;
import com.nouhoun.springboot.jwt.integration.service.LeaderBoardService;
import com.nouhoun.springboot.jwt.integration.util.Output;
import com.nouhoun.springboot.jwt.integration.util.Output.ResponseCode;
/**
 * Created by mshah on 06/09/20.
 */
@Service
public class LeaderBoardServiceImpl implements LeaderBoardService {
	private static final String LEADERSBOARD = "LEADERSBOARD";
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private SystemPropertyRepository systemPropertiesRepository;
	@Autowired
	private BetService betService;
	@Autowired
	private GenericService service;
	
	@Override
	public Output getLeaderBoard() {
    	Output out = new Output();
    	List<Score> userScores = new ArrayList<Score>();
    	List<Score> scoreList = new ArrayList<Score>();
    	Long limit =  Long.valueOf(systemPropertiesRepository.findByName(LEADERSBOARD).getValue());
    	try
		{
    		List<UserDetails> userDetails = (List<UserDetails>)userRepository.findAll();
    		for(UserDetails user : userDetails)
    		{
    			User usr = service.getUser(user);
    			userScores.add(getScore(usr));
    		}
    		Collections.sort(userScores, scoreComparator());
    		
    		for(Score score : userScores)
    		{
    			if(scoreList.size() == limit)
    			{
    				break;
    			}
    			
    			scoreList.add(score);
    		}
    		
    		out.setResults("leadersBoard", scoreList);
		}
    	catch(Exception e)
    	{
			out.setMessage(e.getMessage()); 
			return out;
    	}
    	
    	out.setResponseCode(ResponseCode.SUCCESS.getCode());
    	out.setMessage("LeaderBoard fetched successfully");
        return out;
    }

	private Score getScore(User user) {
		List<Bet> bets = betService.convertsBets(user);
		Long score = 0L;
		for(Bet bet : bets)
		{
			if(bet.getWin() == true)
			{
				score++;
			}
			else if(bet.getWin() == false)
			{
				score--;
			}
		}
		Score newUser = new Score();
		newUser.setDisplayName(user.getDisplayName());
		newUser.setId(user.getId());
		newUser.setPhotoURL(user.getPhotoURL());
		newUser.setScore(score);
		return newUser;
	}

	private Comparator<Score> scoreComparator() {
		return new Comparator<Score>() {
			@Override
			public int compare(Score s1, Score s2) {
				int c;
				c = s2.score.compareTo(s1.score);
				if(c == 0)
				{
					c = s1.displayName.compareTo(s2.displayName);
				}
				return c;
			}
		};
	}

	@Override
	public Output getFriendsLeaderBoard(String uid) {
    	Output out = new Output();
    	List<Score> userScores = new ArrayList<Score>();
    	List<Score> scoreList = new ArrayList<Score>();
    	Long limit =  Long.valueOf(systemPropertiesRepository.findByName(LEADERSBOARD).getValue());
    	try
		{
    		List<User> userDetails = service.findFriends(uid);
    		for(User user : userDetails)
    		{
    			userScores.add(getScore(user));
    		}
    		Collections.sort(userScores, scoreComparator());
    		
    		for(Score score : userScores)
    		{
    			if(scoreList.size() == limit)
    			{
    				break;
    			}
    			
    			scoreList.add(score);
    		}
    		
    		out.setResults("leadersBoard", scoreList);
		}
    	catch(Exception e)
    	{
			out.setMessage(e.getMessage()); 
			return out;
    	}
    	
    	out.setResponseCode(ResponseCode.SUCCESS.getCode());
    	out.setMessage("Friends LeaderBoard fetched successfully");
        return out;
    }

}
