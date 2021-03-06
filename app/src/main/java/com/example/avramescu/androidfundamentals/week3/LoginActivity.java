package com.example.avramescu.androidfundamentals.week3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.avramescu.androidfundamentals.R;

/*
Verificarea email-ului daca e valid( sa aiba @ etc)
De obicei se face cu regular expression dar in Android exista clasa Pattern care permite verificarea.
Are o constanta EMAIL_ADDRESS care e de fapt un regular expression in spate si face matching cu
stringul nosrtru.
* */

public class LoginActivity extends AppCompatActivity {
    private EditText mEditTextEmail;
    private EditText mEditTextPhone;
    private CheckBox mCheckBoxTerms;
    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        mEditTextEmail = findViewById(R.id.edit_text_email);
        mEditTextPhone = findViewById(R.id.edit_text_phone);
        mCheckBoxTerms = findViewById(R.id.checkbox_terms);
        mTextViewResult = findViewById(R.id.text_view_result);
    }

    public void submitDataOnClick(View view) {
        if(isEmailValid() && isPhoneValid() && isCheckboxChecked()){
            String email = mEditTextEmail.getText().toString();
            String phone = mEditTextPhone.getText().toString();
            boolean terms = mCheckBoxTerms.isChecked();
            LoginDetails loginDetails = new LoginDetails(email, phone, terms);
            mTextViewResult.setText(loginDetails.toString());
        }

    }

    private boolean isEmailValid() {
        if(mEditTextEmail != null){
            String email = mEditTextEmail.getText().toString();
            if(!email.isEmpty()){
                boolean b = EmailHelper.isEmailValid(email);
                if( b ) {
                    return true;//email a fost introdus corect
                }else{
                    Toast.makeText(this, "Nu se respecta patter-ul de email", Toast.LENGTH_LONG).show();
                    return false;
                }
            }else{
                mEditTextEmail.setError("Please enter an email address");
                return false;
            }
        }else{
            Toast.makeText(LoginActivity.this, "Please make edit_text_email not null", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    private boolean isPhoneValid() {
        if(mEditTextPhone != null){
            String phone = mEditTextPhone.getText().toString();
            if(!phone.isEmpty()){
                return true;
            }else{
                mEditTextPhone.setError("Please introduce your number");
                return false;
            }
        }else{
            Toast.makeText(LoginActivity.this, "Please make edit_text_phone not null", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    private boolean isCheckboxChecked(){
        if(mCheckBoxTerms != null){
            if(mCheckBoxTerms.isChecked()){
                return true;
            }else{
                Toast.makeText(LoginActivity.this, "Please check T&C", Toast.LENGTH_LONG).show();
                return false;
            }

        }else{
            Toast.makeText(LoginActivity.this, "Please make checkbox_terms not null", Toast.LENGTH_LONG).show();
            return false;
        }

        /*
        * daca am checkbox nebifat si imi apare eroarea iar dupa ce il bifez eroarea ramane trebuie sa setez
        *onCheckChangeListener pe checkbox care sa asculte pe change-ul de checkbox
        * */
    }

}
