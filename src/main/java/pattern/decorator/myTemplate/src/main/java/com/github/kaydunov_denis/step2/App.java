package com.github.kaydunov_denis.step2;

import com.github.kaydunov_denis.step2.bean.Cappuccino;
import com.github.kaydunov_denis.step2.condiment.CoconateSirope;
import com.github.kaydunov_denis.step2.condiment.CondimentDecorator;
import com.github.kaydunov_denis.step2.condiment.Milk;
import com.github.kaydunov_denis.step2.condiment.Sugar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class App {
    private static Logger logger = (Logger) LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        Beverage cappuccino = new Cappuccino();
        CondimentDecorator coffee = new CoconateSirope(new Sugar(new Sugar(new Milk(cappuccino))));
        logger.info("Coffee is ready {}", coffee);

//        Beverage cappuccino = new Cappuccino();
//        cappuccino.coffee = "coffee";
//        cappuccino.milk = "milk";
//
//        Beverage espresso = new Espresso();
//        espresso.coffee = "coffee";
//        espresso.water = "water";
    }
}
