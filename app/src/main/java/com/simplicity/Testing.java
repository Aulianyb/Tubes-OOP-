package com.simplicity;

public class Testing {
    public static void main(String[] args){
        Sim s1 = new Sim("Default"); 
        System.out.println(s1.getPekerjaan().getPekerjaan()); 
        System.out.println(s1.getKekeyangan());
        System.out.println(s1.getMood());
        System.out.println(s1.getUang());
        Waktu w = new Waktu(0, 0, 20); 
        // s1.olahraga(w);
        Point p1 = new Point(2, 2); 
        Point p2 = new Point(0, 0); 

        Rumah r1 = new Rumah(p1, s1.getNama());
        Rumah r2 = new Rumah(p2, s1.getNama());  
        // s1.berkunjung(r2, w);

        // s1.getInventory().lihatInventory();
        BahanMakanan m = new BahanMakanan("Nasi");
        s1.beliBarang(m);
        // s1.getInventory().reduceItem(m, 1); 
        // s1.getInventory().addItem(m, 5);
        // s1.getInventory().addItem(m, 10);
        // s1.getInventory().lihatInventory();
        // s1.getInventory().reduceItem(m, 5); 
        // s1.getInventory().lihatInventory();
        
        // Toilet t = new Toilet("toilet");
        // s1.getInventory().addItem(t, 10); 
        // s1.getInventory().lihatInventory();
        // s1.getInventory().reduceItem(t, 5);
        // s1.getInventory().lihatInventory();
        // s1.getInventory().reduceItem(t, 7);
    
    }
        
}
