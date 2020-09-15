package com.nouhoun.springboot.jwt.integration.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nouhoun.springboot.jwt.integration.domain.Friends;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.domain.UserDetails;
import com.nouhoun.springboot.jwt.integration.repository.FriendsRepository;
import com.nouhoun.springboot.jwt.integration.repository.UserRepository;
import com.nouhoun.springboot.jwt.integration.service.GenericService;
import com.nouhoun.springboot.jwt.integration.util.Output;
import com.nouhoun.springboot.jwt.integration.util.Output.ResponseCode;
/**
 * Created by mshah on 03/13/20.
 */
@Service
public class GenericServiceImpl implements GenericService {
	@Autowired
    private UserRepository userRepository;
	@Autowired
	private FriendsRepository friendsRepository;

    @Override
    public Output findAllUsers() {
    	Output out = new Output();
    	try
		{
    		List<UserDetails> userDetails = (List<UserDetails>)userRepository.findAll();
    		out.setResults("users", userDetails);
		}
    	catch(Exception e)
    	{
			out.setMessage(e.getMessage()); 
			return out;
    	}
    	
    	out.setResponseCode(ResponseCode.SUCCESS.getCode());
    	out.setMessage("Fetched all users successfully");
        return out;
    }

	@Override
	public Output register(UserDetails userDetails) {
		Output out = new Output();
		try
		{
			UserDetails user = userRepository.findByUid(userDetails.getUid());
			if(user != null)
			{
				user.setDisplayName(userDetails.getDisplayName());
				user.setEmail(userDetails.getEmail());
				user.setEmailVerified(userDetails.getEmailVerified());
				user.setIsAnonymous(userDetails.getIsAnonymous());
				user.setPhoneNumber(userDetails.getPhoneNumber());
				user.setPhotoURL(userDetails.getPhotoURL());
				user.setProviderId(userDetails.getProviderId());
				user.setToken(userDetails.getToken());
				userRepository.save(user);
			}
			else
			{
				userRepository.save(userDetails);
			}
		}
		catch(Exception e) 
		{ 
			out.setMessage(e.getMessage()); 
			return out;
		}
		
		 out.setResponseCode(ResponseCode.SUCCESS.getCode());
		 out.setMessage("Profile created successfully..."); 
		 return out;
	}

	@Override
	public UserDetails findByUid(String uid) {
		UserDetails user = userRepository.findByUid(uid);
		return user;
	}

	@Override
	public Output searchUser(String uid, String name) {
    	Output out = new Output();
    	List<User> usersList = new ArrayList<User>();

    	try
		{
    		if(name != null && name != "")
    		{
    	    	List<UserDetails> userDetails = new ArrayList<UserDetails>();

    			userDetails.addAll(userRepository.findByDisplayNameLike("%"+name+"%"));
    			if(!userDetails.isEmpty())
    			{
    				UserDetails user = findByUid(uid);
        			userDetails.remove(user);
        			
        			for(UserDetails details : userDetails)
        			{
        				User friendUser = getUser(details);
    					usersList.add(friendUser);
        			}
    			}
    			List<User> users = new ArrayList<User>();
    			users.addAll(findFriends(uid));
    			
    			usersList.removeAll(users);
    			
    		}
    		out.setResults("users", usersList);
		}
    	catch(Exception e)
    	{
			out.setMessage(e.getMessage()); 
			return out;
    	}
    	
    	out.setResponseCode(ResponseCode.SUCCESS.getCode());
    	out.setMessage("Found users successfully");
        return out;
    }
	
	@Override
	public List<User> findFriends(String uid) throws Exception {
		UserDetails user = findByUid(uid);
		List<User> users = new ArrayList<User>();

		if(user != null)
		{ 
			List<Friends> friends = friendsRepository.findByUserId(user.getId());
			for(Friends friend : friends)
			{
				if(friend.getStatus() == 0)
				{
					continue;
				}
				Optional<UserDetails> frnd = userRepository.findById(friend.getFriendId());
				if(frnd.isPresent())
				{
					User friendUser = getUser(frnd.get());
					friendUser.setFriend(true);

					users.add(friendUser);
				}
			}
		}
		else
		{
			throw new Exception("User not found!");
		}
		
		return users;
	}

	@Override
	public User getUser(UserDetails user)
	{
		User usr = new User();
		usr.setDisplayName(user.getDisplayName());
		usr.setEmail(user.getEmail());
		usr.setId(user.getId());
		usr.setPhotoURL(user.getPhotoURL());
		return usr;
	}
}
