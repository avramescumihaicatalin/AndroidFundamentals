package com.example.avramescu.androidfundamentals.week5;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.avramescu.androidfundamentals.R;

public class ForResultActivity1 extends AppCompatActivity {
    public static final String NAMEKEY = "NAME";
    public static final int FIRST_ACTIVITY = 1;

    public static final String EDIT_TEXT = "EDIT_TEXT";
    public static final String CHECKBOX = "CHECKBOX";

    private EditText mEditTextName;
    private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result1);

        initView();
    }

    private void initView() {
        mEditTextName = findViewById(R.id.edit_text_name);
        mCheckBox= findViewById(R.id.checkBox);

    }

    public void sendNameToSecondActivityOnClick(View view) {
        if(mEditTextName != null && mEditTextName.getText() != null){
            String name = mEditTextName.getText().toString();
            if(!TextUtils.isEmpty(name)){
                Intent startSecondActivity = new Intent(ForResultActivity1.this, ForResultActivity2.class);
                startSecondActivity.putExtra(NAMEKEY, name);
                startActivityForResult(startSecondActivity, FIRST_ACTIVITY);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == FIRST_ACTIVITY && resultCode == RESULT_OK){
            if(data != null){
                String name = data.getStringExtra(NAMEKEY);
                mEditTextName.setText(name);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.d("OnSave", "save");

        super.onSaveInstanceState(outState, outPersistentState);

        if(mEditTextName != null && mEditTextName.getText() != null){
            outState.putString(EDIT_TEXT, mEditTextName.getText().toString());
        }
        if(mCheckBox != null){
            outState.putBoolean(CHECKBOX, mCheckBox.isChecked());
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        Log.d("OnRestore", "restore");

        super.onRestoreInstanceState(savedInstanceState, persistentState);

        if(savedInstanceState != null){
            if(mEditTextName != null){
                mEditTextName.setText(savedInstanceState.getString(CHECKBOX));
            }
            if(mCheckBox != null){
                mCheckBox.setChecked(savedInstanceState.getBoolean(CHECKBOX));
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("onDestroy", "destroyed");
    }
}
