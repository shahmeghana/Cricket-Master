package com.nouhoun.springboot.jwt.integration.repository;

import com.nouhoun.springboot.jwt.integration.domain.TimeTable;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by mshah on 02/19/20.
 */
public interface TimeTableRepository extends CrudRepository<TimeTable, Long> {
    List<TimeTable> findAll();

    List<TimeTable> findByEventDateAfter(Date eventDate);
}
