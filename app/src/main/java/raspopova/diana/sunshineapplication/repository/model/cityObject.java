package raspopova.diana.sunshineapplication.repository.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Diana on 13.08.2016.
 */
public class cityObject {
    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("coord")
    private coordObject coord;

    @SerializedName("country")
    private String country;

    @SerializedName("population")
    private long population;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public coordObject getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    public long getPopulation() {
        return population;
    }
}
