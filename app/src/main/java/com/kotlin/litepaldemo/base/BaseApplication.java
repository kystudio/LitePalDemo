package com.kotlin.litepaldemo.base;

import android.app.Application;

import org.litepal.LitePal;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        LitePal.initialize(getApplicationContext());
    }
}
