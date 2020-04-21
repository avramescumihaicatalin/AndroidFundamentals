package com.example.avramescu.androidfundamentals.week3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.avramescu.androidfundamentals.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    /*
     * Pentru a crea un Spinner avem nevoie de:
     * 1) o sursa de date(DataSource) - hardcodam o lista pentru
     * ca inca nu am invatat sa lucram cu baza de date sau cu API
     * 2) cream Adapterul (new ArrayAdapter)
     * 3) asociem Adapterul Spinnerului. (metoda setAdapter)
     * Sursa de date este trimisa unui Adaptor iar apoi Spinner-ului pentru afisare
     *
     * Exista doua tipuri de Adapter in Android:
     *  a) default
     *  b) custom - implementat de noi
     * */

//    Ctrr + P arata care sunt parametrii disponibili unei metode sau constructor.

    private List<String> mColors;
    //avem nevoie de o lista de elemente pe care sa le introducem in spinner
    private Spinner mSpinner;
    //definim un obiect de tip Spinner

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        initView();// initializare Spinner
        setColors(); // creat dataSource-ul
        setAdapter(); // metoda care creaza si seteazaAdapterul
        mSpinner.setOnItemSelectedListener(this);
    }

/*    am facut overEngeniering asa ca am renuntat la metoda getAdapter si am implementat
    functionalitatea ei in setAdapter
 */
    private ArrayAdapter<String> getAdapter(){ // creaza Adapterul
        return new ArrayAdapter<>(SpinnerActivity.this,
                android.R.layout.simple_list_item_1, mColors);
    }
        /*
    context-ul este activitatea curenta
    LayoutRes -> resursa
    DataSource-ul -> sursa( lista )
    La Recycleview putem sa ne definim noi cum o sa arate item-ul din lista.
    La Spinner putem folosi niste items deja definite in Android.
    Cum exista niste culori predefinite exista si Layoout-uri predefinite.
    Aici folosim un item predefinit care contine doar un textView pentru ca noi
    avem nevoie de un item cu un TextView in care sa afisam culoarea. Noi am folosit
    simple_list_item_1
 */



    private void setAdapter() { // setamAdapterul
        //mSpinner.setAdapter(getAdapter());
        mSpinner.setAdapter(new ArrayAdapter<>(SpinnerActivity.this,
                android.R.layout.simple_list_item_1,
                mColors));
    }

    private void setColors() {
        mColors = new ArrayList<>();
        mColors.add("Verde");
        mColors.add("Albastru");
        mColors.add("Siclam");
        mColors.add("Magenta");
        mColors.add("Roz");
        mColors.add("Galben");
    }

    // preia Spinner-ul
    private void initView() {
        mSpinner = findViewById(R.id.spinner_colors);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Selected: " + mSpinner.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Please select an item from dropdown list!", Toast.LENGTH_SHORT).show();
        //TODO not reached
    }
}