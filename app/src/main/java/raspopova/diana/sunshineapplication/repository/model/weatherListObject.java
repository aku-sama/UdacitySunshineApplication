package raspopova.diana.sunshineapplication.repository.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Diana on 13.08.2016.
 */
public class weatherListObject implements Serializable {

    @SerializedName("dt")
    private long dt;

    @SerializedName("temp")
    private tempObject temp;

    @SerializedName("pressure")
    private double pressure;

    @SerializedName("humidity")
    private int humidity;

    @SerializedName("weather")
    private weatherObject[] weather;

    @SerializedName("speed")
    private double speed;

    @SerializedName("deg")
    private int deg;

    @SerializedName("clouds")
    private int clouds;

    public long getDt() {
        return dt;
    }

    public tempObject getTemp() {
        return temp;
    }

    public double getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public weatherObject[] getWeather() {
        return weather;
    }

    public double getSpeed() {
        return speed;
    }

    public int getDeg() {
        return deg;
    }

    public int getClouds() {
        return clouds;
    }
}
