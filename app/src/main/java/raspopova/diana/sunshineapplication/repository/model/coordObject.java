package raspopova.diana.sunshineapplication.repository.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Diana on 13.08.2016.
 */
public class coordObject {

    @SerializedName("lon")
    private double lon;

    @SerializedName("lat")
    private double lat;

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

}
