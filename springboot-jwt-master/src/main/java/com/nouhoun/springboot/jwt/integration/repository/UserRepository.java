package com.nouhoun.springboot.jwt.integration.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.nouhoun.springboot.jwt.integration.domain.UserDetails;

/**
 * Created by mshah on 02/19/20.
 */
public interface UserRepository extends CrudRepository<UserDetails, Long> {
	UserDetails findByUid(String uid);
	Optional<UserDetails> findById(Long id);
	List<UserDetails> findAll();
}
