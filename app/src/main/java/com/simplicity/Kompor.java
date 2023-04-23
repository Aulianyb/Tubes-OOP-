package com.simplicity;

public class Kompor extends Furnitur {
    //Konstruktor
    public Kompor(String namaObjek) {
        super(namaObjek);
        setValidAction(new Status());
        getValidAction().setStatus("memasak");
    }

    //Nunggu Masakan
    public void masak(Sim sim) {

    }
}
