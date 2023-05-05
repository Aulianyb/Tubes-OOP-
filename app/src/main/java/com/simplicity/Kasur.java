package com.simplicity;
import java.util.*;

public class Kasur extends Furnitur{
    //Konstruktor
    public Kasur(String namaObjek) {
        super(namaObjek);
        setValidAction(new Status());
        getValidAction().setStatus("tidur");
    }

    //Status
    @Override
    public void aksi(Sim sim){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input durasi : ");
        int detik = Integer.parseInt(scanner.nextLine());
        TimeThread.getInstance().resume();
        Thread thread = new Thread(new Runnable(){
            public void run(){
                try {
                    if (detik <= 180) {
                        System.out.println("Durasi tidur tidak valid!");
                    } else {
                        int sleepTime = detik * 1000;
                        System.out.println("Tidur amimir..."); //indikator buat testing
                        while (sleepTime > 0) {
                            if (sleepTime - 240000 >= 0) {
                                System.out.printf("[");
                                for (int i=0;i<10;i++){
                                    Thread.sleep(24000);
                                    System.out.printf(">"); 
                                }
                                System.out.printf("]\n");
                                sim.setMood(30);
                                sim.setKesehatan(20);
                                sleepTime -= 240000;
                            } else {
                                System.out.printf("[");
                                for (int i=0;i<10;i++){
                                    Thread.sleep(sleepTime / 10);
                                    System.out.printf(">"); 
                                }
                                System.out.printf("]\n");
                                sleepTime = 0;
                            }
                        }
                        Waktu.getInstance().timePass(detik);
                        System.out.println("Tidur selesai!");
                        if (detik >= 180) {
                            sim.setJamTidur(0, "Sudah tidur");
                        }
                    }
                } catch(InterruptedException e){
                    System.out.println("Tidur dihentikan.");
                }
            }
        });
        thread.run();
        TimeThread.getInstance().pause();
    }
}
