package com.nouhoun.springboot.jwt.integration.service;

import java.util.List;

import com.nouhoun.springboot.jwt.integration.domain.UserDetails;
import com.nouhoun.springboot.jwt.integration.util.Output;

/**
 * Created by mshah on 30/08/20.
 */
public interface FriendService {
	Output followFriend(String uid, long id);
	
	Output unfollowFriend(String uid, long id);
	
	Output getFriends(String uid);
	
	List<UserDetails> findFriends(String uid) throws Exception;
}
