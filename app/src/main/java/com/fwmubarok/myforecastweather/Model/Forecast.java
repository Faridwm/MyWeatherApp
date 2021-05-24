package com.fwmubarok.myforecastweather.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Forecast {
    @SerializedName("forecastday")
    @Expose
    private List<ForecastDay> forecastDay;

    public List<ForecastDay> getForecastDay() {
        return forecastDay;
    }

    public void setForecastDay(List<ForecastDay> forecastDay) {
        this.forecastDay = forecastDay;
    }
}
