package com.example.androidbasics;

import android.app.Application;
import android.content.res.Configuration;

import com.example.androidbasics.singleton.DoubleLockSingleton;
import com.example.androidbasics.singleton.EarlyInitSingleton;
import com.example.androidbasics.singleton.LazyInitSingleton;

import timber.log.Timber;
import timber.log.Timber.DebugTree;

public class ABApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG)
            Timber.plant(new DebugTree());
        Timber.d("onCreate");

        testLazyInitSingleton();
        testEarlyInitSingleton();
        testThreadSafeSingleton();
    }

    private void testThreadSafeSingleton() {

        DoubleLockSingleton doubleLockSingletonTest_1 = DoubleLockSingleton.getInstance();
        DoubleLockSingleton doubleLockSingletonTest_2 = DoubleLockSingleton.getInstance();

        testSingleThread(doubleLockSingletonTest_1,doubleLockSingletonTest_2);
        testMultiThread();
    }

    private void testMultiThread() {

        final Thread t1 = new Thread() {
            @Override
            public void run() {
                DoubleLockSingleton doubleLockSingletonTest_1 = DoubleLockSingleton.getInstance();
            }
        };


        final Thread t2 = new Thread() {
            @Override
            public void run() {
                DoubleLockSingleton doubleLockSingletonTest_2 = DoubleLockSingleton.getInstance();
            }
        };


        t1.start();
        t2.checkAccess();


    }

    private void testEarlyInitSingleton() {

        EarlyInitSingleton earlyInitSingletonTest_1 = EarlyInitSingleton.getInstance();
        EarlyInitSingleton earlyInitSingletonTest_2 = EarlyInitSingleton.getInstance();

        testSingleThread(earlyInitSingletonTest_1 ,earlyInitSingletonTest_2);
    }

    private void testSingleThread(Object test_1,Object test_2 ) {

        if(test_1 == test_2){
            Timber.d(" Test are equal " );
        }

        if(test_1.equals(test_2)){

            Timber.d(" Tests are equal " );
        }
    }

    private void testLazyInitSingleton() {

        LazyInitSingleton lazyInitSingletonTest_1 = LazyInitSingleton.getInstance();
        LazyInitSingleton lazyInitSingletonTest_2 = LazyInitSingleton.getInstance();

        testSingleThread(lazyInitSingletonTest_1,lazyInitSingletonTest_2);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Timber.d("onConfigurationChanged");
    }


    @Override
    public void onTerminate() {
        super.onTerminate();

        Timber.d("onTerminate");
    }
}



