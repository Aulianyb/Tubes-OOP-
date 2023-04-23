package com.simplicity;

public class Jam extends Furnitur {
    public Jam(String namaObjek) {
        super(namaObjek);
        setPanjang(1);
        setLebar(1);
        setHarga(10);

        setValidAction(new Status());
        getValidAction().setStatus("melihat waktu");
    }

    public void lihatJam(Sim sim) {

    }
}
