package com.example.avramescu.androidfundamentals.week4;

/*
* Pasul3
* Cream clasa CarViewHolder care va extinde pe RecyclerView.ViewHolder si o sa trebuiasca sa adaugam
* dependita. Mergem pe app -> click dreapta -> Open Module Settings -> App -> Dependencies -> + ->
* Library Dependencies -> cautam RecyclerView. de la home.android.support.
* Clean Project + Rebuild si vedem daca apare in Gradle Scrpits -> build.gradle(Module:app)
* Daca nu apare il adaugam manual: implementation 'com.android.support:recyclerview-v7:28.0.0'
* Gradle (Sync project with gradle) de pe butonul cu elefant
* RecyclerView va ramane rosu pentru ca trebuie sa implementam niste metode pentru ca ViewHolder
* e clasa abstracta si are metode abstracte pe care trebuie sa le implementam.
* Ca sa le implementam selectam codul ... + Alt + Enter -> Create Constructor
* Acum definim toate elementele din item( toate View-urile ) si o sa le preluam din item view.
* Acest constructor are un view ca parametru, este de fapt View-ul asociat unui item.(relatie 1:1)
* Ca sa preluam elementele ca in onCreate facem: itemView.findViewById
* Cu findViewById nu le gaseste pentru ca in contextul activitatii atunci cand eu dadeam findViewById
* acea metoda se referea strict la contextul layout-ului( stia ca el trebuie sa caute elementele in
* layout-ul asociat activitatii). In cazul nostru nu avem activitate asociata si contextul lui e
* itemView-ul si ca sa preluam elementul trebuie sa facem referire la itemView.
* itemView.findViewById ...
*
* Pasul4
* Cream Adapterul
* new Java Class CarAdapter
* */

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.avramescu.androidfundamentals.R;

public class CarViewHolder extends RecyclerView.ViewHolder{
    private TextView mTextViewName;
    private TextView mTextViewColor;
    private TextView mTextViewHp;

    public CarViewHolder(@NonNull View itemView) {
        super(itemView);

        mTextViewName = itemView.findViewById(R.id.text_view_name);
        mTextViewColor = itemView.findViewById(R.id.text_view_color);
        mTextViewHp = itemView.findViewById(R.id.text_view_hp);

    }


    TextView getmTextViewName() {
        return mTextViewName;
    }

    public void setmTextViewName(TextView mTextViewName) {
        this.mTextViewName = mTextViewName;
    }

    TextView getmTextViewColor() {
        return mTextViewColor;
    }

    public void setmTextViewColor(TextView mTextViewColor) {
        this.mTextViewColor = mTextViewColor;
    }

    TextView getmTextViewHp() {
        return mTextViewHp;
    }

    public void setmTextViewHp(TextView mTextViewHp) {
        this.mTextViewHp = mTextViewHp;
    }

}