package com.example.androidbasics.singleton;

import timber.log.Timber;

public class EarlyInitSingleton {

    //early-initialisation of Singleton Object
    private static EarlyInitSingleton earlyInitSingleton = new EarlyInitSingleton();

    private EarlyInitSingleton(){

        Timber.d(" Constructor Calling !!!");
    }


    public static EarlyInitSingleton getInstance(){

        Timber.d(" Singelton Instance :"+earlyInitSingleton);
        return earlyInitSingleton;

    }



}
