package com.example.avramescu.androidfundamentals.week6;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.avramescu.androidfundamentals.R;

public class SumActivity extends AppCompatActivity {

    public static final String FIRST_NUMBER_KEY = "FIRST_NUMBER_KEY";
    public static final String SECOND_NUMBER_KEY = "SECOND_NUMBER_KEY";

    private EditText mEditTextFirstNumber;
    private EditText mEditTextSecondNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);

        initView();
    }

    private void initView() {
        mEditTextFirstNumber = findViewById(R.id.edit_text_a);
        mEditTextSecondNumber = findViewById(R.id.edit_text_b);
    }

    public void sumOnClick(View view) {
        int firstNumber = 0;
        int secondNumber = 0;
        if(mEditTextFirstNumber != null && mEditTextFirstNumber.getText() != null) {
            firstNumber = Integer.valueOf(mEditTextFirstNumber.getText().toString());
        }
        if(mEditTextSecondNumber != null && mEditTextSecondNumber.getText() != null) {
            secondNumber = Integer.valueOf(mEditTextSecondNumber.getText().toString());
        }

        Bundle sendParams = new Bundle();
        sendParams.putInt(FIRST_NUMBER_KEY, firstNumber);
        sendParams.putInt(SECOND_NUMBER_KEY, secondNumber);

        //Bundle
//        sendBundle(sendParams);
        //Method
        sendMethod(firstNumber, secondNumber);
    }

    private void sendMethod(int firstNumber, int secondNumber) {
        SumFragment sumFragment = new SumFragment();
        sumFragment.setFirstNumber(firstNumber);
        sumFragment.setSecondNumber(secondNumber);
        replaceFragment(sumFragment);
    }

    private void sendBundle(Bundle sendParams) {
        SumFragment sumFragment = new SumFragment();
        sumFragment.setArguments(sendParams);
        replaceFragment(sumFragment);
    }

    private void replaceFragment(Fragment sumFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment_sum, sumFragment);
        fragmentTransaction.commit();
    }
}
