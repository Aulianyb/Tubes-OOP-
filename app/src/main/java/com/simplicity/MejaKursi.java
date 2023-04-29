package com.simplicity;
import java.util.*;

public class MejaKursi extends Furnitur {
    //Konstruktor
    public MejaKursi(String namaObjek) {
        super(namaObjek);
        setPanjang(3);
        setLebar(3);
        setHarga(50);

        setValidAction(new Status());
        getValidAction().setStatus("makan");
    }

    //Method makan
    public void makan(Sim sim) {
        Thread thread = new Thread(new Runnable(){
            public void run(){
                Makanan temp = null;
                try {
                    Map<Makanan, Integer> inv = sim.getInventory().getInventoryMakanan();
                    int i = 1;

                    //Menampilkan daftar makanan yang dimiliki
                    System.out.println("Makanan yang terdapat dalam inventory:");
                    for (Makanan m : inv.keySet()) {
                        System.out.println(i+". "+m.getNamaObjek());
                        i++;
                    }

                    //Input makanan yang ingin dimakan
                    Scanner scanner = new Scanner(System.in);
                    String namaMakanan = scanner.nextLine();
                    boolean valid = false;
                    //Mengonsumsi makanan
                    for (Makanan ma : inv.keySet()) {
                        if (ma.getNamaObjek().toLowerCase().equals(namaMakanan.toLowerCase())) {
                            valid = true;
                            temp = ma;
                            break;
                        }
                    }

                    if (valid) {
                        System.out.println("Makan..."); //indikator buat testing
                        Thread.sleep(30000);
                        sim.getInventory().reduceItem(temp, 1);
                        sim.setKekenyangan(temp.getNilaiKekenyangan());
                        Waktu.timePass(30);
                    }
                    else {
                        System.out.println("Makanan tidak terdapat pada inventory.");
                    }


                } catch (InterruptedException e){
                }
            }
        });
        thread.run();
    }
}
