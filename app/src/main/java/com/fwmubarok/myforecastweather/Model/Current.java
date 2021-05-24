package com.fwmubarok.myforecastweather.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Current {
    @SerializedName("last_updated")
    @Expose
    private String last_updated;

    @SerializedName("temp_c")
    @Expose
    private Double temp_c;

    @SerializedName("condition")
    @Expose
    private Condition condition;

    @SerializedName("wind_kph")
    @Expose
    private Double wind_kph;

    @SerializedName("pressure_mb")
    @Expose
    private Double pressure_mb;

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

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
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

    public Double getPressure_mb() {
        return pressure_mb;
    }

    public void setPressure_mb(Double pressure_mb) {
        this.pressure_mb = pressure_mb;
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
