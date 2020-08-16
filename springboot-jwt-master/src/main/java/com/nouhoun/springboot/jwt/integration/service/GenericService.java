package com.nouhoun.springboot.jwt.integration.service;

import java.util.List;

import com.nouhoun.springboot.jwt.integration.domain.UserDetails;
import com.nouhoun.springboot.jwt.integration.util.Output;

/**
 * Created by nydiarra on 06/05/17.
 */
public interface GenericService {

    List<UserDetails> findAllUsers();
        
    UserDetails saveUser(UserDetails user);

    Output register(UserDetails user);    
}
