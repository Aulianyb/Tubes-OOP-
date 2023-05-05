package com.simplicity;
import java.util.*;

public class KursiPijat extends Furnitur {
    public KursiPijat(String namaObjek) {
        super(namaObjek);
        setPanjang(1);
        setLebar(1);
        setHarga(60);
        setValidAction(new Status());
        getValidAction().setStatus("pijat");
    }

    @Override
    public void aksi(Sim sim) {
        Scanner s = new Scanner(System.in);
        int durasi = Integer.parseInt(s.nextLine());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Pijat...");
                    int waktuPijat = durasi * 1000;
                    while (waktuPijat > 0) {
                        if (waktuPijat - 30000 >= 0) {
                            System.out.printf("[");
                            for (int i=0;i<10;i++){
                                Thread.sleep(30000);
                                System.out.printf(">");
                            }
                            System.out.printf("]\n");
                            sim.setMood(+10);
                            sim.setKesehatan(+15);
                            waktuPijat -= 30000;
                        } else {
                            System.out.printf("[");
                            for (int i=0;i<10;i++){
                                Thread.sleep(waktuPijat / 10);
                                System.out.printf(">");
                            }
                            System.out.printf("]\n");
                            waktuPijat = 0;
                        }
                    }
                    System.out.println("Pijat selesai!");
                    Waktu.timePass(durasi);
                }
                catch (InterruptedException e) {
                    System.out.println("Pijat dihentikan.");
                }
            }
        });
        thread.run();
    }
}
