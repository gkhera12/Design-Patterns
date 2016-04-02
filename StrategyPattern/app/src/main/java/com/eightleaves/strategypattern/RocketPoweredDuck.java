package com.eightleaves.strategypattern;

import android.content.Context;

/**
 * Created by gkhera on 2/04/16.
 */
public class RocketPoweredDuck extends Duck {
    public RocketPoweredDuck(Context context){
        super(context);
        flyBehaviour = new RocketFly(R.drawable.rocket_duck_fly);
        quackBehaviour = new MuteQuack();
    }
    public int display(){
       return R.drawable.rocket_duck;
    }
}
