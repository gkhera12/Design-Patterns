package com.eightleaves.examples.statepattern.statepattern;

public class SoldState implements State {
    GumBallMachine gumBallMachine;

    public SoldState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we are already giving you gumball...");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the Crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning crank twice will not dispence another gumball");
    }

    @Override
    public void dispense() {
        System.out.println("You may get gumball if i have one");
        if(gumBallMachine.getCount() > 0) {
            gumBallMachine.setState(gumBallMachine.getNoQuaterState());
        }else {
            gumBallMachine.setState(gumBallMachine.getSoldOutState());
        }
    }
}
