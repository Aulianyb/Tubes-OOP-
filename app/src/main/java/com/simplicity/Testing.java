package com.simplicity;

public class Testing {
    public static void main(String[] args){
        Sim s1 = new Sim("Default"); 
        System.out.println(s1.getKekeyangan());
        System.out.println(s1.getMood());
        System.out.println(s1.getUang());
        
        s1.getInventory().lihatInventory();
        Makanan m = new Makanan("Apel");
        s1.getInventory().reduceItem(m, 1); 
        s1.getInventory().addItem(m, 5);
        s1.getInventory().addItem(m, 10);
        s1.getInventory().lihatInventory();
        s1.getInventory().reduceItem(m, 5); 
        s1.getInventory().lihatInventory();
        
        Toilet t = new Toilet("toilet");
        s1.getInventory().addItem(t, 10); 
        s1.getInventory().lihatInventory();
        s1.getInventory().reduceItem(t, 5);
        s1.getInventory().lihatInventory();
        s1.getInventory().reduceItem(t, 7);
    
    }
        
}
