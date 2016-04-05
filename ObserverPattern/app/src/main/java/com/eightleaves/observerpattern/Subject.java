package com.eightleaves.observerpattern;

/**
 * Created by gkhera on 5/04/2016.
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
