package raspopova.diana.sunshineapplication.repository.server;

import android.app.ActivityManager;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Diana on 14.08.2016.
 */
public class RetrofitForMyApp {

    private static Retrofit mRetrofit;
    private static Gson mGson;

    private RetrofitForMyApp() {
        // no instances
    }

    public static void init( ) {
        mGson = new GsonBuilder()
                .create();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .build();
    }


    public static Retrofit getRetrofit() {
        if (mRetrofit != null) {
            return mRetrofit;
        } else {
            throw new IllegalStateException("mRetrofit not initialized");
        }
    }

}
