package com.simplicity;

public class Testing {
    public static void main(String[] args){
        Sim s1 = new Sim("Default"); 
        s1.setPekerjaan("Dokter");
        System.out.println(s1.getPekerjaan().getGaji()); 
    }
}
