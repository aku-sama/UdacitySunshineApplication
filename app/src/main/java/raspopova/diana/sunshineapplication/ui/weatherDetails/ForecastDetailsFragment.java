package raspopova.diana.sunshineapplication.ui.weatherDetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import raspopova.diana.sunshineapplication.Config;
import raspopova.diana.sunshineapplication.R;
import raspopova.diana.sunshineapplication.repository.model.weatherListObject;

/**
 * Created by Diana on 22.08.2016.
 */
public class ForecastDetailsFragment extends Fragment {
    @BindView(R.id.textForecastDetails)
    TextView forecastText;

    private weatherListObject itemWeather;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_forecast_details, container, false);
        ButterKnife.bind(this, view);

        itemWeather = (weatherListObject) getArguments().getSerializable("weather");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        forecastText.setText(createItemText(itemWeather));

    }

    private String createItemText(weatherListObject item) {
        String weather = "";
        String dateString = Config.dateFormat.format(new Date(item.getDt() * 1000));
        String dayTemp = Config.temperatureFormat.format(item.getTemp().getDay());
        String nightTemp = Config.temperatureFormat.format(item.getTemp().getNight());
        String state = item.getWeather().length > 0 ? item.getWeather()[0].getMain() : getActivity().getString(R.string.weather_unknown);
        weather = String.format(getActivity().getString(R.string.weather_item), dayTemp, nightTemp, dateString, state);
        return weather;
    }


}
