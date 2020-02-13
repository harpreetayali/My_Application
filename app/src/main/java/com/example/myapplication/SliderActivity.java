package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.tabs.TabLayout;

import java.util.Timer;
import java.util.TimerTask;

public class SliderActivity extends AppCompatActivity
{
    ViewPager viewPager;
    TabLayout indicator;
    int[] images;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);


        viewPager = findViewById(R.id.slider_viewPager);
        indicator = findViewById(R.id.slider_indicator);
        images = new int[]{
                R.drawable.facebook,
                R.drawable.camera,
                R.drawable.android
        };
        SliderAdapter sliderAdapter =new SliderAdapter(this,images);


        viewPager.setAdapter(sliderAdapter);
        indicator.setupWithViewPager(viewPager,true);



        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),2000,4000);





    }

    private class SliderTimer extends TimerTask {

        @Override
        public void run() {
            SliderActivity.this.runOnUiThread(() ->
            {
                if (viewPager.getCurrentItem() < images.length - 1)
                {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
                else {
                    viewPager.setCurrentItem(0);
                }
            });
        }
    }
}
