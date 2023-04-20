package com.simplicity;
import java.util.*;

public class Pekerjaan {

    private static HashMap <String, Integer> pekerjaanvalid = new HashMap<String, Integer>(){{
        put("Badut Sulap", 15);
        put("Koki", 30);
        put("Polisi", 35); 
        put("Programmer", 45);
        put("Dokter", 50); 
    }}; 
    private String namaPekerjaan; 
    private int gaji; 

    public Pekerjaan(String pekerjaan){
        if (pekerjaanvalid.containsKey(pekerjaan)){
            namaPekerjaan = pekerjaan; 
            gaji = pekerjaanvalid.get(pekerjaan);  
        } else{
            System.out.println("Maaf, pekerjaan yang dimasukkan tidak valid"); 
            //untuk sekarang, nilai atributnya bakalan  null
        } 
    }

    public String getPekerjaan(){
        return namaPekerjaan; 
    }

    public int getGaji(){
        return gaji; 
    }

    public void setPekerjaan(String pekerjaan){
        if (pekerjaanvalid.containsKey(pekerjaan)){
            namaPekerjaan = pekerjaan; 
            gaji = pekerjaanvalid.get(pekerjaan);  
        } else{
            System.out.println("Maaf, pekerjaan yang dimasukkan tidak valid"); 
            //untuk sekarang, nilai atributnya bakalan  null
        } 
    }

    public void kerja(Sim sim, Waktu durasi){
        int detik=240; //ini placeholder buat total detik
        sim.setKekeyangan(-10 * (detik / 30));
        sim.setMood(-10 * (detik / 30));
        sim.setUang(((detik / 60) / 4) * gaji);

        //ini nanti tambahin time passing
    }
}
