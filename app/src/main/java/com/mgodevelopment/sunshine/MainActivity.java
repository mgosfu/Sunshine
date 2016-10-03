package com.mgodevelopment.sunshine;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
implements ForecastFragment.OnFragmentInteractionListener {


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_main, new ForecastFragment())
                    .commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {

        ArrayAdapter<String> mForecastAdapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            String[] weekForecast = {
                    ("Today - Sunny - 20 / 13"),
                    ("Tomorrow - Foggy - 18 / 5"),
                    ("Tuesday - Rainy - 13 / 8"),
                    ("Wednesday - Snowing - 25 / 17"),
                    ("Thursday - Hurricane - 31 / 22"),
                    ("Friday - Sunny - 12 / 2"),
                    ("Saturday - Slushy - 11 / 5")
            };

            mForecastAdapter = new ArrayAdapter<String>(getActivity(),
                    R.layout.list_item_forcast,
                    R.id.list_item_forecast_textview,
                    weekForecast);

            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);

            listView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}
