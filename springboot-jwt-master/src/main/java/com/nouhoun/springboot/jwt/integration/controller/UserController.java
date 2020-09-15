package com.nouhoun.springboot.jwt.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nouhoun.springboot.jwt.integration.domain.Input;
import com.nouhoun.springboot.jwt.integration.domain.UserDetails;
import com.nouhoun.springboot.jwt.integration.service.GenericService;
import com.nouhoun.springboot.jwt.integration.util.Output;
import com.nouhoun.springboot.jwt.integration.util.Output.ResponseCode;

/**
 * Created by mshah on 19/02/20.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private GenericService service;
    
    @GetMapping("/fetchAll")
    public ResponseEntity<?> getUsers(){
    	Output out = service.findAllUsers();
    	if(out.getResponseCode() == ResponseCode.ERROR.getCode())
    	{
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(out);
    	}
    	return ResponseEntity.ok(out);
    }
       
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDetails user){
    	Output out = service.register(user);
    	if(out.getResponseCode() == ResponseCode.ERROR.getCode())
    	{
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(out);
    	}
    	return ResponseEntity.ok(out);
    }

    @PostMapping("/search")
    public ResponseEntity<?> searchUsers(@RequestBody Input input){
    	String uid = input.getUid();
    	String name  = input.getName();
    	Output out = service.searchUser(uid, name);
    	if(out.getResponseCode() == ResponseCode.ERROR.getCode())
    	{
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(out);
    	}
    	return ResponseEntity.ok(out);
    }
}
