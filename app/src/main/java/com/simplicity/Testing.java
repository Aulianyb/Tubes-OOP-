package com.simplicity;
import java.util.*; 

public class Testing {
    public static void main(String[] args) throws InterruptedException{
        World w = new World(new Waktu());
        Menu m = new Menu();
        Point p1 = new Point(30, 30); 
        Point p2 = new Point(0, 0); 

        Rumah r1 = new Rumah(p1);
        Rumah r2 = new Rumah(p2);  
        
        Scanner sc = new Scanner(System.in); 
        w.addSim(sc, "init");
        m.viewSimInfo(w);

        Sim s1 = World.getCurrentSim(); 

        w.getWaktu().displayWaktu();
        BahanMakanan b = new BahanMakanan("Nasi");
        BahanMakanan aaa = new BahanMakanan("Nasi");

        BahanMakanan b2 = new BahanMakanan("Ayam");
        BahanMakanan b3 = new BahanMakanan("Sapi");
        BahanMakanan b4 = new BahanMakanan("Kentang");

        Kiriman bb = new Kiriman(b, s1, 10);

        w.getWaktu().displayWaktu();
        World.getCurrentSim().testAction(820);
        w.getWaktu().displayWaktu();

        m.viewSimInfo(w);
    }
        
}
