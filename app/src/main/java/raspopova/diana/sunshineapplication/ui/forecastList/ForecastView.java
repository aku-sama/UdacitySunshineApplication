package raspopova.diana.sunshineapplication.ui.forecastList;

import java.util.List;

import raspopova.diana.sunshineapplication.repository.model.weatherListObject;
import raspopova.diana.sunshineapplication.ui.IGeneralView;

/**
 * Created by Diana on 13.08.2016.
 */
public interface ForecastView extends IGeneralView{

    void fillWeatherList(List<weatherListObject> list);
}
