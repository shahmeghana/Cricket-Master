package com.nouhoun.springboot.jwt.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nouhoun.springboot.jwt.integration.repository.BetsRepository;

/**
 * Created by mshah on 02/19/20.
 */
@RestController
@RequestMapping("/bets")
public class BetsController {
    @Autowired
    private BetsRepository betsRepository;

}
