package com.intelliFitHub.fitness.common.dao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class TdeeCalculator {
    private double weight;
    private double height;
    private int age;
    private String gender;
    private double activityLevel;
    private String unitSystem;

}
