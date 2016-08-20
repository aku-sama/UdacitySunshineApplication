package raspopova.diana.sunshineapplication.ui.forecastList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import raspopova.diana.sunshineapplication.R;
import raspopova.diana.sunshineapplication.repository.model.weatherListObject;

/**
 * Created by Diana on 10.08.2016.
 */
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {
    private DateFormat dateFormat = DateFormat.getDateInstance();
    public static final DecimalFormat temperatureFormat = new DecimalFormat("#.#");

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
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.forecastText.setText(createItemText(forecastItems.get(position)));
    }

    @Override
    public int getItemCount() {
        return forecastItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textViewListItemForecast)
        TextView forecastText;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private String createItemText(weatherListObject item) {
        String weather = "";
        String dateString = dateFormat.format(new Date(item.getDt()*1000));
        String dayTemp = temperatureFormat.format(item.getTemp().getDay());
        String nightTemp = temperatureFormat.format(item.getTemp().getNight());
        String state = item.getWeather().length > 0 ? item.getWeather()[0].getDescription() : context.getString(R.string.weather_unknown);
        weather = String.format(context.getString(R.string.weather_item), dayTemp, nightTemp, dateString, state);
        return weather;
    }
}
