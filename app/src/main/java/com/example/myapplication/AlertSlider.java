package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.Timer;
import java.util.TimerTask;

public class AlertSlider extends AppCompatActivity implements View.OnClickListener
{
    private Button btn_alertSlider,btn_alertSlider2;
    private ViewPager viewPager;
    private TabLayout indicator;
    private int[] images;
    private String[] titles,descriptions;
    private LayoutInflater inflater;
    private View alertLayout,alertLayout2;
    private RelativeLayout alert_subscription_banner1,alert_subscription_banner2,alert_subscription_banner3;
    private TextView tv_offer_alert1,tv_offer_alert2,tv_offer_alert3,
            tv_period_alert1, tv_period_alert2,tv_period_alert3,
            tv_period_alert1_1,tv_period_alert2_1,tv_period_alert3_1,
            tv_price_alert1,tv_price_alert2,tv_price_alert3,
            tv_fullPrice_alert1,tv_fullPrice_alert2,tv_fullPrice_alert3;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_slider);

        inflater = getLayoutInflater();
        alertLayout = inflater.inflate(R.layout.alert_slider_layout,null);
        alertLayout2 = inflater.inflate(R.layout.alert_slider_layout_2,null);

        btn_alertSlider = findViewById(R.id.btn_alertSlider);
        btn_alertSlider2 = findViewById(R.id.btn_alertSlider2);

        setSlider(alertLayout);
        setSlider(alertLayout2);

        btn_alertSlider.setOnClickListener(this);
        btn_alertSlider2.setOnClickListener(this);

    }

    public void registerWithIDs(View v)
    {
        alert_subscription_banner1= v.findViewById(R.id.alert_subscription_banner1);
        alert_subscription_banner2= v.findViewById(R.id.alert_subscription_banner2);
        alert_subscription_banner3= v.findViewById(R.id.alert_subscription_banner3);

        //Banner  Offer TextViews
        tv_offer_alert1 = v.findViewById(R.id.tv_offer_alert1);
        tv_offer_alert2 = v.findViewById(R.id.tv_offer_alert2);
        tv_offer_alert3 = v.findViewById(R.id.tv_offer_alert3);

        //Banner Period TextViews
        tv_period_alert1 = v.findViewById(R.id.tv_period_alert1);
        tv_period_alert2 = v.findViewById(R.id.tv_period_alert2);
        tv_period_alert3 = v.findViewById(R.id.tv_period_alert3);

        tv_period_alert1_1 = v.findViewById(R.id.tv_period_alert1_1);
        tv_period_alert2_1 = v.findViewById(R.id.tv_period_alert2_1);
        tv_period_alert3_1 = v.findViewById(R.id.tv_period_alert3_1);

        //Banner Price TextViews
        tv_price_alert1 = v.findViewById(R.id.tv_price_alert1);
        tv_price_alert2 = v.findViewById(R.id.tv_price_alert2);
        tv_price_alert3 = v.findViewById(R.id.tv_price_alert3);

        //Banner Full Price TextViews
        tv_fullPrice_alert1 = v.findViewById(R.id.tv_fullPrice_alert1);
        tv_fullPrice_alert2 = v.findViewById(R.id.tv_fullPrice_alert2);
        tv_fullPrice_alert3 = v.findViewById(R.id.tv_fullPrice_alert3);

        alert_subscription_banner1.setOnClickListener(this);
        alert_subscription_banner2.setOnClickListener(this);
        alert_subscription_banner3.setOnClickListener(this);
    }
    public void setSlider(View v)
    {
        viewPager = v.findViewById(R.id.slider_viewPager_alert);
        indicator = v.findViewById(R.id.slider_indicator_alert);
        images = new int[]{
                R.drawable.girl,
                R.drawable.obama,
                R.drawable.boy,
                R.drawable.obama,
                R.drawable.girl
        };
        titles = new String[]{ "5 Free Super Likes A Day", "Boy", "Girl", "Boy", "Girl"};
        descriptions = new String[]{ "You're 5x more likely to get a match",
                                    "You're 6x more likely to get a match",
                                    "You're 7x more likely to get a match",
                                    "You're 8x more likely to get a match",
                                    "You're 9x more likely to get a match"};

        AlertSliderAdapter sliderAdapter =new AlertSliderAdapter(this,images,titles,descriptions);

        viewPager.setAdapter(sliderAdapter);
        indicator.setupWithViewPager(viewPager,true);



    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_alertSlider:

                registerWithIDs(alertLayout);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

                alertDialogBuilder.setView(alertLayout);
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.show();
                break;
            case R.id.btn_alertSlider2:
                registerWithIDs(alertLayout2);
                AlertDialog.Builder alertDialogBuilder2 = new AlertDialog.Builder(this);

                alertDialogBuilder2.setView(alertLayout2);
                AlertDialog alertDialog2 = alertDialogBuilder2.create();
                alertDialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog2.show();
                break;

            case R.id.alert_subscription_banner1:
                alert_subscription_banner1.setBackground(ContextCompat.getDrawable(this,R.drawable.bg_banner));
                alert_subscription_banner2.setBackgroundResource(0);
                alert_subscription_banner3.setBackgroundResource(0);

                tv_offer_alert1.setVisibility(View.VISIBLE);
                tv_offer_alert2.setVisibility(View.INVISIBLE);
                tv_offer_alert3.setVisibility(View.INVISIBLE);

                tv_period_alert1.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
                tv_period_alert1_1.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
                tv_price_alert1.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
                tv_fullPrice_alert1.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));


                tv_period_alert2.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
                tv_period_alert3.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));

                tv_period_alert2_1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
                tv_period_alert3_1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));

                tv_price_alert2.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
                tv_price_alert3.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));

                tv_fullPrice_alert2.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
                tv_fullPrice_alert3.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
                break;

            case R.id.alert_subscription_banner2:
                alert_subscription_banner2.setBackground(ContextCompat.getDrawable(this,R.drawable.bg_banner));
                alert_subscription_banner1.setBackgroundResource(0);
                alert_subscription_banner3.setBackgroundResource(0);

                tv_offer_alert1.setVisibility(View.INVISIBLE);
                tv_offer_alert2.setVisibility(View.VISIBLE);
                tv_offer_alert3.setVisibility(View.INVISIBLE);

                tv_period_alert2.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
                tv_period_alert2_1.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
                tv_price_alert2.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
                tv_fullPrice_alert2.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));

                tv_period_alert1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
                tv_period_alert3.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));

                tv_period_alert1_1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
                tv_period_alert3_1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));

                tv_price_alert1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
                tv_price_alert3.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));

                tv_fullPrice_alert1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
                tv_fullPrice_alert3.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
                break;

            case R.id.alert_subscription_banner3:
                alert_subscription_banner3.setBackground(ContextCompat.getDrawable(this,R.drawable.bg_banner));
                alert_subscription_banner1.setBackgroundResource(0);
                alert_subscription_banner2.setBackgroundResource(0);

                tv_offer_alert3.setVisibility(View.VISIBLE);
                tv_offer_alert2.setVisibility(View.INVISIBLE);
                tv_offer_alert1.setVisibility(View.INVISIBLE);


                tv_period_alert3.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
                tv_period_alert3_1.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
                tv_price_alert3.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
                tv_fullPrice_alert3.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));


                tv_period_alert1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
                tv_period_alert2.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));

                tv_period_alert1_1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
                tv_period_alert2_1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));

                tv_price_alert1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
                tv_price_alert2.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));

                tv_fullPrice_alert1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
                tv_fullPrice_alert2.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));

                break;

