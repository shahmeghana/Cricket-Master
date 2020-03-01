package com.nouhoun.springboot.jwt.integration.service;

import java.util.List;

import com.nouhoun.springboot.jwt.integration.domain.TimeTable;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.domain.UserDetails;
import com.nouhoun.springboot.jwt.integration.util.Output;

/**
 * Created by mshah on 02/29/20.
 */
public interface MatchService {  
    List<User> getUsers();
    
    User saveUser(User user);
    User findByUsername(String username);

    Output register(UserDetails user);
    Output updateUser(String username, String password, String name, String email, String phone);
    
    List<TimeTable> getTimeTableForToday();
    
    List<TimeTable> getTimeTableHistory();
    
    List<TimeTable> getTimeTableUpcoming();
}
