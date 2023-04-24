package com.trungdunghoang125.demoinpage.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 1 || position == 9) {
            ContentFragment fragment = new ContentFragment();
            return fragment;
        }

        if (position == 4) {
            WebFragment fragment = new WebFragment();
            return fragment;
        }
        EmptyFragment fragment = new EmptyFragment();
        return fragment;
    }

    @Override
    public int getCount() {
        return 10;
    }
}