package com.example.androidbasics.broadcastRecievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TestingBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = TestingBroadcastReceiver.class.getSimpleName();
    private static final boolean DEBUG = true;

    @Override
    public void onReceive(Context context, Intent intent) {

        if (DEBUG) Log.d(TAG, "onReceive: " +intent.getAction() );

    }
}
