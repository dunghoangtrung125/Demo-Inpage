package com.trungdunghoang125.demoinpage.ontouch;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.trungdunghoang125.demoinpage.custom.CustomWeb;

/**
 * Created by trungdunghoang125 on 4/21/2023.
 */
public class OnTouchHandler implements View.OnTouchListener {
    /* **********************************************************************
     * Area : Const
     ********************************************************************** */
    private long startTime = Long.MAX_VALUE, holdTime = Long.MAX_VALUE;
    private float startX = -1f, startY = -1f;
    private double distance = -1f;

    /* **********************************************************************
     * Area : Variable
     ********************************************************************** */
    private Rect rect;
    private CustomWeb webView;
    private View blankView;

    private boolean isTouchingAdsPlace = false, isDragging = true;

    public OnTouchHandler(CustomWeb web, View blankView) {
        this.webView = web;
        rect = new Rect();
        this.blankView = blankView;
    }

    /* **********************************************************************
     * Area : Function - Override
     ********************************************************************** */
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (blankView == null) return false;
        blankView.getGlobalVisibleRect(rect);
        float x = event.getRawX();
        float y = event.getRawY();
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                isDragging = false;
                startTime = System.currentTimeMillis();
                distance = 0;
                startX = event.getRawX();
                startY = event.getRawY();
                if (y >= rect.top && y <= rect.bottom) {
                    isTouchingAdsPlace = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                holdTime = System.currentTimeMillis() - startTime;
                double diffX = event.getRawX() - startX;
                double diffY = event.getRawY() - startY;
                distance = Math.sqrt(diffX * diffX + diffY * diffY);
                if (holdTime > 200 || distance > 20) {
                    isDragging = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                isTouchingAdsPlace = false;
                break;
        }

//        boolean isConsumeEvent = false;
//        if (y >= rect.top && y <= rect.bottom) {
//
//            webView.onTouchEvent(event);
//            if (isDragging) {
//                isConsumeEvent = webView.isHandled();
//            } else {
//                isConsumeEvent = false;
//            }
//        } else {
//            isConsumeEvent = webView.isHandled() && isTouchingAdsPlace;
//        }
//        return isConsumeEvent;

        boolean isConsumeEvent = false;
        if (y >= rect.top && y <= rect.bottom) {
            if (isDragging) {
                if (webView.isHandled()) {
                    webView.dispatchTouchEvent(event);
                    blankView.getParent().requestDisallowInterceptTouchEvent(true);
                    Log.i("duongmom", "event pass to webview =  " + event);
                } else {
                    blankView.getParent().requestDisallowInterceptTouchEvent(false);
                    webView.requestDisallowInterceptTouchEvent(true);
                }
                isConsumeEvent = webView.isHandled();
            } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                Log.d("duong", "Action Up");
                webView.resetHandled();
                webView.dispatchTouchEvent(event);
                isConsumeEvent = false;

            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                webView.dispatchTouchEvent(event);
                isConsumeEvent = false;
            }
        } else {
            isConsumeEvent = webView.isHandled() && isTouchingAdsPlace;
        }
        Log.d("duong", "isConsumeEvent = " + isConsumeEvent);
        return isConsumeEvent;
    }
}