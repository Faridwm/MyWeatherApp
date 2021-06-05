package com.fwmubarok.myforecastweather.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistoryWeather {
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("forecast")
    @Expose
    private Forecast forecast;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
}
