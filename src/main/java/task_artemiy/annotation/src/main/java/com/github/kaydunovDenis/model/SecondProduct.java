package com.github.kaydunovDenis.model;

import com.github.kaydunovDenis.annotation.ValidateNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecondProduct {
    @ValidateNumber
    private int price;

    @ValidateNumber
    public Integer cost;
}
