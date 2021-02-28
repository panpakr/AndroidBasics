package com.example.androidbasics.observer;

import java.util.ArrayList;

import timber.log.Timber;

public class Subject implements Publisher{

    private ArrayList<Observer> observers;

    public Subject(){
        observers = new ArrayList<>();
    }


    public void registerObservers(Observer observer){

        Timber.d("Register Observer" + observer.toString());
        observers.add(observer);
    }


    public void unregisterObservers(Observer observer){

        Timber.d("Un-Register Observer" + observer.toString());
        observers.remove(observer);
    }

    @Override
    public void publishPoints() {

        for (Observer observer:observers) {

            observer.updateFaceCard();
        }

    }


}
