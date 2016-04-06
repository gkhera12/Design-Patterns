package com.eightleaves.observerpattern;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by gkhera on 5/04/2016.
 */
public class ForecastDisplay extends Fragment implements Observer, DisplayElement {
    private String temperature;
    private String humidity;
    private Observable observable;
    private ImageView forecastView;
    private static String FORECAST_KEY ="forecast_key";
    public  ForecastDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.forecast_condition, container, false);
        forecastView =(ImageView)rootView.findViewById(R.id.forecast_condition);
        if(savedInstanceState!=null){
            Bundle args = getArguments();
            forecastView.setImageDrawable(getContext().getDrawable(args.getInt(FORECAST_KEY)));
        }
        return rootView;
    }
    @Override
    public void display() {
        if(forecastView!=null){
            forecastView.setImageDrawable(getContext().getDrawable(R.drawable.art_clouds));
        }
        Log.d("Observer Pattern", "ForecastDisplay");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(FORECAST_KEY,R.drawable.art_clouds);
        super.onSaveInstanceState(outState);
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
