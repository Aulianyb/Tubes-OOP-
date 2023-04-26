package com.simplicity;

public class Testing {
    public static void main(String[] args) throws InterruptedException{
        Sim s1 = new Sim("Default"); 
        Sim s2 = new Sim("Kawan"); 
        s2.setMood(100);
        // System.out.println(s1.getPekerjaan().getPekerjaan());
        System.out.println("STATUS S1");
        System.out.println(s1.getKesehatan());
        System.out.println(s1.getKekeyangan());
        System.out.println(s1.getMood());
        System.out.println(s1.getUang());
        // System.out.println("STATUS S2");
        // System.out.println(s1.getKesehatan());
        // System.out.println(s2.getKekeyangan());
        // System.out.println(s2.getMood());
        // System.out.println(s2.getUang());

        Waktu w = new Waktu(0, 0, 120); 
        Waktu w2 = new Waktu(0, 0, 40); 

        // s1.olahraga(w);
        Point p1 = new Point(2, 2); 
        Point p2 = new Point(0, 0); 

        Rumah r1 = new Rumah(p1, s1.getNama());
        Rumah r2 = new Rumah(p2, s1.getNama());  
  
        // s1.berkelahi(s2);
        // s1.monolog(w);
        s1.lelucon(s2);
        System.out.println("STATUS S1");
        System.out.println(s1.getKesehatan());
        System.out.println(s1.getKekeyangan());
        System.out.println(s1.getMood());
        System.out.println(s1.getUang());
        // System.out.println("STATUS S2");
        // System.out.println(s2.getKekeyangan());
        // System.out.println(s2.getMood());
        // System.out.println(s2.getUang());
  
        // s1.berkunjung(r2, w);

        // s1.getInventory().lihatInventory();
        // BahanMakanan m = new BahanMakanan("Nasi");
        // s1.beliBarang(m, 2);
        // // s1.olahraga(w);
        // s1.meditasi(w);

        // s1.getInventory().lihatInventory();

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
