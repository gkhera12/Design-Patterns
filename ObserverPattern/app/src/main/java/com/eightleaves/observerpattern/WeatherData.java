package com.eightleaves.observerpattern;

import java.util.ArrayList;

/**
 * Created by gkhera on 5/04/2016.
 */
public class WeatherData implements Subject {
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int index = observers.indexOf(o);
        if(index >= 0){
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        for(int i=0 ; i<observers.size();i++){
            Observer observer = observers.get(i);
            observer.update(temperature,humidity,pressure);
        }
    }

    public void measurementChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }
}
