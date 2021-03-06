package com.nouhoun.springboot.jwt.integration.service;

import com.nouhoun.springboot.jwt.integration.domain.Bet;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.util.Output;

import java.util.List;

/**
 * Created by mshah on 02/29/20.
 */
public interface BetService {
	Output saveBet(String uid, Long matchId, String teamId);

    Output deleteBet(String uid, Long matchId);

    Output getBets(String uid);

    List<Bet> convertsBets(User user);
}
