package com.github.kaydunov_denis.step1;

import com.github.kaydunov_denis.step1.bean.Beverage;
import com.github.kaydunov_denis.step1.bean.Cappuccino;
import com.github.kaydunov_denis.step1.bean.Espresso;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class App {

    public static void main(String[] args) {
        Beverage cappuccino = new Cappuccino();
        cappuccino.coffee = "coffee";
        cappuccino.milk = "milk";

        Beverage espresso = new Espresso();
        espresso.coffee = "coffee";
        espresso.water = "water";
    }
}

