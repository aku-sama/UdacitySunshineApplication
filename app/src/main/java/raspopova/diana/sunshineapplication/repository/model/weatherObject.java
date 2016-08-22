package raspopova.diana.sunshineapplication.repository.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Diana on 13.08.2016.
 */
public class weatherObject implements Serializable {

    @SerializedName("id")
    private long id;

    @SerializedName("main")
    private String main;

    @SerializedName("description")
    private String description;

    @SerializedName("icon")
    private String icon;

    public long getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
