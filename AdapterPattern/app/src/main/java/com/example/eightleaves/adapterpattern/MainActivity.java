package com.example.eightleaves.adapterpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MallardDuck duck = new MallardDuck();

        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The Turkey says..");
        turkey.gobble();
        turkey.fly();

        System.out.println("\n The Duck Says..");
        testDuck(duck);

        System.out.println("\n The turkeyAdapter says..");
        testDuck(turkeyAdapter);
    }

    private void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }

}
