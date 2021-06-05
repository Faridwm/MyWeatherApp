package com.fwmubarok.myforecastweather.My_interface;

import com.fwmubarok.myforecastweather.Model.CurrentWeather;
import com.fwmubarok.myforecastweather.Model.ForecastWeather;
import com.fwmubarok.myforecastweather.Model.HistoryWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiInterface {
//    String API_KEY = "adc231cf04b14d1381d62047212005";
//    String CITY = "Jakarta";

    @GET("current.json")
    Call<CurrentWeather> getCurrentWeather(@Query("key") String key, @Query("q") String city, @Query("aqi") String aqi);

    @GET("forecast.json")
    Call<ForecastWeather> getForecastWeather(@Query("key") String key, @Query("q") String city, @Query("days") int day, @Query("aqi") String aqi, @Query("alerts") String alerts);

    @GET("history.json")
    Call<HistoryWeather> getHistoryWeather(@Query("key") String key, @Query("q") String city, @Query("dt") String date);
}