//            case R.id.alert_subscription_banner1_1:
//                alert_subscription_banner1_1.setBackground(ContextCompat.getDrawable(this,R.drawable.bg_banner));
//                alert_subscription_banner2_1.setBackgroundResource(0);
//                alert_subscription_banner3_1.setBackgroundResource(0);
//
//                tv_offer_alert1.setVisibility(View.VISIBLE);
//                tv_offer_alert2.setVisibility(View.INVISIBLE);
//                tv_offer_alert3.setVisibility(View.INVISIBLE);
//
//                tv_period_alert1.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
//                tv_period_alert1_1.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
//                tv_price_alert1.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
//                tv_fullPrice_alert1.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
//
//
//                tv_period_alert2.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//                tv_period_alert3.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//
//                tv_period_alert2_1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//                tv_period_alert3_1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//
//                tv_price_alert2.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//                tv_price_alert3.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//
//                tv_fullPrice_alert2.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//                tv_fullPrice_alert3.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//                break;
//
//            case R.id.alert_subscription_banner2_1:
//                alert_subscription_banner2_1.setBackground(ContextCompat.getDrawable(this,R.drawable.bg_banner));
//                alert_subscription_banner1_1.setBackgroundResource(0);
//                alert_subscription_banner3_1.setBackgroundResource(0);
//
//                tv_offer_alert1.setVisibility(View.INVISIBLE);
//                tv_offer_alert2.setVisibility(View.VISIBLE);
//                tv_offer_alert3.setVisibility(View.INVISIBLE);
//
//                tv_period_alert2.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
//                tv_period_alert2_1.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
//                tv_price_alert2.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
//                tv_fullPrice_alert2.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
//
//                tv_period_alert1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//                tv_period_alert3.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//
//                tv_period_alert1_1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//                tv_period_alert3_1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//
//                tv_price_alert1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//                tv_price_alert3.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//
//                tv_fullPrice_alert1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//                tv_fullPrice_alert3.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//                break;
//
//            case R.id.alert_subscription_banner3_1:
//                alert_subscription_banner3_1.setBackground(ContextCompat.getDrawable(this,R.drawable.bg_banner));
//                alert_subscription_banner1_1.setBackgroundResource(0);
//                alert_subscription_banner2_1.setBackgroundResource(0);
//
//                tv_offer_alert3.setVisibility(View.VISIBLE);
//                tv_offer_alert2.setVisibility(View.INVISIBLE);
//                tv_offer_alert1.setVisibility(View.INVISIBLE);
//
//
//                tv_period_alert3.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
//                tv_period_alert3_1.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
//                tv_price_alert3.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
//                tv_fullPrice_alert3.setTextColor(ContextCompat.getColor(this,R.color.colorOrange));
//
//
//                tv_period_alert1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//                tv_period_alert2.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//
//                tv_period_alert1_1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//                tv_period_alert2_1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//
//                tv_price_alert1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//                tv_price_alert2.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//
//                tv_fullPrice_alert1.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//                tv_fullPrice_alert2.setTextColor(ContextCompat.getColor(this,R.color.colorBlack));
//
//                break;

        }

    }

}
