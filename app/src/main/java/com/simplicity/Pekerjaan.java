package com.simplicity;
import java.util.*;

public class Pekerjaan {

    static HashMap <String, Integer> pekerjaanvalid = new HashMap<String, Integer>(){{
        put("Badut Sulap", 15);
        put("Koki", 30);
        put("Polisi", 35); 
        put("Programmer", 45);
        put("Dokter", 50); 
    }}; 
    private static Thread thread; 
    private String namaPekerjaan; 
    private int gaji; 
    private int daysSince; 
    private int jamKerja = 0; 

    public Pekerjaan(String pekerjaan){
        if (pekerjaanvalid.containsKey(pekerjaan)){
            namaPekerjaan = pekerjaan; 
            gaji = pekerjaanvalid.get(pekerjaan);  
        } else{
            System.out.println("Maaf, pekerjaan yang dimasukkan tidak valid"); 
            //untuk sekarang, nilai atributnya bakalan  null
        } 
        daysSince = 0; 
        jamKerja = 0; 
    }

    public String getPekerjaan(){
        return namaPekerjaan; 
    }

    public int getGaji(){
        return gaji; 
    }

    public void setPekerjaan(Sim sim, String pekerjaan){
        if (pekerjaanvalid.containsKey(pekerjaan)){
            int biaya = (int) (0.5 * gaji); 
            if (sim.getUang() < biaya) {
                System.out.println("Maaf uang " + sim.getNama() + " tidak mencukupi untuk mengganti pekerjaan"); 
            }
            else{
                if (daysSince < 1){
                    System.out.println("Hanya bisa mengganti pekerjaan satu hari setelah memilih pekerjaan!"); 
                }
                else{
                    sim.setUang(-1 * biaya);
                    namaPekerjaan = pekerjaan; 
                    gaji = pekerjaanvalid.get(pekerjaan);
                    daysSince = 0;
                    jamKerja = 0;
                    System.out.println("Pekerjaan berhasil diganti menjadi " + pekerjaan); 
                }
            }  
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
                        sim.setKekenyangan(x);
                        sim.setMood(y);
                        System.out.println("Bekerja Selesai!");
                        System.out.println("Kekenyangan : " + x);                      
                        System.out.println("Mood : " + y);                      
                        Waktu.timePass(detik); 
                        jamKerja += detik; 
                        if (jamKerja >= 240){
                            int z = ((detik / 60) / 4) * gaji;
                            sim.setUang(z); 
                            System.out.println("Uang : +" + z);  
                        }
                    } catch(InterruptedException e){
                    
                    }
                }
            }); 
            thread.run(); 
        } else{
            System.out.println("Durasi Harus kelipatan 120!"); 
        }
    }

    public void setDay(int day){
        daysSince = day; 
    }

    public void addDay(){
        daysSince += 1; 
    }

    public int getDaysSince() {
        return daysSince;
    }
    
    public static void displayPekerjaanValid() {
        int i = 1;
        for(String valid : pekerjaanvalid.keySet()) {
            System.out.printf("%d. valid%n",i);
            i++;
        }
    }

    public void setJamKerja(int x){
        jamKerja = x; 
    }
}
