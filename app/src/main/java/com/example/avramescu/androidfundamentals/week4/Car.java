package com.example.avramescu.androidfundamentals.week4;

/*
* Pasul1:
* Definim ViewHolder-ul adica obiectul pe care o sa-l afisam in fiecare item din lista noastra.
* Cream clasa Car si-i definim niste proprietati pe care le are masina.
*Cream gett-eri si sett-eri( Alt + Insert )
*
* Pasul2:
* in res-> layout -> new Layout Resource File pentru a crea Item-ul
* */

public class Car {
    private String mNume;
    private String mCuloare;
    private int mHp;

    public Car(String mNume, String mCuloare, int mHp) {
        this.mNume = mNume;
        this.mCuloare = mCuloare;
        this.mHp = mHp;
    }

    public String getmNume() {
        return mNume;
    }

    public void setmNume(String mNume) {
        this.mNume = mNume;
    }

    public String getmCuloare() {
        return mCuloare;
    }

    public void setmCuloare(String mCuloare) {
        this.mCuloare = mCuloare;
    }

    public int getmHp() {
        return mHp;
    }

    public void setmHp(int mHp) {
        this.mHp = mHp;
    }
}
