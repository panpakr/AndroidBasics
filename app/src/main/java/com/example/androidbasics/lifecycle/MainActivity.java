package com.example.androidbasics.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidbasics.R;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText mNameInput;
    private Button mSend;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initViews();

        Timber.d("onCreate: ");
        delay();
    }

    private void initViews() {

        mNameInput = findViewById(R.id.etName);
        mSend = findViewById(R.id.bSend);


    }

    //1. Show  fatal exception implementing only send()
    //2.Show fatal exception implementing only send(View view)
    public void send(View view){

       String name = String.valueOf(mNameInput.getText());
       Intent intent = new Intent(this, DisplayActivity.class);
       intent.putExtra("myName" ,name);

       startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Timber.d("onStart: ");
        delay();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Timber.d("onSaveInstanceState: ");
        delay();
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Timber.d( "onRestoreInstanceState: ");
        delay();
    }


    @Override
    protected void onResume() {
        super.onResume();

        Timber.d( "onResume: ");
        delay();
    }


    @Override
    protected void onPause() {
        super.onPause();

        Timber.d( "onPause ");
        delay();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Timber.d("onStop: ");
        delay();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Timber.d( "onRestart: ");
        delay();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

       Timber.d( "onDestroy: ");
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