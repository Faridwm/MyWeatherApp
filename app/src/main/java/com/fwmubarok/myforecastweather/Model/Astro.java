package com.fwmubarok.myforecastweather.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Astro {
    @SerializedName("sunrise")
    @Expose
    private String sunrise;
    @SerializedName("sunset")
    @Expose
    private String sunset;
    @SerializedName("moonrise")
    @Expose
    private String moonrise;
    @SerializedName("moonset")
    @Expose
    private String moonset;
    @SerializedName("moon_phase")
    @Expose
    private String moon_phase;
    @SerializedName("moon_illumination")
    @Expose
    private String moon_illumination;

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }

    public String getMoonset() {
        return moonset;
    }

    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }

    public String getMoon_phase() {
        return moon_phase;
    }

    public void setMoon_phase(String moon_phase) {
        this.moon_phase = moon_phase;
    }

    public String getMoon_illumination() {
        return moon_illumination;
    }

    public void setMoon_illumination(String moon_illumination) {
        this.moon_illumination = moon_illumination;
    }
}
