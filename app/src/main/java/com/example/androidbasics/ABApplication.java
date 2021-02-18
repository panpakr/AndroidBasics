package com.example.androidbasics;

import android.app.Application;
import android.content.res.Configuration;

import timber.log.Timber;
import timber.log.Timber.DebugTree;

public class ABApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG)
            Timber.plant(new DebugTree());

        Timber.d("onCreate");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Timber.d("onConfigurationChanged");
    }


    @Override
    public void onTerminate() {
        super.onTerminate();

        Timber.d("onTerminate");
    }
}



