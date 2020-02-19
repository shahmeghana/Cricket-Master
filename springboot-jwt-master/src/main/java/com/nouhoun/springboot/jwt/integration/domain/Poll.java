package com.nouhoun.springboot.jwt.integration.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by mshah on 02/19/20.
 */
@Entity
@Table(name = "polls_rtab")
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "userid")
    private Long userId;
    
    @Column(name = "question")
    private String question;
    
    @Column(name = "report_count")
    private Long reportCount;
    
    @Column(name = "flag_count")
    private Long flagCount;
    
    @Column(name = "when_created")
    private Date whenCreated;
    
    @Column(name = "expiration")
    private Date expiration;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Long getReportCount() {
        return reportCount;
    }

    public void setReportCount(Long reportCount) {
        this.reportCount = reportCount;
    }
    
    
    public Long getFlagCount() {
        return flagCount;
    }

    public void setFlagCount(Long flagCount) {
        this.flagCount = flagCount;
    }
    
    public Date getWhenCreated() {
        return whenCreated;
    }

    public void setWhenCreated(Date whenCreated) {
        this.whenCreated = whenCreated;
    }
    
    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
}

