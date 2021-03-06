package com.fwmubarok.myforecastweather.Model;

import com.google.gson.annotations.SerializedName;

public class AirQuality {
    @SerializedName("co")
    private double co;

    @SerializedName("no2")
    private double no2;

    @SerializedName("o3")
    private double o3;

    @SerializedName("so2")
    private double so2;

    @SerializedName("pm2_5")
    private double pm25;

    @SerializedName("pm10")
    private double pm10;

    @SerializedName("us-epa-index")
    private int usEpaIndex;

    @SerializedName("gb-defra-index")
    private int gbDefraIndex;

    public double getCo() {
        return co;
    }

    public void setCo(double co) {
        this.co = co;
    }

    public double getNo2() {
        return no2;
    }

    public void setNo2(double no2) {
        this.no2 = no2;
    }

    public double getO3() {
        return o3;
    }

    public void setO3(double o3) {
        this.o3 = o3;
    }

    public double getSo2() {
        return so2;
    }

    public void setSo2(double so2) {
        this.so2 = so2;
    }

    public double getPm25() {
        return pm25;
    }

    public void setPm25(double pm25) {
        this.pm25 = pm25;
    }

    public double getPm10() {
        return pm10;
    }

    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }

    public int getUsEpaIndex() {
        return usEpaIndex;
    }

    public void setUsEpaIndex(int usEpaIndex) {
        this.usEpaIndex = usEpaIndex;
    }

    public int getGbDefraIndex() {
        return gbDefraIndex;
    }

    public void setGbDefraIndex(int gbDefraIndex) {
        this.gbDefraIndex = gbDefraIndex;
    }
}
