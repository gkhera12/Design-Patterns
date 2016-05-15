package com.example.eightleaves.singletonpattern;

import android.util.Log;
import android.widget.TextView;

/**
 * Created by gkhera on 16/05/16.
 */
public class ChocolateBoiler {
    private String TAG = "Chocolate Boiler";
    private boolean empty;
    private boolean boiled;
    private static ChocolateBoiler uniqueInstance = new ChocolateBoiler();
    private ChocolateBoiler (){
        empty = true;
        boiled = false;
    }

    public static synchronized ChocolateBoiler getInstance(){
        return uniqueInstance;
    }

    public void fill(TextView boilerText){
        if(isEmpty()){
            empty =false;
            boiled = false;
            Log.i(TAG,"Filling the Boiler");
            boilerText.setText("Filling the Boiler");
        }
    }

    public void drain(TextView boilerText){
        if(!isEmpty() && isBoiled()){
            empty =true;
            Log.i(TAG,"Draining the Boiler");
            boilerText.setText("Draining the Boiler");
        }
    }

    public void boil(TextView boilerText){
        if(!isEmpty() && !isBoiled()){
            boiled = true;
            Log.i(TAG,"Boiling the Chocolate");
            boilerText.setText("Boiling the Chocolate");
        }
    }

    public boolean isEmpty(){
        return empty;
    }

    public boolean isBoiled(){
        return boiled;
    }
}
