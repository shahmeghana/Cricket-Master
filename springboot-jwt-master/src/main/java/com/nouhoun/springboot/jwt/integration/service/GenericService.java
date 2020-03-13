package com.nouhoun.springboot.jwt.integration.service;

import java.util.List;

import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.domain.UserDetails;
import com.nouhoun.springboot.jwt.integration.util.Output;

/**
 * Created by nydiarra on 06/05/17.
 */
public interface GenericService {
    User findByUsername(String username);

    List<User> findAllUsers();
    
    List<User> getUsers();
    
    User saveUser(User user);

    Output register(UserDetails user);
    
    Output updateUser(String username, String password, String name, String email, String phone);
}
