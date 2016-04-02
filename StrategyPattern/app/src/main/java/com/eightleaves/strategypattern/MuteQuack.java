package com.eightleaves.strategypattern;

import android.content.Context;
import android.util.Log;

/**
 * Created by gkhera on 1/04/2016.
 */
public class MuteQuack implements QuackBehaviour {
    @Override
    public int quack(Context context) {
        Log.d("Strategy Pattern", "I am mute");
        return R.string.mute;
    }
}
