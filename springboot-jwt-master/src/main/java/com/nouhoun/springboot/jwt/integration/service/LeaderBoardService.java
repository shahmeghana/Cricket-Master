package com.nouhoun.springboot.jwt.integration.service;

import com.nouhoun.springboot.jwt.integration.util.Output;

public interface LeaderBoardService {
	Output getLeaderBoard();
	
	Output getFriendsLeaderBoard(String uid);
}
