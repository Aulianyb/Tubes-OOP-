package com.simplicity;

public class Sim{
    private String namaLengkap; 
    private Pekerjaan pekerjaan; 
    private int uang;
    // private Inventory inventory; 
    private int kekenyangan; 
    private int mood; 
    private int kesehatan; 
    private Status status; 

    //nanti tambahin buildernya
    public Sim(String namaLengkap){
        kekenyangan = 80; 
        uang = 100; 
        
        // Ini randomizernya belum buat, masih placeholder
        pekerjaan = new Pekerjaan("Programmer"); 

        // inventory = new Inventory(); 
        status = new Status(); 
    }

    public String getNama(){
        return namaLengkap; 
    }

    public Pekerjaan getPekerjaan(){
        return pekerjaan; 
    }

    public int getUang(){
        return uang; 
    }

    public int getKekeyangan(){
        return kekenyangan; 
    }

    public int getMood(){
        return mood; 
    }

    public int getKesehatan(){
        return kesehatan; 
    }

    public Status getStatus(){
        return status; 
    }

    public void setNama(String namaBaru){
        namaLengkap = namaBaru; 
    }

    //ini enaknya pakai String aja
    public void setPekerjaan(String pekerjaan){
        this.pekerjaan.setPekerjaan(pekerjaan);
    }

    public void setKekeyangan(int diff){
        kekenyangan += diff; 
    }

    public void setMood(int diff){
        mood += diff; 
    }

    public void setKesehatan(int diff){
        kesehatan += diff; 
    }

    public static void main(String[] args){
        Sim s1 = new Sim("Default"); 
        s1.setPekerjaan("Polisi");
        System.out.println(s1.getPekerjaan().getGaji()); 
    }

}