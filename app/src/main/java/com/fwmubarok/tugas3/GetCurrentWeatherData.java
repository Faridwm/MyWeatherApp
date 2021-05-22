package com.fwmubarok.tugas3;

import com.fwmubarok.tugas3.Model.CurrentWeather.CurrWeather;
import com.fwmubarok.tugas3.Model.CurrentWeather.Current;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCurrentWeatherData {
//    String API_KEY = "adc231cf04b14d1381d62047212005";
//    String CITY = "Jakarta";

    @GET("current.json?key=adc231cf04b14d1381d62047212005&q=Jakarta&aqi=no")
    Call<CurrWeather> getCurrentWeather();
}
