package raspopova.diana.sunshineapplication.repository.server;

import raspopova.diana.sunshineapplication.repository.model.responseObject;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Diana on 14.08.2016.
 */
public class ServerMethods {

    public static void getWeatherFromServer(String countryCode,
                                            String units,
                                            String dayCount,
                                            String language,
                                            String appId,
                                            Callback<responseObject> cb) {
        // prepare call in Retrofit 2.0
        WeatherAPI weatherApi = RetrofitForMyApp.getRetrofit().create(WeatherAPI.class);

        Call<responseObject> call = weatherApi.getWeather(countryCode,units,dayCount,language,appId);
        //asynchronous call
        call.enqueue(cb);
    }
}
