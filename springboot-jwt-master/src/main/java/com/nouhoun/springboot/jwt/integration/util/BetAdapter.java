package com.nouhoun.springboot.jwt.integration.util;

import com.nouhoun.springboot.jwt.integration.domain.Bet;
import com.nouhoun.springboot.jwt.integration.domain.Bets;
import com.nouhoun.springboot.jwt.integration.domain.Match;

public class BetAdapter {
	Bets bet;
	
	public BetAdapter(Bets bet)
	{
		this.bet = bet;
	}

	public Bet convertToBet(Match match)
	{
		Bet punt = new Bet();
		punt.setMatch(match);
		punt.setBetTeamCode(bet.getTeamCode());
		if(match.getWinner() != null)
		{
			if(match.getWinnerCode().equals(bet.getTeamCode()))
			{
				punt.setBetTeam(match.getWinner());
				punt.setWin(true);
			}
			else
			{
				punt.setWin(false);
			}
		}
		
		if(bet.getTeamCode().equals(match.getTeamCode1()))
		{
			punt.setBetTeam(match.getTeam1());
		}
		else if(bet.getTeamCode().equals(match.getTeamCode2()))
		{
			punt.setBetTeam(match.getTeam2());
		}
		
		return punt;
	}
}
