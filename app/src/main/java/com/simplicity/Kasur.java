package com.simplicity;

public class Kasur extends Furnitur{
    //Konstruktor
    public Kasur(String namaObjek) {
        super(namaObjek);
        setValidAction(new Status());
        getValidAction().setStatus("tidur");
    }

    //Status
    public void tidur(Sim sim, Waktu durasi){
        int detik = durasi.toDetik();
        Thread thread = new Thread(new Runnable(){
            public void run(){
                try {
                    System.out.println("Tidur Z z z..."); //indikator buat testing
                    Thread.sleep(detik * 1000);
                } catch (InterruptedException e){
                }
                finally{
                    sim.setMood(30 * ((detik / 60) / 4));
                    sim.setKesehatan(20 * (detik / 240));
                }
            }
        });
        thread.run();
        //to do : kalau gak tidur gimana nanti?
    }
}
