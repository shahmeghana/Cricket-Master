package com.nouhoun.springboot.jwt.integration.repository;

import org.springframework.data.repository.CrudRepository;
import com.nouhoun.springboot.jwt.integration.domain.Friends;

/**
 * Created by mshah on 02/19/20.
 */
public interface FriendsRepository extends CrudRepository<Friends, Long> {
    
}

