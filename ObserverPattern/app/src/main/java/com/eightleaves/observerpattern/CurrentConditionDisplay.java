package com.eightleaves.observerpattern;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gkhera on 5/04/2016.
 */
public class CurrentConditionDisplay extends Fragment implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    public CurrentConditionDisplay(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.current_condition, container, false);
    }
    @Override
    public void display() {
        Log.d("Observer Pattern","CurrentConditionDisplay->Temperature:"+temperature+" Humidity:"+humidity);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }


}
