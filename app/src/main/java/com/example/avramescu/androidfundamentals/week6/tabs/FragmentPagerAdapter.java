package com.example.avramescu.androidfundamentals.week6.tabs;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

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
