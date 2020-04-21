package com.example.avramescu.androidfundamentals.services;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;
import android.util.Log;

public class ExampleIntentService extends IntentService {
    private final String TAG = ExampleIntentService.this.getClass().getSimpleName();

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     *
     * A constructor is required, and must call the super
     * constructor with a name for the worker thread.
     */
    public ExampleIntentService(String name) {
        this();
        Log.i(TAG, "ExampleIntentService(String name)");
    }

    public ExampleIntentService() {
        super("name");
        Log.i(TAG, "ExampleIntentService()");
    }


    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * The IntentService calls this method from the default worker thread with
     * the intent that started the service. When this method returns, IntentService
     * stops the service, as appropriate.
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG, "onHandleIntent");
        // Normally we would do some work here, like download a file.
        // For our sample, we just sleep for 5 seconds.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Restore interrupt status.
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    /**
     *
     * Implement onBind only if the service allows binding.
     */
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return super.onBind(intent);
//    }
}
