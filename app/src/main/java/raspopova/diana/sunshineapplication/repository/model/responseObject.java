package raspopova.diana.sunshineapplication.repository.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Diana on 13.08.2016.
 */
public class responseObject {

    @SerializedName("city")
    private cityObject city;

    @SerializedName("cod")
    private String cod;

    @SerializedName("message")
    private double message;

    @SerializedName("cnt")
    private int cnt;

    @SerializedName("list")
    private weatherListObject[] list;

    public cityObject getCity() {
        return city;
    }

    public String getCod() {
        return cod;
    }

    public double getMessage() {
        return message;
    }

    public int getCnt() {
        return cnt;
    }

    public List<weatherListObject> getList() {
        return Arrays.asList(list);
    }
}
