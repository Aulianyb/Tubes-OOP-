package com.simplicity;

//Masih harus dikode time passing!

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
        mood = 80; 
        kesehatan = 100; 
        uang = 100; 
        
        // Ini randomizernya belum buat, masih placeholder
        pekerjaan = new Pekerjaan("Programmer"); 

        // inventory = new Inventory(); 
        status = new Status();

        this.namaLengkap = namaLengkap;
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
    public void changePekerjaan(String pekerjaan){
        this.pekerjaan.setPekerjaan(pekerjaan);
    }

    public void setUang(int diff){
        uang += diff; 
    }

    public void setKekeyangan(int diff){
        kekenyangan += diff; 
        if (kekenyangan < 0){
            kekenyangan = 0; 
        }
        if (kekenyangan > 100){
            kekenyangan = 100; 
        }
    }

    public void setMood(int diff){
        mood += diff; 
        if (mood < 0){
            mood = 0; 
        }
        if (mood > 100){
            mood = 100; 
        }
    }

    public void setKesehatan(int diff){
        kesehatan += diff; 
        if (kesehatan < 0){
            kekenya = 0; 
        }
        if (kekenyangan > 100){
            kekenyangan = 100; 
        }
    }

    public void olahraga(Waktu durasi){
        int detik=0; //placeholder
        setKesehatan(5 * (detik / 20));
        setKekeyangan(-5 * (detik / 20));
        setMood(+10 * (detik/20));  
    }

    public void tidur(){
        int detik=0; //placeholder
        setMood(30 * ((detik / 60) / 4));
        setKesehatan(20 * ((detik / 60) / 4));

        //to do : kalau gak tidur gimana nanti?
    }

    public void makan(){
        //nungguin dulu Makanan.java
    }

    public void memasak(){
        //nungguin dulu Makanan.java
    }

    public void berkunjung(){
        //to do
    }

    public void buangAir(){
        setKekeyangan(-20);
        setMood(10); 
    }

}