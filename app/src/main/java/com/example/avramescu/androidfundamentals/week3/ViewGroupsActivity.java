package com.example.avramescu.androidfundamentals.week3;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import com.example.avramescu.androidfundamentals.R;

public class ViewGroupsActivity extends AppCompatActivity {

    private TextView mTextViewLongText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_groups);

        initView(); // metoda pentru definirea view-urilor
    }

    private void initView() {
        mTextViewLongText = findViewById(R.id.text_view_long_text);
        mTextViewLongText.setText(getString(R.string.long_text_for_scroll));
    }

}
