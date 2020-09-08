package com.nouhoun.springboot.jwt.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nouhoun.springboot.jwt.integration.domain.Input;
import com.nouhoun.springboot.jwt.integration.service.FriendService;
import com.nouhoun.springboot.jwt.integration.util.Output;
import com.nouhoun.springboot.jwt.integration.util.Output.ResponseCode;

/**
 * Created by mshah on 30/08/20.
 */
@RestController
@RequestMapping("/friends")
public class FriendsController {
   @Autowired
   FriendService service;
   
   @GetMapping("/get")
   public ResponseEntity<Output> getFriends(@RequestParam String uid){
	   Output out = service.getFriends(uid);
	   if(out.getResponseCode() == ResponseCode.ERROR.getCode())
	   {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(out);
	   }
	   return ResponseEntity.ok(out);
   }
   
   @PostMapping("/follow")
   public ResponseEntity<Output> followFriends(@RequestBody Input input){
	   String uid = input.getUid();
	   Long id = input.getId();
	   Output out = service.followFriend(uid, id);
	   if(out.getResponseCode() == ResponseCode.ERROR.getCode())
	   {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(out);
	   }
	   return ResponseEntity.ok(out);
   }
   
   @PostMapping("/unfollow")
   public ResponseEntity<Output> unfollowFriends(@RequestBody Input input){
	   String uid = input.getUid();
	   Long id = input.getId();
	   Output out = service.unfollowFriend(uid, id);;
	   if(out.getResponseCode() == ResponseCode.ERROR.getCode())
	   {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(out);
	   }
	   return ResponseEntity.ok(out);
   }
}
