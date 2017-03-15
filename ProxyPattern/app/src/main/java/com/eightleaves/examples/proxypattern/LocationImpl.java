package com.eightleaves.examples.proxypattern;

public class LocationImpl implements Task {
    @Override
    public void setData(String data) {
        System.out.println(data+"Setting location");
    }

    @Override
    public int getCalData(int x) {
        return x*2;
    }
}
