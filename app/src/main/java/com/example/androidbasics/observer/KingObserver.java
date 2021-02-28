package com.example.androidbasics.observer;

import timber.log.Timber;

public class KingObserver implements Observer {

    @Override
    public void updateFaceCard() {

        Timber.d("My value King is "+ 10);
    }

}
