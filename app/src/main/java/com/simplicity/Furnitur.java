package com.simplicity;

public class Furnitur extends ObjekGame implements BisaDibeli{
    private int panjang;
    private int lebar;
    private Status validAction;
    private int harga;

    public Furnitur(String namaObjek) {
        super(namaObjek);
        setKategori("Furnitur");
        this.panjang = 0;
        this.lebar = 0;
    }

    //Getter
    public int getPanjang() {
        return panjang;
    }

    public int getLebar() {
        return lebar;
    }

    public Status getValidAction() {
        return validAction;
    }

    public int getHarga() {
        return harga;
    }

    //Setter
    public void setPanjang(int panjang) {
        this.panjang = panjang;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    public void setValidAction(Status validAction) {
        this.validAction = validAction;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
