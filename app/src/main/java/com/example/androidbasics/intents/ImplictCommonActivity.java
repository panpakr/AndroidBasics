package com.example.androidbasics.intents;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.androidbasics.R;


public class ImplictCommonActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = ImplictCommonActivity.class.getSimpleName();
    private static final boolean DEBUG = true;

    private static final int  CAMERA_REQUEST = 101;
    private static final int  CONTACT_PICK_REQUEST = 201;

    private Button bCall;
    private Button blocation;
    private Button bWeb;
    private Button bSendSms;

    private Button bOpenCamera;
    private Button bPickContact;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_common);
        initViews();

    }

    private void initViews() {

        bCall = findViewById(R.id.bCall);
        bCall.setOnClickListener(this);

        blocation = findViewById(R.id.blocation);
        blocation.setOnClickListener(this);

        bWeb = findViewById(R.id.bWeb);
        bWeb.setOnClickListener(this);

        bSendSms = findViewById(R.id.bSendSms);
        bSendSms.setOnClickListener(this);

        bOpenCamera = findViewById(R.id.bOpenCamera);
        bOpenCamera.setOnClickListener(this);

        bPickContact = findViewById(R.id.bPickContact);
        bPickContact.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if (DEBUG) Log.d(TAG, "onClick: ");
        switch (v.getId()) {
            case R.id.bCall:
                dialPerson();
                //callPerson();
                break;

            case R.id.blocation:

                showMyLocation();
                break;
            case R.id.bWeb:

                showWebUrl();
                break;
            case R.id.bSendSms:

                sendSMS();
                break;


            case R.id.bOpenCamera:

                openCamera();
                break;
            case R.id.bPickContact:

                pickContact();
                break;


        }

    }

    private void pickContact() {

        Intent contactIntent = new Intent();
        contactIntent.setAction(Intent.ACTION_PICK);
        contactIntent.setType(ContactsContract.Contacts.CONTENT_TYPE);

        if (isValidActivityAvailable(contactIntent)) {
            startActivityForResult(contactIntent,CONTACT_PICK_REQUEST);
        }
    }

    private void openCamera() {

        Intent cameraIntent = new Intent();
        cameraIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                Uri.withAppendedPath(Uri.parse("/"), "/"));  //imp

        if (isValidActivityAvailable(cameraIntent)) {
            startActivityForResult(cameraIntent,CAMERA_REQUEST);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == CAMERA_REQUEST && resultCode ==RESULT_OK){


            //Bitmap bitmap = data.getParcelableExtra("data");
            Log.d(TAG, "onActivityResult:  result obtained" );
        }

        if(requestCode == CONTACT_PICK_REQUEST && resultCode ==RESULT_OK){


            Uri contact = data.getData();

            Log.d(TAG, "onActivityResult:  result obtained call "+contact.toString() );
        }


    }

    private void sendSMS() {

        Intent smsIntent = new Intent();
        smsIntent.setAction(Intent.ACTION_SENDTO); //Only SMS sending app
        smsIntent.setData(Uri.parse("smsto:8147987950")); // Phone number
        smsIntent.putExtra("sms_body" ,"hello X ");  //Message


        if (isValidActivityAvailable(smsIntent)) {
            startActivity(smsIntent);

        }
    }

    private void showWebUrl() {

        Intent webIntent = new Intent();
        webIntent.setAction(Intent.ACTION_VIEW);
        webIntent.setData(Uri.parse("https://www.google.com"));

        if (isValidActivityAvailable(webIntent)) {

            startActivity(webIntent);
        }
    }

    private void showMyLocation() {

        //zoom level ranges 1-23
        Intent geoIntent = new Intent();
        geoIntent.setAction(Intent.ACTION_VIEW);
        geoIntent.setData(Uri.parse("geo:12.9492465,77.7002437?z=100"));

        if (isValidActivityAvailable(geoIntent)) {

            startActivity(geoIntent);
        }
    }

    private void callPerson() {

        //Need Permission Call Phone
        Intent callIntent = new Intent();
        callIntent.setAction(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + "8147987950"));

        if (isValidActivityAvailable(callIntent)) {

            startActivity(callIntent);
        }


    }

    private void dialPerson() {

       // Intent callIntent = new Intent(Intent.ACTION_DIAL); //Pass intent to Intent Object
        Intent callIntent = new Intent();
        callIntent.setAction(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + "8147987950"));

        if (isValidActivityAvailable(callIntent)) {

            startActivity(callIntent);
        }


    }

    private boolean isValidActivityAvailable(Intent intent) {

        boolean result = false;

        PackageManager mPackageManager = getPackageManager();
        ComponentName componentName = intent.resolveActivity(mPackageManager);

        if (componentName != null)
            result = true;

        return result;
    }


}
