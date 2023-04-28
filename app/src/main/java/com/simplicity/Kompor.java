package com.simplicity;
import java.util.*;
import java.lang.Math;

public class Kompor extends Furnitur {
    List<Masakan> menu = new ArrayList<Masakan>();

    //Initializing field
    {
        addMenu(menu, new Masakan("Nasi Ayam"));
        addMenu(menu, new Masakan("Nasi Kari"));
        addMenu(menu, new Masakan("Susu Kacang"));
        addMenu(menu, new Masakan("Tumis Sayur"));
        addMenu(menu, new Masakan("Bistik"));
    }

    //Konstruktor
    public Kompor(String namaObjek) {
        super(namaObjek);
        setValidAction(new Status());
        getValidAction().setStatus("memasak");
    }

    //add masakan to list menu
    public void addMenu(List<Masakan> l, Masakan m) {
        l.add(m);
    }

    //menampilkan menu masakan
    public void menuMasakan(List<Masakan> l) {
        System.out.print("|");
        for (int k = 0; k < 4; k++) {
            System.out.print(" ");
        }
        System.out.print("Masakan");
        for (int k = 0; k < 4; k++) {
            System.out.print(" ");
        }
        System.out.print("|");
        for (int k = 0; k < 13; k++) {
            System.out.print(" ");
        }
        System.out.print("Resep");
        for (int k = 0; k < 13; k++) {
            System.out.print(" ");
        }
        System.out.print("|");

        System.out.print("\n");

        for (Masakan m : l) {
            System.out.print("| "+m.getNamaObjek());
            for (int j = 0; j < 15 - m.getNamaObjek().length(); j++) {
                System.out.print(" ");
            }
            System.out.print("| ");
            System.out.print(m.getBahan().toString());
            for (int j = 0; j < 30 - m.getBahan().toString().length(); j++) {
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.print("\n");
        }
    }

    public void masak(Sim sim) {
        boolean valid = false;

        //Menampilkan menu makanan
        menuMasakan(menu);

        //Menerima input masakan yang akan dimasak
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        //Menginstansiasi objek masakan
        for (Masakan m : menu) {
            if (m.getNamaObjek().equals(input)) {
                valid = true;
                break;
            }
        }

        if (!valid) {
            System.out.println("Masakan tidak tersedia!");
        }
        else {
            Masakan masakan = new Masakan(input);

            //Mengecek bahanMakanan pada inventory
            if (!masakan.bahanInInventory(sim.getInventory(), masakan.getBahan())) {
                System.out.println("Bahan tidak tersedia pada inventory!");
            } else {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(Math.round(1.5 * (masakan.getNilaiKekenyangan())));
                            for (int i = 0; i < masakan.getBahan().size(); i++) {
                                sim.getInventory().reduceItem(masakan.getBahan().get(i), 1);
                            }
                            sim.getInventory().addItem(masakan, 1);
                        } catch (InterruptedException e) {
                            System.out.println("Proses memasak dihentikan. Bahan makanan dikembalikan ke Inventory...");
                        }
                    }
                });
            }
        }
    }
}
