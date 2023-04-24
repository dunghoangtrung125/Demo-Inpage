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
    private boolean disAllowIntercept;
    private boolean isClamp;

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
        Log.d("ontouch", "ontouch call");
//        logger.info("Event = " + event.getAction() + " " + hashCode());
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            handled = true;
            isClamp = false;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        Log.d("duong", "clampX =  " + clampedX + " & clampY = " + clampedY);
        isClamp = clampedX || clampedY;
        if (isClamp) {
            disAllowIntercept = false;
            requestDisallowInterceptTouchEvent(false);
        }
        handled = !clampedX && !clampedY;
    }

    /* **********************************************************************
     * Area : Function - Getter
     ********************************************************************** */
    public boolean isHandled() {
        return handled;
    }

    public boolean isClamp() {
        return isClamp;
    }

    public void resetClamp() {
        isClamp = false;
        requestDisallowInterceptTouchEvent(true);
    }

    public boolean isAllowIntercept() {
        return !disAllowIntercept;
    }

    /* **********************************************************************
     * Area : Function - Private
     ********************************************************************** */
    private void init() {
    }
}