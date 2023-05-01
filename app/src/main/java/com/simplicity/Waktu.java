package com.simplicity;
import java.util.*;

public class Waktu {
    private static int hari; 
    private static int menit;
    private static int detik;
    private static HashMap <Kiriman, Integer> barangDikirim = new HashMap<Kiriman, Integer>();
    private static HashMap <Rumah, Integer> ongoingUpgrade = new HashMap<Rumah, Integer>(); 

    public Waktu() {
        menit = 0;
        detik = 0;
        hari = 0; 
    }

    public static int getMenit() {
        return menit;
    }

    public static int getDetik() {
        return detik;
    }

    public void setMenit(int menit_input) {
        menit = menit_input;
    }

    public void setDetik (int detik_input) {
        detik = detik_input;
    }

    public void displayWaktu() {

        System.out.print("HARI " + hari);
        System.out.println(""); 

        if (menit<10) {
            System.out.print("0" + menit);
        } else {
            System.out.print(":" + menit);
        }
        if (detik<10) {
            System.out.print(":0" + detik);
        } else {
            System.out.print(":" + detik);
        }
        System.out.println(""); 
    }
    
    public int toDetik() {
        return((menit * 60) + detik);
    }

    public static void timePass(int durasi){
        detik += durasi % 60;
        menit += durasi / 60; 

        //cek apakah tiap SIM masih hidup atau gak
        World.checkDeath(); 
        World.updateSim();

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
                    entry.getKey().getSim().getStatus().updatePembelian(entry.getKey().getSim());
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

        if (menit / 12 > 0){
            hari += menit / 12; 
            menit = menit % 12; 
            World.updateHarian();
            //reset makan, dll ya gitu deh
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
        System.out.println(""); 
        System.out.println("              P E N G I R I M A N"); 
        System.out.println("-".repeat(48)); 
        System.out.println("|     Nama Barang    | Jumlah | Sisa Waktu (d) |"); 
        System.out.println("-".repeat(48)); 


        if (!World.getCurrentSim().getStatus().getBeli()){
            System.out.println("|                    |        |                |"); 
            System.out.println("-".repeat(48)); 
        }else{
            barangDikirim.forEach((key, value)->{
                if (key.getSim() == World.getCurrentSim()){
                    int x = 20 - key.getBarang().getNamaObjek().length();
                    int y = 8 - key.getJumlah().toString().length(); 
                    int z = 16 - value.toString().length(); 
                    System.out.println("|" + key.getBarang().getNamaObjek() + " ".repeat(x) + "|" + key.getJumlah() + " ".repeat(y) + "|" + value + " ".repeat(z) + "|"); 
                    System.out.println("-".repeat(48)); 
                }
            });    
        }
    }

    public static void displayUpgrade(){
        System.out.println(""); 
        System.out.println("          U P G R A D E  R U M A H"); 
        System.out.println("-".repeat(43));
        System.out.println("|       Rumah        |     Sisa Waktu     |");
        System.out.println("-".repeat(43));
        
        if (!World.getCurrentSim().getCurrentRumah().getUpgradeStatus()){
            System.out.println("|                    |                    |");
            System.out.println("-".repeat(43));
        }else{
            ongoingUpgrade.forEach((key, value)->{
                if(key.getOwner() == World.getCurrentSim().getNama()){
                    String rumah = "Rumah " + key.getOwner();
                    String sisaWaktu =  (value / 60) + " menit " + (value % 60) + " detik"; 
                    int x = 20 - rumah.length(); 
                    int y = 20 - sisaWaktu.length(); 
                    System.out.println("|" + rumah + " ".repeat(x) + "|" + sisaWaktu + " ".repeat(y) + "|"); 
                    System.out.println("-".repeat(43));
                }
            });
        }
    }

    public static HashMap<Kiriman, Integer> getPengiriman(){
        return barangDikirim; 
    }
}
