package raspopova.diana.sunshineapplication.ui;

/**
 * Created by Diana on 19.08.2016.
 */
public interface IGeneralView {

    void showError(String error);

    void showError(int error);

    void showProgress();

    void hideProgress();

}
