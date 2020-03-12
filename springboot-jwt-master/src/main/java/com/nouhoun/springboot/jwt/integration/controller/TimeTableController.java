package com.nouhoun.springboot.jwt.integration.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nouhoun.springboot.jwt.integration.domain.Match;
import com.nouhoun.springboot.jwt.integration.domain.TimeTable;
import com.nouhoun.springboot.jwt.integration.service.MatchService;

/**
 * Created by mshah on 02/19/20.
 */
@RestController
@RequestMapping("/timetables")
public class TimeTableController {
    @Autowired
    private MatchService service;
    
    @GetMapping
    @RequestMapping("/today")
    public List<Match> getTimeTableForToday(Date date){
    	return service.getTimeTableForToday(date);
    }
    
    @GetMapping
    @RequestMapping("/history")
    public List<Match> getTimeTableHistory(Date date){
    	return service.getTimeTableHistory(date);
    }
    
    
    @PostMapping("/upcoming")
    public List<Match> getTimeTableUpcoming(Date date){
    	return service.getTimeTableUpcoming(date);
    }
    
}
