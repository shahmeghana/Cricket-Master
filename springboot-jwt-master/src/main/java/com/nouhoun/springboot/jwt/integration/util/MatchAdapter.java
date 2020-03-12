package com.nouhoun.springboot.jwt.integration.util;

import java.util.Date;

import com.nouhoun.springboot.jwt.integration.domain.Match;
import com.nouhoun.springboot.jwt.integration.domain.TeamList;
import com.nouhoun.springboot.jwt.integration.domain.TimeTable;
import com.nouhoun.springboot.jwt.integration.domain.Tournament;

public class MatchAdapter {
	
	private TimeTable timeTable;
	
	public MatchAdapter(TimeTable timeTable)
	{
		this.timeTable = timeTable;
	}
	
	public Match convertToMatch(TeamList team1, TeamList team2, Tournament tournament)
	{
		final Match match  = new Match();
		match.setId(timeTable.getId());
		match.setMatchName(timeTable.getMatchName());
		match.setSeason(timeTable.getSeason());
		match.setEventDate(timeTable.getEventDate());
		match.setStadium(timeTable.getStadium());
		
		match.setTeam1(team1.getTeamName());
		
		match.setTeam2(team2.getTeamName());
		
		match.setTeamCode1(team1.getTeamCode());
		
		match.setTeamCode2(team2.getTeamCode());
		
		match.setTournament(tournament.getTournamentName());
		
		match.setTournamentDesc(tournament.getDescription());

		if((timeTable.getTeam1Id()).equals(timeTable.getWinnerId()))
		{
			match.setWinner(team1.getTeamName());
		}
		else if((timeTable.getTeam2Id()).equals(timeTable.getWinnerId()))
		{
			match.setWinner(team2.getTeamName());
		}
		else if(timeTable.getEventDate().before(new Date()))
		{
			match.setWinner("DRAW");
		}
		else
		{
			match.setWinner(null);
		}

		return match;
	}

}
