package com.nouhoun.springboot.jwt.integration.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * Created by mshah on 02/19/20.
 */
@Entity
@Table(name = "portfolio_rtab")

public class Portfolio {
	@Column(name = "userid")
    private Long userId;
	
	@Column(name = "eventid")
    private Long eventId;
	
	@Column(name = "eventtype")
    private String eventType;
   
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

}