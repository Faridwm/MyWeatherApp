package com.fwmubarok.myforecastweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.fwmubarok.myforecastweather.Model.CurrentWeather;
import com.fwmubarok.myforecastweather.My_interface.WeatherData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String API_KEY = "adc231cf04b14d1381d62047212005";
    private String CITY = "Jakarta";

    //Text View
    private TextView tv_city, tv_wind, tv_pressure, tv_precip, tv_humidity, tv_cloud, tv_gust, tv_condition_text, tv_temp, tv_last_update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_city = findViewById(R.id.current_city);
        tv_wind = findViewById(R.id.current_wind_kph);
        tv_pressure = findViewById(R.id.current_pressure_mb);
        tv_precip = findViewById(R.id.current_precip_m);
        tv_humidity = findViewById(R.id.current_humidity);
        tv_cloud = findViewById(R.id.current_cloud);
        tv_gust = findViewById(R.id.current_gust_kph);
        tv_condition_text = findViewById(R.id.current_condition_text);
        tv_temp = findViewById(R.id.current_temp_c);
        tv_last_update = findViewById(R.id.current_last_update);

        String base_url = "http://api.weatherapi.com/v1/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherData currentWeatherData = retrofit.create(WeatherData.class);

        Call<CurrentWeather> call = currentWeatherData.getCurrentWeather(API_KEY, CITY, "no");

        call.enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                if (!response.isSuccessful()){
                    tv_city.setText("Code: " + response.code());
                    return;
                }

                CurrentWeather currWeather = response.body();
                tv_city.setText(currWeather.getLocation().getName());
                tv_wind.setText(Double.toString(currWeather.getCurrent().getWind_kph()));
                tv_pressure.setText(Double.toString(currWeather.getCurrent().getPressure_mb()));
                tv_precip.setText(Double.toString(currWeather.getCurrent().getPrecip_mm()));
                tv_humidity.setText(Integer.toString(currWeather.getCurrent().getHumidity()));
                tv_cloud.setText(Integer.toString(currWeather.getCurrent().getCloud()));
                tv_gust.setText(Double.toString(currWeather.getCurrent().getGust_kph()));
                tv_condition_text.setText(currWeather.getCurrent().getCondition().getText());
                tv_temp.setText(Double.toString(currWeather.getCurrent().getTemp_c()));
                tv_last_update.setText(currWeather.getCurrent().getLast_updated());
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                tv_city.setText(t.getMessage());
            }
        });
    }
}