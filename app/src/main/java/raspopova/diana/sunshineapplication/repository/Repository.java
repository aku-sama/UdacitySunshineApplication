package raspopova.diana.sunshineapplication.repository;

import android.util.Log;

import raspopova.diana.sunshineapplication.R;
import raspopova.diana.sunshineapplication.repository.model.responseObject;
import raspopova.diana.sunshineapplication.repository.server.ServerMethods;
import raspopova.diana.sunshineapplication.ui.forecastList.ForecastInteractor;
import raspopova.diana.sunshineapplication.utils.OnlineChecker;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Diana on 19.08.2016.
 */
public class Repository {

    public static void getWeatherList(String countryCode,
                                      String units,
                                      String dayCount,
                                      String language,
                                      String appId, final ForecastInteractor.onDataUpdateListener listener) {


        if (OnlineChecker.isOnline()) {
            getFromServer(countryCode, units, dayCount, language, appId, listener);
        } else {
            listener.onError(R.string.http_no_internet);
        }
    }

    private static void getFromServer(String countryCode,
                                      String units,
                                      String dayCount,
                                      String language,
                                      String appId,
                                      final ForecastInteractor.onDataUpdateListener listener)
    {
        ServerMethods.getWeatherFromServer(countryCode, units, dayCount, language, appId, new Callback<responseObject>() {
            @Override
            public void onResponse(Call<responseObject> call, Response<responseObject> response) {
                Log.d("TEMP",response.headers().toString());
                Log.d("TEMP",response.toString());
                listener.onDataReceived(response.body());
            }

            @Override
            public void onFailure(Call<responseObject> call, Throwable t) {
                listener.onError(t.getLocalizedMessage());
            }
        });
    }
}
