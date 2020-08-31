package com.nouhoun.springboot.jwt.integration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nouhoun.springboot.jwt.integration.domain.UserDetails;
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

    @Override
    public List<UserDetails> findAllUsers() {
        return (List<UserDetails>)userRepository.findAll();
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
}
