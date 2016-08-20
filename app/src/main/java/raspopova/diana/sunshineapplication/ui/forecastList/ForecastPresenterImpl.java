package raspopova.diana.sunshineapplication.ui.forecastList;

import raspopova.diana.sunshineapplication.Config;
import raspopova.diana.sunshineapplication.repository.model.responseObject;

/**
 * Created by Diana on 19.08.2016.
 */
public class ForecastPresenterImpl implements ForecastPresenter, ForecastInteractor.onDataUpdateListener {

    private ForecastInteractor interactor;
    private ForecastView view;

    public ForecastPresenterImpl() {
        interactor = new ForecastInteractorImpl();
    }

    @Override
    public void onAttacheView(ForecastView view) {
        this.view = view;
    }

    @Override
    public void getForecastList() {
        if (view != null) {
            getList();
        }
    }

    @Override
    public void refreshList() {
        if (view != null) {
            getList();
        }
    }

    private void getList() {
        view.showProgress();

        interactor.getForecastList(Config.COUNTRY_DEFAULT,
                Config.UNITS_DEFAULT,
                String.valueOf(Config.CNT_DEFAULT),
                Config.LANG_DEFAULT,
                Config.APP_ID,
                this);
    }

    @Override
    public void onError(String error) {
        if (view != null) {
            view.hideProgress();
            view.showError(error);
        }
    }

    @Override
    public void onError(int error) {
        if (view != null) {
            view.hideProgress();
            view.showError(error);
        }
    }

    @Override
    public void onDetachView() {
        view = null;
    }

    @Override
    public void onDataReceived(responseObject result) {
        if (view != null) {
            view.hideProgress();
            view.fillWeatherList(result.getList());
        }
    }
}
