package com.intelliFitHub.fitness.common.user.service;

import com.intelliFitHub.fitness.common.dao.domain.TdeeCalculator;

public interface CalculationService {
    int CalculateTDEE(TdeeCalculator tdeeCalculator) throws Exception;
}
