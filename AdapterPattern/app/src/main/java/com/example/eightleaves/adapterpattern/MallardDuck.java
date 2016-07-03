package com.example.eightleaves.adapterpattern;

/**
 * Created by gkhera on 3/07/16.
 */
public class MallardDuck implements Duck{
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }

}
