package com.example.avramescu.androidfundamentals.week4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.avramescu.androidfundamentals.R;

public class RecyclerViewActivity extends AppCompatActivity {
/*
*   RecyclerView are nevoie de un Adapter.
* Exista doua tipuri de Adapter in Android: default si custom
* Default Adapter -> adapterul folosit la curs3: ArrayAdapter la Spinner
* Custom Adapter -> crem propriul Adapter.
* Trebuie sa urmarim niste pasi astfel incat acest Adapter sa poata fi atasat RecyclerView-ului
*   RecyclerView e o lista: o lista de email-uri, E o modalitate de a afisa o lista foarte mare.
* Aceasta lista are scroll si fiecare item poate fi customizat.( un layout propriu care va fi replicat
* pentru fiecare item).
* E unul dintre cele mai utilizate elemente de UI.
* Inainte de RecyclerView a existat ListView dar nu mai e recomandat sa-l folosim. Arata la fel, era
* o lista in care puteai face scroll si puteai seta itemul sa arate cum vrei dar nu era la fel
* de bine optimizat. Recycler View are in plus faptul ca refoloseste continutul deja desenat.
*   In ListView daca aveam 20 de cadouri de desenat si pe ecran imi incapeau 5 cadouri, aca faceam scroll
* sa le vad pe urmatoarele se popula lista cu urmatoarele cadouri. Daca voiam sa le revad pe cele de la
* inceputul listei si faceam scroll, in spate el le redesena chiar daca le mai desenase o data.
*   RecyclerView refoloseste itemii deja desenati pentru ca i-a mai desenat o data si economiseste resurse,
* tranzitiile devin mai line.
*   Puteai aduce ListView aproape ca functionalitate de RecyclerView daca scriai cod. Exista o metoda setTag
* unde puneai un flag prin care verificai daca a mai fost creat o data sau nu item-ul.
* Acum aceasta implementare e facuta by default.
*   La ListView modalitatile de accesare ai item-ilor erau pe orizontala sau pe verticala.
*   La RecyclerView exista mai multe modalitati. Vertical ca lista, sub forma de grid, sau gen pinterest.
*( e o combinatie intre cele doua, ai itemi cu o dimensiune variabila: LinearLayoutManager; GridLayoutManager
 * si StaggeredGridLayoutManager )
*   Exista un Layout manager care-i spune RecyclerView ului cum sa-si afiseze itemii( cele 3 variante )
*   Exista un nou sablon de proiectare( ViewHolder ) pe care inainte nu erai obligat sa-l scrii ( sa-l
* implementezi). O faceai doar daca voiai tu. Acum daca implementezi RecyclerView esti obligat sa implementezi
* si ViewHolder-ul.
*   ViewHolder era o mapare in java a elementelor din item ca sa ai acces la elementele din item foarte
* usor.
*
*   Pasi de efectuat:
*   1) Data Model
*   2) Create Layout item
*   3) Extindem clasa ViewHolder
*   4) Facem Adapter
*   5) Adaugare dependinte si adaugam view in activitate
*   6) Set LayoutManager - ii spunem cum sa se aseze.
*   7) Set Adapter
*
* */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
    }
}