package com.eightleaves.examples.statepattern.statepattern;

public class HasQuarterState implements State {
    GumBallMachine gumBallMachine;

    public HasQuarterState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you cant insert another quarter..");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter coming out..");
        gumBallMachine.setState(gumBallMachine.getNoQuaterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned..");
        gumBallMachine.setState(gumBallMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
