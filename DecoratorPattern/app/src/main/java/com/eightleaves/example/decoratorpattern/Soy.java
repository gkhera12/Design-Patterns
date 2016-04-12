package com.eightleaves.example.decoratorpattern;

/**
 * Created by gkhera on 12/04/2016.
 */
public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+" Soy";
    }

    @Override
    public double cost() {
        return 0.15 + beverage.cost();
    }
}
