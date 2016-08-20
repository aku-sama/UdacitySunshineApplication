package raspopova.diana.sunshineapplication.ui.forecastList;

import raspopova.diana.sunshineapplication.repository.Repository;

/**
 * Created by Diana on 19.08.2016.
 */
public class ForecastInteractorImpl implements ForecastInteractor {


    @Override
    public void getForecastList(String countryCode, String units, String dayCount, String language, String appId, onDataUpdateListener listener) {

        Repository.getWeatherList(countryCode, units, dayCount, language, appId, listener);

    }
}
