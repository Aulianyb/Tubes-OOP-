package com.simplicity;

import java.awt.*;

public class Treadmil extends Furnitur {
    public Treadmil(String namaObjek) {
        super(namaObjek);
        setPanjang(2);
        setLebar(1);
        setHarga(150);
        setValidAction(new Status());
        getValidAction().setStatus("lari");
    }

    @Override
    public void aksi(Sim sim) {
        TimeThread.getInstance().resume();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Lari...");
                    System.out.printf("[");
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(2000);
                        System.out.printf(">");
                    }
                    System.out.println("]");
                    sim.setKekenyangan(-15);
                    sim.setKesehatan(+15);
                    sim.setMood(+10);
                    Waktu.getInstance().timePass(20);
                    System.out.println("Lari selesai!");
                    System.out.println("Kekenyangan : -15");
                    System.out.println("Kesehatan : +15");
                    System.out.println("Mood : +10");
                }
                catch (InterruptedException e) {
                    System.out.println("Lari dihentikan.");
                }
            }
        });
        thread.run();
        TimeThread.getInstance().pause();
    }
}
