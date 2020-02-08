package com.example.avramescu.androidfundamentals.week6.navigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

import com.example.avramescu.androidfundamentals.R;

public class NavigationScratchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_scratch);

        Toolbar toolbar = findViewById(R.id.toolbar_scr);
//        setSupportActionBar(toolbar);
    }
}
