package raspopova.diana.sunshineapplication.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import raspopova.diana.sunshineapplication.WeatherApplication;

/**
 * Created by Diana on 19.08.2016.
 */
public class OnlineChecker {

    public static boolean isOnline() {
        try {
            ConnectivityManager cm = (ConnectivityManager) WeatherApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
            return cm.getActiveNetworkInfo().isConnectedOrConnecting();
        } catch (Exception e) {
            return false;
        }
    }
}
