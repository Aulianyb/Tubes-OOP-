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

    public void kerja(Sim sim, int detik){
        if (detik % 120 == 0){
            thread = new Thread(new Runnable(){
                public void run(){
                    try{
                        System.out.println("Bekerja...");
                        System.out.printf("["); 
                        for (int i=0;i<10;i++){
                            Thread.sleep(detik * 100);
                            System.out.printf(">"); 
                        }
                        System.out.printf("]\n"); 
                        int x = -10 * (detik / 30); 
                        int y = -10 * (detik / 30); 
                        int z = ((detik / 60) / 4) * gaji; 
                        sim.setKekenyangan(x);
                        sim.setMood(y);
                        sim.setUang(z);
                        System.out.println("Bekerja Selesai!");
                        System.out.println("Kekenyangan : +" + x);                      
                        System.out.println("Mood : " + y);                      
                        System.out.println("Uang : +" + z);  
                        Waktu.timePass(detik); 
                    } catch(InterruptedException e){
                    }
                }
            }); 
            thread.run(); 
        } else{
            System.out.println("Durasi Harus kelipatan 120!"); 
        }
    }
}
