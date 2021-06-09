package com.fwmubarok.myforecastweather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fwmubarok.myforecastweather.Adapter.ForecastHourAdapter;
import com.fwmubarok.myforecastweather.Model.ForecastDay;
import com.fwmubarok.myforecastweather.Model.Hour;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ForecastWeatherDayActivity extends AppCompatActivity {

    private ForecastDay forecastDay;
    private List<Hour> list_hour;

    //Text View
    private TextView tv_con_text, tv_day_name, tv_city, tv_max_wind, tv_precip_total, tv_temp_c_min_max, tv_temp_c_avg, tv_sunrise, tv_sunset;

    //Image View
    private ImageView iv_con_icon;

    //Recycle View
    private RecyclerView rv_forecast_hour;

    //Scroll View
    private ScrollView sv_detail_forecast;

    //EXTRA
    public static final String EXTRA_FORECAST_DAY = "extra_forecast_day";
    public static final String EXTRA_CITY = "extra_city";
    public static final String EXTRA_POSITION = "extra_position";
    public static final String EXTRA_DATE = "extra_date";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast_weather_day);

        tv_con_text = findViewById(R.id.tv_foreday_condition_text);
        tv_day_name = findViewById(R.id.tv_foreday_day_name);
        tv_city = findViewById(R.id.tv_foreday_city);
        tv_max_wind = findViewById(R.id.tv_foreday_maxwind_kph);
        tv_precip_total = findViewById(R.id.tv_foreday_precip_total);
        tv_temp_c_min_max = findViewById(R.id.tv_foreday_temp_c_min_max);
        tv_temp_c_avg = findViewById(R.id.tv_foreday_temp_c_avg);
        tv_sunrise = findViewById(R.id.tv_foreday_astro_sunrise);
        tv_sunset = findViewById(R.id.tv_foreday_astro_sunset);

        iv_con_icon = findViewById(R.id.img_foreday_condition_icon);

        rv_forecast_hour = findViewById(R.id.rv_forecast_hours);
        rv_forecast_hour.setHasFixedSize(true);

        sv_detail_forecast = findViewById(R.id.sv_forecast_hour);
        sv_detail_forecast.smoothScrollTo(0, 0);

        forecastDay = getIntent().getParcelableExtra(EXTRA_FORECAST_DAY);

        tv_city.setText(getIntent().getStringExtra(EXTRA_CITY));
        String sDate = forecastDay.getDate();
        String day;
        int position = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (position == 0) {
            day = "Yesterday";
        }
        else if (position == 1) {
            day = "Today";
        }
        else {
            day = new SimpleDateFormat("EEEE", Locale.getDefault()).format(date);
        }

        String tx;

        tx = day + ", " + getIntent().getStringExtra(EXTRA_DATE);
        tv_day_name.setText(tx);
        tv_con_text.setText(forecastDay.getDay().getCondition().getText());
        tx = forecastDay.getDay().getMaxwind_kph() + " kph";
        tv_max_wind.setText(tx);
        tx = forecastDay.getDay().getTotalprecip_mm() + " mm";
        tv_precip_total.setText(tx);
        tx = forecastDay.getDay().getMin_tempC() + "\u00B0C | " + forecastDay.getDay().getMax_tempC() + "\u00B0C";
        tv_temp_c_min_max.setText(tx);
        tx = forecastDay.getDay().getAvg_tempC() + "\u00B0C";
        tv_temp_c_avg.setText(tx);

        String amPm_to_24 = forecastDay.getAstro().getSunrise();
        try {
            date = new SimpleDateFormat("hh:mm a", Locale.getDefault()).parse(amPm_to_24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        amPm_to_24 = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(date);
        tv_sunrise.setText(amPm_to_24);

        amPm_to_24 = forecastDay.getAstro().getSunset();
        try {
            date = new SimpleDateFormat("hh:mm a", Locale.getDefault()).parse(amPm_to_24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        amPm_to_24 = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(date);
        tv_sunset.setText(amPm_to_24);

        Glide.with(ForecastWeatherDayActivity.this)
                .load("https:" + forecastDay.getDay().getCondition().getIcon())
                .into(iv_con_icon);
        list_hour = forecastDay.getHour();
        showRecyclerList();
    }

    private void showRecyclerList() {
        rv_forecast_hour.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        ForecastHourAdapter forecastHourAdapter = new ForecastHourAdapter(ForecastWeatherDayActivity.this);
        forecastHourAdapter.setHours(list_hour);
        rv_forecast_hour.setAdapter(forecastHourAdapter);
    }
}