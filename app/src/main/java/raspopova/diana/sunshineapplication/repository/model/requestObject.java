package raspopova.diana.sunshineapplication.repository.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Diana on 14.08.2016.
 */
public class requestObject {

    @SerializedName("q") // city name and country code divided by comma, use ISO 3166 country codes
    private long postcode;

    @SerializedName("units")
    private String units;

    @SerializedName("cnt") //number of days returned (from 1 to 16)
    private int dayCount;

    @SerializedName("lang")
    private String lang;

    @SerializedName("appId")
    private String appId;

}
