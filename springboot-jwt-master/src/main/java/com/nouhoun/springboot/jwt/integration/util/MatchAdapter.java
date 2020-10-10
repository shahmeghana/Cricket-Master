package com.nouhoun.springboot.jwt.integration.util;

import com.nouhoun.springboot.jwt.integration.domain.Match;
import com.nouhoun.springboot.jwt.integration.domain.TeamList;
import com.nouhoun.springboot.jwt.integration.domain.TimeTable;
import com.nouhoun.springboot.jwt.integration.domain.Tournament;

import java.util.Date;

public class MatchAdapter {

	private TimeTable timeTable;

    public MatchAdapter(TimeTable timeTable)
	{
		this.timeTable = timeTable;
	}

    public Match convertToMatch(TeamList team1, TeamList team2, Tournament tournament)
	{
		Match match  = new Match();
		match.setId(timeTable.getId());
		match.setMatchName(timeTable.getMatchName());
		match.setSeason(timeTable.getSeason());
		if(timeTable.getEventDate() != null)
		{
			match.setEventDate(timeTable.getEventDate());
		}
		match.setStadium(timeTable.getStadium());

        if(team1 != null && team1.getTeamName() != null)
		{
			match.setTeam1(team1.getTeamName());
			match.setTeamCode1(team1.getTeamCode());
		}

        if(team2 != null && team2.getTeamName() != null)
		{
			match.setTeam2(team2.getTeamName());
			match.setTeamCode2(team2.getTeamCode());
		}

        match.setTournament(tournament.getTournamentName());

        match.setTournamentDesc(tournament.getDescription());

		if(timeTable.getTeam1Id() != null && team1 != null && (timeTable.getTeam1Id()).equals(timeTable.getWinnerId()))
		{
			match.setWinner(team1.getTeamName());
			match.setWinnerCode(team1.getTeamCode());
		}
		else if(timeTable.getTeam2Id() != null && team2 != null && (timeTable.getTeam2Id()).equals(timeTable.getWinnerId()))
		{
			match.setWinner(team2.getTeamName());
			match.setWinnerCode(team2.getTeamCode());
		}
		else if(timeTable.getEventDate() != null && timeTable.getEventDate().before(new Date()))
		{
			match.setWinner("DRAW");
			match.setWinnerCode("Draw");
		}
		else
		{
			match.setWinner(null);
		}

        match.setIplid(timeTable.getIplid());
        match.setIpllabel(timeTable.getIpllabel());
        match.setIplname(timeTable.getIplname());

		return match;
	}

}
