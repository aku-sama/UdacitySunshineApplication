package raspopova.diana.sunshineapplication;

import android.app.Application;

import raspopova.diana.sunshineapplication.repository.server.RetrofitForMyApp;

/**
 * Created by Diana on 14.08.2016.
 */
public class WeatherApplication extends Application {

    private static WeatherApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initRetrofit();
    }


    private void initRetrofit() {
        RetrofitForMyApp.init();
    }

    public static WeatherApplication getInstance() {
        return instance;
    }
}
