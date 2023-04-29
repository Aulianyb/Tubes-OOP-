package com.simplicity;

public class BarangDikirim {
    private BisaDibeli barang; 
    private Sim sim; 
    private int jumlah; 

    public BarangDikirim(BisaDibeli barang, Sim sim, int jumlah){
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
