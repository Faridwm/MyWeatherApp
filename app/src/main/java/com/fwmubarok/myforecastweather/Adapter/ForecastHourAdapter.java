package com.fwmubarok.myforecastweather.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fwmubarok.myforecastweather.Model.Hour;
import com.fwmubarok.myforecastweather.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ForecastHourAdapter extends RecyclerView.Adapter<ForecastHourAdapter.ListViewHolder> {

    private List<Hour> hours;
    private Activity activity;

    public ForecastHourAdapter(Activity activity) {
        this.activity = activity;
    }

    public List<Hour> getHours() {
        return hours;
    }

    public void setHours(List<Hour> hours) {
        this.hours = hours;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_forecast_hour, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Hour hour = getHours().get(position);

        String dt = hour.getTime();
        String[] date_time = dt.split(" ");
        String time_hour = date_time[1];



        holder.tv_time.setText(time_hour);
        holder.tv_cond_text.setText(hour.getCondition().getText());
        holder.tv_temp_c.setText(hour.getTemp_c() + "\u00B0C");
        holder.tv_feelslike_c.setText(hour.getFeelslike_c() + "\u00B0C");
        holder.tv_chance_rain.setText(hour.getChance_of_rain() + "%");
        String w_rain;
        if (hour.getWill_it_rain() == 1) {
            w_rain = "YES";
        }
        else {
            w_rain = "NO";
        }
        holder.tv_will_rain.setText(w_rain);

        Glide.with(holder.itemView.getContext())
                .load("https:" + hour.getCondition().getIcon())
                .into(holder.iv_cond_icon);

    }

    @Override
    public int getItemCount() {
        return getHours().size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        //Text View
        TextView tv_cond_text, tv_time, tv_temp_c, tv_feelslike_c, tv_chance_rain, tv_will_rain;

        //Image View
        ImageView iv_cond_icon;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_cond_text = itemView.findViewById(R.id.tv_forehour_condition_text);
            tv_time = itemView.findViewById(R.id.tv_forehour_time);
            tv_temp_c = itemView.findViewById(R.id.tv_forehour_temp_c);
            tv_feelslike_c = itemView.findViewById(R.id.tv_forehour_feelslike_c);
            tv_chance_rain = itemView.findViewById(R.id.tv_forehour_chance_rain);
            tv_will_rain = itemView.findViewById(R.id.tv_forehour_will_rain);
            iv_cond_icon = itemView.findViewById(R.id.img_forehour_condition_icon);
        }
    }
}
