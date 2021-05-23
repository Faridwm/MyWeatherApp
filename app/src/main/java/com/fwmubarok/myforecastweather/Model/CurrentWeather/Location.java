package com.fwmubarok.myforecastweather.Model.CurrentWeather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("region")
    @Expose
    private String region;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("lat")
    @Expose
    private Double lat;

    @SerializedName("lon")
    @Expose
    private Double lon;

    @SerializedName("tz_id")
    @Expose
    private String tz_id;

    @SerializedName("localtime_epoch")
    @Expose
    private Integer localtime_epoch;

    @SerializedName("localtime")
    @Expose
    private String localtime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getTz_id() {
        return tz_id;
    }

    public void setTz_id(String tz_id) {
        this.tz_id = tz_id;
    }

    public Integer getLocaltime_epoch() {
        return localtime_epoch;
    }

    public void setLocaltime_epoch(Integer localtime_epoch) {
        this.localtime_epoch = localtime_epoch;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }
}
