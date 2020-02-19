package com.nouhoun.springboot.jwt.integration.repository;

import org.springframework.data.repository.CrudRepository;
import com.nouhoun.springboot.jwt.integration.domain.SystemProperty;

/**
 * Created by mshah on 02/19/20.
 */
public interface SystemPropertyRepository extends CrudRepository<SystemProperty, Long> {
    
}
