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
    public void tidur(Sim sim){
        Scanner scanner = new Scanner(System.in);
        int detik = Integer.parseInt(scanner.nextLine());
        Thread thread = new Thread(new Runnable(){
            public void run(){
                try {
                    if (detik <= 0) {
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
                        if (detik >= 180) {
                            sim.setJamTidur(0);
                        }
                        Waktu.timePass(detik);
                    }
                } catch(InterruptedException e){
                    System.out.println("Tidur dihentikan.");
                }
            }
        });
        thread.run();
    }
}
