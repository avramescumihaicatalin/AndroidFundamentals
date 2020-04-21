package com.example.avramescu.androidfundamentals.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.avramescu.androidfundamentals.R;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = ServiceActivity.this.getClass().getSimpleName();

    private Button mButtonIntentService;
    private Button mButtonService;
    private Button mButtonStartForegroundService;
    private Button mButtonStopForegroundService;
    private Button mButtonbindingService;

    ExampleBinderService mService;
    boolean mBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Log.i(TAG, "onCreate -> Activity created");

        initViews();
        setListeners();
    }

    private void initViews() {
        mButtonIntentService = findViewById(R.id.btn_intent_service);
        mButtonService = findViewById(R.id.btn_service);
        mButtonStartForegroundService = findViewById(R.id.btn_start_foreground_service);
        mButtonStopForegroundService = findViewById(R.id.btn_stop_foreground_service);
        mButtonbindingService = findViewById(R.id.btn_binding_service);
    }

    private void setListeners() {
        mButtonIntentService.setOnClickListener(this);
        mButtonService.setOnClickListener(this);
        mButtonStartForegroundService.setOnClickListener(this);
        mButtonStopForegroundService.setOnClickListener(this);
        mButtonbindingService.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_intent_service: {
                Intent intentStartIntentService = new Intent(this, ExampleIntentService.class);
                startService(intentStartIntentService);
                startService(intentStartIntentService);
                startService(intentStartIntentService);
                startService(intentStartIntentService);
                startService(intentStartIntentService);
                break;
            }
            case R.id.btn_service: {
                Intent intentStartService = new Intent(this, ExampleService.class);
                startService(intentStartService);
                startService(intentStartService);
                startService(intentStartService);
                startService(intentStartService);
                startService(intentStartService);
                //calling one time stopService will stop any started of that intent
//                stopService(intentStartService);
//                Log.i(TAG, "service stopped");
                break;
            }
            case R.id.btn_start_foreground_service: {
                Log.i(TAG, "started Foreground Service");

                Intent serviceIntent = new Intent(this, ExampleForegroundService.class);
                serviceIntent.putExtra("inputExtra", "Foreground Service Example in Android");

                ContextCompat.startForegroundService(this, serviceIntent);
                break;
            }
            case R.id.btn_stop_foreground_service: {
                Log.i(TAG, "stopped Foreground Service");

                Intent serviceIntent = new Intent(this, ExampleForegroundService.class);
                stopService(serviceIntent);
                break;
            }
            case R.id.btn_binding_service: {
                Log.i(TAG, "Binding Service");

                if (mBound) {
                    // Call a method from the ExampleBinderService.
                    // However, if this call were something that might hang, then this request should
                    // occur in a separate thread to avoid slowing down the activity performance.
                    int num = mService.getRandomNumber();
                    Toast.makeText(this, "number: " + num, Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    /** Defines callbacks for service binding, passed to bindService() */
    private ServiceConnection serviceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to ExampleBinderService, cast the IBinder and get LocalService instance
            ExampleBinderService.LocalBinder binder = (ExampleBinderService.LocalBinder) service;
            mService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        // Bind to ExampleBinderService
        Intent intent = new Intent(this, ExampleBinderService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Bind from ExampleBinderService
        unbindService(serviceConnection);
        mBound = false;
    }

}
