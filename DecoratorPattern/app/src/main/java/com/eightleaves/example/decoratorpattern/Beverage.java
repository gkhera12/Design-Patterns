package com.eightleaves.example.decoratorpattern;

/**
 * Created by gkhera on 12/04/2016.
 */
public abstract class Beverage{
    String description = "Unknown Beverage";
    public String getDescription(){
        return description;
    }
    public abstract double cost();
}
