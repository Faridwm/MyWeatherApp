package com.fwmubarok.myforecastweather.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Day implements Parcelable {
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

    protected Day(Parcel in) {
        if (in.readByte() == 0) {
            max_tempC = null;
        } else {
            max_tempC = in.readDouble();
        }
        if (in.readByte() == 0) {
            min_tempC = null;
        } else {
            min_tempC = in.readDouble();
        }
        if (in.readByte() == 0) {
            avg_tempC = null;
        } else {
            avg_tempC = in.readDouble();
        }
        condition = in.readParcelable(Condition.class.getClassLoader());
        if (in.readByte() == 0) {
            maxwind_kph = null;
        } else {
            maxwind_kph = in.readDouble();
        }
        if (in.readByte() == 0) {
            avghumidity = null;
        } else {
            avghumidity = in.readDouble();
        }
        if (in.readByte() == 0) {
            totalprecip_mm = null;
        } else {
            totalprecip_mm = in.readDouble();
        }
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (max_tempC == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(max_tempC);
        }
        if (min_tempC == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(min_tempC);
        }
        if (avg_tempC == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(avg_tempC);
        }
        dest.writeParcelable(condition, flags);
        if (maxwind_kph == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(maxwind_kph);
        }
        if (avghumidity == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(avghumidity);
        }
        if (totalprecip_mm == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(totalprecip_mm);
        }
    }
}
