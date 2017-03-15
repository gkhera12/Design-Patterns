package com.eightleaves.examples.proxypattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Task task = (Task)ProxyFactory.newInstance(new TaskImpl());
        task.setData("Test");
        System.out.println(task.getCalData(5));

        task = (Task)ProxyFactory.newInstance(new DatabaseImpl());
        task.setData("DatabaseImpl:");

        task = (Task)ProxyFactory.newInstance(new LocationImpl());
        task.setData("LocationImpl:");
    }
}
