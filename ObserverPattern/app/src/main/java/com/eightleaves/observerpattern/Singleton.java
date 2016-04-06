package com.eightleaves.observerpattern;

/**
 * Created by gkhera on 6/04/16.
 */
public class Singleton {

    public ForecastData getForecastData() {
        return forecastData;
    }

    public void setForecastData(ForecastData forecastData) {
        this.forecastData = forecastData;
    }

    private ForecastData forecastData;
    private StatsData statsData;

    public CurrentConditionData getCurrentConditionData() {
        return currentConditionData;
    }

    public void setCurrentConditionData(CurrentConditionData currentConditionData) {
        this.currentConditionData = currentConditionData;
    }

    private CurrentConditionData currentConditionData;

    private static Singleton singleton = new Singleton( );

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private Singleton(){ }

    /* Static 'instance' method */
    public static Singleton getInstance( ) {
        return singleton;
    }
    /* Other methods protected by singleton-ness */
    protected static void demoMethod( ) {
        System.out.println("demoMethod for singleton");
    }
}
