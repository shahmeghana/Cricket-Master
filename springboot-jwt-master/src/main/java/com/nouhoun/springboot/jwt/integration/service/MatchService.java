package com.nouhoun.springboot.jwt.integration.service;

import java.util.Date;
import java.util.List;

import com.nouhoun.springboot.jwt.integration.domain.Match;

/**
 * Created by mshah on 02/29/20.
 */
public interface MatchService {  
    List<Match> getTimeTableForToday(Date date);
    
    List<Match> getTimeTableHistory(Date date);
    
    List<Match> getTimeTableUpcoming(Date date);
}
