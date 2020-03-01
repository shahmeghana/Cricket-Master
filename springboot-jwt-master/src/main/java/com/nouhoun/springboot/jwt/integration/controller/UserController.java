package com.nouhoun.springboot.jwt.integration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.domain.UserDetails;
import com.nouhoun.springboot.jwt.integration.service.MatchService;
import com.nouhoun.springboot.jwt.integration.util.Output;

/**
 * Created by mshah on 02/19/20.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private MatchService service;
    
    @GetMapping("/fetchAll")
    public List<User> getUsers(){
    	return service.getUsers();
    }
       
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDetails user){
    	Output out = service.register(user);
    	return ResponseEntity.ok(out);
    }
    
    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
    	Output out = service.updateUser(user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getPhone());
    	return ResponseEntity.ok(out);
    }

}
