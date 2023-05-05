package com.simplicity;

public class Wastafel extends Furnitur {
    public Wastafel(String namaObjek) {
        super(namaObjek);
        setPanjang(1);
        setLebar(1);
        setHarga(35);
        setValidAction(new Status());
        getValidAction().setStatus("cuci tangan");
    }

    @Override
    public void aksi(Sim sim) {
        TimeThread.getInstance().resume();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Cuci tangan...");
                    System.out.printf("[");
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(500);
                        System.out.printf(">");
                    }
                    System.out.println("]");
                    sim.setKesehatan(+5);
                    Waktu.getInstance().timePass(5);
                    System.out.println("Cuci tangan selesai!");
                    System.out.println("Kesehatan : +5");
                }
                catch (InterruptedException e) {
                    System.out.println("Cuci tangan dihentikan.");
                }
            }
        });
        thread.run();
        TimeThread.getInstance().pause();
    }
}
