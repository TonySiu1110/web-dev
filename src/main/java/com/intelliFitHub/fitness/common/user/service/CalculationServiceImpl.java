package com.intelliFitHub.fitness.common.user.service;

import org.springframework.stereotype.Service;

import com.intelliFitHub.fitness.common.dao.domain.TdeeCalculator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CalculationServiceImpl implements CalculationService {

    @Override
    public int CalculateTDEE(TdeeCalculator tdeeCalculator) throws Exception {
        try {
            double weight = tdeeCalculator.getWeight();
            double height = tdeeCalculator.getHeight();
            int age = tdeeCalculator.getAge();
            String gender = tdeeCalculator.getGender();
            double activityLevel = tdeeCalculator.getActivityLevel();
            String unitSystem = tdeeCalculator.getUnitSystem();

            // Convert weight to kilograms if it's in imperial units (pounds)
            if ("imperial".equals(unitSystem)) {
                weight *= 0.453592; // 1 pound = 0.453592 kilograms
            }

            // Convert height to centimeters if it's in imperial units (inches)
            if ("imperial".equals(unitSystem)) {
                height *= 2.54; // 1 inch = 2.54 centimeters
            }

            // Calculate BMR using the Mifflin-St Jeor equation based on gender
            double bmr = 0;
            if ("male".equals(gender)) {
                bmr = 10 * weight + 6.25 * height - 5 * age + 5;
            } else if ("female".equals(gender)) {
                bmr = 10 * weight + 6.25 * height - 5 * age - 161;
            }

            // Calculate TDEE by multiplying BMR with the activity level
            double tdee = bmr * activityLevel;

            // Log the calculated TDEE
            // String logMessage = String.format("Weight: %.2f, Height: %.2f, Age: %d,
            // Gender: %s, Activity Level: %.3f, Unit System: %s, TDEE: %.2f",
            // weight, height, age, gender, activityLevel, unitSystem, tdee);

            // log.info(logMessage);

            return (int) Math.round(tdee);
        } catch (Exception e) {
            log.error("Error while calculating TDEE: {}", e.getMessage());
            throw e;
        }
    }
}
