package com.nouhoun.springboot.jwt.integration.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nouhoun.springboot.jwt.integration.domain.Bet;
import com.nouhoun.springboot.jwt.integration.domain.Bets;
import com.nouhoun.springboot.jwt.integration.domain.Match;
import com.nouhoun.springboot.jwt.integration.domain.TimeTable;
import com.nouhoun.springboot.jwt.integration.domain.UserDetails;
import com.nouhoun.springboot.jwt.integration.repository.BetsRepository;
import com.nouhoun.springboot.jwt.integration.repository.SystemPropertyRepository;
import com.nouhoun.springboot.jwt.integration.repository.TimeTableRepository;
import com.nouhoun.springboot.jwt.integration.service.BetService;
import com.nouhoun.springboot.jwt.integration.service.GenericService;
import com.nouhoun.springboot.jwt.integration.service.MatchService;
import com.nouhoun.springboot.jwt.integration.util.BetAdapter;
import com.nouhoun.springboot.jwt.integration.util.Output;
import com.nouhoun.springboot.jwt.integration.util.Output.ResponseCode;
import com.nouhoun.springboot.jwt.integration.util.Utility;
/**
 * Created by mshah on 20/08/20.
 */
@Service
public class BetServiceImpl implements BetService {
	private static final String BET_TIME = "BET_TIME";
	@Autowired
	private BetsRepository betsRepository;
	@Autowired
    private TimeTableRepository timeTableRepository;
	@Autowired
    private SystemPropertyRepository systemPropertiesRepository;
	@Autowired
	GenericService genericService;
	@Autowired
	MatchService matchService;
	
	@Override
	public Output saveBet(String uid, Long matchId, String teamCode) {
		Output out =  new Output();

		try
		{
			UserDetails user = genericService.findByUid(uid);
			if(user != null)
			{
				Optional<TimeTable> timeTable = timeTableRepository.findById(matchId);
				if(timeTable.isPresent())
				{
					Match match = matchService.getMatch(timeTable.get());
					int threshold = Integer.valueOf(systemPropertiesRepository.findValueByName(BET_TIME));
					if(match.getEventDate().before(Utility.addCalenderMinutes(match.getEventDate(), -threshold)))
					{
						throw new Exception("Cannot modify bet for old or ongoing matches!");
					}
				}
				Bets bet = betsRepository.findByUserIdAndMatchId(user.getId(), matchId);
				if(bet != null)
				{
					bet.setTeamCode(teamCode);
					betsRepository.save(bet);
				}
				else
				{
					Bets newBet = new Bets();
					newBet.setMatchId(matchId);
					newBet.setUserId(user.getId());
					newBet.setTeamCode(teamCode);
					betsRepository.save(newBet);
				}
			}
			else
			{
				throw new Exception("User not found!");
			}
		}
		catch(Exception e) 
		{ 
			out.setMessage(e.getMessage()); 
			return out;
		}
		
		 out.setResponseCode(ResponseCode.SUCCESS.getCode());
		 out.setMessage("Bet saved successfully..."); 
		 return out;
	}

	@Override
	public Output getBets(String uid) {
		Output out =  new Output();
		List<Bet> bets = new ArrayList<Bet>();
		try
		{
			UserDetails user = genericService.findByUid(uid);
			if(user != null)
			{
				List<Bets> allBets = betsRepository.findAllByUserId(user.getId());
				for(Bets bet : allBets)
				{
					Optional<TimeTable> timeTable = timeTableRepository.findById(bet.getMatchId());
					if(timeTable.isPresent())
					{
						Match match = matchService.getMatch(timeTable.get());
						final BetAdapter convertor = new BetAdapter(bet);
						final Bet punt = convertor.convertToBet(match);
						bets.add(punt);
					}
				}
			}
			else
			{
				throw new Exception("User not found!");
			}
		}
		catch(Exception e) 
		{ 
			out.setMessage(e.getMessage()); 
			return out;
		}
		
		 out.setResponseCode(ResponseCode.SUCCESS.getCode());
		 out.setMessage("All bet fetched..."); 
		 out.setResults("bets",bets);
		 return out;
	}

}
