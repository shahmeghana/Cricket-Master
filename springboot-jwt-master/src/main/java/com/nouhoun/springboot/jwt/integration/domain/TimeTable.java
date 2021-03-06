package com.nouhoun.springboot.jwt.integration.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mshah on 02/19/20.
 */
@Entity
@Table(name = "timetable_rtab")
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String matchName;

    @Column(name = "season")
    private String season;

    @Column(name = "tournamentid")
    private Long tournamentId;

    @Column(name = "stadium")
    private String stadium;

    private Date eventDate;

    @Column(name = "team1")
    private Long team1Id;

    @Column(name = "team2")
    private Long team2Id;

    @Column(name = "winnerid")
    private Long winnerId;

    @Column(name = "comment")
    private String comment;

    private String ipllabel;

    private String iplname;

    private Integer iplid;

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

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
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

    public Long getTeam1Id() {
        return team1Id;
    }

    public void setTeam1Id(Long team1Id) {
        this.team1Id = team1Id;
    }

    public Long getTeam2Id() {
        return team2Id;
    }

    public void setTeam2Id(Long team2Id) {
        this.team2Id = team2Id;
    }

    public Long getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(Long winnerId) {
        this.winnerId = winnerId;
    }

    public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

    public String getIpllabel() {
        return ipllabel;
    }

    public void setIpllabel(String ipllabel) {
        this.ipllabel = ipllabel;
    }

    public String getIplname() {
        return iplname;
    }

    public void setIplname(String iplname) {
        this.iplname = iplname;
    }

    public Integer getIplid() {
        return iplid;
    }

    public void setIplid(Integer iplid) {
        this.iplid = iplid;
    }
}

