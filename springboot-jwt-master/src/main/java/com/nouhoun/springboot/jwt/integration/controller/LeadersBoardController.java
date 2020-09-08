package com.nouhoun.springboot.jwt.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nouhoun.springboot.jwt.integration.service.LeaderBoardService;
import com.nouhoun.springboot.jwt.integration.util.Output;
import com.nouhoun.springboot.jwt.integration.util.Output.ResponseCode;

/**
 * Created by mshah on 06/09/20.
 */
@RestController
@RequestMapping("/leaderboard")
public class LeadersBoardController {
   @Autowired
   LeaderBoardService service;
   
   @GetMapping("/getGlobal")
   public ResponseEntity<Output> getLeaderBoard(){
	   Output out = service.getLeaderBoard();
	   if(out.getResponseCode() == ResponseCode.ERROR.getCode())
	   {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(out);
	   }
	   return ResponseEntity.ok(out);
   }
   
   @GetMapping("/getFriends")
   public ResponseEntity<Output> getFriendsLeaderBoard(@RequestParam String uid){
	   Output out = service.getFriendsLeaderBoard(uid);
	   if(out.getResponseCode() == ResponseCode.ERROR.getCode())
	   {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(out);
	   }
	   return ResponseEntity.ok(out);
   }
}
