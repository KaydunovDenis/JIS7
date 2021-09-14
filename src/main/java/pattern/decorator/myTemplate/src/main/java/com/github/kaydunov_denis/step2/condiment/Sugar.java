package com.github.kaydunov_denis.step2.condiment;

import com.github.kaydunov_denis.step2.Beverage;

public class Sugar extends CondimentDecorator {
    Beverage beverage;

    public Sugar(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 0.2;
    }
}
