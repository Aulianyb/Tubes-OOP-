package com.simplicity;

public class Makanan extends ObjekGame {
    private int nilaiKekenyangan;

    //Konstruktor
    public Makanan(String namaObjek) {
        super(namaObjek);
    }

    //Getter
    public int getNilaiKekenyangan() {
        return nilaiKekenyangan;
    }

    //Setter
    public void setNilaiKekenyangan(int nilaiKekenyangan) {
        this.nilaiKekenyangan = nilaiKekenyangan;
    }
}
