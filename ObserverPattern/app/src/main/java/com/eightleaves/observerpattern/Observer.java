package com.eightleaves.observerpattern;

/**
 * Created by gkhera on 5/04/2016.
 */
public interface Observer {
    public void update(float temp, float humidity, float pressure);
}
