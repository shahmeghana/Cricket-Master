package com.nouhoun.springboot.jwt.integration.domain;

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
@Table(name = "publicchats_rtab")
public class PublicChats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "userid")
    private Long userId;
    
    @Column(name = "comments")
    private String comments;
    
    @Column(name = "report_count")
    private Long reportCount;
    
    @Column(name = "flag_count")
    private Long flagCount;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommenst() {
        return comments;
    }

    public void setCommenst(String comments) {
        this.comments = comments;
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
}

