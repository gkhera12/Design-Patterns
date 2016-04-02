package com.eightleaves.strategypattern;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

/**
 * Created by gkhera on 1/04/2016.
 */
public class Squeak implements QuackBehaviour {
    @Override
    public int quack(Context context) {
        Log.d("Strategy Pattern", "I Squeak");
        int resID=R.raw.squeaks;
        MediaPlayer mediaPlayer=MediaPlayer.create(context,resID);
        mediaPlayer.start();
        return R.string.squeak;
    }
}
