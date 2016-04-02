package com.eightleaves.strategypattern;

import android.content.Context;
import android.util.Log;

/**
 * Created by gkhera on 1/04/2016.
 */
public class FlyNoWay implements FlyBehaviour {
    @Override
    public Holder fly(Context context) {
        Log.d("Strategy Pattern", "Can't fly");
        Holder holder = new Holder();
        holder.setImage(R.drawable.rubber_duck);
        holder.setText(R.string.nofly);
        return holder;
    }
}
