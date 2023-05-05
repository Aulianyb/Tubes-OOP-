package com.simplicity;

public class Shower extends Furnitur {
    public Shower(String namaObjek) {
        super(namaObjek);
        setPanjang(2);
        setLebar(1);
        setHarga(40);
        setValidAction(new Status());
        getValidAction().setStatus("mandi");
    }

    @Override
    public void aksi(Sim sim) {
        TimeThread.getInstance().resume();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Mandi...");
                    System.out.printf("[");
                    for (int i = 0; i < 30; i++) {
                        System.out.printf(">");
                        Thread.sleep(1000);
                    }
                    System.out.println("]");
                    sim.setKesehatan(+20);
                    sim.setMood(+10);
                    Waktu.getInstance().timePass(30);
                    System.out.println("Mandi selesai!");
                    System.out.println("Kesehatan : +20");
                    System.out.println("Mood : +10");
                }
                catch (InterruptedException e) {
                    System.out.println("Mandi dihentikan.");
                }
            }
        });
        thread.run();
        TimeThread.getInstance().pause();
    }
}
