package com.eightleaves.examples.statepattern.statepattern;

public class GumBallMachine {
    private SoldOutState soldOutState;
    private SoldState soldState;
    private HasQuarterState hasQuarterState;
    private NoQuaterState noQuaterState;
    private State state = soldOutState;
    int count =0;
    public GumBallMachine(int numberOfGumballs){
        soldOutState = new SoldOutState();
        soldState = new SoldState();
        hasQuarterState = new HasQuarterState();
        noQuaterState = new NoQuaterState();
        this.count = numberOfGumballs;
        if(count > 0){
            state = noQuaterState;
        }
    }

    public void insertQuarter(){
        state.insertQuarter();
    }

    public void ejectQuarter(){
        state.ejectQuarter();
    }

    public void turnCrank(){
        state.turnCrank();
        state.dispense();
    }

    public void setState(State state){
        this.state = state;
    }

    public void releaseBall(){
        System.out.println("GumBall coming out..");
        if(count !=0){
            count = count -1;
        }
    }

    public SoldOutState getSoldOutState() {
        return soldOutState;
    }

    public SoldState getSoldState() {
        return soldState;
    }

    public HasQuarterState getHasQuarterState() {
        return hasQuarterState;
    }

    public NoQuaterState getNoQuaterState() {
        return noQuaterState;
    }

    public State getState() {
        return state;
    }

    public int getCount() {
        return count;
    }
}
