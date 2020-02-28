package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.Timer;
import java.util.TimerTask;

public class CollapsingToolbar extends AppCompatActivity
{
    ViewPager viewPager;
    TabLayout indicator;
    int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar);

        Toolbar toolbar = findViewById(R.id.toolbar_collapse);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        collapsingToolbarLayout.setTitle("Collapsing Toolbar");
        collapsingToolbarLayout.setExpandedTitleColor(Color.BLACK);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
            CollapsingToolbar.this.runOnUiThread(() ->
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
