package com.github.kaydunovDenis.model;


import com.github.kaydunovDenis.GenerateIntValue;
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
}
