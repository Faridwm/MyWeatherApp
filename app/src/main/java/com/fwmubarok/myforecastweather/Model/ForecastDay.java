package com.fwmubarok.myforecastweather.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastDay implements Parcelable {
    @SerializedName("date")
    private String date;

    @SerializedName("date_epoch")
    private long dateEpoch;

    @SerializedName("day")
    private Day day;

    @SerializedName("astro")
    private Astro astro;

    @SerializedName("hour")
    private List<Hour> hour;

    protected ForecastDay(Parcel in) {
        date = in.readString();
        dateEpoch = in.readLong();
        day = in.readParcelable(Day.class.getClassLoader());
        astro = in.readParcelable(Astro.class.getClassLoader());
        hour = in.createTypedArrayList(Hour.CREATOR);
    }

    public static final Creator<ForecastDay> CREATOR = new Creator<ForecastDay>() {
        @Override
        public ForecastDay createFromParcel(Parcel in) {
            return new ForecastDay(in);
        }

        @Override
        public ForecastDay[] newArray(int size) {
            return new ForecastDay[size];
        }
    };

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getDateEpoch() {
        return dateEpoch;
    }

    public void setDateEpoch(Integer dateEpoch) {
        this.dateEpoch = dateEpoch;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Astro getAstro() {
        return astro;
    }

    public void setAstro(Astro astro) {
        this.astro = astro;
    }

    public List<Hour> getHour() {
        return hour;
    }

    public void setHour(List<Hour> hour) {
        this.hour = hour;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeLong(dateEpoch);
        dest.writeParcelable(day, flags);
        dest.writeParcelable(astro, flags);
        dest.writeTypedList(hour);
    }
}
