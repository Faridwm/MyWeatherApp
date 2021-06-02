package com.fwmubarok.myforecastweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fwmubarok.myforecastweather.Adapter.ForecastDayAdapter;
import com.fwmubarok.myforecastweather.Model.ForecastDay;
import com.fwmubarok.myforecastweather.Model.ForecastWeather;
import com.fwmubarok.myforecastweather.Model.HistoryWeather;
import com.fwmubarok.myforecastweather.My_interface.WeatherApiInterface;
import com.fwmubarok.myforecastweather.REST.ApiClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String API_KEY = "adc231cf04b14d1381d62047212005";
    private String CITY = "Jakarta";
    private List<ForecastDay> list_forecast_days = new ArrayList<>();
    private List<ForecastDay> forecast_history = new ArrayList<>();
    private static final String TAG = "API ERROR";

    private ForecastDayAdapter forecastDayAdapter;

    private ApiClient apiClient;
    private WeatherApiInterface weatherApiInterface;

    //Text View
    private TextView tv_city, tv_wind, tv_pressure, tv_precip, tv_humidity, tv_cloud, tv_gust, tv_condition_text, tv_temp, tv_last_update;

    //Image View
    private ImageView im_current_condition_icon;

    //Recycle View
    private RecyclerView rv_forecast_days;

    //Swipe
    private SwipeRefreshLayout swipe_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_city = findViewById(R.id.current_city);
        tv_wind = findViewById(R.id.current_wind_kph);
        tv_pressure = findViewById(R.id.current_pressure_mb);
        tv_precip = findViewById(R.id.current_precip_mm);
        tv_humidity = findViewById(R.id.current_humidity);
        tv_cloud = findViewById(R.id.current_cloud);
        tv_gust = findViewById(R.id.current_gust_kph);
        tv_condition_text = findViewById(R.id.current_condition_text);
        tv_temp = findViewById(R.id.current_temp_c);
        tv_last_update = findViewById(R.id.current_last_update);

        im_current_condition_icon = findViewById(R.id.current_condition_icon);

        rv_forecast_days = findViewById(R.id.rv_forecast_days);
        rv_forecast_days.setHasFixedSize(true);

        swipe_c = findViewById(R.id.swipe_container);

        weatherApiInterface = apiClient.getClient().create(WeatherApiInterface.class);

        getForecastDay();
        getHistoryDay();

        swipe_c.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateForecastDay();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipe_c.setRefreshing(false);
                    }
                }, 3000);
            }
        });
    }

    private void getForecastDay() {
        Call<ForecastWeather> call = weatherApiInterface.getForecastWeather(API_KEY, CITY, 3, "no", "no");

        call.enqueue(new Callback<ForecastWeather>() {
            @Override
            public void onResponse(Call<ForecastWeather> call, Response<ForecastWeather> response) {
                if (!response.isSuccessful()){
                    Log.d(TAG, "Code: " + response.code());
                    return;
                }

                ForecastWeather forecastWeather = response.body();
                tv_city.setText(forecastWeather.getLocation().getName());
                tv_wind.setText(Double.toString(forecastWeather.getCurrent().getWind_kph()));
                tv_pressure.setText(Double.toString(forecastWeather.getCurrent().getPressure_mb()));
                tv_precip.setText(Double.toString(forecastWeather.getCurrent().getPrecip_mm()));
                tv_humidity.setText(Integer.toString(forecastWeather.getCurrent().getHumidity()));
                tv_cloud.setText(Integer.toString(forecastWeather.getCurrent().getCloud()));
                tv_gust.setText(Double.toString(forecastWeather.getCurrent().getGust_kph()));
                tv_condition_text.setText(forecastWeather.getCurrent().getCondition().getText());
                tv_temp.setText(forecastWeather.getCurrent().getTemp_c() + "\u00B0C");
                tv_last_update.setText(forecastWeather.getCurrent().getLast_updated());


                Glide.with(MainActivity.this)
                        .load("https:" + forecastWeather.getCurrent().getCondition().getIcon())
                        .into(im_current_condition_icon);

                list_forecast_days.addAll(forecastWeather.getForecast().getForecastDay());
                Log.d("panjang list", Integer.toString(list_forecast_days.size()));
                showRecyclerList();
            }

            @Override
            public void onFailure(Call<ForecastWeather> call, Throwable t) {
                Log.d(TAG, "Message: " + t.getMessage());
            }
        });
    }

    private void updateForecastDay() {
        forecastDayAdapter.clear();
        Call<ForecastWeather> call = weatherApiInterface.getForecastWeather(API_KEY, CITY, 3, "no", "no");
        call.enqueue(new Callback<ForecastWeather>() {
            @Override
            public void onResponse(Call<ForecastWeather> call, Response<ForecastWeather> response) {
                if (!response.isSuccessful()){
                    Log.d(TAG, "Code: " + response.code());
                    return;
                }

                ForecastWeather forecastWeather = response.body();
                tv_city.setText(forecastWeather.getLocation().getName());
                tv_wind.setText(Double.toString(forecastWeather.getCurrent().getWind_kph()));
                tv_pressure.setText(Double.toString(forecastWeather.getCurrent().getPressure_mb()));
                tv_precip.setText(Double.toString(forecastWeather.getCurrent().getPrecip_mm()));
                tv_humidity.setText(Integer.toString(forecastWeather.getCurrent().getHumidity()));
                tv_cloud.setText(Integer.toString(forecastWeather.getCurrent().getCloud()));
                tv_gust.setText(Double.toString(forecastWeather.getCurrent().getGust_kph()));
                tv_condition_text.setText(forecastWeather.getCurrent().getCondition().getText());
                tv_temp.setText(forecastWeather.getCurrent().getTemp_c() + "\u00B0C");
                tv_last_update.setText(forecastWeather.getCurrent().getLast_updated());


                Glide.with(MainActivity.this)
                        .load("https:" + forecastWeather.getCurrent().getCondition().getIcon())
                        .into(im_current_condition_icon);

                list_forecast_days.addAll(forecastWeather.getForecast().getForecastDay());
//                Log.d("panjang list", Integer.toString(list_forecast_days.size()));
                showRecyclerList();
            }

            @Override
            public void onFailure(Call<ForecastWeather> call, Throwable t) {
                Log.d(TAG, "Message: " + t.getMessage());
            }
        });
    }

    private void getHistoryDay() {

        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()-24*60*60*1000));
        Log.d("date", date);
        Call<HistoryWeather> call = weatherApiInterface.getHistoryWeather(API_KEY, CITY, date);

        call.enqueue(new Callback<HistoryWeather>() {
            @Override
            public void onResponse(Call<HistoryWeather> call, Response<HistoryWeather> response) {
                if (!response.isSuccessful()){
                    Log.d(TAG, "Code: " + response.code());
                    return;
                }
                list_forecast_days.add(0, response.body().getForecast().getForecastDay().get(0));
            }

            @Override
            public void onFailure(Call<HistoryWeather> call, Throwable t) {
                Log.d(TAG, "Message: " + t.getMessage());
            }
        });
    }

    private void showRecyclerList() {
        rv_forecast_days.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        forecastDayAdapter = new ForecastDayAdapter(list_forecast_days);
//        forecastDayAdapter.setForecastDays(list_forecast_days);
        forecastDayAdapter.setCity(CITY);
        rv_forecast_days.setAdapter(forecastDayAdapter);
    }
}