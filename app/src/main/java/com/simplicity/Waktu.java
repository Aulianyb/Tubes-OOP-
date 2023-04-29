package com.simplicity;
import java.util.*;

public class Waktu {
    private static int hari; 
    private static int jam;
    private static int menit;
    private static int detik;
    private static HashMap <BisaDibeli, Integer> pekerjaanAktif = new HashMap<BisaDibeli, Integer>();

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
    }

    public static addBeli(BisaDibeli barang, Integer duration){
        pekerjaanAktif.put(barang, duration); 
    }
}
