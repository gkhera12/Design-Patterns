package com.eightleaves.observerpattern;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Observable;

/**
 * Created by gkhera on 5/04/2016.
 */
public class WeatherData extends Observable {
    private String temperature;
    private String humidity;
    private String pressure;

    public WeatherData(){

    }

    public void measurementChanged(){
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(String temperature, String humidity, String pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }

    public String getPressure() {
        return pressure;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

}
