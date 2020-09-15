package com.nouhoun.springboot.jwt.integration.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nouhoun.springboot.jwt.integration.domain.Friends;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.domain.UserDetails;
import com.nouhoun.springboot.jwt.integration.repository.FriendsRepository;
import com.nouhoun.springboot.jwt.integration.service.FriendService;
import com.nouhoun.springboot.jwt.integration.service.GenericService;
import com.nouhoun.springboot.jwt.integration.util.Output;
import com.nouhoun.springboot.jwt.integration.util.Output.ResponseCode;
/**
 * Created by mshah on 30/08/20.
 */

@Service
public class FriendServiceImpl implements FriendService {
	@Autowired
	private FriendsRepository friendsRepository;
	@Autowired
	private GenericService genericService;
	
	@Override
	public Output followFriend(String uid, long id) {
		Output out =  new Output();
		try
		{
			UserDetails user = genericService.findByUid(uid);
			if(user != null)
			{
				Friends friend = friendsRepository.findByUserIdAndFriendId(user.getId(), id);
				if(friend.getId() != null)
				{
					friend.setStatus(1);
				}
				else
				{
					friend = new Friends();
					friend.setUserId(user.getId());
					friend.setFriendId(id);
					friend.setStatus(1);
				}

				friendsRepository.save(friend);
			}
			else
			{
				throw new Exception("User not found!");
			}
		}
		catch(Exception e) 
		{ 
			out.setMessage(e.getMessage()); 
			return out;
		}
		
		 out.setResponseCode(ResponseCode.SUCCESS.getCode());
		 out.setMessage("Following successfully..."); 
		 return out;
	}

	@Override
	public Output unfollowFriend(String uid, long id) {
		Output out =  new Output();
		try
		{
			UserDetails user = genericService.findByUid(uid);
			if(user != null)
			{
				Friends friend = friendsRepository.findByUserIdAndFriendId(user.getId(), id);
				friend.setStatus(0);
				friendsRepository.save(friend);
			}
			else
			{
				throw new Exception("User not found!");
			}
		}
		catch(Exception e) 
		{ 
			out.setMessage(e.getMessage()); 
			return out;
		}
		
		 out.setResponseCode(ResponseCode.SUCCESS.getCode());
		 out.setMessage("Unfollowed successfully..."); 
		 return out;
	}

	@Override
	public Output getFriends(String uid) {
		Output out =  new Output();
		List<User> users = new ArrayList<User>();
		try
		{
			users.addAll(genericService.findFriends(uid));
		}
		catch(Exception e) 
		{ 
			out.setMessage(e.getMessage()); 
			return out;
		}
		
		 out.setResponseCode(ResponseCode.SUCCESS.getCode());
		 out.setMessage("Fetched all friends successfully...");
		 out.setResults("friends",users);
		 return out;
	}

}
