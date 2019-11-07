package com.example.avramescu.androidfundamentals.week4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.avramescu.androidfundamentals.R;

import java.util.ArrayList;

/*
 *   RecyclerView are nevoie de un Adapter.
 * Exista doua tipuri de Adapter in Android: default si custom
 * Default Adapter -> adapterul folosit la curs3: ArrayAdapter la Spinner
 * Custom Adapter -> cream propriul Adapter.
 * Trebuie sa urmam niste pasi astfel incat acest Adapter sa poata fi atasat RecyclerView-ului
 *   RecyclerView e o lista: o lista de email-uri. E o modalitate de a afisa o lista foarte mare.
 * Aceasta lista are scroll si fiecare item poate fi customizat.( un layout propriu care va fi replicat
 * pentru fiecare item).
 * E unul dintre cele mai utilizate elemente de UI.
 * Inainte de RecyclerView a existat ListView dar nu mai e recomandat sa-l folosim. Arata la fel, era
 * o lista in care puteai face scroll si puteai seta itemul sa arate cum vrei dar nu era la fel
 * de bine optimizat. Recycler View are in plus faptul ca refoloseste continutul deja desenat.
 *   In ListView daca aveam 20 de cadouri de desenat si pe ecran imi incapeau 5 cadouri, cand faceam scroll
 * sa le vad pe urmatoarele se popula lista cu urmatoarele cadouri. Daca voiam sa le revad pe cele de la
 * inceputul listei si faceam scroll, in spate el le redesena chiar daca le mai desenase o data.
 *   RecyclerView refoloseste itemii deja desenati pentru ca i-a mai desenat o data si economiseste resurse
 *   si tranzitiile devin mai line.
 *   Puteai aduce ListView aproape ca functionalitate de RecyclerView daca scriai cod. Exista o metoda setTag
 * unde puneai un flag prin care verificai daca a mai fost creat o data sau nu item-ul.
 * Acum aceasta implementare e facuta by default.
 *   La ListView modalitatile de pozitionare ai item-ilor erau pe orizontala sau pe verticala.
 *   La RecyclerView exista mai multe modalitati. Vertical ca lista, sub forma de grid, sau gen pinterest.
 *( e o combinatie intre cele doua, ai itemi cu o dimensiune variabila: LinearLayoutManager; GridLayoutManager
 * si StaggeredGridLayoutManager )
 *   Exista un Layout manager care-i spune RecyclerView ului cum sa-si afiseze itemii( cele 3 variante )
 *   Exista un nou sablon de proiectare( ViewHolder ) pe care inainte nu erai obligat sa-l scrii ( sa-l
 * implementezi). O faceai doar daca voiai tu. Acum daca implementezi RecyclerView esti obligat sa implementezi
 * si ViewHolder-ul.
 *   ViewHolder este o mapare in java a elementelor din item ca sa ai acces la elementele din item foarte
 * usor.
 *
 *   Pasi de efectuat:
 *   1) Data Model
 *   2) Create Layout item( cum sa arate item-ul meu atat in java cat si in xml)
 *   3) Extindem clasa ViewHolder
 *   4) Facem Adapter
 *   5) Adaugare dependinte si adaugam view in activitate
 *   6) Set LayoutManager - ii spunem cum sa se aseze.
 *   7) Set Adapter
 *
 *  Pasul1
 *  Cream Modelul de date. Cream clasa Car care reprezinta item-ul nostru
 *
 * O sa adaugam RecyclerView in activitate. Ne ducem pe layout, punem LinearLayout si in interior un
 * RecyclerView si ii adaugam id.
 *
 * Pasul6
 * Setam LayoutManager dar inainte de a-l seta trebuie sa-l preluam.
 *Facem metoda separata pentru a seta LayoutManager-ul
 *  Ne folosim de clasa RecyclerView care are in interior un LayoutManageer si folosim un
 *  LinearLayoutManager
 *
 *  Pasul7
 *  Setam Adapter dar inainte trebuie sa avem DataSource-ul
 *  Facem o lista de masini pe care o populam si o apelam.
 *  Facem o metoda setAdapter();
 *
 * */


public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewCars;
    private ArrayList<Car> mCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initView();
        setLayoutManager();
        setCars();
        setAdapter();

    }

    private void setAdapter() {
        CarAdapter carAdapter = new CarAdapter(mCars);
        mRecyclerViewCars.setAdapter(carAdapter);
    }

    private void setCars() {
        mCars = new ArrayList<>();
        Car car1 = new Car("Dacia", "red", 70);
        Car car2 = new Car("Benveu", "negru", 500);
        Car car3 = new Car("Trabant", "roz", 2);
        Car car4 = new Car("Bentley", "lila", 650);
        Car car5 = new Car("Audi", "alb", 300);
        Car car6 = new Car("Dacia", "red", 70);
        Car car7 = new Car("Benveu", "negru", 500);
        Car car8 = new Car("Trabant", "gri", 12);
        Car car9 = new Car("Bentley", "albastru", 220);
        Car car10 = new Car("Audi", "galben", 170);
        mCars.add(car1);
        mCars.add(car2);
        mCars.add(car3);
        mCars.add(car4);
        mCars.add(car5);
        mCars.add(car6);
        mCars.add(car7);
        mCars.add(car8);
        mCars.add(car9);
        mCars.add(car10);
    }

    private void initView() {
        mRecyclerViewCars = findViewById(R.id.recycler_view_cars);
    }

    private void setLayoutManager(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerViewCars.setLayoutManager(layoutManager);
    }
}
