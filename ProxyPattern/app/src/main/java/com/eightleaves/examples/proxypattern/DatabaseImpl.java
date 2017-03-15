package com.eightleaves.examples.proxypattern;

public class DatabaseImpl implements Task{
    @Override
    public void setData(String data) {
        System.out.println(data+"Setting the database");
    }

    @Override
    public int getCalData(int x) {
        return x*1;
    }
}
