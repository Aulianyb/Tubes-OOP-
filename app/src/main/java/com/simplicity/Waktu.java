package com.simplicity;
import java.util.*;

public class Waktu {
    private static int hari; 
    private static int jam;
    private static int menit;
    private static int detik;
    private static HashMap <BisaDibeli, Integer> barangDikirim = new HashMap<BisaDibeli, Integer>();

    public Waktu(int jam, int menit, int detik) {
        jam = 0;
        menit = 0;
        detik = 0;
        hari = 0; 
    }

    public int getJam() {
        return jam;
    }    

    public int getMenit() {
        return menit;
    }

    public int getDetik() {
        return detik;
    }

    public void setJam(int jam_input) {
        jam = jam_input;
    }

    public void setMenit(int menit_input) {
        menit = menit_input;
    }

    public void setDetik (int detik_input) {
        detik = detik_input;
    }

    public void displayWaktu() {
        if (jam<10) {
            System.out.print("0" + jam);
        } else {
            System.out.print(jam);
        }
        if (menit<10) {
            System.out.print(":0" + menit);
        } else {
            System.out.print(":" + menit);
        }
        if (detik<10) {
            System.out.print(":0" + detik);
        } else {
            System.out.print(":" + detik);
        }
    }
    
    public int toDetik() {
        return((jam*3600)+(menit*60)+detik);
    }

    public static void timePass(int durasi){
        detik += durasi % 60;
        menit += durasi / 60; 
        if (!barangDikirim.isEmpty()){
            System.out.println("test2"); 
            barangDikirim.forEach((key, value) -> {
                int temp = value - durasi; 
                if (temp <= 0){
                    barangDikirim.remove(key, value); 

                }else{
                    barangDikirim.put(key, temp); 
                }
            });

        }
    }

    public static void addBeli(BisaDibeli barang, Integer duration){
        barangDikirim.put(barang, duration); 
    }

    public static void displayPengiriman(){
        System.out.println("BARANG DALAM PENGIRIMAN"); 
        barangDikirim.forEach((key, value)->{
            System.out.println(key.getNamaObjek() + " : " + value + " detik"); 
        });   
    }
}
