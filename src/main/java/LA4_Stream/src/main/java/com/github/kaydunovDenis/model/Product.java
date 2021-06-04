package com.github.kaydunovDenis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String name;
    private double price;
    private double discount;

    @Override
    public String toString() {
        return String.format("%15s   price=%5.2f   discount=%3.2f%%", name, price, discount);
    }
}
