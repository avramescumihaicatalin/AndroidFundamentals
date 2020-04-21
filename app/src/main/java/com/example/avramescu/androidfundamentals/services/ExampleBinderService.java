package com.example.avramescu.androidfundamentals.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import androidx.annotation.Nullable;
import android.util.Log;

import java.util.Random;

    public class ExampleBinderService extends Service {
    private final String TAG = ExampleBinderService.this.getClass().getSimpleName();

    // Binder given to clients
    private final IBinder binder = new LocalBinder();

    // Random number generator
    private final Random mGenerator = new Random();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        return binder;
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class LocalBinder extends Binder {
        ExampleBinderService getService() {
            // Return this instance of ExampleBinderService so clients can call public methods
            return ExampleBinderService.this;
        }
    }

    /** method for clients */
    public int getRandomNumber() {
        return mGenerator.nextInt(100);
    }
}
