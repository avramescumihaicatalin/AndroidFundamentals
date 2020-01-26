package com.example.avramescu.androidfundamentals.week6;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.avramescu.androidfundamentals.R;

public class LengthActivity extends AppCompatActivity implements LengthListener{

    TextView mTextViewActivityLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        initView();
        replaceFragment();
    }

    private void replaceFragment() {
        LengthFragment lengthFragment = new LengthFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment_length, lengthFragment);
        fragmentTransaction.commit();
    }

    private void initView() {
        mTextViewActivityLength = findViewById(R.id.text_view_length);
    }

    @Override
    public void displayLength(String value) {
        mTextViewActivityLength.setText("length:" + value.length());
    }
}
