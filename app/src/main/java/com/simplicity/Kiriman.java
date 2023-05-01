package com.simplicity;

public class Kiriman {
    private BisaDibeli barang;
    private Sim sim;
    private Integer jumlah;

    public Kiriman(BisaDibeli barang, Sim sim, Integer jumlah){
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

    public Integer getJumlah(){
        return jumlah;
    }
}
