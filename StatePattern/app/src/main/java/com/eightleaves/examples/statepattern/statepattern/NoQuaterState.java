package com.eightleaves.examples.statepattern.statepattern;

public class NoQuaterState implements State {
    GumBallMachine gumBallMachine;

    public NoQuaterState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Has the coin, now you can turn the crank...");
        gumBallMachine.setState(gumBallMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("you inserted no quarter..you crook");
    }

    @Override
    public void turnCrank() {
        System.out.println("Are you kidding me..insert the quarter first");
    }

    @Override
    public void dispense() {
        System.out.println("You asshole, you filthy shit,..Get away from me");
    }
}
