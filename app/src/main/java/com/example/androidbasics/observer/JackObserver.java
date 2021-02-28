package com.example.androidbasics.observer;

import timber.log.Timber;

public class JackObserver implements Observer{


    @Override
    public void updateFaceCard() {
        Timber.d("My value Jack is "+ 10);
    }
}
