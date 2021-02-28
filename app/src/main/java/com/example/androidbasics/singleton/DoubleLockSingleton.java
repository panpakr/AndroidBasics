package com.example.androidbasics.singleton;

import timber.log.Timber;

public class DoubleLockSingleton {

    //double locking method (Thread safe )
    private static volatile DoubleLockSingleton doubleLockSingleton ;

    private DoubleLockSingleton(){

        Timber.d(" Constructor Calling !!!");
    }


   public static DoubleLockSingleton getInstance(){

        if(doubleLockSingleton==null){

            synchronized (DoubleLockSingleton.class) {

                if (doubleLockSingleton == null)
                doubleLockSingleton = new DoubleLockSingleton();
            }
        }
        Timber.d(" Singelton Instance :"+doubleLockSingleton);
        return doubleLockSingleton;

    }

}
