package com.simplicity;

public class Toilet extends Furnitur {
    public Toilet(String namaObjek) {
        super(namaObjek);
        setPanjang(1);
        setLebar(1);
        setHarga(50);
        setValidAction(new Status());
        getValidAction().setStatus("buang air");
    }

    public void buangAir(Sim sim){
        Thread thread = new Thread(new Runnable(){
            public void run(){
                try {
                    System.out.println("Buang Air..."); //indikator buat testing
                    Thread.sleep(10000);
                } catch (InterruptedException e){
                }
                finally{
                    sim.setKekeyangan(-20);
                    sim.setMood(10);
                }
            }
        });
        thread.run();
    }
}
