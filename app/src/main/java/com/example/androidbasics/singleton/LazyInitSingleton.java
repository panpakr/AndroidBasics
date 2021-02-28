package com.example.androidbasics.singleton;

import timber.log.Timber;


public class LazyInitSingleton {

    //late-initialisation of Singleton Object
    private static LazyInitSingleton lazyInitSingleton ;

    private LazyInitSingleton(){

        Timber.d(" Constructor Calling !!!");
    }


   public static LazyInitSingleton getInstance(){

        if(lazyInitSingleton == null){

            lazyInitSingleton = new LazyInitSingleton();
        }
        Timber.d(" Singelton Instance :"+lazyInitSingleton);
        return lazyInitSingleton;

    }

}
