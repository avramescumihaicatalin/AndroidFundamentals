package com.example.avramescu.androidfundamentals.broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class ExampleBroadcastReceiver extends BroadcastReceiver {

    //metoda este executata cand receiverul nostru este triggeruit.
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Toast.makeText(context, "Boot completed", Toast.LENGTH_SHORT).show();
        }

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            Toast.makeText(context, "Connectivity changed", Toast.LENGTH_SHORT).show();
            /*
            *   Din android Oreo aproape toate broadcast receivere de system implicite (inregistrate)
            * in manifest sunt restrictionate.
            * Solutii:
            *   folosim un JobScheduler
            *   inregistrare dimanica in cod java intr-un context iar receiverul va trai
            * atata timp cat contextul traieste. Putem inregistra receiverul in contextul aplicatiei
            * iar acesta va trai atata timp cat aplicatia ruleaza si se va opri cand aplicatia nu mai
            * ruleaza dar poate de asemenea sa fie pornit cat timp aplicatia este in foreground.
            * */

            boolean noConnectivity = intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            //trebuie sa specificam o valoare default pentru cazul in care nu primim informatia in
            // intent

            if (noConnectivity) {
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
            }
        }

        //listen for custom action
        if ("com.example.avramescu.EXAMPLE_ACTION".equals(intent.getAction())) {
            String receivedText = intent.getStringExtra("com.example.avramescu.EXTRA_TEXT");
            Toast.makeText(context, receivedText, Toast.LENGTH_SHORT).show();
        }
    }

    /*
    *   Broadcast receiverul asculta dupa event-urile de sistem setate prin intent filter in Manifest
    * iar cand un astfel de event se intampla va trigarui metoda onReceive din ExampleBroadcastReceiver
    * chiar daca aplicatia nu este pornita pentru ca sistemul va porni aplicatia noastra pentru a
    * reactiona la event.
    * Acesta este un broadcast receiver implicit pentru ca ExampleBroadcastReceiver nu e apelat direct
    * ci doar subscrie la event-urile din Manifest.
    * Un broadcast explicit va apela direct ExampleBroadcastReceiver prin numele clasei.
    *
    * Inregistrarea broadcast receiverului in manifest reprezinta o inregistrare statica.
    * Inregistrarea dinamica este alternativa la inregistrarea statica.
    * */
}
