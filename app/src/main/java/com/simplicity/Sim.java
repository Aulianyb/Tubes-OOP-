package com.simplicity;
import java.util.*; 
//Masih harus dikode time passing! -- udah!

public class Sim{
    //atribut static
    private static Thread thread; 
    private static int detik;
    private static String[] listPekerjaan = {"Badut Sulap", "Koki", "Polisi", "Programmer", "Dokter"}; 
    private static Random randomizer = new Random(); 

    //atribut non static
    private String namaLengkap; 
    private Pekerjaan pekerjaan; 
    private int uang;
    private Inventory inventory; 
    private int kekenyangan; 
    private int mood; 
    private int kesehatan; 
    private Status status; 
    private Rumah currentRumah; 
    private Tracking jamTidur;
    private Tracking jamBuangAir;
    private int jamKerja;

    protected class Tracking {
        protected int waktu;
        protected String kondisi;

        protected Tracking(String kondisi) {
            waktu = 0;
            this.kondisi = kondisi;
        }
    }
    
    public Sim(String namaLengkap, Rumah rumah){
        kekenyangan = 80; 
        mood = 80; 
        kesehatan = 100; 
        uang = 100;  
        int x = randomizer.nextInt(5); 
        pekerjaan = new Pekerjaan(listPekerjaan[x]); 
        inventory = new Inventory(); 
        status = new Status();
        this.namaLengkap = namaLengkap;
        currentRumah = rumah; 
        jamTidur = new Tracking("Belum tidur");
        jamBuangAir = new Tracking("Sudah buang air");
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
        this.pekerjaan.setPekerjaan(this, pekerjaan);
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

    public void olahraga(int detik){
        if (detik % 20 == 0){
            thread = new Thread(new Runnable(){
                public void run(){
                    try {
                        status.setStatus("Berolahraga");
                        System.out.println("Olahraga dalam progress!"); //indikator buat testing
                        System.out.printf("["); 
                        for (int i=0;i<10;i++){
                            Thread.sleep(detik * 100);
                            System.out.printf(">"); 
                        }
                        System.out.printf("]"); 
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
                        status.setStatus("idle");
                        Waktu.timePass(detik);            
                    } catch (InterruptedException e){
                    }
                }
            }); 
            thread.run();   
        } else{
            System.out.println("Durasi Harus kelipatan 20!"); 
        }
    }

    public void berkunjung(Rumah tujuan){
        double hasil = Math.sqrt(Math.pow(tujuan.getLokasi().getX() - currentRumah.getLokasi().getX(), 2) + Math.pow(tujuan.getLokasi().getY() - currentRumah.getLokasi().getY(), 2)); 
        detik = (int) hasil; 
        thread = new Thread(new Runnable(){
            public void run(){
                try {
                    status.setStatus("Berkunjung");
                    System.out.println("Berjalan ke rumah tujuan.."); //indikator buat testing
                    System.out.printf("["); //indikator buat testing
                    for (int i=0;i<10;i++){
                        Thread.sleep(detik * 100);
                        System.out.printf(">"); 
                    }
                    System.out.printf("]"); //indikator buat testing
                    int x = -10 * (detik / 30); 
                    int y = 10 * (detik / 30);
                    setKekenyangan(x);
                    setMood(y); 
                    System.out.println("\nKunjungan Selesai!");
                    System.out.println("Kekenyangan : "  + x); 
                    System.out.println("Mood : +" + y);  
                    status.setStatus("idle");
                    Waktu.timePass(detik);                
                } catch (InterruptedException e){
                }
            }
        }); 
        thread.run(); 
    }

    public boolean isDie(){
        return ((kesehatan <= 0) || (mood <= 0) || (kekenyangan <= 0)); 
    }

    public void printDeathMessage(){
        if (kesehatan <= 0){
            System.out.println(namaLengkap + " sakit berat dan meninggal!");
        }
        if (mood <= 0){
            System.out.println(namaLengkap + " depresi dan meninggal!");
        }
        if (kekenyangan <= 0){
            System.out.println(namaLengkap + " kelaparan dan meninggal!");
        }
    }

    public void beliBarang(BisaDibeli barang, int jumlah){
        if (uang < barang.getHarga() * jumlah){
            System.out.println("Maaf, uang yang dimiliki tidak mencukupi!"); 
        } else{
            setUang(-1 * barang.getHarga() * jumlah);
            Integer x = (randomizer.nextInt(5) + 1) * 30;  
            // Integer x = 5;
            System.out.println("[NOTICE PENGIRIMAN] " + barang.getNamaObjek() + " sedang dalam proses pengiriman.."); 
            Waktu.addBeli(barang, this, jumlah, x);
            status.setBeli(true);
        }
    }

    public void terimaBarang(BisaDibeli barang, int jumlah){
        System.out.println("[NOTICE PENGIRIMAN] " + barang.getNamaObjek() + " sudah sampai ditujuan!");
        inventory.addItem((ObjekGame) barang, jumlah);
    }

    public void meditasi(int detik){
        if (detik % 30 == 0){
            thread = new Thread(new Runnable(){
                public void run(){
                    try {
                        status.setStatus("Bermeditasi");
                        System.out.println("Meditasi dalam progress!"); //indikator buat testing
                        System.out.printf("["); 
                        for (int i=0;i<10;i++){
                            Thread.sleep(detik * 100);
                            System.out.printf(">"); 
                        }
                        System.out.printf("]"); 
                        int x = 10 * (detik / 30); 
                        setMood(x); 
                        System.out.println("\nMeditasi Selesai!");                  
                        System.out.println("Mood : +" + x);   
                        Waktu.timePass(detik);
                        status.setStatus("idle");
                    } catch (InterruptedException e){
                    }
                }
            }); 
            thread.run();   
        } else{
            System.out.println("Durasi Harus kelipatan 30!"); 
        }
    }

    public void berkelahi(Sim kawan){
        status.setStatus("berkelahi");
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
                        int win = randomizer.nextInt(2); 
                        setKesehatan(-10);
                        kawan.setKesehatan(-10); 
                        System.out.println("\nPerkelahian Selesai!");
                        if (win == 1){
                            System.out.println("Yipee! Kamu menang!");
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
                        Waktu.timePass(10);     
                        status.setStatus("idle");
                    } catch (InterruptedException e){
                    }
                }
            });
            thread.run(); 
        } 
    }

    public void nyanyi(int detik){
        status.setStatus("bernyanyi");
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
                        int x = 20 * (detik / 30); 
                        setMood(x); 
                        System.out.println("\nBernyanyi Selesai!");                  
                        System.out.println("Mood : +" + x);         
                        Waktu.timePass(detik);
                        status.setStatus("idle");
                    } catch (InterruptedException e){
                    }
                }
            }); 
            thread.run();   
        } else{
            System.out.println("Durasi Harus kelipatan 30!"); 
        }
    }

    public void menari(int detik){
        status.setStatus("menari");
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
                        int x = 20 * (detik / 10); 
                        setMood(x); 
                        System.out.println("\nMenari Selesai!");                  
                        System.out.println("Mood : +" + x);    
                        if (detik > 10){
                            System.out.println("Badanmu.. terasa pegal..");
                            System.out.println("Kesehatan : -5");    
                            setKesehatan(-5);    
                        }          
                        Waktu.timePass(detik);
                        status.setStatus("idle");
                    } catch (InterruptedException e){
                    }
                }
            }); 
            thread.run();   
        } else{
            System.out.println("Durasi Harus kelipatan 10!"); 
        }
    }

    public void daydreaming(){
        status.setStatus("menghalu");
        thread = new Thread( new Runnable(){
            public void run(){
                System.out.println("Menghalu- eh daydreaming dimulai!");
                System.out.println(namaLengkap + " menutup matanya...");
                try {
                    System.out.printf("["); 
                    for (int i=0;i<10;i++){
                        Thread.sleep(1000);
                        System.out.printf(">"); 
                    }
                    System.out.printf("]"); 
                    int x = randomizer.nextInt(4); 
                    int diff=0; 
                    switch (x){
                        case 0: 
                            System.out.println("\n" + namaLengkap + " membayangkan dapat IPK 4.0!");
                            diff = 30; 
                            break;
                        case 1: 
                            System.out.println("\n" + namaLengkap + " membayangkan bermain di pantai!");
                            diff = 10;
                            break; 
                        case 2:
                            System.out.println("\n" + namaLengkap + "... tidak bisa membayangkan apa apa...");
                            diff = 0;
                            break;
                        case 3:
                            System.out.println("\n" + namaLengkap + " membayangkan MIMPI BURUK AHH!!");
                            diff = -50;
                            break;  
                    }            
                    setMood(diff);
                    if (diff > 0){
                        System.out.println("Mood : +" + diff);    
                    } else{
                        System.out.println("Mood : " + diff);   
                    }
                    Waktu.timePass(detik);
                    status.setStatus("idle");
                } catch (InterruptedException e){
                }
            }
        }); 
        thread.run();
    }

    public void monolog(int detik){
        status.setStatus("bermonolog");
        if (detik % 30 == 0){
            thread = new Thread(new Runnable(){
                public void run(){
                    try {
                        System.out.println(namaLengkap + " bermonolog!"); //indikator buat testing
                        System.out.printf("["); 
                        for (int i=0;i<10;i++){
                            Thread.sleep(detik * 100);
                            System.out.printf(">"); 
                        }
                        System.out.printf("]"); 
                        int x = 20 * (detik / 30); 
                        setMood(x); 
                        System.out.println("\nBermonolog Selesai!");                  
                        System.out.println("Mood : +" + x);    
                        if (detik > 60){
                            System.out.println("kok kamu ngomong sendiri lama banget sih...");
                            System.out.println("Kesehatan : -10");    
                            setKesehatan(-10);    
                        }                
                        Waktu.timePass(detik);
                        status.setStatus("idle");
                    } catch (InterruptedException e){
                    }
                }
            }); 
            thread.run();   
        } else{
            System.out.println("Durasi Harus kelipatan 30!"); 
        }
    }

    public void lelucon(Sim kawan){
        status.setStatus("berlelucon");
        System.out.println(namaLengkap + " memberikan lelucon kepada " + kawan.getNama() + "!"); 
        int x = randomizer.nextInt(2); 
        if (x == 1){
            System.out.println(kawan.getNama() + " tidak menganggap leluconmu lucu..."); 
            setMood(-10); 
            System.out.println("Mood : -10");    

        }else{
            System.out.println(kawan.getNama() + " tertawa mendengar leluconmu!"); 
            setMood(10); 
            kawan.setMood(10);  
            System.out.println("Mood : +10");    
        }
        status.setStatus("idle");
    }

    public Rumah getCurrentRumah() {
        return currentRumah;
    }

    public void setCurrentRumah(Rumah rumah) {
        currentRumah = rumah;
    }

    //buat testing 
    public void testAction(int detik){
        System.out.println("Ini aksi test selama " + detik + " detik");
        Waktu.timePass(detik);
    }

    public Tracking getJamTidur() {
        return jamTidur;
    }

    public Tracking getJamBuangAir() {
        return jamBuangAir;
    }

    public int getJamKerja() {
        return jamKerja;
    }

    public void setJamTidur(int detik, String kondisi) {
        jamTidur.waktu = detik;
        jamTidur.kondisi = kondisi;
    }

    public void setJamBuangAir(int detik, String kondisi) {
        jamBuangAir.waktu = detik;
        jamBuangAir.kondisi = kondisi;
    }

    public void setJamKerja(int detik) {
        jamKerja = detik;
    }

    public void testThread(TimeThread t){
        t.resume();
        System.out.println("Boiye lmao");
        t.pause(); 
        System.out.println("Thread Done");
    }

}