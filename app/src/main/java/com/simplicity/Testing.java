package com.simplicity;

public class Testing {
    public static void main(String[] args) throws InterruptedException{
        Waktu w = new Waktu(0, 0, 0); 
        Menu m = new Menu(); 
        // s1.olahraga(w);
        Point p1 = new Point(30, 30); 
        Point p2 = new Point(0, 0); 

        Rumah r1 = new Rumah(p1);
        Rumah r2 = new Rumah(p2);  
        Sim s1 = new Sim("Default", r1); 
        Sim s2 = new Sim("Kawan", r2); 
        m.viewSimInfo(s1);

        w.displayWaktu();
        BahanMakanan b = new BahanMakanan("Nasi");
        s1.beliBarang(b, 1);
        s1.olahraga(20);
        w.displayWaktu();

        m.viewSimInfo(s1);

    
    }
        
}
