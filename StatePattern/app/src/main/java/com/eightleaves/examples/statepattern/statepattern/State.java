package com.eightleaves.examples.statepattern.statepattern;


public interface State {
    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();
}
