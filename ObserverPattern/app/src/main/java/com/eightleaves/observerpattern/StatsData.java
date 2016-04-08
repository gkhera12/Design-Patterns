package com.eightleaves.observerpattern;

import java.util.List;

/**
 * Created by gkhera on 6/04/16.
 */
public class StatsData {
    public List<CurrentConditionData> getStats() {
        return stats;
    }

    public void setStats(List<CurrentConditionData> stats) {
        this.stats = stats;
    }

    public int getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(int avgTemp) {
        this.avgTemp = avgTemp;
    }

    public int getAvgHumidity() {
        return avgHumidity;
    }

    public void setAvgHumidity(int avgHumidity) {
        this.avgHumidity = avgHumidity;
    }

    public int getAvgPressure() {
        return avgPressure;
    }

    public void setAvgPressure(int avgPressure) {
        this.avgPressure = avgPressure;
    }

    private List<CurrentConditionData> stats;
    private int avgTemp;
    private int avgHumidity;
    private int avgPressure;
}
