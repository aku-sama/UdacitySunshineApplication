package raspopova.diana.sunshineapplication.ui.weatherDetails;

import android.os.Bundle;

import raspopova.diana.sunshineapplication.R;
import raspopova.diana.sunshineapplication.repository.model.weatherListObject;
import raspopova.diana.sunshineapplication.ui.GeneralActivity;
import raspopova.diana.sunshineapplication.ui.forecastList.ForecastFragment;

/**
 * Created by Diana on 22.08.2016.
 */
public class ForecastDetailsActivity extends GeneralActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast_details);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            ForecastDetailsFragment forecastDetailsFragment = new ForecastDetailsFragment();
            forecastDetailsFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, forecastDetailsFragment).commit();
        }



    }
}
