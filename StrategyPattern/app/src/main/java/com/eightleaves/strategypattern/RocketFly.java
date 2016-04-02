package com.eightleaves.strategypattern;

import android.content.Context;
import android.util.Log;

/**
 * Created by gkhera on 2/04/16.
 */
public class RocketFly implements FlyBehaviour {
    private int mfly;
    public RocketFly(int res){
        mfly = res;
    }
    @Override
    public Holder fly(Context context) {
        Log.d("Strategy Pattern", "I am flying");
        Holder holder = new Holder();
        holder.setImage(mfly);
        holder.setText(R.string.rocket_fly);
        return holder;
    }
}
