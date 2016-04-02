package com.eightleaves.strategypattern;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mallardDuckView;
    private Button rubberDuckView;
    private Button rocketPoweredDuckView;
    private ImageView duckImageView;
    private Button flyButton;
    private Button quackButton;
    private TextView text;
    private Duck duck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rubberDuckView = (Button)findViewById(R.id.rubber_duck);
        mallardDuckView = (Button)findViewById(R.id.mallard_duck);
        rocketPoweredDuckView = (Button)findViewById(R.id.rocket_powered_duck);
        duckImageView =(ImageView)findViewById(R.id.duck_image);
        flyButton =(Button)findViewById(R.id.fly);
        quackButton =(Button)findViewById(R.id.quack);
        text = (TextView)findViewById(R.id.duck_text);
        flyButton.setOnClickListener(this);
        quackButton.setOnClickListener(this);
        rubberDuckView.setOnClickListener(this);
        mallardDuckView.setOnClickListener(this);
        rocketPoweredDuckView.setOnClickListener(this);
        duckImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Holder holder;
        switch (v.getId()){
            case R.id.mallard_duck:
                duck = new MallardDuck(getApplicationContext());
                duckImageView.setImageDrawable(getDrawable(duck.display()));
                text.setText("I'm Mallard");
                flyButton.setVisibility(View.VISIBLE);
                quackButton.setVisibility(View.VISIBLE);
                break;
            case R.id.rocket_powered_duck:
                duck = new RocketPoweredDuck(getApplicationContext());
                duckImageView.setImageDrawable(getDrawable(duck.display()));
                text.setText("I'm Rocket Duck");
                flyButton.setVisibility(View.VISIBLE);
                quackButton.setVisibility(View.VISIBLE);
                break;
            case R.id.rubber_duck:
                duck = new RubberDuck(getApplicationContext());

                duckImageView.setImageDrawable(getDrawable(duck.display()));
                text.setText("I'm Rubber Duck");
                flyButton.setVisibility(View.VISIBLE);
                quackButton.setVisibility(View.VISIBLE);
                break;
            case R.id.fly:
                duckImageView.setImageDrawable(getDrawable(duck.performFly().getImage()));
                text.setText(duck.performFly().getText());
                break;
            case R.id.quack:
                text.setText(duck.performQuack());
                break;

        }
    }
}
