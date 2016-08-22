package raspopova.diana.sunshineapplication.ui.forecastList;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import raspopova.diana.sunshineapplication.R;
import raspopova.diana.sunshineapplication.repository.model.weatherListObject;
import raspopova.diana.sunshineapplication.ui.GeneralActivity;

/**
 * Created by Diana on 10.08.2016.
 */
public class ForecastFragment extends Fragment implements ForecastView {

    @BindView(R.id.recyclerViewForecast)
    RecyclerView forecastRecyclerView;

    private LinearLayoutManager mLayoutManager;
    private ForecastAdapter adapter;

    private ForecastPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new ForecastPresenterImpl();
        mLayoutManager = new LinearLayoutManager(getActivity());
        forecastRecyclerView.setLayoutManager(mLayoutManager);
        presenter.onAttacheView(this);
        presenter.getForecastList();
    }


    @Override
    public void onStop() {
        presenter.onDetachView();
        super.onStop();
    }


    @Override
    public void fillWeatherList(List<weatherListObject> list) {
        adapter = new ForecastAdapter(getActivity(), list);
        forecastRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showError(String error) {
        ((GeneralActivity) getActivity()).showErrorSnack(error);
    }

    @Override
    public void showError(int error) {
        ((GeneralActivity) getActivity()).showErrorSnack(getString(error));

    }

    @Override
    public void showProgress() {
        ((GeneralActivity) getActivity()).showProgressView();

    }

    @Override
    public void hideProgress() {
        ((GeneralActivity) getActivity()).hideProgressView();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                presenter.getForecastList();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
