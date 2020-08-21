package com.nouhoun.springboot.jwt.integration.service;

import java.util.List;

import com.nouhoun.springboot.jwt.integration.domain.UserDetails;
import com.nouhoun.springboot.jwt.integration.util.Output;

/**
 * Created by mshah on 02/29/20.
 */
public interface GenericService {

    List<UserDetails> findAllUsers();
        
    Output register(UserDetails user);    
    
    UserDetails findByUid(String uid);
}
