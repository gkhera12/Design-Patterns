package com.eightleaves.examples.statepattern.statepattern;

public class SoldOutState implements State {
    GumBallMachine gumBallMachine;

    public SoldOutState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Already processing your request..");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Giving your money back..");
        gumBallMachine.setState(gumBallMachine.getNoQuaterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("Will not give u gumball I dont like you (Sold out)...");
    }

    @Override
    public void dispense() {
        System.out.println("Seriously, you thought you would get gumball, Why?");
    }
}
