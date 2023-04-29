package com.simplicity;
import java.util.*;

public class Waktu {
    private static int hari; 
    private static int jam;
    private static int menit;
    private static int detik;
    private static HashMap <Kiriman, Integer> barangDikirim = new HashMap<Kiriman, Integer>();
    private static HashMap <Rumah, Integer> ongoingUpgrade = new HashMap<Rumah, Integer>(); 

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
            barangDikirim.forEach((key, value) -> {
                int temp = value - durasi; 
                if (temp <= 0){
                    key.getSim().terimaBarang(key.getBarang(), key.getJumlah());
                }
                barangDikirim.put(key, temp); 
            });
            Iterator <Map.Entry<Kiriman, Integer>> iterator = barangDikirim.entrySet().iterator(); 

            while (iterator.hasNext()){
                Map.Entry<Kiriman, Integer> entry  = iterator.next ();
                if (entry.getValue() <= 0){
                    iterator.remove(); 
                }
            }
        }

        if (!ongoingUpgrade.isEmpty()){
            ongoingUpgrade.forEach((key, value) -> {
                int temp = value - durasi; 
                if (temp <= 0){
                    key.implementUpgrade();
                }
                ongoingUpgrade.put(key, temp); 
            });
            Iterator <Map.Entry<Rumah, Integer>> iterator = ongoingUpgrade.entrySet().iterator(); 

            while (iterator.hasNext()){
                Map.Entry<Rumah, Integer> entry  = iterator.next ();
                if (entry.getValue() <= 0){
                    iterator.remove(); 
                }
            }
        }
    }

    public static void addBeli(BisaDibeli barang, Sim sim, int jumlah, Integer duration){
        Kiriman kiriman = new Kiriman(barang, sim, jumlah); 
        barangDikirim.put(kiriman, duration); 
    }

    public static void addUpgrade(Rumah rumah){
        ongoingUpgrade.put(rumah, 18 * 60); 
    }

    public static void displayPengiriman(){
        System.out.println("=================="); 
        System.out.println("BARANG DALAM PENGIRIMAN"); 
        System.out.println("=================="); 
        if (barangDikirim.isEmpty()){
            System.out.println("Tidak ada barang dalam pengiriman");
        }else{
            barangDikirim.forEach((key, value)->{
                if (key.getSim() == World.getCurrentSim()){
                    System.out.println(key.getBarang().getNamaObjek() + " : " + value + " detik"); 
                }
            });    
        }
    }

    public static void displayUpgrade(){
        System.out.println("=================="); 
        System.out.println("UPGRADE RUMAH"); 
        System.out.println("==================");
        if (ongoingUpgrade.isEmpty()){
            System.out.println("Tidak ada upgrade rumah yang sedang berjalan saat ini"); 
        }else{
            ongoingUpgrade.forEach((key, value)->{
                if(key.getOwner() == World.getCurrentSim().getNama()){
                    System.out.println("Rumah " + key.getOwner() + " : " + (value / 60) + " menit " + (value % 60) + " detik"); 
                }
            });
        }
    }
}
