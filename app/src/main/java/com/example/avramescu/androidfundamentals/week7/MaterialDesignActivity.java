package com.example.avramescu.androidfundamentals.week7;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.avramescu.androidfundamentals.R;

public class MaterialDesignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design);
    }

    public void displayDatePickOnClick(View view) {
    }

    public void displayTimePickOnClick(View view) {
    }

    public void displayAlertdialogWitButtonsOnClick(View view) {
    }

    public void startPermissionActivity(View view) {
    }

    public void takePictureOnClick(View view) {
    }

    public void startCollapsingToolbarActivity(View view) {
    }

    public void displaySnackBarOnClick(View view) {
        Snackbar.make(view, "This is a snakcbar", Snackbar.LENGTH_LONG);
    }

    /*  Stiluri
    *   Fisierul styles tine de stilizare.
    *   Acum cativa ani s-a lansat material design care aduce nou faptul ca s-a creat un trent in partea
    * de desing astfel incat aplicatiile sa arate cat mai aproape de realitate.
    *   Toate animatiile si efectele din zona de Material design au fost create studiind intai cum se
    * intampla in realitate, au adagat un element de spatialitate numit elevation care adauga o umbra
    * pe dedesupt si da senzatia ca obiectul este in spatiu.
    *   A fost adaugata in android L si a fost imbunatatit ulterior cand au fost adaugate niste teme.
    *   Material design reprezinta doua mari categorii:
    *   - partea de stiluri: fonturi speciale, culori speciale, imagini folosite intr-un anumit stil
    *   - component: folosind stilurile acestea ei au definit niste componente custom specifice
    * zonei de material design (ex: cardView)
    *   CardView - e un ViewGroup care se bazeaza pe editare? unui FrameLayout sau unui ConstraintLayout.
    *   Zona de desing presupune adaugarea unei dependinte in gradle.
    *   Are specific: cardBackgroudColor, cardCornerRadius, cardElevation(cat de rotunda sa fie umbra),
    * elevation( cam max 8 dp )
    *
    *   Stilurile in android se definesc similar cu CSS in web. Avem niste xml-uri in care definim
    * stiluri. Mai multe stiluri constituie o tema.
    *   Daca ai multe elemente de design care respecta aceleasi proprietati(ex: colturi rotunjite,
    * background alb ) iti creezi un stil si aplici stilul respectiv pe toate elementele care trebuie sa
    * arate la fel.
    *   Pe langa faptul ca putel defini stiluri in fisierul styles.xml, mai putem crea resurse custom
    * in folderul drawable. Putem adauga niste fisiere xml in care ne definim niste resurse specifice.
    * De ex: La butoane nu e indicat sa folosim background cu poze pentru ca pe unele ecrane o sa arate
    * diferit -> ca alternativa: iti faci un shape.
    *   Un shape se creaza in xml si ii spui ce culoare sa aiba, daca vrei border, daca vrei sa aiba
    * gradient etc.
    *   Intr-un style definim aceleasi elemente care se pun si pe view-uri
    *   Stilurile se pot si mosteni adaugand in stilul copil atributul "parent" care refera stilul
    * parinte.
    *
    *   Themes: se aplica specificand tema in manifest si se definesc in fisierul styles.xml.
    *
    *   Exista 3 culor by default cand cream un proiect. ColorAccent se potriveste cu bold pentru ca
    * e o culoare care atrage atentia si mai e folosita si pe anumite componente cu precadere.
    *   Pe zona de poze se merge pe ideea de a afisa niste imagini care sunt relevante pentru utulizator
    * care sa ofere informatii extra fara a afisa text.
    *   In zona de font au creat un font special care se numeste Roboto, un font Material Design care
    * pe Android e folosit by default si mai mult de atat, au creat niste stiluri: display4, display3,
    * display2 etc. Ex: display4 imi da un font care sa aiba 112sp si fontul este light, adica nu e
    * bolduit, e o varianta subtire de text. Pentru a le accesa folosim proprietatea textAppearamce.
    *
    *   Colors: colorPrimary, colorPrimaryDark, colorAccent.
    *   Fiecare componenta are by default o culoare, daca vrem sa schimbam acea culoare trebuie sa
    * o schimbam din stiluri, suprascriem acel stil si ii definim culoarea custom.
    *   colorPrimary se foloseste la Status bar.
    *   colorPrimaryDark se foloseste la Action bar (App bar)
    *   textColorPrimary se foloseste pentru textul din navigation bar ( App bar ).
    *   windowBackground pentru backgroundul activitatilor.
    *   navigationBarColor penntru culoarea barii de navigare cand avem o bara de navigare pe ecran.
    *
    *   Material design mai implica partea de motion.
    *   Pe partea de Spacing sunt impuse niste reguli cum ar fi: 16dp margin stanga-dreapta, iar distanta
    * pana la text sa fie de 72dp in cazul unor itemi cum sunt cei de la gmail. In cazul iconitei de
    * avatar dimensiunea trebuie sa fie de 48dp iar continutul sa fie de 40 (imaginea).
    *
    *   Componente noi in Material design: FAB, Tabs, NavigationDrawer, SnackBar.
    *   FAB: intr-un ecran nu se pune mai mult de 1 singur FAB iar actiunea lui trebuie sa fie foarte
    * importanta pentru ecranul respectiv si de obicei se seteaza colorAccent pe el.
    *   Are proprietatea rippleColor, fabSize( small, normal, big )
    *   SnackBar e un fel de toast care apare in partea de jos si ca sa-l putem folosi avem nevoie de un
    *   CoordinatorLayout ca si parinte. CoordinatorLayout a aparut tot in MaterialDesign si e folosit
    * in zona de actiuni pentru ca SnackBar are o animatie care apare de jos si dispare sau putem sa-i
    * adaugam un singur buton cu o actiune sau putem doar sa afisam un text. Userul poate face swipe
    * pentru a inchide mesajul.
    *   Ripple efect: aparut tot in Material design.
    *   BottonBarNavigation sunt un fel de taburi in partea de jos a ecranului.
    *   FloatingLabels: e un EditText adaugat intr-un alt view. Cand incepi sa scrii in el, hint-ul
    * devine label, se muta in partea de sus a view-ului. Se obtine printr-un TextInputLayout in
    * interiorul caruia adaugam un EditText.
    *   ColapsingToolbar: se bazeaza pe CoordinatorLayout care iti permite sa faci scroll
    *
    *       Permisiuni
    *   La inceput pe magazin aveai o lista de permisiuni de care avea nevoie aplicatia, prin instalare
    * iti dadeai acceptul. Din android M s-au introdus permisiunile la Runtime, totusi nu se aplica
    * pentru toate tipurile de permisiuni. Pentru permisiunea de internet nu se cere userului permisiunea
    * ci se pune in manifest. In schimb la camera, locatie, microfon etc. se cere userului.
    *   Best practice: Se explica foarte bine de ce este nevoie de permisiune. Se cere permisiune fix
    * acolo unde este nevoie de ea.
    * 
    *
    * */
}
