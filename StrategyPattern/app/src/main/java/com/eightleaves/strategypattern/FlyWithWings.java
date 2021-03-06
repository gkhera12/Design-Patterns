package com.eightleaves.strategypattern;

import android.content.Context;
import android.util.Log;

/**
 * Created by gkhera on 1/04/2016.
 */
public class FlyWithWings implements FlyBehaviour{
    private int mfly;
    public FlyWithWings(int res){
        mfly = res;
    }
    @Override
    public Holder fly(Context context) {
        Log.d("Strategy Pattern", "I am flying");
        Holder holder = new Holder();
        holder.setImage(mfly);
        holder.setText(R.string.canfly);
        return holder;
    }
}
