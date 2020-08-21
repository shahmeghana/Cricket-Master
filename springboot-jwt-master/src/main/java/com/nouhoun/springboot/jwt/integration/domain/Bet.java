package com.nouhoun.springboot.jwt.integration.domain;

public class Bet {
   
    private Match match;
    
    private String betTeamCode;
    
    private String betTeam;

    private Boolean win = null;
	
	public Match getMatch() {
		return match;
	}
	
	public void setMatch(Match match) {
		this.match = match;
	}
	
	public String getBetTeam() {
		return betTeam;
	}
	
	public void setBetTeam(String betTeam) {
		this.betTeam = betTeam;
	}
	
    public String getBetTeamCode() {
		return betTeamCode;
	}
    
	public void setBetTeamCode(String betTeamCode) {
		this.betTeamCode = betTeamCode;
	}
	
	public Boolean getWin() {
		return win;
	}
	
	public void setWin(Boolean win) {
		this.win = win;
	}
}
