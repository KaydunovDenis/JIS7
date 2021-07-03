package com.github.kaydunovDenis.model;


import com.github.kaydunovDenis.GenerateIntValue;
import com.github.kaydunovDenis.TimeFrameDefinition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculatorObject {

    @GenerateIntValue
    private Integer firstValue;

    @GenerateIntValue
    private Integer secondValue;

    @TimeFrameDefinition
    public Integer calculate() {
        return firstValue + secondValue;
    }

    @TimeFrameDefinition
    public Integer calculate(Integer firstValue, Integer secondValue) {
        return firstValue + secondValue;
    }
}
