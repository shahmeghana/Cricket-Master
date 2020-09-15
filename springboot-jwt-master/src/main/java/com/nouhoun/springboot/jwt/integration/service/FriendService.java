package com.nouhoun.springboot.jwt.integration.service;

import com.nouhoun.springboot.jwt.integration.util.Output;

/**
 * Created by mshah on 30/08/20.
 */
public interface FriendService {
	Output followFriend(String uid, long id);
	
	Output unfollowFriend(String uid, long id);
	
	Output getFriends(String uid);
}
