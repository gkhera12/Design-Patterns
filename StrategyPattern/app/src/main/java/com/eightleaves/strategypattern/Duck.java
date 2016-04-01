package com.eightleaves.strategypattern;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by gkhera on 1/04/2016.
 */
public class Duck {
    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehaviour;
    private Context mContext;

    public void Duck(Context context){
        mContext = context;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    private Drawable display(){
        return mContext.getDrawable(R.drawable.duck);
    }
}
