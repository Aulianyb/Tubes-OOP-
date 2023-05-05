package com.simplicity;
import java.util.*; 

public class Testing {
    public static void main(String[] args) throws InterruptedException{
        World w = new World(new Waktu());
        Menu m = new Menu();
        Point p1 = new Point(30, 30); 
        Point p2 = new Point(0, 0); 
        TimeThread t = TimeThread.getInstance(); 
        Thread th = new Thread(t); 
        th.start();
        // t.pause();

        Rumah r1 = new Rumah(p1);
        Rumah r2 = new Rumah(p2);  
        
        Scanner sc = new Scanner(System.in); 
        w.addSim(sc, "init");
        // w.addSim(sc, "");

        m.viewSimInfo(w);

        Sim s1 = World.getCurrentSim(); 
        BahanMakanan b = new BahanMakanan("Nasi");
        BahanMakanan b1 = new BahanMakanan("Nasi");
        BahanMakanan b2 = new BahanMakanan("Ayam");
        BahanMakanan b3 = new BahanMakanan("Sapi");
        BahanMakanan b4 = new BahanMakanan("Kentang");
       
        TimeThread.getInstance().pause();
        s1.beliBarang(b, 2);
        s1.beliBarang(b2, 2);
        s1.beliBarang(b3, 2);  
        // Kompor kompor = new Kompor("kompor"); 
        Waktu.displayPengiriman();  
        s1.daydreaming();
        Waktu.displayPengiriman();  
        s1.daydreaming();
        Waktu.displayPengiriman();  
        s1.getInventory().lihatInventory();


        // Waktu.displayUpgrade();
        // s1.getStatus().displayStatus(s1);  

        // s1.testAction(1100);
        // kompor.masak(s1);

    }
        
}
