package com.example.androidbasics.lifecycle;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.androidbasics.R;

import timber.log.Timber;

public class DisplayActivity extends AppCompatActivity {

    private static final String TAG = DisplayActivity.class.getSimpleName();
    private static final boolean DEBUG = true;

    //@Bind(R.id.tvdisplayText)
    private TextView mDisplayName;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display); //Layout inflation

        String sentName = getIntent().getStringExtra("myName");

        initViews(sentName);

        Timber.d("onCreate");
        delay();
    }

    private void initViews(String sentName) {

        mDisplayName = findViewById(R.id.tvdisplayText);

        //ButterKnife.bind(this);

        mDisplayName.setText(sentName);
        mDisplayName.setTextSize(20);

    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);


        if(DEBUG) Log.d(TAG, "onSaveInstanceState: ");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(DEBUG) Log.d(TAG, "onRestoreInstanceState: ");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Timber.e("onStart");
        if(DEBUG) Log.d(TAG, "onStart: ");
        delay();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(DEBUG) Log.d(TAG, "onResume: ");
        delay();
    }


    @Override
    protected void onPause() {
        super.onPause();

        if(DEBUG) Log.d(TAG, "onPause: ");
        delay();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if(DEBUG) Log.d(TAG, "onStop: ");
        delay();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        if(DEBUG) Log.d(TAG, "onRestart: ");
        delay();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(DEBUG) Log.d(TAG, "onDestroy: ");
        delay();
    }


    void delay(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
