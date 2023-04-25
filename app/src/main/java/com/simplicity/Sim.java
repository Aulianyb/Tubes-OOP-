package com.simplicity;
import java.util.*; 
//Masih harus dikode time passing! -- udah!

public class Sim{
    private static Thread thread; 
    private static int detik;
    private String namaLengkap; 
    private Pekerjaan pekerjaan; 
    private int uang;
    private Inventory inventory; 
    private int kekenyangan; 
    private int mood; 
    private int kesehatan; 
    private Status status; 
    private static String[] listPekerjaan = {"Badut Sulap", "Koki", "Polisi", "Programmer", "Dokter"}; 
    private static Random randomizer = new Random(); 


    //nanti tambahin buildernya
    public Sim(String namaLengkap){
        kekenyangan = 80; 
        mood = 80; 
        kesehatan = 100; 
        uang = 100;  
        int x = randomizer.nextInt(5); 
        pekerjaan = new Pekerjaan(listPekerjaan[x]); 
        inventory = new Inventory(); 
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

    public Inventory getInventory(){
        return inventory; 
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

    public void setKekenyangan(int diff){
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
            kesehatan = 0;
        }
        if (kesehatan > 100){
            kesehatan = 100;
        }
    }

    public void olahraga(Waktu durasi){
        detik=durasi.toDetik();
        if (detik % 20 == 0){
            thread = new Thread(new Runnable(){
                public void run(){
                    try {
                        System.out.println("Olahraga dalam progress!"); //indikator buat testing
                        System.out.printf("["); 
                        for (int i=0;i<10;i++){
                            Thread.sleep(detik * 100);
                            System.out.printf(">"); 
                        }
                        System.out.printf("]"); 
                    } catch (InterruptedException e){
                    }
                    finally{
                        int x = 5 * (detik / 20); 
                        int y = -5 * (detik / 20); 
                        int z = 10 * (detik / 20); 
                        setKesehatan(5 * (detik / 20));
                        setKekenyangan(-5 * (detik / 20));
                        setMood(10 * (detik / 20)); 
                        System.out.println("\nOlahraga Selesai!");
                        System.out.println("Kesehatan : +" + x);                      
                        System.out.println("Kekenyangan : " + y);                      
                        System.out.println("Mood : +" + z);                      
                    } 
                }
            }); 
            thread.run();   
        } else{
            System.out.println("Durasi Harus kelipatan 20!"); 
        }
    }

    public void berkunjung(Rumah tujuan, Waktu durasi){
        double hasil = Math.sqrt(Math.pow(tujuan.getLokasi().getX() - rumah.getLokasi().getX(), 2) + Math.pow(tujuan.getLokasi().getY() - rumah.getLokasi().getY(), 2)); 
        detik = (int) hasil; 
        thread = new Thread(new Runnable(){
            public void run(){
                try {
                    System.out.println("Berjalan ke rumah tujuan.."); //indikator buat testing
                    for (int i=0;i<10;i++){
                        Thread.sleep(detik * 100);
                        System.out.printf(">"); 
                    }
                } catch (InterruptedException e){
                }
                finally{
                    setKekenyangan(-10 * (detik / 30));
                    setMood(+10 * (detik / 30)); 
                } 
            }
        }); 
        thread.run(); 
    }

    public boolean isDie(){
        return ((kesehatan <= 0) || (mood <= 0) || (kekenyangan <= 0)); 
    }

    public synchronized void beliBarang(BisaDibeli barang){
        if (uang < barang.getHarga()){
            System.out.println("Maaf, uang yang dimiliki tidak mencukupi!"); 
        } else{
            setUang(-1 * barang.getHarga());
            System.out.println(barang.getNamaObjek() + " sedang dalam proses pengiriman..");
            Thread threadBeli = new Thread(new Runnable(){
                public void run(){
                    try{
                        Thread.sleep(2000);
                        // ini random maksudnya apa
                    }catch(InterruptedException e){

                    }finally{
                        System.out.println(barang.getNamaObjek() + " sudah sampai ditujuan!");
                        inventory.addItem(barang, detik);
                    }
                }
            }); 
            threadBeli.run(); 
        }
    }

    public void meditasi(){

    }



}