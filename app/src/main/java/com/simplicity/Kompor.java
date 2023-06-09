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
    private void addMenu(List<Masakan> l, Masakan m) {
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
        System.out.print(" |");
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
            System.out.print(m.listBahan(m.getBahan()));
            for (int j = 0; j < 30 - m.listBahan(m.getBahan()).length(); j++) {
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.print("\n");
        }
    }

    @Override
    public void aksi(Sim sim) {
        boolean valid = false;

        //Menampilkan menu makanan
        menuMasakan(menu);

        //Menerima input masakan yang akan dimasak
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        //Menginstansiasi objek masakan
        for (Masakan m : menu) {
            if (m.getNamaObjek().toLowerCase().equals(input.toLowerCase())) {
                valid = true;
                break;
            }
        }

        if (!valid) {
            System.out.println("Masakan tidak tersedia!");
        }
        else {
            //Format input to match constructor
            String words[] = input.split("\\s");
            String capitalizeWord = "";
            for(String w:words){
                String first=w.substring(0,1);
                String afterfirst=w.substring(1);
                capitalizeWord+=first.toUpperCase()+afterfirst+" ";
            }


            Masakan masakan = new Masakan(capitalizeWord.substring(0,capitalizeWord.length()-1));

            //Mengecek bahanMakanan pada inventory
            if (!masakan.bahanInInventory(sim, masakan.getBahan())) {
                System.out.println("Bahan tidak tersedia pada inventory!");
            } else {
                TimeThread.getInstance().resume();
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println("Memasak...");
                            int durasiMasak = (int)Math.round(1.5 * (masakan.getNilaiKekenyangan()));
                            System.out.printf("[");
                            for (int i=0;i<10;i++){
                                Thread.sleep(durasiMasak * 100);
                                System.out.printf(">"); 
                            }
                            System.out.printf("]\n");
                            for (int i = 0; i < masakan.getBahan().size(); i++) {
                                sim.getInventory().reduceItem((ObjekGame)masakan.getBahan().get(i), 1);
                            }
                            sim.getInventory().addItem((ObjekGame)masakan, 1);
                            Waktu.getInstance().timePass(durasiMasak);
                        } catch (InterruptedException e) {
                            System.out.println("Proses memasak dihentikan. Bahan makanan dikembalikan ke Inventory...");
                        }
                    }
                });
                thread.run();
                TimeThread.getInstance().pause();
            }
        }
    }
}
