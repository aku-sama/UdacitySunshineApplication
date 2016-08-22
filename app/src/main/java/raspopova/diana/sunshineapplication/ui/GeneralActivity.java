package raspopova.diana.sunshineapplication.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import raspopova.diana.sunshineapplication.R;

/**
 * Created by Diana on 19.08.2016.
 */
public class GeneralActivity extends AppCompatActivity {

    private RelativeLayout progress;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {

        LayoutInflater layoutInflater = getLayoutInflater();

        final View container = layoutInflater.inflate(R.layout.activity_general, (ViewGroup) getWindow().getDecorView(), false);
        layoutInflater.inflate(layoutResID, (ViewGroup) container.findViewById(R.id.cont_root), true);

        super.setContentView(layoutResID);

        progress = (RelativeLayout) container.findViewById(R.id.progressLay);
        progress.setVisibility(View.GONE);

        coordinatorLayout = (CoordinatorLayout) container.findViewById(R.id.coordinatorLayout);

    }


    public void showProgressView() {
        progress.setVisibility(View.VISIBLE);

    }
    public void hideProgressView() {
        progress.setVisibility(View.GONE);

    }

    public void showErrorSnack(final String error) {
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, error, Snackbar.LENGTH_LONG)
                .setAction(R.string.dialog_ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });

        // Change background color
        snackbar.getView().setBackgroundColor(getResources().getColor(R.color.white));
        // Changing action button text color
        snackbar.setActionTextColor(getResources().getColor(R.color.colorPrimaryDark));

        // Changing message text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(getResources().getColor(R.color.darkGray));
        textView.setMaxLines(4);
        snackbar.show();
    }
}
