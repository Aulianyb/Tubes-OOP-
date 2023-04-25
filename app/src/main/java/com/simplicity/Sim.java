package com.simplicity;

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
    private Rumah rumah; 
    private Ruangan ruangan; 

    //nanti tambahin buildernya
    public Sim(String namaLengkap){
        kekenyangan = 80; 
        mood = 80; 
        kesehatan = 100; 
        uang = 100; 
        
        // Ini randomizernya belum buat, masih placeholder
        pekerjaan = new Pekerjaan("Programmer"); 

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

    public void setKekeyangan(int diff){
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
                        System.out.println("Olaharaga! Huft Huft..."); //indikator buat testing
                        Thread.sleep(detik * 1000);
                    } catch (InterruptedException e){
                    }
                    finally{
                        setKesehatan(5 * (detik / 20));
                        setKekeyangan(-5 * (detik / 20));
                        setMood(+10 * (detik/20)); 
                    } 
                }
            }); 
            thread.run();   
        } else{
            System.out.println("Durasi Harus kelipatan 20!"); 
        }
    }

    //tolong pindahin ke Kasur.java
    public void tidur(Waktu durasi){
        detik=durasi.toDetik();
        thread = new Thread(new Runnable(){
            public void run(){
                try {
                    System.out.println("Tidur Z z z..."); //indikator buat testing
                    Thread.sleep(detik * 1000);
                } catch (InterruptedException e){
                }
                finally{
                    setMood(30 * ((detik / 60) / 4));
                    setKesehatan(20 * (detik / 240));
                } 
            }
        }); 
        thread.run(); 
        //to do : kalau gak tidur gimana nanti?
    }

    public void makan(){
        //nungguin dulu Makanan.java
    }

    public void memasak(){
        //nungguin dulu Makanan.java
    }

    public void berkunjung(Rumah tujuan){
        detik = Math.sqrt(Math.pow(tujuan.getLokasi().getX() - rumah.getLokasi().getX(), 2) + Math.pow(tujuan.getLokasi().getY() - rumah.getLokasi().getY(), 2)); 
        thread = new Thread(new Runnable(){
            public void run(){
                try {
                    System.out.println("Buang Air..."); //indikator buat testing
                    Thread.sleep(detik * 1000);
                } catch (InterruptedException e){
                }
                finally{
                    setKekeyangan(-10 * (detik / 30));
                    setMood(+10 * (detik / 30)); 
                } 
            }
        }); 
        thread.run(); 
    }

    // ini aku simpen di toilet
    public void buangAir(){
        thread = new Thread(new Runnable(){
            public void run(){
                try {
                    System.out.println("Buang Air..."); //indikator buat testing
                    Thread.sleep(10000);
                } catch (InterruptedException e){
                }
                finally{
                    setKekeyangan(-20);
                    setMood(10); 
                } 
            }
        }); 
        thread.run(); 
    }

    public boolean isDie(){
        return ((kesehatan <= 0) || (mood <= 0) || (kekenyangan <= 0)); 
    }



}