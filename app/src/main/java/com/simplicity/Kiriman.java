package com.simplicity;

public class Kiriman {
    private BisaDibeli barang;
    private Sim sim;
    private int jumlah;

    public Kiriman(BisaDibeli barang, Sim sim, int jumlah){
        this.barang = barang;
        this.sim = sim;
        this.jumlah = jumlah;
    }

    public BisaDibeli getBarang(){
        return barang;
    }

    public Sim getSim(){
        return sim;
    }

    public int getJumlah(){
        return jumlah;
    }
}
