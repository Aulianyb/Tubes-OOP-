package com.simplicity;

public class Gramofon extends Furnitur {
    public Gramofon(String namaObjek) {
        super(namaObjek);
        setPanjang(1);
        setLebar(1);
        setHarga(65);
        setValidAction(new Status());
        getValidAction().setStatus("mendengarkan musik");
    }

    @Override
    public void aksi(Sim sim) {
        TimeThread.getInstance().resume();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Mendengarkan musik...");
                    System.out.printf("[");
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(1500);
                        System.out.printf(">");
                    }
                    System.out.println("]");
                    sim.setMood(+10);
                    Waktu.getInstance().timePass(15);
                    System.out.println("Mendengarkan musik selesai!");
                    System.out.println("Mood : +10");
                }
                catch (InterruptedException e) {
                    System.out.println("Mendengarkan musik dihentikan.");
                }
            }
        });
        thread.run();
        TimeThread.getInstance().pause();
    }
}
