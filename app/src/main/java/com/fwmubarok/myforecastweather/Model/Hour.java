package com.fwmubarok.myforecastweather.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Hour implements Parcelable {
    @SerializedName("time_epoch")
    private int time_epoch;

    @SerializedName("time")
    private String time;

    @SerializedName("temp_c")
    private double temp_c;

    @SerializedName("feelslike_c")
    private double feelslike_c;

    @SerializedName("condition")
    private Condition condition;

    @SerializedName("wind_kph")
    private double wind_kph;

    @SerializedName("precip_mm")
    private double precip_mm;

    @SerializedName("humidity")
    private int humidity;

    @SerializedName("cloud")
    private int cloud;

    @SerializedName("gust_kph")
    private double gust_kph;

    @SerializedName("will_it_rain")
    private int will_it_rain;

    @SerializedName("chance_of_rain")
    private String chance_of_rain;

    protected Hour(Parcel in) {
        time_epoch = in.readInt();
        time = in.readString();
        temp_c = in.readDouble();
        feelslike_c = in.readDouble();
        condition = in.readParcelable(Condition.class.getClassLoader());
        wind_kph = in.readDouble();
        precip_mm = in.readDouble();
        humidity = in.readInt();
        cloud = in.readInt();
        gust_kph = in.readDouble();
        will_it_rain = in.readInt();
        chance_of_rain = in.readString();
    }

    public static final Creator<Hour> CREATOR = new Creator<Hour>() {
        @Override
        public Hour createFromParcel(Parcel in) {
            return new Hour(in);
        }

        @Override
        public Hour[] newArray(int size) {
            return new Hour[size];
        }
    };

    public int getTime_epoch() {
        return time_epoch;
    }

    public void setTime_epoch(int time_epoch) {
        this.time_epoch = time_epoch;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(double temp_c) {
        this.temp_c = temp_c;
    }

    public double getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(double feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public double getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(double wind_kph) {
        this.wind_kph = wind_kph;
    }

    public double getPrecip_mm() {
        return precip_mm;
    }

    public void setPrecip_mm(double precip_mm) {
        this.precip_mm = precip_mm;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getCloud() {
        return cloud;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }

    public double getGust_kph() {
        return gust_kph;
    }

    public void setGust_kph(double gust_kph) {
        this.gust_kph = gust_kph;
    }

    public int getWill_it_rain() {
        return will_it_rain;
    }

    public void setWill_it_rain(int will_it_rain) {
        this.will_it_rain = will_it_rain;
    }

    public String getChance_of_rain() {
        return chance_of_rain;
    }

    public void setChance_of_rain(String chance_of_rain) {
        this.chance_of_rain = chance_of_rain;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(time_epoch);
        dest.writeString(time);
        dest.writeDouble(temp_c);
        dest.writeDouble(feelslike_c);
        dest.writeParcelable(condition, flags);
        dest.writeDouble(wind_kph);
        dest.writeDouble(precip_mm);
        dest.writeInt(humidity);
        dest.writeInt(cloud);
        dest.writeDouble(gust_kph);
        dest.writeInt(will_it_rain);
        dest.writeString(chance_of_rain);
    }
}
