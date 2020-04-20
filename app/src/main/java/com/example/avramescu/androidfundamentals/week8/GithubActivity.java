package com.example.avramescu.androidfundamentals.week8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.avramescu.androidfundamentals.R;

import java.util.List;

public class GithubActivity extends AppCompatActivity {

    private TextView mTextViewRetrofit;
    private ImageView mImageViewPicasso;

    private UsersRepository usersRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);

        initView();
        getData();
    }

    private void initView() {
        mTextViewRetrofit = findViewById(R.id.textViewRetrofit);
        mImageViewPicasso = findViewById(R.id.imageViewPicasso);

//        Picasso.get().load("https://9to5google.com/wp-content/uploads/sites/4/2015/10/android-versions.jpg").into(mImageViewPicasso);
    }

    private void getData() {
        usersRepository = UsersRepository.getInstance();
        usersRepository.getUsers(new OnGetUsersCallback() {
            @Override
            public void onSuccess(List<User> users) {
                StringBuilder stringBuilder = new StringBuilder();
                for (User user : users) {
                    stringBuilder.append(user.toString() + " /// ");
                    mTextViewRetrofit.append(user.toString() + " /// ");
                }
                Logging.show("Github users = ", users.toString());
                Toast.makeText(GithubActivity.this, stringBuilder.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError() {
                Logging.show("error Github users = ", "check the code :D ");
                Toast.makeText(GithubActivity.this, "error getting the Github users",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    /**          Networking : - Http request (Retrofit)
                             - Firebase

     In Android avem un main thread care e responsabil cu UI-ul.
     Long running operations trebuie rulate in afara main thread-ului. ( operatii complexe, filtre,
     networking, download, upload, procesare de imagini, database operations.
     De aceea au aparut worker threads care executa niste long running operations si la sfarsit
     updateaza UI-ul sau nu, in functie de necesitate.

        Servicii web:
     Avem aplicatia Android si un server. Pe server avem o baza de date sau in cloud undeva. Nu e best
     practice ca android-ul sa se conecteze la server direct si nici nu e foarte facil pentru ca nu o
     sa am aceleasi capabilitati si aceleasi performante. Solutie: serviciu web.

     Avem o baza de date si aceasta baza de date e in cloud. Avem telefonul cu Android care trebuie sa
     se conecteze la BD si sa ia informatii pentru ca aplicatia are mai multi useri. Schimbul de
     informatie se realizeaza in ambele sensuri. Deoarece comunicarea din BD si aplicatie nu se poate
     realiza direct, apare un layer intre ele care este reprezentat de Serviciul Web.
     Web Service-ul e un cod de backend ( C#, NodeJs, Java, Scala, Kotlin ) care are grija sa trimita
     datele si intr-un sens si in celalalt. Aici sunt niste controlere care au niste metode expuse,
     adica am acces la ele din HTTP.
     Daca serviciul este locat la: http:students.com -> reprezinta root-ul
     http:students.com/students/ -> students e o metoda in controler
     http:students.com/students/id -> intoarce studentul cu id-ul respectiv
     http:students.com/student -> pentru a salva un student
     http:students.com/university
     http:students.com/teacher

     Databases:
     O baza de date are mai multe tabele.
     Ex: Avem tabela Student.
     O particularitate a tabelei este PK -> identifica unic un rand in cadrul tabelei.
     FK -> foreign key: cand ai nevoie sa mapezi o relatie 1:N intre mai multe tabele.
     Intre tabele pot exista relatii:
     1 : 1 ex: un Manager este un Angajat
     1 : M ex: o Companie are mai multi Angajati -> avem nevoie de FK. Cand adaug o Companie in tabela
     Company e totul in regula dar cand adaug un Angajat, acea inregistrare trebuie sa o mapez pe o
     Companie. -> Voi adauga in tabela Angajati id-ul companiei pentru care lucreaza. Ca sa ma asigur
     ca acea companie exista stabilesc o legatura de tip cheie straina cu tabela Company, daca tabela
     Company are Pk atributul Company_id , aceasta devine FK in tabela Angajati. Cand adaug un angajat
     nou spun pe ce companie adaug acel angajat adaugandu-i FK.
     M : N  ex: O Universitate poate avea mai multi Studenti si un student poate invata la mai multe
     universitati. In cazul unei astfel de relatii se va face o tabela de legatura (join table).
     Tabelul de legatura trebuie sa contina PK ale celor doua tabele pentru a realiza maparea.

     Operatii pe BD:
        SELECT -> preia un rand/mai multe       echivalente <=> GET
        INSERT -> adauga un rand/mai multe      in          <=> POST
        DELETE -> sterge un rand/mai multe      serviciu    <=> DELETE
        UPDATE - > updateaza un rand/mai multe  web         <=> PUT
     GET, POST, DELETE, PUT sunt verbe http. Cand apelam serviciul web trebuie sa precizam verbul
     asociat pentru a stii serviciul web ce metoda sa apeleze.

     JSON
     ex: obiectul Student cu proprietatile id, nume si varsta
     reprezentare in JSON( JSON Array de Studenti
     [
        { "id" : 7
          "nume" : "Ion"
          "varsta" : 23},
        {

        }
     ]
     Paranteza dreapta inseamna Array sau Lista.
     Acolada inseamna obiect.
     Daca o valoarea unei proprietati e fara ghilimele inseamna ca e numar

     Cand apelez GET -> o sa primesc fie { } (un obiect) fie {{}, {}, ... {}} (lista de obiecte) si nu
     trimit nimic.
     Cand apelez POST -> trimit informatia sub forma de JSON pentru a face insert in BD. Informatia
     se trimite sub forma de JSON in Body.
     Un request poate sa aiba un Body.
     POST(Body=JSON)
     Ca raspuns voi primi niste cod-uri (200, 404 etc.)
     Cand apelez DELETE -> nu trimit informatie pentru ca apelez un api cu /id si va sterge inregistrarea
     cu id-ul respectiv
     Cand apelez UPDATE -> trimit in Body: UPDATE(Body=JSON)

        Token
     Avand expuse toate metodele poti avea acces la BD -> security issue. Pentru a ne asigura
     ca fiecare user are acces doar la datele lui exista mai multe metode. Una dintre ele este de a
     avea accessToken si refreshToken.
     Ca user ai un username si o parola. La login trimiti username si parola catre API. Api imi
     intoarce un accessToken si un refreshToken. AccessToken expira destul de repede( 30, 60 min).
     RefreshToken expira greu(6-12 luni). Pentru a face un request catre API, API-ul trebuie sa stie
     ca cine sunt eu si nu doar tirmit username-ul pentru ca il poate sti oricine, trimit in toate
     request-urile in Header accessToken-ul meu. Inainte de a-mi da informatiile din DB, API-ul verifica
     daca sunt userul care trebuie, accessToken-ul a fost generat tot de backed si stie cui ii este
     asociat acel accesToken, carui username. Cand expira in mod normal il deloghezi pe user dar cum
     expira foarte repede nu poti da afara userul la fiecare 30 de minute. RefreshToken-ul e folosit
     cand iti expira accessToken-ul. Faci un request special prin care ceri un nou accessToken folosind
     refreshToken-ul. Cand expira RefreshToken-ul il deloghezi.

     In trecut pentru a face http request-uri scriai foarte mult cod pentru a avea http un http client
     si pentru a face http request-uri si ca urmare a aparut o librarie Retrofit care faciliteaza
     procesul.

        Retrofit
     E un wrapper peste toate clasele care se scriau inainte si expune doar o interfata in care trebuie
     sa definim caile pentru metode si punem adnotari pentru verbe, cream un client de Retrofit.
     Pe langa libraria de retrofit trebuie sa mai adaugam si pe cea de OkHttp care e HTTP-ul care se
     folosea in trecut si GSON care face converteste un obiect Java in JSON si invers.

     Pasi de implementare
     1. Dependinte in gradle
     2. Definim o instanta de Retrofit
     3. Definim interfata care defineste verbele
     4. Definim POJO adica data modeul pentru datele noastre
     5. Facem request-uri sincrone sau asincrone si specificam cum se comporta aplicatia in caz de
     succes sau eroare.

        Best practice
     Cand ai o aplicatie mai mare este bine ca aplicatia sa o ai structurata pe mai multe layere.
     Layout-ul de repository face parte dintre acestea.
     Repository e o clasa care te ajuta sa separi logica. In el ai tot ce tine de user si toata partea
     de conexiune la baza. Cand folosesti si conexiune catre un API si BD locala, din repository decizi
     de unde se ia informatia (daca are net ia din api daca nu din BD). E o clasa care-ti separa interactiunea
     cu ce vrei tu din API. Ai modelul, clasa User si apoi ai o clasa, Repository care decide comportamentul
     pentru acel user, ce ai tu nevoie pentru el. Noi in exemplul nostru avem nevoie sa luam lista
     de useri. E partea de management a acelei entitati, al acelui model.

     Am pus Base_url intr-un buildConfigField in gradle(Module: app) pe un buildType.
     ex: buildConfigField "String", "BASE_GITHUB_URL", "https://api.github.com/"
     In practica se folosesc doua configuratii pentru ca in general pe backend cand se face
     dezvoltare se mai fac modificari. Staging care nu e conectat cu baza de date de live si altul
     de productie.
     Tu cand rulezi, rulezi pe unul dintre build-uri, la build variants (debug sau release). In functie
     de ce selectezi acolo se va duce pe o anumita ramura din gradle. Cand publici aplicatie schimbi
     build variant-ul pe release. Ele trebuie sa se numeasca la fel si doar valoarea sa difere.

     Nu interactionez direct din activitate cu partea de Retrofit ci prin intermediul Repository-ului.
     Am instanta de repository si apelez metoda getUsers si afisez la consola userii daca e succes
     daca nu, afisez eroare.

        Firebase
     E o platforma cu mai multe servicii. La inceput era o companie care avea doar o baza de date
     real time. O BD real time e o BD stocata in cloud si daca se modifica ceva era capabila sa trimita
     notificare catre aplicatiile care folosea acea baza de date (clienti) si daca erai in ecranul
     in care afisai informatiile din baza de date, ti se facea refresh automat.
     Toata playarea de servicii e gandita in ideea de a construi o aplicatie fara sa ai nevoie de
     backend (BD in cloud, serviciu web dezvoltat, toate stocate intr-un server, ai grija sa se scaleze,
     sa fie safe). Prin firebase ei iti pun la dispozitie o intreaga infrastructura cu BD scalabile
     securizate si foarte usor de accesat.
     Toate serviciile se impart in 3 categorii:
        Build - creare de aplicatii
        App quality - captezi bug-uri din aplicatie, vezi cati useri sunt
        Grow - marketing
     By default mai toate serviciile sunt free pana la un anumit numar de useri.

     Build
        Auth - Autentificare: poti sa te autentifici si sa-ti creezi niste conturi direct la ei in BD.
     Daca eu vreau sa fac register si login cu user si parola, ofera ei tot mecanismul din spate.
     Daca vreau sa fac autentificare cu goolge, tweeter, numar de telefon e posibil.
        Hosting - daca ai o idee de site micut il poti hosta la ei.
        Could functions - iti pun la dispozitie BD dar mai ai nevoie de procesari. Sunt niste functii
     care sunt definite acolo si sunt apelate si iti fac niste treaba in plus fata de cazul in care ai
     doar acces la o BD.
        ML KIT - folosesti machine learning direct in Android
        Cloud Firestore & Realtime Database - Fac aproximativ acelasi lucru.
     Primul a fost Realtime Database de la compania mama insa dupa cativa ani au lansat Cloud Firestore.
     Realtime Database nu era suficient de scalabil si era greu sa faci query. E NoSQL si nu aveai
     multe legaturi intre entitati. Poti adauga dependinte dar aplicatia poate deveni foarte lenta.
     (7 entitati si 3 sharuite aplicatia se misca greu) Si era greu sa faci query. Nu e recomandat
     sa-l folosim.
     Cloud Firestore e scalabil, safe, foarte usor de folosit.
        Cloud Storage - Foldere pe un cloud unde poti sa inserezi fisiere si iti genereaza un url
     catre acel fisier si tu stochezi in DB doar url-ul catre fisiere.

     App quality
        Crashlytics - Se intampla sa-ti crape aplicatia si iti vor fi aratate toate crash-urile cu
     multe detalii, pe ce telefon, portret/landscape, wi-fi sau 3g,4g,5g, locatie, limba aplicatiei
     etc. Iti da si tot stackTrace-ul de unde a crapat aplicatia.
        Performance Monitoring - arata daca aveti spike-uri.
        Test Lab - Daca ai un bug si nu poti sa-l reproduci pe un anumit telefon, ei iti pun la
     dispozitie o serie de device-uri remote pe care poti sa-ti instalezi aplicatia
     Exista doua tipuri de testari: testare unitara din cod si testara de UI in care testezi niste
     flow-uri. Ca sa nu repeti aceste flow-uri scrii niste cod (Espresso de obicei) si obtii un script
     prin care ruleaza un anumit flow.

        Remote Config - permite sa faci configurari remote. De ex de Paste in aplicatie vrei sa schimbi
     background-ul peste tot dar nu vreau sa fac update la aplicatie pe market ca sa schimb background.
     Setezi o cheie valoare in firebase unde ai acces oricand in cloud si in functie de valoare
     interpretezi content-ul corespunzator.
     Ex: Esti o companie si ai uitat sa platesti hosting-ul la API si ai ramas fara API. Ai o copie
     a API-ului si il pui pe un server al tau, poti sa schimbi url-ul remote pentru a-ti merge
     aplicatia in continuare.
        A/B Testing - Ai doua variante in aplicatie si nu esti sigur pe care sa o alegi. Se lanseaza
     doua aplicatii, una cu iepurasi de Paste pe roz ca fiind varianta A si una cu iepurasii pe galben
     ca varianta B. Si in felul asta vezi care are succes la public si te decizi. La o parte din useri
     o sa fie disponibila aplicatia A la altii aplicatia B si iti vor face niste grafice si iti dau
     statistici.
        Cloud Messaging - push notifications. Cand primesti o notificare e implementata chestia asta.
     1)Se adauga dependinte.
     2)Cand instantiem partea asta de Could Messages se genereaza un token, un FirebaseToken. Acest
     token este trimis catre api-ul nostru. Api-ul trebuie sa-mi expuna o metoda prin care sa trimit
     acest FirebaseToken. Firebase-ul stie automat de token-ul acesta si pentru fiecare device are
     unul diferit, nu tine de user. Legatura dintre user si FirebaseToken este 1:M.(un user se poate
     loga pe mai multe device-uri). Am FirebaseToken-ul pe care-l trimit catre api sa mi-l salveze
     in BD (userul x are token-ul respectiv). Ex: sunt pe FB si primesc friend request. Trebuie sa-mi
     dea fb-ul notificare, userul x a primit notificare. Se duce in baza, imi cauta userul, se duce
     si-mi ia userul si vede ce tokeni are. Daca are mai multi ii ia pe toti. Cu token-ul/token-urile
     se duce la firebase si-i cere sa trimita friend request-ul la tokenii astia.
        Dynamic Links - link-uri inteligente. Primesti un link si daca ai dat pe el ti-a deschis o
     alta aplicatie. Aceste link-uri sunt definite in firebase si stie in functie de device-ul pe
     care-ai deschis link-ul, ce sa faca cu el. Aceste scenarii sunt configurabile. Daca esti in
     browser sa se deschida site-ul. Daca primesti link-ul pe telefon si ai aplicatia instalata sa
     te duca direct in aplicatie in ecranul respectiv. Daca nu ai aplicatia si sunt pe telefon, pot
     sa-l duc in google play la aplicatie sa o instaleze.
        In-app Messaging - sunt legate de reclame in sensul ca poti pune niste mesaje direct in
     aplicatie ca niste pop-up-uri cu content, cu poze.

     Din Android 7 trebuie sa-i dai notificare user-ului atunci cand faci long running operations in
     background pentru ca userul sa fie constient si sa poata decide daca accepta operatia sau nu.
     In functie de ce versiune de Android ai, au implementat niste background processing solutions
     dedicate. De curand a fost lansat WorkManager care e un wrapper peste toate.
     Daca nu ai Google Play services, singura solutie e sa folosesti AlarmManager cu BroadcastReceiver.
     Daca ai Google Play services poti sa folosesc FirebaseScheduler. FirebaseScheduler e deprecated
     si din 2020 nu va mai putea fi folosit.
     JobScheduler merge doar de la anumite versiuni in sus.

     Firebase services sunt cross platform.
     Cand integrezi un serviciu extern esti notificat daca s-a instalat cu succes serviciul.

     //TODO ramas la 30:00 in ultimul curs.

     * */
}
