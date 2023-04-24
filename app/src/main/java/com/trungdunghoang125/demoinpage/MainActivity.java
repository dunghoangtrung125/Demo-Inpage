package com.trungdunghoang125.demoinpage;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.trungdunghoang125.demoinpage.databinding.ActivityMainBinding;
import com.trungdunghoang125.demoinpage.viewpager.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        ViewGroup view = (ViewGroup) binding.getRoot();
        setContentView(view);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        binding.viewpager.setAdapter(adapter);
        binding.viewpager.setPageMargin(4);
    }
}