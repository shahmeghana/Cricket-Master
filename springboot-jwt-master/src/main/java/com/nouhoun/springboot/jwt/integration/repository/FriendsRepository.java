package com.nouhoun.springboot.jwt.integration.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nouhoun.springboot.jwt.integration.domain.Friends;

/**
 * Created by mshah on 02/19/20.
 */
public interface FriendsRepository extends CrudRepository<Friends, Long> {
    Friends findByUserIdAndFriendId(Long userId, Long friendId);
    
    List<Friends> findByUserIdAndStatus(Long userId, int status);
}

