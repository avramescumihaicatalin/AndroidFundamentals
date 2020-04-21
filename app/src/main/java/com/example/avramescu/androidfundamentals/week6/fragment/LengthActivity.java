package com.example.avramescu.androidfundamentals.week6.fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.avramescu.androidfundamentals.R;

public class LengthActivity extends AppCompatActivity implements LengthListener{

    TextView mTextViewActivityLength;
    Button mButtonSendDataToFragmentWithListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        initView();
        replaceFragment();

    }

    private void replaceFragment() {
        final LengthFragment lengthFragment = new LengthFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment_length, lengthFragment);
        fragmentTransaction.commit();

        mButtonSendDataToFragmentWithListener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lengthFragment.displayLength(mTextViewActivityLength.getText().toString());
            }
        });
    }

    private void initView() {
        mTextViewActivityLength = findViewById(R.id.text_view_length);
        mButtonSendDataToFragmentWithListener = findViewById(R.id.button_send_data_to_fragment_with_listener);
    }

    @Override
    public void displayLength(String value) {
        mTextViewActivityLength.setText("length:" + value.length());
    }
}
