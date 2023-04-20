package com.simplicity;

public class Testing {
    public static void main(String[] args){
        Sim s1 = new Sim("Default"); 
        System.out.println(s1.getKekeyangan());
        System.out.println(s1.getMood());
        System.out.println(s1.getUang());
        s1.getPekerjaan().kerja(s1, null);
        System.out.println(s1.getKekeyangan());
        System.out.println(s1.getMood()); 
        System.out.println(s1.getUang());
    }
}
