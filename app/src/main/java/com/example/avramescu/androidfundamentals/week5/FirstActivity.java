package com.example.avramescu.androidfundamentals.week5;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.avramescu.androidfundamentals.R;

public class FirstActivity extends AppCompatActivity {

    private EditText mEditTextMessage;
    public static final String CHEIE = "mesaj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        initView();
    }

    private void initView() {
        mEditTextMessage = findViewById(R.id.editTextMessage);
    }

    public void startSecondactivityOnClick(View view) {
        Intent goToSecondActivity = new Intent(FirstActivity.this, SecondActivity.class);
        //cream intentul
        // parametrii sunt reprezentati de: de unde plecam
        // si unde vrem sa ajungem
        startActivity(goToSecondActivity);// startActivity(intent)
    }

    public void callImplicitIntentOnClick(View view) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:0754345678")); // se asteapta la un URI =  e un fel de URL doar ca e specific pe zona
//        de setare nr de telefon, email, gps?
//        URI e format din schema si valoare. Schema:Valoare. ex: Uri.parse("tel:0752441232")
//        in functie de schema stie ce sa astepte ca valoare.
//        Acum trebuie sa ne asiguram ca in telefonul nostru putem sa preluam aceasta cerinta.
        if(callIntent.resolveActivity(getPackageManager()) != null){
            startActivity(callIntent);
        }

    }

    public void sendMessageOnClick(View view) {
        if(mEditTextMessage != null && mEditTextMessage.getText()!= null){
            String message = mEditTextMessage.getText().toString();
            if(!TextUtils.isEmpty(message)){
                Intent intentTrimiteMesaj = new Intent(FirstActivity.this, SecondActivity.class);
                intentTrimiteMesaj.putExtra(CHEIE, message);
                startActivity(intentTrimiteMesaj);
            }
        }
    }

    public void btnStartActivityForResultsOnClick(View view) {
        Intent intentActivityForResults = new Intent(FirstActivity.this, ForResultActivity1.class);
        startActivity(intentActivityForResults);
    }

    public void startDebugActivityOnClick(View view) {
        Intent intentActivityForResults = new Intent(FirstActivity.this, DebugActivity.class);
        startActivity(intentActivityForResults);
    }
}

