package com.nouhoun.springboot.jwt.integration.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.nouhoun.springboot.jwt.integration.domain.Tournament;

/**
 * Created by mshah on 02/19/20.
 */
public interface TournamentReposiory extends CrudRepository<Tournament, Long> {
	Optional<Tournament> findById(Long id);
	
	String findNameById(Long id);
}
