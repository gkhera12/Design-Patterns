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
public class StatisticsDisplay extends Fragment implements DisplayElement, Observer {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.weather_stats, container, false);
    }

    @Override
    public void display() {
        Log.d("Observer Pattern","StatisticalDisplay");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        display();
    }
}
