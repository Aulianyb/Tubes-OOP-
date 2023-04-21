package com.simplicity;

public class Testing {
    public static void main(String[] args){
        Sim s1 = new Sim("Default"); 
        System.out.println(s1.getKekeyangan());
        System.out.println(s1.getMood());
        System.out.println(s1.getUang());
        
        Waktu w = new Waktu(0, 0, 5); 
        s1.tidur(w);

        System.out.println(s1.getKekeyangan());
        System.out.println(s1.getMood()); 
        System.out.println(s1.getUang());
    }
}
