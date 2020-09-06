package com.nouhoun.springboot.jwt.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nouhoun.springboot.jwt.integration.service.BetService;
import com.nouhoun.springboot.jwt.integration.util.Output;
import com.nouhoun.springboot.jwt.integration.util.Output.ResponseCode;

/**
 * Created by mshah on 02/19/20.
 */
@RestController
@RequestMapping("/bets")
public class BetsController {
   @Autowired
   BetService service;
   
   @GetMapping("/get")
   public ResponseEntity<Output> getBets(String uid){
	   Output out = service.getBets(uid);
	   if(out.getResponseCode() == ResponseCode.ERROR.getCode())
	   {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(out);
	   }
	   return ResponseEntity.ok(out);
   }
   
   @PostMapping("/save")
   public ResponseEntity<Output> saveBet(String uid, Long matchId, String teamCode){
	   Output out = service.saveBet(uid, matchId, teamCode);
	   if(out.getResponseCode() == ResponseCode.ERROR.getCode())
	   {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(out);
	   }
	   return ResponseEntity.ok(out);
   }
   
   @PostMapping("/delete")
   public ResponseEntity<Output> deleteBet(String uid, Long matchId){
	   Output out = service.deleteBet(uid, matchId);
	   if(out.getResponseCode() == ResponseCode.ERROR.getCode())
	   {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(out);
	   }
	   return ResponseEntity.ok(out);
   }
}
