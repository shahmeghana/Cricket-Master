package com.nouhoun.springboot.jwt.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nouhoun.springboot.jwt.integration.domain.Input;
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
   
   @GetMapping
   public ResponseEntity<Output> getBets(@RequestParam String uid){
	   Output out = service.getBets(uid);
	   if(out.getResponseCode() == ResponseCode.ERROR.getCode())
	   {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(out);
	   }
	   return ResponseEntity.ok(out);
   }
   
   @PostMapping
   public ResponseEntity<Output> saveBet(@RequestBody Input input){
	   String uid = input.getUid();
	   Long matchId = input.getMatchId();
	   String teamCode = input.getTeamCode();
	   Output out = service.saveBet(uid, matchId, teamCode);
	   if(out.getResponseCode() == ResponseCode.ERROR.getCode())
	   {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(out);
	   }
	   return ResponseEntity.ok(out);
   }
   
   @DeleteMapping
   public ResponseEntity<Output> deleteBet(@RequestBody Input input){
	   String uid = input.getUid();
	   Long matchId = input.getMatchId();
	   Output out = service.deleteBet(uid, matchId);
	   if(out.getResponseCode() == ResponseCode.ERROR.getCode())
	   {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(out);
	   }
	   return ResponseEntity.ok(out);
   }
}
