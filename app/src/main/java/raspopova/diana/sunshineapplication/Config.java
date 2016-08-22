package raspopova.diana.sunshineapplication;

import java.text.DateFormat;
import java.text.DecimalFormat;

import raspopova.diana.sunshineapplication.repository.model.eUnits;

/**
 * Created by Diana on 14.08.2016.
 */
public class Config {

    public static final DateFormat dateFormat = DateFormat.getDateInstance();
    public static final DecimalFormat temperatureFormat = new DecimalFormat("#.#");

    public static String APP_ID = "a45199001eafc373637d40d332432d15";

    public static String UNITS_DEFAULT = eUnits.METRIC.toString();
    public static int CNT_DEFAULT = 7;
    public static String COUNTRY_DEFAULT = "630000";
    public static String LANG_DEFAULT = "en_US";


}
