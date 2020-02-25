package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication.TabFragments.TabFragment1;
import com.example.myapplication.TabFragments.TabFragment2;
import com.example.myapplication.TabFragments.TabFragment3;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class NavigationExample extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
                                                                    BottomNavigationView.OnNavigationItemSelectedListener
{
    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_example);

        Toolbar  toolbar = findViewById(R.id.navigation_toolbar);
        toolbar.setTitle("Navigation Drawer");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomListener);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                                                (
                                                this,
                                                drawer,
                                                toolbar,
                                                R.string.navigation_drawer_open,
                                                R.string.navigation_drawer_close
                                                );
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.ic_more);
        toggle.setToolbarNavigationClickListener(view ->
        {
            if (drawer.isDrawerOpen(GravityCompat.START))
            {
                drawer.closeDrawer(GravityCompat.START);
            }
            else
            {
                drawer.openDrawer(GravityCompat.START);
            }

        });
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public void onBackPressed()
    {
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }


    }
    private BottomNavigationView.OnNavigationItemSelectedListener bottomListener = menuItem ->
    {
        switch (menuItem.getItemId())
        {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TabFragment1()).commit();
                break;
            case R.id.nav_favourite:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TabFragment2()).commit();
                break;

            case R.id.nav_search:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TabFragment3()).commit();
                break;
        }
        return true;
    };

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        switch (menuItem.getItemId())
        {
            case R.id.nav_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TabFragment1()).commit();
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_chat:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TabFragment2()).commit();
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TabFragment3()).commit();
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_share:
                startActivity(new Intent(this, SingletonGetData.class));
        }
        return false;
    }


}
