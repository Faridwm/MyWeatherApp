package com.fwmubarok.myforecastweather.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Day {
    @SerializedName("maxtemp_c")
    @Expose
    private Double max_tempC;

    @SerializedName("mintemp_c")
    @Expose
    private Double min_tempC;

    @SerializedName("avgtemp_c")
    @Expose
    private Double avg_tempC;

    @SerializedName("condition")
    @Expose
    private Condition condition;

    @SerializedName("maxwind_kph")
    @Expose
    private Double maxwind_kph;

    @SerializedName("avghumidity")
    @Expose
    private Double avghumidity;

    @SerializedName("totalprecip_mm")
    @Expose
    private Double totalprecip_mm;

    public Double getMax_tempC() {
        return max_tempC;
    }

    public void setMax_tempC(Double max_tempC) {
        this.max_tempC = max_tempC;
    }

    public Double getMin_tempC() {
        return min_tempC;
    }

    public void setMin_tempC(Double min_tempC) {
        this.min_tempC = min_tempC;
    }

    public Double getAvg_tempC() {
        return avg_tempC;
    }

    public void setAvg_tempC(Double avg_tempC) {
        this.avg_tempC = avg_tempC;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Double getMaxwind_kph() {
        return maxwind_kph;
    }

    public void setMaxwind_kph(Double maxwind_kph) {
        this.maxwind_kph = maxwind_kph;
    }

    public Double getAvghumidity() {
        return avghumidity;
    }

    public void setAvghumidity(Double avghumidity) {
        this.avghumidity = avghumidity;
    }

    public Double getTotalprecip_mm() {
        return totalprecip_mm;
    }

    public void setTotalprecip_mm(Double totalprecip_mm) {
        this.totalprecip_mm = totalprecip_mm;
    }
}
