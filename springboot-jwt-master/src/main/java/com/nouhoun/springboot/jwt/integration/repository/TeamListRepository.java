package com.nouhoun.springboot.jwt.integration.repository;

import com.nouhoun.springboot.jwt.integration.domain.TeamList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by mshah on 02/19/20.
 */
public interface TeamListRepository extends CrudRepository<TeamList, Long> {
	TeamList findByIdAndTournamentId(Long id, Long tournamentId);

    List<TeamList> findAll();

    String findNameByIdAndTournamentId(Long id, Long tournamentId);
	String findCodeNameByIdAndTournamentId(Long id, Long tournamentId);

}
