package com.example.eightleaves.adapterpattern;

/**
 * Created by gkhera on 3/07/16.
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
