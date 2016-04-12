package com.eightleaves.example.decoratorpattern;

/**
 * Created by gkhera on 12/04/2016.
 */
public class Espresso extends Beverage {
    public Espresso(){
        description = "Espresso";
    }
    @Override
    public double cost() {
        return 1.99;
    }
}
