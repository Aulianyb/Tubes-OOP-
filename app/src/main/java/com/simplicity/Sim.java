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
                        setKesehatan(x);
                        setKekenyangan(y);
                        setMood(z); 
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

    public void berkunjung(Rumah tujuan){
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

    public void beliBarang(BisaDibeli barang, int jumlah){
        if (uang < barang.getHarga() * jumlah){
            System.out.println("Maaf, uang yang dimiliki tidak mencukupi!"); 
        } else{
            setUang(-1 * barang.getHarga() * jumlah);
            int x = (randomizer.nextInt(5) + 1) * 30; 
            System.out.println(barang.getNamaObjek() + " sedang dalam proses pengiriman..");
            thread = new Thread(new Runnable(){
                public void run(){
                    try{
                        Thread.sleep(x * 1000);
                    }catch(InterruptedException e){

                    }finally{
                        System.out.println(barang.getNamaObjek() + " sudah sampai ditujuan!");
                        inventory.addItem((ObjekGame) barang, jumlah);
                    }
                }
            }); 
            thread.start(); 
        }
    }

    public void pasangBarang(Furnitur barang){
        //aku bingung
    }

    public void meditasi(Waktu durasi){
        detik=durasi.toDetik();
        if (detik % 30 == 0){
            thread = new Thread(new Runnable(){
                public void run(){
                    try {
                        System.out.println("Meditasi dalam progress!"); //indikator buat testing
                        System.out.printf("["); 
                        for (int i=0;i<10;i++){
                            Thread.sleep(detik * 100);
                            System.out.printf(">"); 
                        }
                        System.out.printf("]"); 
                    } catch (InterruptedException e){
                    }
                    finally{
                        int x = 10 * (detik / 30); 
                        setMood(x); 
                        System.out.println("\nMeditasi Selesai!");                  
                        System.out.println("Mood : +" + x);                      
                    } 
                }
            }); 
            thread.run();   
        } else{
            System.out.println("Durasi Harus kelipatan 30!"); 
        }
    }

    public void berkelahi(Sim kawan){
        System.out.println("Kamu mengajak " + kawan.getNama() + " berkelahi!"); //indikator buat testing
        if (kawan.getMood() > 90){
            System.out.println(kawan.getNama() + " menolak ajakanmu.");
            System.out.println("'Berkelahi itu tidak Baik! >:(' - " + kawan.getNama());
        } else{
            System.out.println(kawan.getNama() + " menerima ajakanmu!");
            System.out.println(kawan.getNama() + " melontarkan pukulannya!");
            thread = new Thread(new Runnable(){
                public void run(){
                    try {
                        System.out.printf("["); 
                        for (int i=0;i<10;i++){
                            Thread.sleep(1000);
                            System.out.printf(">"); 
                        }
                        System.out.printf("]"); 
                    } catch (InterruptedException e){
                    }
                    finally{
                        int win = randomizer.nextInt(2); 
                        setKesehatan(-10);
                        kawan.setKesehatan(-10); 
                        System.out.println("\nPerkelahian Selesai!");
                        if (win == 1){
                            System.out.println("\nYipee! Kamu menang!");
                            kawan.setMood(-10);
                            setMood(10);
                            System.out.println("Mood : +10");
                        } else{
                            System.out.println("\nUh oh... kamu kalah..");
                            kawan.setMood(10);
                            setMood(-10);
                            System.out.println("Mood : -10");
                        }                  
                        System.out.println("Kesehatan : -10");                      
                    } 
                }
            });
            thread.run(); 
        } 
    }

    public void nyanyi(Waktu durasi){
        detik=durasi.toDetik();
        if (detik % 30 == 0){
            thread = new Thread(new Runnable(){
                public void run(){
                    try {
                        System.out.println(namaLengkap + " sedang bernyanyi! La.. la.. la.."); //indikator buat testing
                        System.out.printf("["); 
                        for (int i=0;i<10;i++){
                            Thread.sleep(detik * 100);
                            System.out.printf(">"); 
                        }
                        System.out.printf("]"); 
                    } catch (InterruptedException e){
                    }
                    finally{
                        int x = 20 * (detik / 30); 
                        setMood(x); 
                        System.out.println("\nBernyanyi Selesai!");                  
                        System.out.println("Mood : +" + x);                      
                    } 
                }
            }); 
            thread.run();   
        } else{
            System.out.println("Durasi Harus kelipatan 30!"); 
        }
    }

    public void menari(Waktu durasi){
        detik = durasi.getDetik(); 
        if (detik % 10 == 0){
            thread = new Thread(new Runnable(){
                public void run(){
                    try {
                        System.out.println(namaLengkap + " sedang menari!"); //indikator buat testing
                        System.out.printf("["); 
                        for (int i=0;i<10;i++){
                            Thread.sleep(detik * 100);
                            System.out.printf(">"); 
                        }
                        System.out.printf("]"); 
                    } catch (InterruptedException e){
                    }
                    finally{
                        int x = 20 * (detik / 10); 
                        setMood(x); 
                        System.out.println("\nMenari Selesai!");                  
                        System.out.println("Mood : +" + x);    
                        if (detik > 10){
                            System.out.println("\nBadanmu.. terasa pegal..");
                            System.out.println("Kesehatan : -5");    
                            setKesehatan(-5);    
                        }                  
                    } 
                }
            }); 
            thread.run();   
        } else{
            System.out.println("Durasi Harus kelipatan 10!"); 
        }
    }



}