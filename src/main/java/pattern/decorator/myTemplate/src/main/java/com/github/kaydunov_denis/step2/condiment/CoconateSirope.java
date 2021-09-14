package com.github.kaydunov_denis.step2.condiment;

import com.github.kaydunov_denis.step2.Beverage;

public class CoconateSirope extends CondimentDecorator {
    Beverage beverage;

    public CoconateSirope(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double getCost() {
        return 1;
    }
}
