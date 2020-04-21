package com.example.avramescu.androidfundamentals.week3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.avramescu.androidfundamentals.R;

public class WebViewActivity extends AppCompatActivity {
//    pentru a crea un WebView avem nevoie de un URL
//    psf -> scurtatura pentru public static final

    public static final String URL = "https://developer.android.com/"; // definim o constanta ce va
    //reprezenta url-ul nostru.
    WebView mWebViewAndroid; //variabila in care preluam WebView-ul

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        initView(); // initializam View-urile
    }

    private void initView() {
        mWebViewAndroid = findViewById(R.id.web_view_android); // preluam WebView-ul
        WebSettings webSettings = mWebViewAndroid.getSettings(); //preluam setarile intr-un obiect
        //de tipul WebSettings
        /*Manages settings state for a WebView. When a WebView is first created,
        it obtains a set of default settings. These default settings will be returned
        from any getter call. A WebSettings object obtained from WebView#getSettings()
        is tied to the life of the WebView. If a WebView has been destroyed, any method call
        on WebSettings will throw an IllegalStateException.*/

        webSettings.setJavaScriptEnabled(true); // aplicam metoda de activare a setarii de JavaScript
        /*Tells the WebView to enable JavaScript settings
        execution. Tells the WebView to enable JavaScript execution.
        by default JavaScript is disabled
        */

        mWebViewAndroid.loadUrl(URL);
//        incarca URL-ul
    }
    /* urmeaza partea de setare a activitatii in manifest iar apoi pentru a avea acces la internet
    trebuie sa setam niste permisiuni pentru a avea acces la driverul de net.
    By default nu are acces la nimic: internet, storega... etc.
    Trebuie sa setam permisiunea de internet in manifest
    */

}
