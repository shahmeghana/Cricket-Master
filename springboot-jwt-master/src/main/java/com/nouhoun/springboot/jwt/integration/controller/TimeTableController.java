package com.nouhoun.springboot.jwt.integration.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nouhoun.springboot.jwt.integration.service.MatchService;
import com.nouhoun.springboot.jwt.integration.util.Output;

/**
 * Created by mshah on 02/19/20.
 */
@RestController
@RequestMapping("/timetable")
public class TimeTableController {
    @Autowired
    private MatchService service;
    
    @GetMapping
    public ResponseEntity<Output> getTimeTableForToday(Date date){
    	Output out = service.getTimeTable();
    	return ResponseEntity.ok(out);
    }    
}
