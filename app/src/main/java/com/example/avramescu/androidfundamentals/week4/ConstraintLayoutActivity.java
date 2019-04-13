package com.example.avramescu.androidfundamentals.week4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.avramescu.androidfundamentals.R;

public class ConstraintLayoutActivity extends AppCompatActivity {

/*
* ConstraintsLayout vine sa inlocuiasca RelativeLayout. Face cam tot ce face RelativeLayout si mai
* exista diferenta ca RelativeLayout construieste o structura arborescenta pe cand ConstraintLayout
* are o structura liniara si implicit cand randeaza acel ecran e mult mai simplu sa parcurga acea
* structura.
* Se lucreaza foarte mult in zona de design din xml.
* In partea stanga sus avem Palette unde avem toate view-urile.
* In partea de Component tree de fiecare data cand adaugam un view o sa apara si aici.
* Cand selectam un view or sa apara toate propiretatile lui in dreapta.
* Daca adaug un view si nu-i pun constrangeri o sa sara in (0.0). Trebuie sa am constrangeri cel
* putin una pe orizontala si una pe verticala. Constrangerile se seteaza din punctele de pe view.
*Avem doua modalitati sa vedem ca nu am setat constrangeri:
*       1) in component tree avem eroare care ne spune ca nu am setat constrangeri
*       2) in text in xml avem proprietatile absoluteX si/sau absoluteY
*
*
* */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);
    }
}
