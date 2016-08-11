package raspopova.diana.sunshineapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import raspopova.diana.sunshineapplication.adapters.ForecastAdapter;

/**
 * Created by Diana on 10.08.2016.
 */
public class MainFragment extends Fragment {

    @BindView(R.id.recyclerViewForecast)
    RecyclerView forecastRecyclerView;

    private LinearLayoutManager mLayoutManager;
    private ForecastAdapter adapter;

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

        mLayoutManager = new LinearLayoutManager(getActivity());
        forecastRecyclerView.setLayoutManager(mLayoutManager);

        initTestForecastList();
    }

    private void initTestForecastList() {
        List<String> testList = new ArrayList<>();
        testList.add("Today, Sunny, 21oC/15oC");
        testList.add("Tomorrow, Foggy, 17oC/12oC");
        testList.add("Fri., Rainy, 23oC/10oC");
        testList.add("Sat., Cloudy, 19oC/16oC");
        testList.add("Son., Sunny, 31oC/22oC");
        testList.add("Mon., Rainy, 26oC/16oC");
        testList.add("Tues., Sunny, 24oC/14oC");

        adapter = new ForecastAdapter(getActivity(), testList);
        forecastRecyclerView.setAdapter(adapter);
    }
}
