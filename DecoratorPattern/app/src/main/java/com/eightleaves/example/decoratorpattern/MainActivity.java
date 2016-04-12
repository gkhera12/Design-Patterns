package com.eightleaves.example.decoratorpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button espressoBtn;
    private Button houseBlendBtn;
    private Button soyBtn;
    private Button whipBtn;
    private Button mochaBtn;
    private Button resetBtn;
    private TextView orderView;
    private TextView costView;
    private Beverage beverage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        espressoBtn = (Button)findViewById(R.id.espresso);
        houseBlendBtn = (Button)findViewById(R.id.houseblend);
        soyBtn = (Button)findViewById(R.id.soy);
        mochaBtn = (Button)findViewById(R.id.mocha);
        whipBtn = (Button)findViewById(R.id.Whip);
        orderView =(TextView)findViewById(R.id.order);
        costView = (TextView)findViewById(R.id.cost);
        resetBtn = (Button)findViewById(R.id.reset);
        espressoBtn.setOnClickListener(this);
        houseBlendBtn.setOnClickListener(this);
        mochaBtn.setOnClickListener(this);
        whipBtn.setOnClickListener(this);
        soyBtn.setOnClickListener(this);
        resetBtn.setOnClickListener(this);
        Beverage beverage = new Espresso();
        Log.d("Decorator pattern",beverage.getDescription()+"$"+beverage.cost());

        Beverage beverage1 = new HouseBlend();
        beverage1 = new Soy(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        Log.d("Decorator Pattern",beverage1.getDescription()+"$"+beverage1.cost());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reset:
                espressoBtn.setEnabled(true);
                houseBlendBtn.setEnabled(true);
            case R.id.espresso:
                espressoBtn.setEnabled(false);
                houseBlendBtn.setEnabled(false);
                beverage = new Espresso();
                orderView.setText(String.valueOf(beverage.getDescription()));
                costView.setText(String.valueOf(beverage.cost()));
                break;
            case R.id.houseblend:
                espressoBtn.setEnabled(false);
                houseBlendBtn.setEnabled(false);
                beverage = new HouseBlend();

                costView.setText(String.valueOf(beverage.cost()));
                break;
            case R.id.soy:
                beverage = new Soy(beverage);
                costView.setText(String.valueOf(beverage.cost()));
                break;
            case R.id.Whip:
                beverage = new Whip(beverage);
                costView.setText(String.valueOf(beverage.cost()));
                break;
            case R.id.mocha:
                beverage = new Mocha(beverage);
                costView.setText(String.valueOf(beverage.cost()));
                break;
        }
    }
}
