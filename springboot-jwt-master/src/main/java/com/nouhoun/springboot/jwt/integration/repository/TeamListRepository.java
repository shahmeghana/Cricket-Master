package com.nouhoun.springboot.jwt.integration.repository;

import org.springframework.data.repository.CrudRepository;
import com.nouhoun.springboot.jwt.integration.domain.TeamList;

/**
 * Created by mshah on 02/19/20.
 */
public interface TeamListRepository extends CrudRepository<TeamList, Long> {
	TeamList findByIdAndTournamentId(Long id, Long tournamentId);
	
	String findNameByIdAndTournamentId(Long id, Long tournamentId);
	String findCodeNameByIdAndTournamentId(Long id, Long tournamentId);

}
