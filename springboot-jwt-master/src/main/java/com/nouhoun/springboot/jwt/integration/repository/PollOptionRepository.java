package com.nouhoun.springboot.jwt.integration.repository;

import org.springframework.data.repository.CrudRepository;
import com.nouhoun.springboot.jwt.integration.domain.PollOption;

/**
 * Created by mshah on 02/19/20.
 */
public interface PollOptionRepository extends CrudRepository<PollOption, Long> {
    
}
