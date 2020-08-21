package com.nouhoun.springboot.jwt.integration.service;

import com.nouhoun.springboot.jwt.integration.util.Output;

/**
 * Created by mshah on 02/29/20.
 */
public interface BetService {
	Output saveBet(String uid, Long matchId, String teamId);
	
	Output getBets(String uid);
}
