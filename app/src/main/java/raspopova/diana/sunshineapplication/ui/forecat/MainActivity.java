package raspopova.diana.sunshineapplication.ui.forecat;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import raspopova.diana.sunshineapplication.R;
import raspopova.diana.sunshineapplication.ui.GeneralActivity;
import raspopova.diana.sunshineapplication.ui.forecastList.ForecastFragment;

public class MainActivity extends GeneralActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            ForecastFragment forecastFragment = new ForecastFragment();
            forecastFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, forecastFragment).commit();
        }


    }


}
