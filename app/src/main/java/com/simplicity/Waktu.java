package com.simplicity;
import java.util.*;

public class Waktu {
    private int hari; 
    private int jam;
    private int menit;
    private int detik;

    public Waktu(int jam, int menit, int detik) {
        this.jam = jam;
        this.menit = menit;
        this.detik = detik;
        hari = 0; 
    }

    public int getJam() {
        return this.jam;
    }    

    public int getMenit() {
        return this.menit;
    }

    public int getDetik() {
        return this.detik;
    }

    public void setJam(int jam) {
        this.jam = jam;
    }

    public void setMenit(int menit) {
        this.menit = menit;
    }

    public void setDetik (int detik) {
        this.detik = detik;
    }

    public void displayWaktu() {
        if (this.jam<10) {
            System.out.print("0" + this.jam);
        } else {
            System.out.print(this.jam);
        }
        if (this.menit<10) {
            System.out.print(":0" + this.menit);
        } else {
            System.out.print(":" + this.menit);
        }
        if (this.detik<10) {
            System.out.print(":0" + this.detik);
        } else {
            System.out.print(":" + this.detik);
        }
    }
    
    public int toDetik() {
        return((this.jam*3600)+(this.menit*60)+this.detik);
    }
}
