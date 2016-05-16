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

    public String fill(){
        if(isEmpty()){
            empty =false;
            boiled = false;
            Log.i(TAG,"Filling the Boiler");
            return "Filling the Boiler";
        }
        return "Already Filling";
    }

    public String drain(){
        if(!isEmpty() && isBoiled()){
            empty =true;
            Log.i(TAG,"Draining the Boiler");
            return "Draining the Boiler";
        }
        return "Already Draining";
    }

    public String boil(){
        if(!isEmpty() && !isBoiled()){
            boiled = true;
            Log.i(TAG,"Boiling the Chocolate");
            return ("Boiling the Chocolate");
        }
        return "Already Boiling";
    }

    public boolean isEmpty(){
        return empty;
    }

    public boolean isBoiled(){
        return boiled;
    }
}
