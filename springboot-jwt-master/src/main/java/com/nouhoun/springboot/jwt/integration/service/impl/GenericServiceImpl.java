package com.nouhoun.springboot.jwt.integration.service.impl;

import com.nouhoun.springboot.jwt.integration.domain.*;
import com.nouhoun.springboot.jwt.integration.repository.FriendsRepository;
import com.nouhoun.springboot.jwt.integration.repository.UserRepository;
import com.nouhoun.springboot.jwt.integration.service.BetService;
import com.nouhoun.springboot.jwt.integration.service.GenericService;
import com.nouhoun.springboot.jwt.integration.util.Output;
import com.nouhoun.springboot.jwt.integration.util.Output.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * Created by mshah on 03/13/20.
 */
@Service
public class GenericServiceImpl implements GenericService {
	@Autowired
    private UserRepository userRepository;
	@Autowired
	private FriendsRepository friendsRepository;
	@Autowired
	private BetService betService;

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

			UserDetails savedUser = userRepository.findByUid(userDetails.getUid());
			User suser = getUser(savedUser);
			List<Friends> followers = friendsRepository.findByFriendIdAndStatus(savedUser.getId(), 1);
			List<Friends> following = friendsRepository.findByUserIdAndStatus(savedUser.getId(), 1);
			Score score  = getScore(suser);

			Profile userProfile = new Profile();
			userProfile.setFollowers(followers.size());
			userProfile.setFollowing(following.size());
			userProfile.setScore(score.getScore());
			out.setResults("profile",userProfile);
        } catch (Exception e) {
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

                    for (UserDetails details : userDetails)
        			{
        				User friendUser = getUser(details);
        				Friends friend = friendsRepository.findByUserIdAndFriendId(user.getId(), details.getId());
        				if(friend != null && friend.getStatus() != 0)
        				{
        					friendUser.setFriend(true);
        				}

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
        if (user == null) {
            throw new Exception("User not found!");
        }

        // There was nothing wrong with initial code,
        // This was it just reduces the number of brackets

        List<User> users = new ArrayList<User>();
        int status = 1;
        List<Friends> friends = friendsRepository.findByUserIdAndStatus(user.getId(), status);
        for (Friends friend : friends) {
            Optional<UserDetails> frnd = userRepository.findById(friend.getFriendId());
            if (frnd.isPresent()) {
                User friendUser = getUser(frnd.get());
                friendUser.setFriend(true);

                users.add(friendUser);
            }
        }

		return users;
	}

    @Override
	public Score getScore(User user) {
		List<Bet> bets = betService.convertsBets(user);
		Long score = 0L;
		for(Bet bet : bets)
		{
			if(bet.getWin() == null)
			{
				continue;
			}
			if(bet.getWin() == true)
			{
				score++;
			}
			else if(bet.getWin() == false)
			{
				score--;
			}
		}
		Score newUser = new Score();
		newUser.setDisplayName(user.getDisplayName());
		newUser.setId(user.getId());
		newUser.setPhotoURL(user.getPhotoURL());
		newUser.setScore(score);
		return newUser;
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
