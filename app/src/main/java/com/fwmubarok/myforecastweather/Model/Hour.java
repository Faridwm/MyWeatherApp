package com.fwmubarok.myforecastweather.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hour {
    @SerializedName("time_epoch")
    @Expose
    private Integer time_epoch;

    @SerializedName("time")
    @Expose
    private String time;

    @SerializedName("temp_c")
    @Expose
    private Double temp_c;

    @SerializedName("condition")
    @Expose
    private Condition condition;

    @SerializedName("wind_kph")
    @Expose
    private Double wind_kph;

    @SerializedName("precip_mm")
    @Expose
    private Double precip_mm;

    @SerializedName("humidity")
    @Expose
    private Integer humidity;

    @SerializedName("cloud")
    @Expose
    private Integer cloud;

    @SerializedName("gust_kph")
    @Expose
    private Double gust_kph;

    public Integer getTime_epoch() {
        return time_epoch;
    }

    public void setTime_epoch(Integer time_epoch) {
        this.time_epoch = time_epoch;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(Double temp_c) {
        this.temp_c = temp_c;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Double getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(Double wind_kph) {
        this.wind_kph = wind_kph;
    }

    public Double getPrecip_mm() {
        return precip_mm;
    }

    public void setPrecip_mm(Double precip_mm) {
        this.precip_mm = precip_mm;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getCloud() {
        return cloud;
    }

    public void setCloud(Integer cloud) {
        this.cloud = cloud;
    }

    public Double getGust_kph() {
        return gust_kph;
    }

    public void setGust_kph(Double gust_kph) {
        this.gust_kph = gust_kph;
    }
}
