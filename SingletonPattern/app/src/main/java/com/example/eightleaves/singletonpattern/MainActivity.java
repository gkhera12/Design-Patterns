package com.example.eightleaves.singletonpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView fillText;
    private TextView boilText;
    private TextView drainText;
    private Button startBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillText = (TextView) findViewById(R.id.fill);
        boilText = (TextView) findViewById(R.id.boil);
        drainText = (TextView) findViewById(R.id.drain);
        startBtn = (Button)findViewById(R.id.start);
        startBtn.setOnClickListener(this);
    }

    public void onClick(View v){
        new Thread(new Runnable() {
            @Override
            public void run() {
                fillText.post(new Runnable() {
                    @Override
                    public void run() {
                        fillText.setText(ChocolateBoiler.getInstance().fill());

                    }
                });
                try {
                    Thread.sleep(3000,0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                boilText.post(new Runnable() {
                    @Override
                    public void run() {
                        fillText.setText("");
                        boilText.setText(ChocolateBoiler.getInstance().boil());
                    }
                });
                try {
                    Thread.sleep(3000,0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                drainText.post(new Runnable() {
                    @Override
                    public void run() {
                        boilText.setText("");
                        drainText.setText(ChocolateBoiler.getInstance().drain());
                    }
                });
                try {
                    Thread.sleep(3000,0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
