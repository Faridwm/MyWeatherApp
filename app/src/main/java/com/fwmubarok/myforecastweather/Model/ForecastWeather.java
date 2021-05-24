package com.fwmubarok.myforecastweather.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForecastWeather {

    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("current")
    @Expose
    private Current current;
    @SerializedName("forecast")
    @Expose
    private Forecast forecast;
}
