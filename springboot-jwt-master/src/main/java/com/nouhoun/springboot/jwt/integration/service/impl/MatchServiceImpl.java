package com.nouhoun.springboot.jwt.integration.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nouhoun.springboot.jwt.integration.domain.TimeTable;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.domain.UserDetails;
import com.nouhoun.springboot.jwt.integration.repository.TimeTableRepository;
import com.nouhoun.springboot.jwt.integration.repository.UserRepository;
import com.nouhoun.springboot.jwt.integration.service.MatchService;
import com.nouhoun.springboot.jwt.integration.util.Output;
import com.nouhoun.springboot.jwt.integration.util.ResponseCode;

/**
 * Created by mshah on 02/29/20.
 */
@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TimeTableRepository timeTableRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public List<TimeTable> getTimeTableForToday(){
    	return timeTableRepository.findByEventDate(new Date());
    }

    @Override
    public List<TimeTable> getTimeTableHistory(){
    	return timeTableRepository.findAllByEventDateBefore(new Date());
    }
 
    @Override
    public List<TimeTable> getTimeTableUpcoming(){
    	return timeTableRepository.findAllByEventDateAfter(new Date());
    }

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public Output updateUser(String username, String password, String name, String email, String phone) {
    	Output out =  new Output();
		User user = findByUsername(username);
		if(password != null)
		{
	        String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
		}
		
		if(name != null)
		{
			user.setName(name);
		}
		
		if(email != null)
		{
			user.setEmail(email);
		}
		
		if(phone != null)
		{
			user.setPhone(phone);
		}
		
		try
		{
			saveUser(user);
	    	out.setResponseCode(ResponseCode.OK);
	    	out.setMessage("Profile saved successfully...");
		}
		catch(Exception e)
		{
			out.setMessage(e.getMessage());
			return out;
		}
		
		return out;
	}
	
	public User findByPhone(String phone) {
		return userRepository.findByPhone(phone);
	}

	@Override
	public Output register(UserDetails userDetails) {
		Output out =  new Output();
		
		if(userDetails.getUsername() == null)
		{
	    	out.setMessage("Invalid username...");
	    	return out;
		}
		User u = findByUsername(userDetails.getUsername());
		
		if(u != null)
		{
	    	out.setMessage("Username "+ userDetails.getUsername()+" already exist! Try another username.");
	    	return out;
		}
		
		if(userDetails.getPhone() == null)
		{
	    	out.setMessage("Invalid phone number...");
	    	return out;
		}
		u = findByPhone(userDetails.getPhone());
		
		if(u != null)
		{
	    	out.setMessage("User with number "+ userDetails.getPhone()+" already exist! Try another number.");
	    	return out;
		}
		
		if(userDetails.getName() != null && userDetails.getEmail() != null && userDetails.getPassword() != null)
		{
			try
			{
		        String encodedPassword = passwordEncoder.encode(userDetails.getPassword());
		        
		        User user = new User();
		        
		        user.setName(userDetails.getName());
		        user.setUsername(userDetails.getUsername());
		        user.setPassword(encodedPassword);
		        user.setEmail(userDetails.getEmail());
		        user.setPhone(userDetails.getPhone());

				saveUser(user);
				out.setResponseCode(ResponseCode.OK);
		    	out.setMessage("Profile created successfully...");
		    	return out;
			}
			catch(Exception e)
			{
		    	out.setMessage(e.getMessage());
		    	return out;
			}
		}
    	out.setMessage("Enter valid user details...");
    	return out;
	}
}
