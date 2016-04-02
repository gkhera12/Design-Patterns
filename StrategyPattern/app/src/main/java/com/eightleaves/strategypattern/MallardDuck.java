package com.eightleaves.strategypattern;

import android.content.Context;

/**
 * Created by gkhera on 2/04/16.
 */
public class MallardDuck extends Duck {

    public MallardDuck(Context context){
        super(context);
        flyBehaviour = new FlyWithWings(R.drawable.mallard_duck_fly);
        quackBehaviour = new Quack();
    }

    public int display(){
        return R.drawable.mallard_duck;
    }
}
