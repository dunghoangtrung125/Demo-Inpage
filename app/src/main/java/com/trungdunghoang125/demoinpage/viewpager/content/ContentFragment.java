package com.trungdunghoang125.demoinpage.viewpager.content;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.trungdunghoang125.demoinpage.custom.CustomWeb;
import com.trungdunghoang125.demoinpage.databinding.FragmentContentBinding;
import com.trungdunghoang125.demoinpage.ontouch.OnTouchHandler;

public class ContentFragment extends Fragment {
    private FragmentContentBinding binding;

    @SuppressLint({"SetJavaScriptEnabled", "ClickableViewAccessibility"})
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentContentBinding.inflate(inflater, container, false);
        CustomWeb inpage = new CustomWeb(getContext());
        inpage.setVerticalScrollBarEnabled(false);
        inpage.setHorizontalScrollBarEnabled(false);

        WebSettings inpageSettings = inpage.getSettings();
        inpageSettings.setJavaScriptEnabled(true);
        inpage.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return true;
            }
        });
        inpage.loadUrl("https://shopee.vn/");

        CustomWeb stream = new CustomWeb(getContext());
        stream.setVerticalScrollBarEnabled(false);
        stream.setHorizontalScrollBarEnabled(false);

        WebSettings streamSettings = stream.getSettings();
        streamSettings.setJavaScriptEnabled(true);
        stream.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return true;
            }
        });
        stream.loadUrl("https://shopee.vn/");

        binding.root.addView(inpage, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        binding.fake6.addView(stream, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        OnTouchHandler onTouch = new OnTouchHandler(inpage, binding.fake2);
        binding.scroll.setOnTouchListener(onTouch);
        return binding.getRoot();
    }
}