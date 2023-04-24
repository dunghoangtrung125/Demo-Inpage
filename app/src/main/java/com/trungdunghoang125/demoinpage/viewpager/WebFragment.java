package com.trungdunghoang125.demoinpage.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.trungdunghoang125.demoinpage.databinding.FragmentWebBinding;

/**
 * Created by trungdunghoang125 on 4/21/2023.
 */
public class WebFragment extends Fragment {
    private FragmentWebBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentWebBinding.inflate(inflater, container, false);
        binding.web.getSettings().setJavaScriptEnabled(true);
        binding.web.loadUrl("https://shopee.vn/");
        return binding.getRoot();
    }
}
