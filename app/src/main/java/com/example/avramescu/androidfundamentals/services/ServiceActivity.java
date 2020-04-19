package com.example.avramescu.androidfundamentals.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.avramescu.androidfundamentals.R;

public class ServiceActivity extends AppCompatActivity {
    private final String TAG = ServiceActivity.this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        Log.i(TAG, "onCreate -> Activity created");

        Intent intentStartService = new Intent(this, ExampleService.class);
        startService(intentStartService);

//        Intent intentStartIntentService = new Intent(this, ExampleIntentService.class);
//        startService(intentStartIntentService);
//        startService(intentStartIntentService);
//        startService(intentStartIntentService);
//        startService(intentStartIntentService);
//        startService(intentStartIntentService);

    }
}
