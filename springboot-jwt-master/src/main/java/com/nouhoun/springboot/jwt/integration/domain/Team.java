package com.nouhoun.springboot.jwt.integration.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * Created by mshah on 02/19/20.
 */
@Entity
@Table(name = "team_rtab")

public class Team {
	@Column(name = "teamid")
    private Long teamId;
	
	@Column(name = "playerid")
    private Long playerId;
	
    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
    
    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }
}