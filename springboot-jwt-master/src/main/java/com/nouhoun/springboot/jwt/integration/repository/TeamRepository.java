package com.nouhoun.springboot.jwt.integration.repository;

import org.springframework.data.repository.CrudRepository;
import com.nouhoun.springboot.jwt.integration.domain.Team;

/**
 * Created by mshah on 02/19/20.
 */
public interface TeamRepository extends CrudRepository<Team, Long> {
    
}