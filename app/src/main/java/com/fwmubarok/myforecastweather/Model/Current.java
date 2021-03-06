package com.fwmubarok.myforecastweather.Model;

import com.google.gson.annotations.SerializedName;

public class Current {
    @SerializedName("last_updated")
    private String last_updated;

    @SerializedName("temp_c")
    private double temp_c;

    @SerializedName("condition")
    private Condition condition;

    @SerializedName("wind_kph")
    private double wind_kph;

    @SerializedName("pressure_mb")
    private double pressure_mb;

    @SerializedName("precip_mm")
    private double precip_mm;

    @SerializedName("humidity")
    private int humidity;

    @SerializedName("cloud")
    private int cloud;

    @SerializedName("gust_kph")
    private double gust_kph;

    @SerializedName("air_quality")
    private AirQuality airQuality;

    public AirQuality getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(AirQuality airQuality) {
        this.airQuality = airQuality;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(double temp_c) {
        this.temp_c = temp_c;
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

    public double getPressure_mb() {
        return pressure_mb;
    }

    public void setPressure_mb(double pressure_mb) {
        this.pressure_mb = pressure_mb;
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
}
