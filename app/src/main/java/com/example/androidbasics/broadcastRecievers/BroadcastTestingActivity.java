package com.example.androidbasics.broadcastRecievers;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.androidbasics.R;

public class BroadcastTestingActivity extends AppCompatActivity {

    private static final String TAG = BroadcastTestingActivity.class.getSimpleName();
    private static final boolean DEBUG = true;

    private BroadcastReceiver mBroadcastReceiver ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        if(DEBUG) Log.d(TAG, "onCreate: ");
        mBroadcastReceiver = new TestingBroadcastReceiver();

    }


    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);

        registerReceiver(mBroadcastReceiver,intentFilter);

        if(DEBUG) Log.d(TAG, "registerReceiver: ");



    }


    @Override
    protected void onStop() {
        super.onStop();
       unregisterReceiver(mBroadcastReceiver);

        if(DEBUG) Log.d(TAG, "unregisterReceiver: ");
    }
}
