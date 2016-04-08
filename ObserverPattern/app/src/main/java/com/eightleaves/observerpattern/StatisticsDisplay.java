package com.eightleaves.observerpattern;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by gkhera on 5/04/2016.
 */
public class StatisticsDisplay extends Fragment implements DisplayElement, Observer {
    private String temperature;
    private String humidity;
    private String pressure;
    private int avgTemp;
    private int avgHumidity;
    private int avgPressure;
    private TextView weatherStatView;

    private Observable observable;
    public StatisticsDisplay(Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.weather_stats, container, false);
        weatherStatView = (TextView)rootView.findViewById(R.id.weather_stats);
        StatsData statsData = Singleton.getInstance().getStatsData();
        if(statsData != null){
            weatherStatView.setText("Avg Temp:"+statsData.getAvgTemp()+
                    " Avg Humidity:"+statsData.getAvgHumidity()+
            "AvgPressure:"+statsData.getAvgPressure());
        }
        return rootView;
    }

    @Override
    public void display() {
        List<CurrentConditionData> list = new ArrayList<>();
        StatsData statsData =  new StatsData();
        CurrentConditionData currentConditionData = new CurrentConditionData();
        currentConditionData.setHumidity(humidity);
        currentConditionData.setTemperature(temperature);
        currentConditionData.setPressure(pressure);
        if(Singleton.getInstance().getStatsData() !=null ) {
            statsData = Singleton.getInstance().getStatsData();
            list = statsData.getStats();
        }
        list.add(currentConditionData);
        caculateAvg(list);
        statsData.setAvgHumidity(avgHumidity);
        statsData.setAvgPressure(avgPressure);
        statsData.setAvgTemp(avgTemp);
        statsData.setStats(list);
        Singleton.getInstance().setStatsData(statsData);
        weatherStatView.setText("Avg Temp:"+statsData.getAvgTemp()+
                " Avg Humidity:"+statsData.getAvgHumidity()+
                "AvgPressure:"+statsData.getAvgPressure());
        Log.d("Observer Pattern", "StatisticalDisplay");
    }

    private void caculateAvg(List<CurrentConditionData> list) {
        avgPressure =0;
        avgTemp =0;
        avgPressure=0;
        for(int i=0 ; i<list.size();i++){
            avgTemp = avgTemp+Integer.valueOf(list.get(i).getTemperature());
            avgPressure = avgPressure+Integer.valueOf(list.get(i).getTemperature());
            avgHumidity = avgHumidity+Integer.valueOf(list.get(i).getTemperature());
        }
        avgHumidity = avgHumidity/list.size();
        avgPressure = avgPressure/list.size();
        avgTemp =  avgTemp/list.size();
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
