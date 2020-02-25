package com.example.myapplication;

import android.app.Application;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

public class CustomApplication extends Application
{

    private static Singleton singleton;

    public static Singleton getInstance()
    {
        return singleton;
    }
    @Override
    public void onCreate()
    {
        super.onCreate();

        this.singleton = new Singleton();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);

    }

    @Override
    public void onLowMemory()
    {
        super.onLowMemory();

    }
}
