package com.fwmubarok.myforecastweather;

import com.fwmubarok.myforecastweather.Model.CurrentWeather.CurrWeather;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCurrentWeatherData {
//    String API_KEY = "adc231cf04b14d1381d62047212005";
//    String CITY = "Jakarta";

    @GET("current.json?key=adc231cf04b14d1381d62047212005&q=Jakarta&aqi=no")
    Call<CurrWeather> getCurrentWeather();
}
