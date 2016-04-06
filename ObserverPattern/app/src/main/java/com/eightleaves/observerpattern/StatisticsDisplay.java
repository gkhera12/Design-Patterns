package com.eightleaves.observerpattern;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by gkhera on 5/04/2016.
 */
public class StatisticsDisplay extends Fragment implements DisplayElement, Observer {
    private String temperature;
    private String humidity;
    private Observable observable;
    public StatisticsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.weather_stats, container, false);

        return rootView;
    }

    @Override
    public void display() {
        Log.d("Observer Pattern","StatisticalDisplay");
    }

    @Override
    public void update(Observable observable, Object args) {
        if(observable instanceof WeatherData){
            WeatherData weatherData = (WeatherData)observable;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
        }
        display();
    }
}
