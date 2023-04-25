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
    private static Thread thread; 
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
        int detik=durasi.toDetik();
        if (detik % 120 == 0){
            thread = new Thread(new Runnable(){
                public void run(){
                    try{
                        System.out.println("Bekerja...");
                        Thread.sleep(detik * 1000);
                    } catch(InterruptedException e){

                    } finally{
                        sim.setKekeyangan(-10 * (detik / 30));
                        sim.setMood(-10 * (detik / 30));
                        sim.setUang(((detik / 60) / 4) * gaji);
                    }
                }
            }); 
            thread.run(); 
        } else{
            System.out.println("Durasi Harus kelipatan 120!"); 
        }
    }
}
