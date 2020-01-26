package com.example.avramescu.androidfundamentals.week6;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.avramescu.androidfundamentals.R;

public class SumFragment extends Fragment {

    private int firstNumber;
    private int secondNumber;

    TextView mSumTextView;

    public SumFragment () {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_sum, container, false);

        initView(view);

//        bundleVersion();

        methodVersion();

        return view;
    }

    private void initView(View parent) {
        mSumTextView = parent.findViewById(R.id.text_view_sum);
        mSumTextView.setText("test");
    }

    private void methodVersion() {
        int sum = this.firstNumber + this.secondNumber;
        mSumTextView.setText(sum + "");
    }

    private void bundleVersion() {
        Bundle receivedParams = getArguments();
        assert receivedParams != null;
        int a = receivedParams.getInt(SumActivity.FIRST_NUMBER_KEY);
        int b = receivedParams.getInt(SumActivity.SECOND_NUMBER_KEY);
        int sum = a + b;
        if (mSumTextView != null) {
            mSumTextView.setText(sum + "");
        }
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }
}
