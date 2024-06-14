package com.intelliFitHub.fitness.common.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.intelliFitHub.fitness.common.dao.domain.TdeeCalculator;
import com.intelliFitHub.fitness.common.user.service.CalculationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/calculate-tdee")
public class CalculateTdeeController {
    @Autowired
    protected CalculationService calculationService;

    @PostMapping
    public ResponseEntity<Object> delete(TdeeCalculator tdeeCalculator) throws Exception {
        log.info("*** Calculating TDEE ***");
        int result = calculationService.CalculateTDEE(tdeeCalculator);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