/*
 *      Activitati si Intentii
 *
 *      Activitate
 * O activitate este o componenta de aplicatie care ofera un ecran cu care utilizatorul poate
 * interactiona cu scopul de a face ceva cum ar fi: sa formeze un numar de telefon, sa faca o
 * poza, sa trimita un mail sau sa vada o harta.
 * Fiecare activitate iti da o fereastra in care sa desenezi interfata userului.
 * Fereastra de obicei se intinde cat tot ecranul dar poate fi mai mica decat ecranul si sa
 * pluteasca deasupra celorlalte ferestre.
 *
 *  Atunci cand cream o activitate se intampla niste lucruri. Acestea nu se intamplau de la inceput,
 *  adica in eclipse trebuiau facuti manual acesti pasi.
 *  Pasi in implementarea unei activitati:
 *      1) Definirea layout-ului in XML
 *      2) Definirea activitatii in clasa Java ( extends AppCompatActivity )
 *      3) Conectarea activitatii cu layout-ul. ( set content view in onCreate() )
 *      4) Declararea activitatii in manifest.
 *  In Android Studio cand se creaza o activitate noua i se seteaza automat si un layout si
 *  i se asociaza direct in onCreate, extinde clasa AppCompatActivity( e parintele tuturor activitatilor)
 *  si se declara activitatea in manifest.
 *
 *  O activitate are un ciclu de viata.
 *  Ciclul de viata al unei activitati are un trend ascendent( de creare ) si unul descendent( de
 *  distrugere ).
 *  Trendul ascendent e format din:
 *      onCreate() - crearea activitatii
 *                  - facem @Override la onCreate() din AppCompatactivity
 *                  - i se asociaza layout-ul
 *                  - e creata activitatea ca si entitate.
 *      onStart() - activitatea incepe sa devina vizibila dar nu putem interactiona cu ea.
 *      onResume() - e si vizibila si incepem sa interactionam cu ea si devine activa ( facem scroll,
 *          swipe, citim text etc. )
 *
 * Daca avem un buton care ne duce intr-o alta activitatea in momentul ala intra pe trendul
 * descendent ce este format din:
 *      onPause() - incepe sa dispara
 *                  - inca mai putem interactiona cu ea dar e foarte rapid procesul
 *      onStop() - activitatea a disparut
 *                  - daca userul se razgandeste si da pe butonul de back se intra pe onRestart()
 *      onDestroy() - daca pentru o perioada mai lunga de timp nu o folosim si nu mai e referentiata
 *          o sa intre pe onDestroy()
 *      onRestart() - activitatea e deja creata si nu o mai creaza din nou ci intra prin onStart() ->
 *          onResume() si e din nou vizibila si putem interactiona cu ea.
 *
 *  !La codechallenge o sa avem sa suprascriem toate metodele si sa punem cate un log in fiecare metoda
 *  si sa urmarim logul pentru a vedea ordinea de executie. Testare si cu alta activitate si cu alta
 *  aplicatie si daca distrugem aplicatia.
 *
 *  **********************
 *      Intent
 *  Intentia = dorinta de a face ceva ( pornesti de la ceva si vrei sa ajungi in alta parte )
 *  In Android una dintre utilizarile intentului este sa ne mutam dintr-o activitate in alta activitate.
 *  Exista doua tipuri de Intenturi:
 *      Explicit - folosim Intentul sa pornim o activitate creata de noi ( de developper )
 *      Implicit - folosim Intentul sa pornim o activitate existenta deja in sistem ( intr-o aplicatie
 *          avem iconul de phone ce ne permite sa sunam. Folosim un intent implicit pentru  ca activitatea
 *          de call e deja definita in sistem si o putem apela direct).
 *
 *  Intrebare de interviu: cate tipuri de intenturi exista?
 *
 *  La intent implicit trebuie sa setam niste proprietati.( data si extras )
 *      data - este o bucata de informatie a carei locatie poate fi reprezentata de un URI
 *      extras - una sau mai multe bucati de informatii ca o colectii de perechi cheie-valoare
 *          intr-un Bundle.
 *  Trimiterea unui implicit intent cu data URI:
 *      1) Crearea unei intentii pentru o actiune. ( ce activitate sa lanseze )
 *          Intent intent = new Intent(Intent.ACTION_DIAL);
 *      Intent.ACTION_DIAL - e o ct.
 *      Cand apelez constructorul de Intent cu aceasta constanta imi deschide activitatea ce imi
 *      permite sa sun.
 *      2) Ofera date ca un URI.
 *          Spune ce numar de telefon sa formeze pentru ca daca vrei sa suni inseamna ca vrei sa
 *       apelezi un numar.
 *       intent.setData(Uri.parse("tel:1221412193"));
 *      3) Porneste activitatea cu startActivity(intent)
 *          if(intent.resolveActivity(getPackageManager()) != null){
 *              startActivity(intent);
 *          }
 *          Trebuie sa verific daca pot suna pentru ca de exemplu de pe o tableta care nu are cartela
 *          sim nu pot suna iar daca nu verific va crapa aplicatia in momentul in care voi apela
 *          activitatea.
 *          intent.resolveActivity(getPackageManager()) -> se scaneaza tot sistemul inclusiv aplicatiile
 *          pe care le avem noi instalate si verifica daca acel id ( Intent.ACTION_DIAL ) poate
 *          fi procesat de vreo aplicatie in momentul respectiv. Daca exista adica e diferit de null
 *          te lasa sa suni, altfel ori nu faci nimic ori afisezi o alerta.( pe else )
 *
 *  Aceste proprietati pe langa faptul ca pot fi setate din java, ele se pot seta si din manifest.
 *  ex: avem aplicatii care au buton de share, cand dai pe el iti da toate aplicatiile prin care poti
 *  sa dai share. Acest lucru se face cu Intent filter. Aplicatiile care pot da share au in manifest
 *  o activitate definita cu un Intent filder ce permite share-ul.
 *  Intent filter are 3 tag-uri:
 *      <action> - actiunea pe care o accepta activitatea
  *      <data> - tipul de data acceptat
  *      <category> - categoria intentului ( ex: android.intent.category.BROWSABLE )
  *
  * Moduri de lansare a unei activitati: ( proprietatea launchMode in MANIFEST in tag-ul <activity/> )
  *     standard: O noua activitate este lansata si adaugata catre stiva de intoarcere a task-ului
  * curent. O activitate poate fi instantiata de mai multe ori, un singur task poate avea mai
  * multe instante ale aceleiasi activitati si mai multe instante pot apartine diferitor task-uri.
  *     singleTop: Daca o instanta a unei activitati exista in varful stivei de intoarcere pentru
  * task-ul curent si o cerere de intent pentru acea activitate ajunge, Androidul directioneaza acest
  * intent catre instanta de activvitate existenta mai degraba decat crearea unei noi instante.
  * O noua activitate este inca instantiata daca este o activitate existenta oriunde in stiva de
  * reintoarcere in alta parte decat in varf.
  *     singleTask: Cand o activitate este lansata sistemul creaza un nou task pentru acea acctivitate.'
  * Daca alt task deja exista cu o instanta a acelei activitati sistemul ruteaza intentul catre acea
  * activitate.
  *     singleInstance: La fel ca singleTask cu exceptia ca sistemul nu lanseaza orice alta activitate
  * in task tinand instanta de activitate. Activitatea este mereu singurul membru al task ului.
  *
 *  **********************
  *Intent flags:
  *     FLAG_ACTIVITY_NEW_TASK: porneste o activitate intr-un task nou. Acest comportament
  * este acelasi ca pentru modul de lansare: singleTask.
  *     FLAG_ACTIVITY_SINGLE_TOP: daca activitatea care urmeaza sa fie lansata este in varful
  * stivei de intoarcere, directioneaza intentul catre instanta de activitate existenta. In caz
  * contrar creaza o noua instanta de activitate. Este acelasi comportament ca in modul de lansare
  * singleTop.
  *     FLAG_ACTIVITY_CLEAR_TOP: Daca o instanta a activitatii ce urmeaza sa fie lansata deja exista
  * in stiva de intoarcere, distruge orice alta activitate din varful stivei si directioneaza intentul
  * catre acea instanta existenta. Cand e folosit in conjunctie cu FLAG_ACTIVITY_NEW_TASK acest fanion
  * localizeaza ori instanta existenta a activitatii in orice task si o aduce in prin plan.
 *
 * Vreau sa pun un buton in FirstActivity, cand apas pe buton ma mut in cea de-a doua.
 *
 *  **********************
 *  Bundle
 *  E ca un fel de postas. Avem cele doua activitati si e nevoie uneori sa trimitem informatie dintr-o
 *  activitate in cealalta activitate si asta se poate face prin intermediul Bundleului. Putem trimite
 *  doar lucruri limitate, nu putem trimite obiecte sau liste de obiecte dar putem trimite un int,
 *  boolean, de obicei primitive.
 *  Vreau intr-o activitate sa scriu un nume si in cealalta activitate sa zica: Hello + nume.
 *  Avem instanta de intent ca pana acum si apelam din ea metoda putExtra("Cheie", "Valoare").
 *  Cheia o sa fie intotdeauna un String. Valoarea poate fi: int, String, boolean etc. Pentru a nu ne
 *  incurca in chei folosim constante. Fie o definim in cadrul activitatii fie ne cream un fisier de
 *  constante. Atunci cand trimitem mesajul din activitatea1 in activitatea2 il trimite cu cheia
 *  cheie1. In activitatea2 daca vrem sa-l preluam trebuie sa avem aceeasi cheie cheie1. De aceeea nu
 *  e bine sa mergem pe varianta hardcodata si mai bine folosim constante.
 *  Pentru preluare folosim clasa Bundle. Cream un obiect de tip Bundle:
 *      Bundle bundle = getIntent().getExtras();
 *  Preluam intentul si apelam comportamentul getExtras. Aici e la plural Extras fata de Extra
 *  asta inseamna ca in activitatea1 pot apela de mai multe ori putExtra si cu getExtras le preia
 *  pe toate. Pentru a prelua doar un anumit element trimis din activitatea1 folosim cheia aferenta.
 *  Apelam din obiectul de tip bundle comportamentul getString(cheie1);
 *
 *  PutExtra o sa-l folosim la proiectul final la RecyclerView.
 *  Avem mai multi Items. RecyclerView o sa-l populam din Firebase. Si o sa am Trip1(7) ( Trip( id 7 )
 *  Trip2(11), Trip3(5) ... Si o sa trebuiasca sa implementam RecyclerView-ul asta cu lista de
 *  calatorii si o sa avem nevoie ca atunci cand userul selecteaza un item( da click pe un item )
 *  sa ne duca intr-un ecran cu detaliile acelei calatorii. Ca sa ma trimita din activitateaRecyclerView
  *  in activitateaTrip2 si sa stiu ce informatie sa afisez trebuie sa fac o legatura intre ele.
  *  Trebuie sa stiu ca daca am dat click pe Trip2 inseamna ca eu vreau informatia pentru Trip2.
  *  Acest lucru se face cu putExtra(ID, 11); 11 e din java un int id.
  *  In partea de details facem cu getExtras(); si facem int idPrimit = extras.getInt(ID); ID e cheia.
  *  Eu am id-ul si o sa fac un request la FireBase ca sa-mi dea detaliile acestui id.
  *
  *   Nu e ok sa trimiti obiect pentru ca daca toata lumea are acces la obiecte si le modifica
  *   e posibil ca pana sa se trimita obiectul dintr-o parte in alta sa se fi modificat structura
  *   intre timp si pot aparea probleme.
  *  Pot sa am o cheie cu int si alta cu String dar trebuie sa fie cheile diferite.
  *  In exemplul nostru am trimis o valoare de tip String si in activitatea2 am extras.getString.
  *  Daca as fi trimis un int as fi avut extras.getInt(). Trebuie sa-i spunem ce am trimis.
  *
  *  In activitatea1 putem un EditText si un Button. Scriu ceva in EditText iar cand apas pe buton
  *  ma mut in activitatea2 si afisez mesajul scris in activitatea1.
  *
  *  **********************
  *     StartActivityForResults
  *     Ne muta din prima activitatea curenta in alta activitate insa in plus cea de-a doua activitate
  * trebuie sa-i trimita un result inapoi primeia. Metoda startActivityForResults() e partea prin care
  * ma mut din activitatea1 in activitatea2 pentru a prelua ceva din activitatea2 si e strans legata
  * de metoda onActivityResults. Cand ma intorc din activitatea2 in activitatea1 cu acel obiect, in
  * activitatea1 o sa se declanseze onActivityResult().
  * ex: activitatea1 porneste galeria pentru a lasa userul sa aleaga o poza si apoi ma intorc in
  * activitatea1 pentru a afisa-o.
  * ex: activitatea1 porneste o lista cu numere de telefon, aleg si preiau un numar de acolo.
  * startActivityForResults e foarte buna pentru intenturi implicite.
  * startActivityForResults() are doi parametri:
  *     intent data
  *     int requestCode - identificare a orderului adica daca trimit acel cod, tot pe acel cod trebuie sa
  * primesc si rezultatul.  E o modalitate de a identifica acel canal de comunicare intre cele doua
  * activitati.
  * onActivityResult() are parametri:
  *     int requestCode - codul de identificare
  *     int resultCode - cod care ne spune daca actiunea a esuat sau a fost efectuata cu succes
  *     intent data - data care e putin diferit fata de data folosit trimis pana acum
  * In activitatea2 pentru a trimite ceva inapoi trebuie sa apelam metoda setResult();
  * Are doi parametri:
  *     resultCode - care poate fi OK sau CANCELED.
  *     data - ce se trimite mai departe.
  *De obicei dupa aceasta metoda se apeleaza metoda finish(); Ea distruge activitatea curenta.
  * Activitatea curenta intra pe fluxul de onPause, onStop, onDestroy.
  *
  *     onSavedInstanceState() + onRestoreInstanceState()
  * Pe langa metodele de la activity life-cycle mai exista si altele.
  * Exista situatii cand se schimba configuratia: rotim telefonul, schimbam limba si se vor pierde
  * datele din ecran daca nu au fost salvate.
  * Ca sa nu pierdem datele exista posibiliatea sa facem un fel de cache adica atunci cand intervine
  * o schimbare de stare sa reinstantieze starea de dinainte de schimbare.
  * Salvarea datelor se bazeaza pe Bundle.
  * La schimbarea de configurarea activitatea se recreaza.
  *
  *
  *
 * */