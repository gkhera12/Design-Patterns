package com.eightleaves.example.decoratorpattern;

/**
 * Created by gkhera on 12/04/2016.
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + "Mocha";
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }
}
