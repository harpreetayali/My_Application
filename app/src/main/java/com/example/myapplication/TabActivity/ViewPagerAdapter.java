package com.example.myapplication.TabActivity;

import com.example.myapplication.TabFragments.TabFragment1;
import com.example.myapplication.TabFragments.TabFragment2;
import com.example.myapplication.TabFragments.TabFragment3;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter
{
    public ViewPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment = null;

        switch (position)
        {
            case 0:
                fragment = new TabFragment1();
                break;
            case 1:
                fragment = new TabFragment2();
                break;
            case 2:
                fragment = new TabFragment3();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        String title = null;

        switch (position)
        {
            case 0:
                title = "Tab 1";
                break;
            case 1:
                title = "Tab 2";
                break;
            case 2:
                title = "Tab 3";
                break;
        }

        return title;
    }
}
