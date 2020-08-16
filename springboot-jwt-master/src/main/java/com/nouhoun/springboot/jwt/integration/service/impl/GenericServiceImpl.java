package com.nouhoun.springboot.jwt.integration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nouhoun.springboot.jwt.integration.domain.UserDetails;
import com.nouhoun.springboot.jwt.integration.repository.UserRepository;
import com.nouhoun.springboot.jwt.integration.service.GenericService;
import com.nouhoun.springboot.jwt.integration.util.Output;
/**
 * Created by mshah on 03/13/20.
 */
@Service
public class GenericServiceImpl implements GenericService {
	@Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDetails> findAllUsers() {
        return (List<UserDetails>)userRepository.findAll();
    }


	@Override
	public UserDetails saveUser(UserDetails user) {
		return userRepository.save(user);
	}

	@Override
	public Output register(UserDetails userDetails) {
		return null;
		/*
		 * Output out = new Output();
		 * 
		 * if(userDetails.getUsername() == null) {
		 * out.setMessage("Invalid username..."); return out; } User u =
		 * findByUsername(userDetails.getUsername());
		 * 
		 * if(u != null) { out.setMessage("Username "+
		 * userDetails.getUsername()+" already exist! Try another username."); return
		 * out; }
		 * 
		 * if(userDetails.getPhone() == null) {
		 * out.setMessage("Invalid phone number..."); return out; } u =
		 * findByPhone(userDetails.getPhone());
		 * 
		 * if(u != null) { out.setMessage("User with number "+
		 * userDetails.getPhone()+" already exist! Try another number."); return out; }
		 * 
		 * if(userDetails.getName() != null && userDetails.getEmail() != null &&
		 * userDetails.getPassword() != null) { try { String encodedPassword =
		 * passwordEncoder.encode(userDetails.getPassword());
		 * 
		 * User user = new User();
		 * 
		 * user.setName(userDetails.getName());
		 * user.setUsername(userDetails.getUsername());
		 * user.setPassword(encodedPassword); user.setEmail(userDetails.getEmail());
		 * user.setPhone(userDetails.getPhone());
		 * 
		 * saveUser(user); out.setResponseCode(ResponseCode.SUCCESS.getCode());
		 * out.setMessage("Profile created successfully..."); return out; }
		 * catch(Exception e) { out.setMessage(e.getMessage()); return out; } }
		 * out.setMessage("Enter valid user details..."); return out;
		 */}
}
