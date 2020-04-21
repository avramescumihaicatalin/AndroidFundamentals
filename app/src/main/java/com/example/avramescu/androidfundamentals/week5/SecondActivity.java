package com.example.avramescu.androidfundamentals.week5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.avramescu.androidfundamentals.R;

public class SecondActivity extends AppCompatActivity {

    private TextView mTextViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
    }

    @Override
    protected void onResume(){
        super.onResume();
        String mesaj = null;
        Bundle dataReceived = getIntent().getExtras();
        if(dataReceived != null){
            mesaj = dataReceived.getString(FirstActivity.CHEIE);
            //String messageReceived = getIntent().getStringExtra(FirstActivity.MESSAGE);
            //cele doua sunt echivalente
        }
        if(mTextViewMessage != null && !TextUtils.isEmpty(mesaj) && mesaj != null){
            mTextViewMessage.setText(mesaj);
        }
    }

    private void initView() {
        mTextViewMessage = findViewById(R.id.text_view_message_received);
    }
}
