package com.github.kaydunov_denis.step2.condiment;

import com.github.kaydunov_denis.step2.Beverage;

public class Water extends CondimentDecorator {
    Beverage beverage;

    @Override
    public double getCost() {
        return beverage.getCost() + 0.1;
    }
}
