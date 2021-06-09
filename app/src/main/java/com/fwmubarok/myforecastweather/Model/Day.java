package com.fwmubarok.myforecastweather.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Day implements Parcelable {
    @SerializedName("maxtemp_c")
    private double max_tempC;

    @SerializedName("mintemp_c")
    private double min_tempC;

    @SerializedName("avgtemp_c")
    private double avg_tempC;

    @SerializedName("condition")
    private Condition condition;

    @SerializedName("maxwind_kph")
    private double maxwind_kph;

    @SerializedName("avghumidity")
    private double avghumidity;

    @SerializedName("totalprecip_mm")
    private double totalprecip_mm;

    protected Day(Parcel in) {
        max_tempC = in.readDouble();
        min_tempC = in.readDouble();
        avg_tempC = in.readDouble();
        condition = in.readParcelable(Condition.class.getClassLoader());
        maxwind_kph = in.readDouble();
        avghumidity = in.readDouble();
        totalprecip_mm = in.readDouble();
    }

    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel in) {
            return new Day(in);
        }

        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };

    public double getMax_tempC() {
        return max_tempC;
    }

    public void setMax_tempC(double max_tempC) {
        this.max_tempC = max_tempC;
    }

    public double getMin_tempC() {
        return min_tempC;
    }

    public void setMin_tempC(double min_tempC) {
        this.min_tempC = min_tempC;
    }

    public double getAvg_tempC() {
        return avg_tempC;
    }

    public void setAvg_tempC(double avg_tempC) {
        this.avg_tempC = avg_tempC;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public double getMaxwind_kph() {
        return maxwind_kph;
    }

    public void setMaxwind_kph(double maxwind_kph) {
        this.maxwind_kph = maxwind_kph;
    }

    public double getAvghumidity() {
        return avghumidity;
    }

    public void setAvghumidity(double avghumidity) {
        this.avghumidity = avghumidity;
    }

    public double getTotalprecip_mm() {
        return totalprecip_mm;
    }

    public void setTotalprecip_mm(double totalprecip_mm) {
        this.totalprecip_mm = totalprecip_mm;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(max_tempC);
        dest.writeDouble(min_tempC);
        dest.writeDouble(avg_tempC);
        dest.writeParcelable(condition, flags);
        dest.writeDouble(maxwind_kph);
        dest.writeDouble(avghumidity);
        dest.writeDouble(totalprecip_mm);
    }
}
