package com.eightleaves.strategypattern;

import android.content.Context;

/**
 * Created by gkhera on 2/04/16.
 */
public class RubberDuck extends Duck {
    public RubberDuck(Context context){
        super(context);
        flyBehaviour = new FlyNoWay();
        quackBehaviour = new Squeak();
    }
    public int display(){
        return R.drawable.rubber_duck;
    }
}
