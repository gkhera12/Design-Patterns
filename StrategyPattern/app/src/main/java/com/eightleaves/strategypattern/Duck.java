package com.eightleaves.strategypattern;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by gkhera on 1/04/2016.
 */
public abstract class Duck {
    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehaviour;
    private Context mContext;

    public Duck(Context context){
        mContext = context;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public Holder performFly(){
        return flyBehaviour.fly(mContext);
    }

    public int performQuack(){
        return quackBehaviour.quack(mContext);
    }
    public abstract int display();
}
