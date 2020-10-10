package com.nouhoun.springboot.jwt.integration.domain;

import java.util.Date;

public class Match {
    private Long id;

    private String matchName;

    private String season;

    private String tournament;

    private String tournamentDesc;

    private String stadium;

    private Date eventDate;

    private String team1;

    private String teamCode1;

    private String team2;

    private String teamCode2;

    private String winnerCode;

    private String winner;

    private String comment;

    private String ipllabel;

    private Integer iplid;

    private String iplname;

    public String getIpllabel() {
        return ipllabel;
    }

    public void setIpllabel(String ipllabel) {
        this.ipllabel = ipllabel;
    }

    public Integer getIplid() {
        return iplid;
    }

    public void setIplid(Integer iplid) {
        this.iplid = iplid;
    }

    public String getIplname() {
        return iplname;
    }

    public void setIplname(String iplname) {
        this.iplname = iplname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getTournamentDesc() {
        return tournamentDesc;
    }

    public void setTournamentDesc(String tournamentDesc) {
        this.tournamentDesc = tournamentDesc;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeamCode1() {
        return teamCode1;
    }

    public void setTeamCode1(String teamCode1) {
        this.teamCode1 = teamCode1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getTeamCode2() {
        return teamCode2;
    }

    public void setTeamCode2(String teamCode2) {
        this.teamCode2 = teamCode2;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

	public String getWinnerCode() {
		return winnerCode;
	}

	public void setWinnerCode(String winnerCode) {
		this.winnerCode = winnerCode;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
