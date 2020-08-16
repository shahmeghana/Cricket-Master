package com.nouhoun.springboot.jwt.integration.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nouhoun.springboot.jwt.integration.domain.TimeTable;

/**
 * Created by mshah on 02/19/20.
 */
public interface TimeTableRepository extends CrudRepository<TimeTable, Long> {
    List<TimeTable> findAll();
}
