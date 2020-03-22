package com.example.avramescu.androidfundamentals.week6.tabs;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

    int numberOfTabs;

    public FragmentPagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int i) {
        //pentru fiecare fragment intoarcem o noua instanta a aceluiasi fragment in acest caz
        return new TabFragment();
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
