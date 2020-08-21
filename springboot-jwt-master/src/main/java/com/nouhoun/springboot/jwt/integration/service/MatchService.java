package com.nouhoun.springboot.jwt.integration.service;

import com.nouhoun.springboot.jwt.integration.domain.Match;
import com.nouhoun.springboot.jwt.integration.domain.TimeTable;
import com.nouhoun.springboot.jwt.integration.util.Output;

/**
 * Created by mshah on 02/29/20.
 */
public interface MatchService {  
    Output getTimeTable();
    
    Match getMatch(TimeTable timeTable);
}
