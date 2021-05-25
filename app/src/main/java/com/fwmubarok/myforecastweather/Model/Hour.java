package com.fwmubarok.myforecastweather.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hour implements Parcelable {
    @SerializedName("time_epoch")
    @Expose
    private Integer time_epoch;

    @SerializedName("time")
    @Expose
    private String time;

    @SerializedName("temp_c")
    @Expose
    private Double temp_c;

    @SerializedName("feelslike_c")
    @Expose
    private Double feelslike_c;

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

    @SerializedName("will_it_rain")
    @Expose
    private Integer will_it_rain;

    @SerializedName("chance_of_rain")
    @Expose
    private String chance_of_rain;

    protected Hour(Parcel in) {
        if (in.readByte() == 0) {
            time_epoch = null;
        } else {
            time_epoch = in.readInt();
        }
        time = in.readString();
        if (in.readByte() == 0) {
            temp_c = null;
        } else {
            temp_c = in.readDouble();
        }
        if (in.readByte() == 0) {
            feelslike_c = null;
        } else {
            feelslike_c = in.readDouble();
        }
        condition = in.readParcelable(Condition.class.getClassLoader());
        if (in.readByte() == 0) {
            wind_kph = null;
        } else {
            wind_kph = in.readDouble();
        }
        if (in.readByte() == 0) {
            precip_mm = null;
        } else {
            precip_mm = in.readDouble();
        }
        if (in.readByte() == 0) {
            humidity = null;
        } else {
            humidity = in.readInt();
        }
        if (in.readByte() == 0) {
            cloud = null;
        } else {
            cloud = in.readInt();
        }
        if (in.readByte() == 0) {
            gust_kph = null;
        } else {
            gust_kph = in.readDouble();
        }
        if (in.readByte() == 0) {
            will_it_rain = null;
        } else {
            will_it_rain = in.readInt();
        }
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

    public Double getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(Double feelslike_c) {
        this.feelslike_c = feelslike_c;
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

    public Integer getWill_it_rain() {
        return will_it_rain;
    }

    public void setWill_it_rain(Integer will_it_rain) {
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
        if (time_epoch == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(time_epoch);
        }
        dest.writeString(time);
        if (temp_c == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(temp_c);
        }
        if (feelslike_c == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(feelslike_c);
        }
        dest.writeParcelable(condition, flags);
        if (wind_kph == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(wind_kph);
        }
        if (precip_mm == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(precip_mm);
        }
        if (humidity == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(humidity);
        }
        if (cloud == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(cloud);
        }
        if (gust_kph == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(gust_kph);
        }
        if (will_it_rain == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(will_it_rain);
        }
        dest.writeString(chance_of_rain);
    }
}
