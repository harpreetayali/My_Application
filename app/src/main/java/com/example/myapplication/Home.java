package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.TabActivity.ExampleTabLayout;

public class Home extends AppCompatActivity implements View.OnClickListener
{
    Button btn_alertSlider_activity,btn_asyncTask_activity,btn_collapsing_toolbar_activity,btn_singleton_activity,
            btn_navigation_activity, btn_list_view_activity,
            btn_slider_activity, btn_tab_layout_activity,
            btn_camera_activity, btn_button_display_activity,
            btn_register_activity, btn_login_activity,
            btn_main_activity;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_alertSlider_activity = findViewById(R.id.btn_alertSlider_activity);
        btn_asyncTask_activity = findViewById(R.id.btn_asyncTask_activity);
        btn_collapsing_toolbar_activity = findViewById(R.id.btn_collapsing_toolbar_activity);
        btn_singleton_activity = findViewById(R.id.btn_singleton_activity);
        btn_navigation_activity = findViewById(R.id.btn_navigation_activity);
        btn_list_view_activity = findViewById(R.id.btn_list_view_activity);
        btn_slider_activity = findViewById(R.id.btn_slider_activity);
        btn_tab_layout_activity = findViewById(R.id.btn_tab_layout_activity);
        btn_camera_activity = findViewById(R.id.btn_camera_activity);
        btn_button_display_activity = findViewById(R.id.btn_button_display_activity);
        btn_register_activity = findViewById(R.id.btn_register_activity);
        btn_login_activity = findViewById(R.id.btn_login_activity);
        btn_main_activity = findViewById(R.id.btn_main_activity);

        btn_alertSlider_activity.setOnClickListener(this);
        btn_asyncTask_activity.setOnClickListener(this);
        btn_collapsing_toolbar_activity.setOnClickListener(this);
        btn_singleton_activity.setOnClickListener(this);
        btn_navigation_activity.setOnClickListener(this);
        btn_list_view_activity.setOnClickListener(this);
        btn_slider_activity.setOnClickListener(this);
        btn_tab_layout_activity.setOnClickListener(this);
        btn_camera_activity.setOnClickListener(this);
        btn_button_display_activity.setOnClickListener(this);
        btn_register_activity.setOnClickListener(this);
        btn_login_activity.setOnClickListener(this);
        btn_main_activity.setOnClickListener(this);


    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_alertSlider_activity:
                startActivity(new Intent(this,AlertSlider.class));
                break;
            case R.id.btn_asyncTask_activity:
                startActivity(new Intent(this,AsynctaskExample.class));
                break;
            case R.id.btn_collapsing_toolbar_activity:
                startActivity(new Intent(this,CollapsingToolbar.class));
                break;
            case R.id.btn_singleton_activity:
                startActivity(new Intent(this,SingletonSetData.class));
                break;
            case R.id.btn_navigation_activity:
                startActivity(new Intent(this,NavigationExample.class));
                break;
            case R.id.btn_list_view_activity:
                startActivity(new Intent(this,ListViewExample.class));
                break;
            case R.id.btn_slider_activity:
                startActivity(new Intent(this,SliderActivity.class));
                break;
            case R.id.btn_tab_layout_activity:
                startActivity(new Intent(this, ExampleTabLayout.class));
                break;
            case R.id.btn_camera_activity:
                startActivity(new Intent(this,CameraIntent.class));
                break;
            case R.id.btn_button_display_activity:
                startActivity(new Intent(this,ButtonDisplay.class));
                break;
            case R.id.btn_register_activity:
                startActivity(new Intent(this,Register.class));
                break;
            case R.id.btn_login_activity:
                startActivity(new Intent(this,Login.class));
                break;
            case R.id.btn_main_activity:
                startActivity(new Intent(this,MainActivity.class));
                break;
        }

    }
}
