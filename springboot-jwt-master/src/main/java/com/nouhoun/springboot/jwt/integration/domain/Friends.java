package com.nouhoun.springboot.jwt.integration.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * Created by mshah on 02/19/20.
 */
@Entity
@Table(name = "friends_rtab")

public class Friends {
	@Column(name = "userid")
    private Long userId;
	
	@Column(name = "friendid")
    private Long friendId;
	
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }
}