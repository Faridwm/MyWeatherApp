package com.fwmubarok.myforecastweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
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
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String API_KEY = "adc231cf04b14d1381d62047212005";
    private String CITY = "Jakarta";
    private List<ForecastDay> list_forecast_days = new ArrayList<>();
    private ForecastWeather forecastWeather;
    private static final String TAG = "API ERROR";

    private ForecastDayAdapter forecastDayAdapter;

    private ApiClient apiClient;
    private WeatherApiInterface weatherApiInterface;

    //Text View
    private TextView tv_city, tv_wind, tv_pressure, tv_precip, tv_humidity, tv_cloud, tv_gust, tv_condition_text, tv_temp, tv_last_update, tv_co, tv_no2, tv_o3, tv_so2, tv_pm25, tv_pm10;

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
        tv_co = findViewById(R.id.current_co);
        tv_no2 = findViewById(R.id.current_no2);
        tv_o3 = findViewById(R.id.current_o3);
        tv_so2 = findViewById(R.id.current_so2);
        tv_pm25 = findViewById(R.id.current_pm25);
        tv_pm10 = findViewById(R.id.current_pm10);

        im_current_condition_icon = findViewById(R.id.current_condition_icon);

        rv_forecast_days = findViewById(R.id.rv_forecast_days);
        rv_forecast_days.setHasFixedSize(true);

        swipe_c = findViewById(R.id.swipe_container);

        weatherApiInterface = ApiClient.getClient().create(WeatherApiInterface.class);
        getHistoryDay();
        showRecyclerList();

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

    @SuppressLint("DefaultLocale")
    private void upView(ForecastWeather forecastWeather) {
        String tx = "";
        tv_city.setText(forecastWeather.getLocation().getName());
        tx = Double.toString(forecastWeather.getCurrent().getWind_kph());
        tv_wind.setText(tx);
        tx = Double.toString(forecastWeather.getCurrent().getPressure_mb());
        tv_pressure.setText(tx);
        tx = Double.toString(forecastWeather.getCurrent().getPrecip_mm());
        tv_precip.setText(tx);
        tx = Integer.toString(forecastWeather.getCurrent().getHumidity());
        tv_humidity.setText(tx);
        tx = Integer.toString(forecastWeather.getCurrent().getCloud());
        tv_cloud.setText(tx);
        tx = Double.toString(forecastWeather.getCurrent().getGust_kph());
        tv_gust.setText(tx);
        tv_condition_text.setText(forecastWeather.getCurrent().getCondition().getText());
        tx = forecastWeather.getCurrent().getTemp_c() + "\u00B0C";
        tv_temp.setText(tx);
        tv_last_update.setText(forecastWeather.getCurrent().getLast_updated());
        tv_co.setText(String.format("%.2f\u00B5g/m\u00B3", forecastWeather.getCurrent().getAirQuality().getCo()));
        tv_no2.setText(String.format("%.2f\u00B5g/m\u00B3", forecastWeather.getCurrent().getAirQuality().getNo2()));
        tv_o3.setText(String.format("%.2f\u00B5g/m\u00B3", forecastWeather.getCurrent().getAirQuality().getO3()));
        tv_so2.setText(String.format("%.2f\u00B5g/m\u00B3", forecastWeather.getCurrent().getAirQuality().getSo2()));
        tv_pm25.setText(String.format("%.2f\u00B5g/m\u00B3", forecastWeather.getCurrent().getAirQuality().getPm25()));
        tv_pm10.setText(String.format("%.2f\u00B5g/m\u00B3",forecastWeather.getCurrent().getAirQuality().getPm10()));


        Glide.with(MainActivity.this)
                .load("https:" + forecastWeather.getCurrent().getCondition().getIcon())
                .into(im_current_condition_icon);
        showRecyclerList();
    }

    private void getForecastDay() {
        Call<ForecastWeather> call = weatherApiInterface.getForecastWeather(API_KEY, CITY, 3, "yes", "no");

        call.enqueue(new Callback<ForecastWeather>() {
            @Override
            public void onResponse(Call<ForecastWeather> call, Response<ForecastWeather> response) {
                if (!response.isSuccessful()){
                    Log.d(TAG, "Code: " + response.code());
                    return;
                }

                forecastWeather = response.body();
                list_forecast_days.addAll(forecastWeather.getForecast().getForecastDay());
                upView(forecastWeather);
                Log.d("panjang list", Integer.toString(list_forecast_days.size()));

            }

            @Override
            public void onFailure(Call<ForecastWeather> call, Throwable t) {
                Log.d(TAG, "Message: " + t.getMessage());
            }
        });
    }

    private void updateForecastDay() {
        list_forecast_days.clear();
        forecastDayAdapter.clear();
        getHistoryDay();
//        getForecastDay();
    }

    private void getHistoryDay() {

        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()-24*60*60*1000));
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
                getForecastDay();
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