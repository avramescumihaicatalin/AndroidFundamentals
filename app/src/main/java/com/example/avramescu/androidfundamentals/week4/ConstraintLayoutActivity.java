package com.example.avramescu.androidfundamentals.week4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.avramescu.androidfundamentals.R;

public class ConstraintLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);
    }
}

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
 *Daca setez constrangere se va modifica si in xml.
 *El asociaza by default id-uri.
 * Exista notiunea de chain de elemente. Pentru a crea un chain, selectam elementele -> click dreapta
 * -> chains ->create horizontal/vertical chain si observam ca elementele au fost unite printr-un
 * lant.
 * Are 3 variante de pozitionare a elementelor din lant:
 *   - spread -> le face egale distantele
 *   - spread inside cand seteaza distante
 *   O imagine adaugata ne obliga sa setam un avatar care nu va fi afisat.
 *   La imagini de obicei suntem obligati sa folosim dimensiuni fixe. Folosind dimensiuni fixe suntem
 *   obligati sa ii dam un scale: 16:9, 3:4 de ex si in functie de cat de mare e poza va stii sa o aseze
 *   corespunzator.
 *   Daca ii dam match_constraint ne apare un triunghi care ne intreaba ce ratio vrem sa folosim.
 *Mai exista notiunea de guideline astfel incat atunci cand pozitionam elementele ele sa se aseze de
 * la o anumita limita(unde setam noi guideline) -> putem seta pozitiile ale view-urilor relative la
 * un anumit guideline.
 *   Exista notiunea de grup. El e util cand asupra acelorasi elemente aplicam acelasi stil.
 *Ca sa folosim grupul: click dreapta -> Helpers -> add group
 * Pentru a adauga elemente in grup: selectam elementele si cu drag and drop le punem in grup.
 * In cod nu exista o structura arborescenta ci doar grupul adauga o constrangere de genul:
 * contraint_references_ids = text_view1, text_view2
 * Acest grup poate fi preluat din partea de java dupa id si daca vreau sa setez  vizibilitatea
 * pentru toate elementele din grup nu mai trebuie sa iau fiecare element in parte ci setez vizibilitatea
 * pentru intregul grup.
 * Se intampla de foarte multe ori ca atunci realizezi o aplicatie sa pui niste valori in textView ca
 * sa vezi cum se afiseaza si sa ti dai seama daca o sa se afiseze ok in layout si pui niste texte
 * hardcodate. Daca uiti de aceste valori hardcodate si pana se incarca respectivul continut si se
 * face request-ul catre api sa le afiseze or sa apara valorile default care nu sunt valori comune.
 * Ca sa te asiguri ca nu se intampla asta a fost adaugata proprietatea tot text dar care e din
 * tools nu din android. Pentru a o seta facem: tools:text = "text pentru testare". Aceasta valoarea
 * nu va fi incarcata ci va aparea doar in editor.
 *
 *   https://www.youtube.com/watch?v=rzmB3UxxhaA&t=387s -> video ConstraintLayout
 * Procesul de randare al unui layout pe ecran:
 * Folosind un algoritm de tip depth-first traversal
 *   Inflation: preia fiecare element din arborele de view-uri si le face Inflate
 *   Measuremets: Parintele masoara fiecare copil. Copilul calculeaza width si height masurate si apoi
 * isi masoara proprii copii daca exista.
 *   Layout-onLayout(): Fiecare parinte pentru copiii lui din view va prelua marimile si le va pune
 * pe ecran
 *   Draw-onDraw(): Faza in care sunt randate elementele pe ecran. Parintele stie acum exact unde
 * si cat de mari ar trebui sa fie elementele pe ecran si apoi ii spune fiecarui copil unde exact
 * sa deseneze si cum sa deseneze.
 *
 * Tipuri de Layout in android:
 *   LinearLayout: Aliniaza copiii intr-o singura directie (orizontala sau verticala). Poate folosi
 * weights dar nu e indicat din cauza performantei slabe.
 *   Relativelayout: Permite alinierea obiectelor relative unele la celelalte sau relative la parinte.
 * Exemple de pozitionare: unul peste celalalt, in partea de jos a ecranului, la stanga cuiva, la dreapta
 * cuiva
 * E o versiune mai light a lui ConstraintLayout. Este un layout destul de puternic dar partea proasta
 * a lui este ca el face doua parcurgeri ale layout-ului ( face de doua ori procesul de randare al unui
 * layout pe ecran ) ceea ce duce la performante mai slabe.
 *   FrameLayout: permite sa ai un singur view pe ecan. Este de obicei folosit pentru ascunderea sau
 * afisarea layout-urilor de eroare sau acoperirea partii de sus a unei harti si se deseneaza intr-o
 * stiva unul peste celalalt. Este folosit si pentru fragmente de asemenea.
 *   ConstraintLayout:
 *   Suporta API 9+
 *   Nu e includs in Android SDK -> trebuie sa-l incluzi ca dependinta in fisierul gradele.
 *   Functioneaza pe baza algoritmului Cassowary -> Constrangerile sunt exprimate ca un set de ecuatii
 *   Avem doua tipuri de vizionare a ecranului: design mode si blue print mode.
 *   Putem adauga view-uri prin drag and drop.
 *   Dupa adaugare avem elementul adaugat si in arborele de elemente unde se specifica o eroare pentru
 *   view-ul respectiv care spune ca trebuie sa punem constrangeri pe view altfel nu va fi randat corect
 *   pe dispozitiv. Pe cele patru laturi ale view-ului avem patru cerculete ( manere ) pe care le tragem
 *   si le conectam cu allt view sau cu parintele. Asa se adauga constrangerile.
 *   In partea dreapta exista optiuni detaliate ale view-ului.
 *   In partea de sus este prezentat chenarul elementului. Daca dam click pe sagetile din interiorul
 *   chenarului putem schimba tipul de dimennsionare a view-ului. (wrap_content, fixed sau match_constraint)
 *   Match_constraint -> se va intinde pana la constrangerea care e pusa pe element.
 *   Avem margini default in ConstraintLayout. In Android si MaterialDesign trebuie sa avem o margine de
 *   8dp pe toate elementele sau 16db pe tablete. Exista un buton pentru setarea dimensiunii marginilor
 *   deasupra blueprint-ului si a designmode-ului.
 *   Tot din aceasta zona putem alege si dimensiunea dispozivitului dar putem cu drag sa redimensionam
 *   design-view-ul pentru a redimensiona dispozitivul.
 *   Poti face rotate.
 *   Exista notiunea de AutoConnect ce permite unui view ca odata adaugat sa se conecteze la cel mai
 *   apropiat. Icon-ul pentru a face asta e cel cu magnet.
 *   Exista buton pentru Delete all constraints. View-urile raman pozitionate cum erau in editor
 *   dar daca incerci rularea pe telefon nu vor fi afisate corect.
 *   In xml vom vedea AbsoluteX si AbsolutY. Acestea sunt doar pentru editor dar nu sunt constrangeri.
 *   Odata adaugate constrangeri din editor AbsoluteX si AbsoluteY vor disparea.
 *   Mai exista butonum de Infer Connections: incearca sa-si dea seama ( sa deduca ) cum sa realizeze toate
 *   constrangerile pentru layout-ul pe care il ai pe ecran.
 *  Base Line Constraints: Dand click pe un view apare Edit Baseline. Edit Baseline permite sa aliniem
 *  linia bazei textului unui elementu cu a altui element.
 *  Bias: Daca avem un view cu constrangeri: top, left si right putem sa-l mutam intr-o anumita directie
 *  Chain: Un lant este folosit pentru elemente cu distributie de spatiu egala. Selectam elementele ->
 *  create horizontal/vertical chain. Putem schimba modul de lant prin click pe iconita ce reprezeinta
 *  un lant: pack( uneste toate elementele ) , spread ( spatiu egal intre ele si intre margini)
  *  si spread inside (spatiu egal intre items dar fara spatiu la margini ).
  *  GuideLines: click dreapta -> create horizontal/vertical guideline. Guideline apare in component tree
  *  si e vizibil in blueprind mode. Pot pozitiona view-uri la acest guideline. In loc de a crea
  *  un margin de 8dp putem crea un guideline de 8dp si sa aliniel item-urile la acest guideline.
  *  Ajuta la dezvoltarea pentru ecrane mai mari unde vrem ca marginile sa fie mai mari. Odata aliniate
  *  view-urile la guideline putem muta guideline-ul iar view-urile se vor muta odata cu el.
  *  Putem de asemenea sa setam guideline-ul la un procent din ecran.
  *  Guideline e adaugat in xml. View-urile care au constrangere setata la guideline vor avea acest
  *  atribut setat in xml. GuideLine e definit deasemenea ca tag in xml si are un id.
  *  Barrier: Putem avea elemente care sunt grupate impreuna pentru a forma o bariera unde celelalte
  *  elemente nu ar trebui aliniate. Ex: Am un TextView si un Button sub el ce au constrangeri. Vreau
  *  ca in cazul in care pun un alt view in dreapta lor daca textul din TextView devine foarte mare
  *  sa nu se suprapuna cu view-ul nou iar daca textul din Textview e prea mic sa nu se suprapuna
  *  noul view cu Button-ul. Creez o bariera cu click dreapta Add barrier. Ea apare in arborele
  *  de componente. Trag elementele pe care le vreau in bariera din arborele de componente si le adaug
  * cu drag and drop in bariera. Setez bariera sa fie pe partea dreapta a butonului si a TextView-ului
 * (click pe ea si din partea detaliata de atribute setam barrierDiirection: right
 *  Aliniez celalalt view la bariera si vad ca daca textul din TextView e prea mare noul view se muta
 *  odata cu el iar daca textul e prea mic noul view se va alinia la Button.
 *  Groups: poti controla simultan atributul mai multor elemente. Pentru moment poate fi controlata
 *  doar vizibilitatea. Click dreapta -> add group. Cu drag and drop adaug elementele in grup.
 *  Pot selecta grupul si sa i setez proprietatea de vizibilitate.
 *  Dimensions: Daca trebuie sa creezi un player video care are ratio de 16:9 e destul de dificil
 *  pentru ca trebuie sa creezi propriul layout si sa calculezi inaltimea ecranului si sa faci
 *  latimea dinamic sau sa folosesti layout de procentaj dar poti face un ConstraintLayouyt
 *  asta mult mai usor. Adaug o imagine, ii setez constrangeri. Setarea dimensiunii pe wrap_content
 *  nu se impaca bine cu ConstraintLayout asa ca folosim match_constraints. Pentru a seta
 *  un ratio dam click in partea de detalii de view pe coltul din stanga sus al view-ului si
 *  ne apare un chenar pentru a seta ratio. Acum daca modific una dintre dimensiunile imaginii
 *  cealalta va fi calculata ina sa fel incat sa pastreze ratio.
 *  Am doua imagini. Pe prima o setez cu constrangeri top left right. si pe cealalta lef si right.
 *  Acum am un poster si un header. Vreau ca centrul posterului sa fie bottom-ul header-ului.
 *  Setez constrangere top pentru poster la bottom-ul headerului si bottom-ul posterului
 *  tot la bottom-ul headerului. Se creaza ce se numeste: senzor constraints.
 *
 *
 * */
