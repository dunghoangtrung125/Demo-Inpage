package com.trungdunghoang125.demoinpage.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.trungdunghoang125.demoinpage.viewpager.content.ContentFragment;

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
        Fragment fragment;
        if (position == 1 || position == 9) {
            fragment = new ContentFragment();
        } else if (position == 4) {
            fragment = new WebFragment();
        } else {
            fragment = new EmptyFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 10;
    }
}