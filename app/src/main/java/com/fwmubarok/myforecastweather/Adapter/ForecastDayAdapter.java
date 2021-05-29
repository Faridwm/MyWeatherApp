package com.fwmubarok.myforecastweather.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fwmubarok.myforecastweather.CustomOnItemClickListener;
import com.fwmubarok.myforecastweather.ForecastWeatherDayActivity;
import com.fwmubarok.myforecastweather.Model.ForecastDay;
import com.fwmubarok.myforecastweather.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ForecastDayAdapter extends RecyclerView.Adapter<ForecastDayAdapter.ListViewHolder> {
    private final int item_count = 3;

    private List<ForecastDay> forecastDays;
//    private Activity activity;
    private String city;


    public ForecastDayAdapter(List<ForecastDay> forecastDays) {
        this.forecastDays = forecastDays;
    }

//    public ForecastDayAdapter(Activity activity) {
//        this.activity = activity;
//    }

    public List<ForecastDay> getForecastDays() {
        return forecastDays;
    }

    public void setForecastDays(List<ForecastDay> forecastDays) {
        this.forecastDays = forecastDays;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @NonNull
    @Override
    public ForecastDayAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_column_forecast, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastDayAdapter.ListViewHolder holder, int position) {
        ForecastDay forecastDay = getForecastDays().get(position);
        String sDate = forecastDay.getDate();
        String day = null;
        try {

            Date ndate = new Date();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
            if (ndate.compareTo(date) != 1) {
                day = new SimpleDateFormat("EEEE", Locale.getDefault()).format(date);
            }
            else {
                day = "Today";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        holder.tv_day_name.setText(day);
        holder.tv_condition_text.setText(forecastDay.getDay().getCondition().getText());
        holder.tv_temp_c.setText(forecastDay.getDay().getAvg_tempC() + "\u00B0C");

        Glide.with(holder.itemView.getContext())
                .load("https:" + forecastDay.getDay().getCondition().getIcon())
                .into(holder.iv_forecast_day);

        //On Click
        holder.itemView.setOnClickListener(new CustomOnItemClickListener(position, (view, position1) -> {
            Intent intent = new Intent(holder.itemView.getContext(), ForecastWeatherDayActivity.class);
            intent.putExtra(ForecastWeatherDayActivity.EXTRA_FORECAST_DAY, forecastDays.get(position1));
            intent.putExtra(ForecastWeatherDayActivity.EXTRA_CITY, getCity());
            holder.itemView.getContext().startActivity(intent);
        }));
    }

    @Override
    public int getItemCount() {
        if (getForecastDays().size() > item_count) {
            return item_count;
        }
        else {
            return getForecastDays().size();
        }
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        TextView tv_day_name, tv_temp_c, tv_condition_text;
        ImageView iv_forecast_day;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_forecast_day = itemView.findViewById(R.id.img_forecast_condition_icon);
            tv_condition_text = itemView.findViewById(R.id.tv_forecast_condition_text);
            tv_day_name = itemView.findViewById(R.id.tv_forecast_day);
            tv_temp_c = itemView.findViewById(R.id.tv_forecast_temp_c);
        }
    }
}
