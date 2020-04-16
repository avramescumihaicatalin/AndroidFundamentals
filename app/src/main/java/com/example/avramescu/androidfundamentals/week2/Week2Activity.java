package com.example.avramescu.androidfundamentals.week2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.avramescu.androidfundamentals.R;

public class Week2Activity extends AppCompatActivity {

/*  Vom prealua elementele din layout si le vom seta proprietati din partea de java
*   pentru a prelua elementul trebuie sa-i setam un id
*   definim o variabila private pentru fiecare element al nostru
*   conventie - Identificatori:
*                   m pentru membru al clasei
*                   s static
*                   UPPERCASE constanta
*               Metode:
*                   camelCaseRule
*
* Initializarea se face in onCreate();
*
* 1) Vreau sa scriu ceva in EditText, apas pe buton si sa mi se preia texul din EditText si sa l
* afiseze in TextView
*
* 2) Cand apasa pe buton ratingBar sa aiba visibility = gone
* */

    private TextView mTextViewHello;
    private EditText mEditTextEmail;
    private Button  nButton;
    private RatingBar mRatingBarMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init(); // metoda de initializare a view-urilor
    }

    private void init() {
        /*pentru preluarea textului folosim clasa R dupa id cu metoda findViewById
        *
        * */

        mTextViewHello = findViewById(R.id.text_view_hello);
        mTextViewHello.setText(getString(R.string.hello_from_java)); /// echivalent cu android:text din xml
        /*
         *de obicei avem gett-eri si sett-eri setText getText setVisibility getVisibility
         *la fel ca si in partea de xml putem sa adaugam direct in string texte cu Alt+Enter
         * pentru a prelua string-ul din string.xml avem metoda getString(R.string.numeString)
         */

        mEditTextEmail = findViewById(R.id.edit_text_email);
//        mEditTextEmail = null; //pentru a vedea Toast-ul
        mRatingBarMain = findViewById(R.id.rating_bar_main);
    }

    public void btnHelloOnClick(View view) {
        if(mEditTextEmail != null){
            String email = mEditTextEmail.getText().toString(); //  conversie la toString pentru ca el ne da un Editable
            if(email != null && !email.isEmpty()){
                mTextViewHello.setText(email);
            }else{
//                daca e null sau gol sa-i spunem utilizatorului sa l completeze
//                exista o metoda pe EditText care se numeste setError -> se inroseste si apare un ! rosu in dreapta
                mTextViewHello.setError(getString(R.string.please_enter_an_email_address));
            }

        }else{
            // ii dam un mesaj developerului sa initializeze email
//                folosim clasa Toast -> un mesaj care apare cateva secunde pe ecran
            Toast.makeText(Week2Activity.this, "Please make EditText not null :)", Toast.LENGTH_LONG).show();
//              Toast are o metoda statica makeText(context = this, text, durata);
//              show pentru afisare.
        }

        mRatingBarMain.setVisibility(View.GONE);
//        constante din clasa View pentru setarea vizibilitatii: GONE, INVISIBLE, VISIBLE
    }
}

/*
* drawableLeft si alegem un icon il deseneaza in stanga dar in interiorul TextView-ului
* */