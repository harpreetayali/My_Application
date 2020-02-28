package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{


    private Button btn_1,btn_2,btn_3;
    private Toast t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);

        BlankFragment blankFragment = new BlankFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container1,blankFragment).commit();






    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_1:
               t1 = Toast.makeText(this,"Button 1 pressed",Toast.LENGTH_SHORT);
               t1.setGravity(Gravity.TOP|Gravity.LEFT,0,0);
               t1.show();

                BlankFragment blankFragment = new BlankFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container1,blankFragment).commit();
                break;

            case R.id.btn_2:
                t2 = new Toast(getApplicationContext());
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_layout));
                t2.setView(layout);
                t2.setGravity(Gravity.BOTTOM|Gravity.RIGHT,10,10);
                t2.setDuration(Toast.LENGTH_SHORT);
                t2.show();



                break;

            case R.id.btn_3:
                t3 = new Toast(getApplicationContext());
                Toast.makeText(this, "Button 3 pressed", Toast.LENGTH_SHORT).show();
                SecondFragment secondFragment = new SecondFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container1,secondFragment).commit();


                break;
        }

    }



}
