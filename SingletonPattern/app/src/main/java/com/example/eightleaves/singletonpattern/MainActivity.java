package com.example.eightleaves.singletonpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView boilerText;
    private Button startBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boilerText = (TextView) findViewById(R.id.state);
        startBtn = (Button)findViewById(R.id.start);
        startBtn.setOnClickListener(this);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        new Thread(new Runnable() {
            @Override
            public void run() {
                ChocolateBoiler.getInstance().fill(boilerText);
                ChocolateBoiler.getInstance().boil(boilerText);
                ChocolateBoiler.getInstance().drain(boilerText);
            }
        }).start();

    }
}
