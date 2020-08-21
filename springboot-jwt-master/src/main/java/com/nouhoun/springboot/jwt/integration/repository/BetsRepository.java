package com.nouhoun.springboot.jwt.integration.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nouhoun.springboot.jwt.integration.domain.Bets;

/**
 * Created by mshah on 02/19/20.
 */
public interface BetsRepository extends CrudRepository<Bets, Long> {
    List<Bets> findAllByUserId(Long userId);
    
    Bets findByUserIdAndMatchId(Long userId, Long matchId);
}
