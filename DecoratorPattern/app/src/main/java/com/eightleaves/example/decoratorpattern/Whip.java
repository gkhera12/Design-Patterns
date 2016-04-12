package com.eightleaves.example.decoratorpattern;

/**
 * Created by gkhera on 12/04/2016.
 */
public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+" Whip";
    }

    @Override
    public double cost() {
        return 0.10;
    }
}
