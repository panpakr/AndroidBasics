package com.example.androidbasics.observer;

import timber.log.Timber;

public class QueenObserver implements Observer {

    @Override
    public void updateFaceCard() {
        Timber.d("My value Queen is "+ 10);
    }
}
