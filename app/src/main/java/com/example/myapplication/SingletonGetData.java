package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SingletonGetData extends AppCompatActivity
{

    private Button show_btn,prev_btn;
    private TextView username_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleton_get_data);

        Toolbar toolbar = findViewById(R.id.singletonGetToolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Singleton Set Data");

        username_tv = findViewById(R.id.username_tv);
        prev_btn = findViewById(R.id.prev_screen);
        CustomApplication customApplication = (CustomApplication) getApplicationContext();

        show_btn = findViewById(R.id.getUsername);
        show_btn.setOnClickListener(view ->
        {
            username_tv.setText("Username : "+CustomApplication.getInstance().getUsername());
        });

        prev_btn.setOnClickListener(view ->
        {
            startActivity(new Intent(this,SingletonSetData.class));
            this.finish();
        });



    }
}
