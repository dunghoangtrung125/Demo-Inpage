package com.trungdunghoang125.demoinpage.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by trungdunghoang125 on 4/21/2023.
 */
public class CustomWeb extends WebView {
    /* **********************************************************************
     * Area : Variable
     ********************************************************************** */
    private boolean handled;

    /* **********************************************************************
     * Area : Constructor
     ********************************************************************** */
    public CustomWeb(@NonNull Context context) {
        super(context);
        init();
    }

    public CustomWeb(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomWeb(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /* **********************************************************************
     * Area : Function - Override
     ********************************************************************** */
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.w("duongmom", "webview receive this event = " + event);
        // TODO stream ads
        //requestDisallowInterceptTouchEvent(false);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        Log.d("duong", "clampX =  " + clampedX + " & clampY = " + clampedY);
        // TODO : stream ads
//        if (isClamp) {
//            requestDisallowInterceptTouchEvent(false);
//        }
        handled = !clampedX && !clampedY;
    }

    /* **********************************************************************
     * Area : Function - Getter
     ********************************************************************** */
    public boolean isHandled() {
        return handled;
    }

    public void resetHandled() {
        handled = true;
        requestDisallowInterceptTouchEvent(true);
    }

    /* **********************************************************************
     * Area : Function - Private
     ********************************************************************** */
    private void init() {
    }
}