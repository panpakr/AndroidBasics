package com.example.androidbasics.intents;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidbasics.R;

import java.util.List;

public class ImplicitActivity extends AppCompatActivity {

    private static final String TAG = ImplicitActivity.class.getSimpleName();
    private static final boolean DEBUG = true;

    private EditText mMessage;
    private Button mSend;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);
        initViews();

    }

    private void initViews() {

        mMessage = findViewById(R.id.etMessage);
        mSend = findViewById(R.id.bSendToMail);
        mSend.setOnClickListener(onClickListener);

    }


    void  sendImplicitDisambiguationAlternate(){

        // Teach Debugger Here

        String name = mMessage.getText().toString().trim();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND); //Try only this to show if implicit wont match what will happend

        intent.setType("*/*"); //
        intent.putExtra(Intent.EXTRA_SUBJECT, name);

        if(DEBUG) Log.d(TAG, "sendImplicitDisambiguation: "  +name);

        PackageManager mPackageManager = getPackageManager();


        List<ResolveInfo>  resolveInfoList = mPackageManager.queryIntentActivities(intent,PackageManager.MATCH_DEFAULT_ONLY);

        if(DEBUG) Log.d(TAG, "sendImplicitDisambiguation:   resolveInfoList"  +resolveInfoList.size());
        if(!resolveInfoList.isEmpty()){
            startActivity(intent);
        }
    }

    void  sendImplicitDisambiguation(){

        String name = mMessage.getText().toString().trim();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND); //Try only this to show if implicit wont match what will happend

        intent.setType("*/*"); //
        intent.putExtra(Intent.EXTRA_SUBJECT, name);

        if(DEBUG) Log.d(TAG, "sendImplicitDisambiguation: "  +name);

        PackageManager mPackageManager = getPackageManager();
        ComponentName componentName = intent.resolveActivity(mPackageManager);

        if(DEBUG) Log.d(TAG, "sendImplicitDisambiguation:  resolve activity "  +componentName);

        if(componentName!=null) {
            if (DEBUG)
                Log.d(TAG, "sendImplicitDisambiguation:  resolve component " + componentName.getPackageName());
            startActivity(intent);
        }
    }


    void  sendImplicitPersistentChooser(){

        String name = mMessage.getText().toString().trim();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND); //Try only this to show if implicit wont match what will happend

        intent.setType("*/*"); //
        intent.putExtra(Intent.EXTRA_SUBJECT, name);

       Intent chooser = Intent.createChooser(intent,"Choose Here ");

        if(DEBUG) Log.d(TAG, "sendImplicitDisambiguation: "  +name);

        PackageManager mPackageManager = getPackageManager();
        ComponentName componentName = intent.resolveActivity(mPackageManager);

        if(DEBUG) Log.d(TAG, "sendImplicitDisambiguation:  resolve activity "  +componentName);

        if(componentName!=null) {
            if (DEBUG)
                Log.d(TAG, "sendImplicitDisambiguation:  resolve component " + componentName.getPackageName());
            startActivity(chooser);
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(v.getId() == R.id.bSendToMail) {
                if (DEBUG) Log.d(TAG, "onClick: ");
                //sendImplicitDisambiguation();
                //sendImplicitPersistentChooser();
                sendImplicitDisambiguationAlternate();
            }

        }
    };
}
