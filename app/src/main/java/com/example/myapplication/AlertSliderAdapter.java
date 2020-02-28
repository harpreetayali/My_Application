package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class AlertSliderAdapter extends PagerAdapter
{
        private int[] images;
        private String[] titles,descriptions;
        private Context ctx;

        public AlertSliderAdapter(Context ctx,int[] images,String[] titles,String[] descriptions)
        {
            this.ctx = ctx;
            this.titles = titles;
            this.descriptions = descriptions;
            this.images = images;
        }

        @Override
        public int getCount()
        {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object)
        {

            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position)
        {
            LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.slider_alert_item,null);

            TextView tv_alert_title = view.findViewById(R.id.tv_alert_title);
            TextView tv_alert_description = view.findViewById(R.id.tv_alert_description);
            ImageView imageView = view.findViewById(R.id.alert_slider_imageView);

            tv_alert_title.setText(titles[position]);
            tv_alert_description.setText(descriptions[position]);
            imageView.setImageResource(images[position]);

            ViewPager viewPager = (ViewPager) container;
            viewPager.addView(view);



            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object)
        {
            ViewPager viewPager = (ViewPager) container;
            View view = (View) object;
            viewPager.removeView(view);
        }
}
