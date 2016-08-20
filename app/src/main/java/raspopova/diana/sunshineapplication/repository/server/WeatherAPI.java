package raspopova.diana.sunshineapplication.repository.server;

import raspopova.diana.sunshineapplication.repository.model.responseObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Diana on 14.08.2016.
 */
public interface WeatherAPI {

    @GET(Urls.DAILY_WEATHER)
    Call<responseObject> getWeather(@Query("q") String countryCode,
                                    @Query("units") String units,
                                    @Query("cnt") String dayCount,
                                    @Query("lang") String language,
                                    @Query("appId") String appId);

}
