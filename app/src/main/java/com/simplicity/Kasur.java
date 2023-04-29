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
                    int sleepTime = detik * 1000;
                    System.out.println("Tidur Z z z..."); //indikator buat testing
                    while (sleepTime > 0) {
                        if (sleepTime - 180000 >= 0) {
                            Thread.sleep(180000);
                            sim.setMood(30);
                            sim.setKesehatan(20);
                            sleepTime -= 180000;
                        }
                        else {
                            Thread.sleep(sleepTime);
                            sleepTime = 0;
                        }
                    }
                    Waktu.timePass(detik);
                } catch (InterruptedException e){
                }
            }
        });
        thread.run();
    }
}
