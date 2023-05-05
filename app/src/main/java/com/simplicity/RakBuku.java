package com.simplicity;

public class RakBuku extends Furnitur {
    public RakBuku(String namaObjek) {
        super(namaObjek);
        setPanjang(3);
        setLebar(1);
        setHarga(80);
        setValidAction(new Status());
        getValidAction().setStatus("membaca");
    }

    @Override
    public void aksi(Sim sim) {
        TimeThread.getInstance().resume();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Membaca...");
                    System.out.printf("[");
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(3000);
                        System.out.printf(">");
                    }
                    System.out.println("]");
                    sim.setMood(+15);
                    Waktu.getInstance().timePass(30);
                    System.out.println("Membaca selesai!");
                    System.out.println("Mood : +15");
                }
                catch (InterruptedException e) {
                    System.out.println("Membaca dihentikan.");
                }
            }
        });
        thread.run();
        TimeThread.getInstance().pause();
    }
}
