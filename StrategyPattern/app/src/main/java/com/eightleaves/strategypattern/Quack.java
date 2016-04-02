package com.eightleaves.strategypattern;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

/**
 * Created by gkhera on 1/04/2016.
 */
public class Quack implements QuackBehaviour {
    @Override
    public int quack(Context context) {
        Log.d("Strategy Pattern", "I Quack");
            //set up MediaPlayer
        int resID=R.raw.quacks;
        MediaPlayer mediaPlayer=MediaPlayer.create(context,resID);
        mediaPlayer.start();
        return R.string.quack;
    }
}
