package com.example.avramescu.androidfundamentals.week6;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.avramescu.androidfundamentals.R;

public class LengthFragment extends Fragment implements LengthListener{

    EditText mEditTextFragmentInput;
    Button mButtonGetLength;

    public LengthFragment () {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_length, container, false);

        initView(view);

        mButtonGetLength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendInputValue();
            }
        });

        return  view;
    }

    private void sendInputValue() {
        if (mEditTextFragmentInput != null && mEditTextFragmentInput.getText() != null) {
            String value = mEditTextFragmentInput.getText().toString();
            LengthListener lengthListener = (LengthListener) getActivity();
            lengthListener.displayLength(value);
        }
    }

    private void initView(View view) {
        mEditTextFragmentInput = view.findViewById(R.id.edit_text_input);
        mButtonGetLength = view.findViewById(R.id.btn_get_length);
    }

    @Override
    public void displayLength(String value) {
        mEditTextFragmentInput.setText("received text from activity: " + value + " length:" + value.length());
    }
}
