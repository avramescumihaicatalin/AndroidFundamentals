package com.example.avramescu.androidfundamentals.week5;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.avramescu.androidfundamentals.R;

public class ForResultActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result2);

        getDataFromFirstActivity();
    }

    private void getDataFromFirstActivity() {
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String name = extras.getString(ForResultActivity1.NAMEKEY, "default value");
            if(!TextUtils.isEmpty(name)){
                name = "Hello " + name;
                Intent backToFirstActivity = new Intent(ForResultActivity2.this, ForResultActivity1.class);
                backToFirstActivity.putExtra(ForResultActivity1.NAMEKEY, name);
                setResult(RESULT_OK, backToFirstActivity);
                finish();
            }
        }

    }
}
