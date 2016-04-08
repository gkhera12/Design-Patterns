package com.eightleaves.observerpattern;


import java.util.concurrent.Callable;

/*public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(80,65,30.45f);
    }
}*/
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Button weatherBtn;
    private EditText tempText;
    private EditText humidityText;
    private EditText pressureText;
    WeatherData weatherData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        weatherBtn = (Button)findViewById(R.id.test_btn);
        tempText =(EditText)findViewById(R.id.temperature);
        humidityText =(EditText)findViewById(R.id.humidity);
        pressureText =(EditText)findViewById(R.id.pressure);
        weatherBtn.setOnClickListener(this);

    }

    private void setupViewPager(ViewPager viewPager) {

        weatherData = new WeatherData();
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CurrentConditionDisplay(weatherData), "Today");
        adapter.addFragment(new StatisticsDisplay(weatherData), "Stats");
        adapter.addFragment(new ForecastDisplay(weatherData), "Forecast");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if(!TextUtils.isEmpty(tempText.getText().toString())
                && !TextUtils.isEmpty(humidityText.getText().toString())
                && !TextUtils.isEmpty(pressureText.getText().toString())) {
            weatherData.setMeasurements(tempText.getText().toString(),
                    humidityText.getText().toString(), pressureText.getText().toString());
        }
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}