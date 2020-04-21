package com.example.avramescu.androidfundamentals.week5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.example.avramescu.androidfundamentals.R;

public class DebugActivity extends AppCompatActivity {
    private Switch mSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);

        initView();
    }

    private void initView() {
        mSwitch = findViewById(R.id.toggle_switch);
    }

    public void displayStatusSwitchOnClick(View view) {
        if(mSwitch != null){
            if(mSwitch.isChecked()){
                Toast.makeText(this, "Switch is on", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Switch is off", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
