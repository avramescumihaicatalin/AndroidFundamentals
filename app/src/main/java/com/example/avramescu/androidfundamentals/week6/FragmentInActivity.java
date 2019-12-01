package com.example.avramescu.androidfundamentals.week6;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.avramescu.androidfundamentals.R;

public class FragmentInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_in);

        addFragmentDynamically();
    }

    private void addFragmentDynamically() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_for_fragment, new HelloFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(FragmentInActivity.this, "Back was pressed",
                Toast.LENGTH_LONG).show();

    }

    /*
    *       Fragmente
    *
    * Un fragment e o componenta reutilizabila de UI cu propriul life-cycle.
    * Fragmentul nu poate trai fara o activitate care sa-l contina.
    *   Modalitati de creare:
    *       static: in xml ca pe un alt view
    *       dinamic: din partea de java
    * Fragmentele nu sunt declarate in manifest ci se comporta ca niste clase.
    *   Static:
    *       creare layout pentru fragment
    *       creare clasa care sa extinda clasa Fragment
    *       legam layout-ul cu clasa creata
    *       plasam fragmentul in layout-ul activitatii cu tag-ul <fragment>
    * In layout-ul activitatii trebuie sa dam un id fragmentului in tagul de <fragment> cat si
    * sa setam proprietatea name="package.HelloFragment"
    * Daca cream un Fragment in Android Studio el stie sa faca primii 3 pasi.
    *   Dinamic:
    *      creare layout pentru fragment
    *      creare clasa care sa extinda clasa Fragment
    *      legam layout-ul cu clasa creata
    *      folosim clasa FragmentManager pentru managementul fragmentelor intr-o aplicatie
    * Pentru inserarea in layout-ul activitatii a fragmentului ne folosim de un FrameLayout pe post
    * de placeholder.
    *   FragmentTransaction ne permite sa facem operatii cu fragmente:
    *   add(), remove(), replace(), hide(), show(), addToBackStack()-cand vrem ca fragmentul sa fie
    * adaugat in backStack.
    *
    *       Fragment Life-cycle
    * Are un trend ascendent si unul descendent.
    *   onAttach();
    *   onCreate(); se creaza obiectul
    *   onCreateView(); se creaza view-ul
    *   onActivityCreated(); a fost creata activitatea
    *   onStart(); ca la activity
    *   onResume(); ca la activity
    *       Acum fragmentul ruleaza.
    *   onPuase(); ca la activity
    *   onStop(); ca la activity
    *   onDestroyView(); distruge view-ul
    *   onDestroy(); distruge obiectul
    *   onDetach(); detaseaza fragmentul.(il scoate din stack-ul activitatii?)
    *
    *       Fragmentul va fi mereu in activitate si de cele mai multe ori vom avea nevoie sa
    * trasmitem date din activitate in fragment sau din fragment in activitate.
    *   Exista 3 variante:
    *       cu Bundle
    *       cu o metoda care e un setter pe un camp
    *       cu Listener care e o interfata pe care o reutilizam in cadrul activitatii.
    * a) Bundle: Bundle-ul e la fel ca la activitate si avem metode de genul: putInt, putString iar
    * daca in activitate aveam putExtra() aici avem fragment.setArguments(bundle).
    *   Pe partea de preluare avem bundle b = getArguments(); si apoi apelam metode getInt(), getString()
    * cu cheile aferente pentru a prelua datele.
    * b) Prin metode: presupune ca avem in fragment o metoda doWork() sau un setter pe un alt camp.
    * In activitate apeland metoda respectiva o sa am acces la acea valoare.
    * c) Listener: Am o interfata si am fie doua fragmente si o activitate fie doar un fragment
    * si o activitate.
    * In fragment apelez listenerul prin intermediul activitatii si in activitate fac override de
    * metoda din listener si definesc ce face suprascrierea metodei in activitate.
    *
    *       User Navigation
    *   Tipuri:
    *       Back: userul foloseste butonul fizic de back(sau din nav bar). E controlata de back stack.
    *       Ierarhica: fie foloseste tab-ul, fie foloseste navigation drawer, fie navigatie ancestrala???
    * a) Back: E un stack de activitati si cand apas pe back, aplicatia de sus dispare si apare urmatoarea.
    *   onBackPressed() - suprascriem pentru a modifica comportarea de back a butoanelor.
    * b)
    *  Parent screen: ecran care permite navigarea inapoi la ecrane copil, cum ar fi home screen sau
    * main activity.
    *  Collection sibling: navigation, ecran care permite navigarea inapoi la o colectie de ecrane
    * copil, cum ar fi o lista de titluri
    *  Section sibling: ecran cu continut ca la taburi.
    * !!!!!!!!!!!!!
    * De creat navigation drawer din template pentru a vedea cate view-uri se creaza si cum sunt
    * inlantuite!!!
    *
    *   <include> seamana cu import-ul din java. Unde este folosit poti adauga un alt layout folosind
    * acest tag ca si cum l-as copia cu totul acolo.
    *   Crem un NavigationDrawer cu new Activity-> Navigation Drawer Activity
    *
    * 1:08 curs6-2
    * Mi-a creat NavigationActivity, apoi layout-ul
    *
    *
    * */
}
