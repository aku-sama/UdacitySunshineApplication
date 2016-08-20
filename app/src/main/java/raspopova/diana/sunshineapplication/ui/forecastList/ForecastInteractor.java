package raspopova.diana.sunshineapplication.ui.forecastList;

import raspopova.diana.sunshineapplication.repository.model.responseObject;
import raspopova.diana.sunshineapplication.ui.IGeneralInteractorListener;

/**
 * Created by Diana on 13.08.2016.
 */
public interface ForecastInteractor {

    interface onDataUpdateListener extends IGeneralInteractorListener{
        void onDataReceived(responseObject result);
    }

    void getForecastList(String countryCode,
                         String units,
                         String dayCount,
                         String language,
                         String appId,
                         onDataUpdateListener listener);
}
