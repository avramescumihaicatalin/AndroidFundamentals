package com.example.avramescu.androidfundamentals.week4;

/*
*Pasul4 - Creare Adapter
* Clasa trebuie sa extinda RecyclerView.Adapter<ViewHolder>;
* In cazul nostru ViewHolder-ul este CarViewHolder.
* Alt+Enter -> implement methods
* CarAdapter are acelasi rol ca si la Spinner adica avem un datasource si preluam elementele si le
* afisam intr-un RecyclerView in cazul nostru si avem o lista de obiecte pe care vrem sa le afisam.
* In adapterul nostru o sa avem o referinta catre acea lista pentru ca datasource ul o sa l preluam
* din activitate exact ca la Spinner si trebuie sa definim o lista de obiecte( de cars ).
* Ca sa-i pasam valoarea listei o sa o dam in constructor
*
*Avem 3 metode in clasa CarAdapter:
* getItemCount -> ne spune cati items sa desenam, in cazul nostru, cate masini atatia items
*   onCreateViewHolder -> ViewHolderul se mapeaza cu item-ul nostru.
*   Creaza noul item
*   Se uita si vede cate are de desenat si o sa repete metoda de 20 ori si o sa populeze tot 20 de
*       items
*       creaza item-ul in sine adica ii creaza un item cu 3 TextView-uri
* onBindViewHolder -> populeaza item-ul cu elementul corespunzator din lista de obiecte( populeaza
*   continutul item-ului )
*Iterarea se face in background in functie de itemCount.
*
*       onCreateViewHolder
*   prima data trebuie sa avem referinta catre itemView-ul nostru.
*Android se foloseste de notiunea de inflate pentru a desena, adica la un parinte adauga un item
* si apoi mai adauga unul si tot asa.
* Face inflate la item si ca sa preiau item o sa folosesc clasa R
* LayoutInflater apeleaza metoda from(de unde porneste), in cazul nostru e un context al viewGrop=ului
* si face inflate la item-ul nostru din layout si il asociaza viewGroup-ului
* Acel parametru care e pus pe false la noi e considerat byDefault a fi true -> true trebuie folosit
* cand stim noi in ce moment sa se faca inflate-ul asa ca il setam pe false pentru ca vreau sa-l las
* pe el sa decida lucrul asta.
* Avem parametrul i in onCreate in cazul in care avem nevoie sa zice de o separare a item-ilor: ex pt
* i-urile pare afisezi un alt layout
*
*       onBindViewHolder
* Avem nevoie de i pentru a ne spune pe ce pozitie am ajuns cu desenatul.
* Trebuie sa luam obiectul din lista de obiecte si sa preluam continutul si sa-l afisam in itemView-ul
* nostru.
* Trebuie sa luam obiecutl curent actual si ne folosim de lista noastra.
* Trebuie sa luam valorile din interior lui si sa le punem in TextView-uri si de aceea am creat gett-ere
*
*
* Cream o noua activitate RecyclerViewActivity
* */

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.avramescu.androidfundamentals.R;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarViewHolder>{
    List<Car> mCars;

    public CarAdapter(List<Car> mCars) {
        this.mCars = mCars;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.car_item,
                        viewGroup, false);
        return new CarViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder carViewHolder, int i) {
        Car currentCar = mCars.get(i);
        if(currentCar != null){
            if(currentCar.getmNume() != null ){
                carViewHolder.getmTextViewName().setText(currentCar.getmNume());
            }
            if(currentCar.getmNume() != null){
                carViewHolder.getmTextViewColor().setText(currentCar.getmCuloare());
            }
            if(currentCar.getmHp() > 0){
                carViewHolder.getmTextViewHp().setText(currentCar.getmHp() + "");// am pus + ""
                // pentru ca trebuia sa fie string si e un int si i-am facut conversie
            }
        }
    }

    @Override
    public int getItemCount() {
        return mCars.size();
    }
}
