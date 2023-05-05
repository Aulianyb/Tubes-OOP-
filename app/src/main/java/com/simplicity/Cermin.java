package com.simplicity;

import java.awt.*;

public class Cermin extends Furnitur {
    public Cermin(String namaObjek) {
        super(namaObjek);
        setPanjang(1);
        setLebar(1);
        setHarga(35);
        setValidAction(new Status());
        getValidAction().setStatus("becermin");
    }

    @Override
    public void aksi(Sim sim) {
        TimeThread.getInstance().resume();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Becermin...");
                    System.out.printf("[");
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(1000);
                        System.out.printf(">");
                    }
                    System.out.println("]");
                    sim.setMood(+10);
                    Waktu.timePass(10);
                    System.out.println("Becermin selesai!");
                    System.out.println("Mood : +10");
                }
                catch (InterruptedException e) {
                    System.out.println("Becermin dihentikan.");
                }
            }
        });
        thread.run();
        TimeThread.getInstance().pause();
    }
}
