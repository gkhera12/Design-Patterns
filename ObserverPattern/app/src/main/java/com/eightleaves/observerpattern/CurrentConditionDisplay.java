package com.eightleaves.observerpattern;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by gkhera on 5/04/2016.
 */
public class CurrentConditionDisplay extends Fragment implements Observer, DisplayElement {
    private String temperature;
    private String humidity;
    private String pressure;
    private TextView currentConditionView;
    private static Observable observable;
    private static String CURRENT_CONDITION_KEY ="current_condition_key";
    public  CurrentConditionDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }
    public CurrentConditionDisplay(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.current_condition, container, false);
        currentConditionView = (TextView)rootView.findViewById(R.id.current_temp);
        CurrentConditionData currentConditionData = Singleton.getInstance().getCurrentConditionData();
        if(currentConditionData != null){
            currentConditionView.setText("Temp:"+currentConditionData.getTemperature()+
            " Humidity:"+currentConditionData.getHumidity());
        }
        if(savedInstanceState !=null){
            Bundle args =getArguments();
            currentConditionView.setText(args.getString(CURRENT_CONDITION_KEY));
        }
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(CURRENT_CONDITION_KEY,"Temp:" + temperature + " Humidity:" + humidity);
        super.onSaveInstanceState(outState);
    }
    @Override
    public void display() {
        CurrentConditionData currentConditionData = new CurrentConditionData();
        currentConditionData.setHumidity(humidity);
        currentConditionData.setTemperature(temperature);
        currentConditionData.setPressure(pressure);
        Singleton.getInstance().setCurrentConditionData(currentConditionData);
        if(getView()!=null){
        currentConditionView.setText("Temp:" + temperature + " Humidity:" + humidity);}
        Log.d("Observer Pattern","CurrentConditionDisplay->Temperature:"+temperature+" Humidity:"+humidity);
    }

    @Override
    public void update(Observable observable, Object args) {
        if(observable instanceof WeatherData){
            WeatherData weatherData = (WeatherData)observable;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
        }
        display();
    }


}
