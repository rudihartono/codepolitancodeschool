package com.codepolitan.viewpagerexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by rudihartono on 5/19/18.
 */

public class MyViewPager extends FragmentStatePagerAdapter {

    public MyViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "News";
            case 1:
                return  "Tutorial";
            case 2:
                return "Info";
            default:
                return  "News";
        }

    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new NewsFragment(); //urutan pertama
            case 1:
                return  new TutorialFragment(); //uratan kedua
            case 2:
                return new InfoFragment(); //urutan
            default:
                return  new NewsFragment();
        }
    }


    @Override
    public int getCount() {
        return 3;
    }
}
