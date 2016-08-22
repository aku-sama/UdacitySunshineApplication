package raspopova.diana.sunshineapplication.ui.forecastList;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import raspopova.diana.sunshineapplication.Config;
import raspopova.diana.sunshineapplication.R;
import raspopova.diana.sunshineapplication.repository.model.weatherListObject;
import raspopova.diana.sunshineapplication.ui.weatherDetails.ForecastDetailsActivity;

/**
 * Created by Diana on 10.08.2016.
 */
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {


    private Context context;
    private static LayoutInflater inflater = null;
    private List<weatherListObject> forecastItems;

    public ForecastAdapter(Context context, final List<weatherListObject> list) {
        this.context = context;
        this.forecastItems = new ArrayList<>(list);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_forecats, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final weatherListObject item = forecastItems.get(position);
        String dateString = Config.dateFormat.format(new Date(item.getDt() * 1000));
        String dayTemp = Config.temperatureFormat.format(item.getTemp().getDay());
        String nightTemp = Config.temperatureFormat.format(item.getTemp().getNight());
        String state = item.getWeather().length > 0 ? item.getWeather()[0].getMain() : context.getString(R.string.weather_unknown);

        holder.dateText.setText(dateString);
        holder.descriptionText.setText(state);
        holder.dayTemperatureText.setText(dayTemp + " " + context.getString(R.string.celsius_degree));
        holder.nightTemperatureText.setText(nightTemp + " " + context.getString(R.string.celsius_degree));

        holder.itemRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ForecastDetailsActivity.class);
                intent.putExtra("weather", item);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return forecastItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageForecastItem)
        ImageView weatherImage;
        @BindView(R.id.textViewDate)
        TextView dateText;
        @BindView(R.id.textViewWeatherDescription)
        TextView descriptionText;
        @BindView(R.id.textViewDayTemperature)
        TextView dayTemperatureText;
        @BindView(R.id.textViewNightTemperature)
        TextView nightTemperatureText;

        @BindView(R.id.forecastItemRoot)
        RelativeLayout itemRoot;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
