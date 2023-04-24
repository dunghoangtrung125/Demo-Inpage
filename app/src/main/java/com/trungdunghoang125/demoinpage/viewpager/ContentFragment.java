package com.trungdunghoang125.demoinpage.viewpager;

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

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentContentBinding.inflate(inflater, container, false);
        CustomWeb webView = new CustomWeb(getContext());
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return true;
            }
        });
        webView.loadUrl("https://shopee.vn/");

        binding.root.addView(webView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        OnTouchHandler onTouch = new OnTouchHandler(webView, binding.fake2);
        binding.scroll.setOnTouchListener(onTouch);
        return binding.getRoot();
    }
}
