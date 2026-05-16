package com.example.androidbasics.broadcastRecievers;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidbasics.R;

import timber.log.Timber;

public class BroadcastTestingActivity extends AppCompatActivity {

    private static final String TAG = BroadcastTestingActivity.class.getSimpleName();
    private static final boolean DEBUG = true;

    private BroadcastReceiver mBroadcastReceiver ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        if(DEBUG) Timber.tag(TAG).d("onCreate: ");
        mBroadcastReceiver = new TestingBroadcastReceiver();

    }


    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);

        registerReceiver(mBroadcastReceiver,intentFilter);

        if(DEBUG) Timber.tag(TAG).d("registerReceiver: ");



    }


    @Override
    protected void onStop() {
        super.onStop();
       unregisterReceiver(mBroadcastReceiver);

        if(DEBUG) Timber.tag(TAG).d("unregisterReceiver: ");
    }
}
