package com.nouhoun.springboot.jwt.integration.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.nouhoun.springboot.jwt.integration.domain.User;

/**
 * Created by mshah on 02/19/20.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
	
	List<User> findAll();
}
