package com.example.avramescu.androidfundamentals.broadcast_receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;

import com.example.avramescu.androidfundamentals.R;

public class BroadcastReceiverActivity extends AppCompatActivity {

    private static final String TAG = BroadcastReceiverActivity.class.getSimpleName();

    ExampleBroadcastReceiver exampleBroadcastReceiver = new ExampleBroadcastReceiver();
    /*
    *   Vom asculta la broadcast receiverul nostru cat timp aplicatia este in foreground -> inregistram
    * receiverul pe onStart si ii vom anula inregistrarea pe onStop.( pentru onResume corespondend este
    * onPause, pentru onCreate - onDestroy )
    *
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);

        /*
            inregistram in onCreate si ii anulam inregistrarea pe onDestroy pentru ca vrem sa trimitem
            broadcast-ul din alta aplicatie si cand aplicatia noastra va fi in background vrem sa
            primim broadcast-ul.
        * */
        IntentFilter filter = new IntentFilter("com.example.avramescu.EXAMPLE_ACTION");
        registerReceiver(exampleBroadcastReceiver, filter);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
////       filter.addAction(); //daca vrem sa adaugam alte actions
//        registerReceiver(exampleBroadcastReceiver, filter);
//
//        /*
//        * Ne trebuie un intent filter pentru a specifica pentru ce actiuni ascultam.
//        * */
//    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        unregisterReceiver(exampleBroadcastReceiver);
//    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
        unregisterReceiver(exampleBroadcastReceiver);
    }
}
