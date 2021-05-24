package com.fwmubarok.myforecastweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.fwmubarok.myforecastweather.Model.ForecastDay;

public class ForecastWeatherDayActivity extends AppCompatActivity {

    public static final String EXTRA_FORECAST_DAY = "extra_forecast_day";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast_weather_day);
    }
}