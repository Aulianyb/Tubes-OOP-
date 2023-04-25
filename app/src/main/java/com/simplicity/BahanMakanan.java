package com.simplicity;

//Mending pake subclass ato if-else aja?
public class BahanMakanan extends Makanan implements BisaDibeli {
    private int harga;

    //Konstruktor
    public BahanMakanan(String namaObjek) {
        super(namaObjek);

        //Set Harga
        if (namaObjek.equals("Nasi")) {
            setHarga(5);
            setNilaiKekenyangan(5);
        }
        else if (namaObjek.equals("Kentang")) {
            setHarga(3);
            setNilaiKekenyangan(4);
        }
        else if (namaObjek.equals("Ayam")) {
            setHarga(10);
            setNilaiKekenyangan(8);
        }
        else if (namaObjek.equals("Sapi")) {
            setHarga(12);
            setNilaiKekenyangan(15);
        }
        else if (namaObjek.equals("Wortel")) {
            setHarga(3);
            setNilaiKekenyangan(2);
        }
        else if (namaObjek.equals("Bayam")) {
            setHarga(3);
            setNilaiKekenyangan(2);
        }
        else if (namaObjek.equals("Kacang")) {
            setHarga(2);
            setNilaiKekenyangan(2);
        }
        else if (namaObjek.equals("Susu")) {
            setHarga(2);
            setNilaiKekenyangan(1);
        }
    }

    //Getter
    public int getHarga() {
        return harga;
    }

    //Setter
    public void setHarga(int harga) {
        this.harga = harga;
    }
}
