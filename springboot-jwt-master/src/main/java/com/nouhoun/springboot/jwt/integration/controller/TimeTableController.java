package com.nouhoun.springboot.jwt.integration.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nouhoun.springboot.jwt.integration.domain.TimeTable;
import com.nouhoun.springboot.jwt.integration.repository.TimeTableRepository;

/**
 * Created by mshah on 02/19/20.
 */
@RestController
@RequestMapping("/timetables")
public class TimeTableController {
    @Autowired
    private TimeTableRepository timeTableRepository;
    
    @GetMapping
    @RequestMapping("/today")
    public List<TimeTable> getTimeTableForToday(){
    	return timeTableRepository.findByEventDate(new Date());
    }
    
    @GetMapping
    @RequestMapping("/history")
    public List<TimeTable> getTimeTableHistory(){
    	return timeTableRepository.findAllByEventDateBefore(new Date());
    }
    
    @GetMapping
    @RequestMapping("/upcoming")
    public List<TimeTable> getTimeTableUpcoming(){
    	return timeTableRepository.findAllByEventDateAfter(new Date());
    }
    
}
