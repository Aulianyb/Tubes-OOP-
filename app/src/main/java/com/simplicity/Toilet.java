package com.simplicity;

import java.sql.Time;

public class Toilet extends Furnitur {
    public Toilet(String namaObjek) {
        super(namaObjek);
        setPanjang(1);
        setLebar(1);
        setHarga(50);
        setValidAction(new Status());
        getValidAction().setStatus("buang air");
    }

    @Override
    public void aksi(Sim sim){
        TimeThread.getInstance().resume();
        Thread thread = new Thread(new Runnable(){
            public void run(){
                try {
                    System.out.println("Buang Air..."); //indikator buat testing
                    System.out.printf("["); 
                    for (int i=0;i<10;i++){
                        Thread.sleep(1000);
                        System.out.printf(">"); 
                    }
                    System.out.printf("]\n");
                    sim.setKekenyangan(-20);
                    sim.setMood(10);
                    Waktu.getInstance().timePass(10);
                    sim.setJamBuangAir(0, "Sudah buang air");
                    System.out.println("Buang air Selesai!");
                    System.out.println("Kekenyangan : -20");                      
                    System.out.println("Mood : +10");
                } catch (InterruptedException e){
                    System.out.println("Buang air dihentikan.");
                }
            }
        });
        thread.run();
        TimeThread.getInstance().pause();
    }
}
