package raspopova.diana.sunshineapplication.ui.forecastList;

import raspopova.diana.sunshineapplication.ui.IGeneralPresenter;

/**
 * Created by Diana on 13.08.2016.
 */
public interface ForecastPresenter extends IGeneralPresenter {

    void onAttacheView(ForecastView view);

    void getForecastList();

    void refreshList();
}
