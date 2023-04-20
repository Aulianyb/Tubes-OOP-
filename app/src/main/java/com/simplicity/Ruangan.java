package com.simplicity;
import java.util.*;

public class Ruangan {
    private String namaRuangan;
    private int panjang = 6;
    private int lebar = 6;
    // private List<Furnitur> objekList = new ArrayList<Furnitur>();
    // private HashMap<Point, Furnitur> objekLoc = new ArrayList<Point<Integer, Integer>();

    public Ruangan(String namaRuangan) {
        this.namaRuangan = namaRuangan;
    }

    public String getNama() {
        return this.namaRuangan;
    }

    public int getPanjang() {
        return this.panjang;
    }

    public int getLebar() {
        return this.lebar;
    }

    public int getLuas() {
        return(this.panjang*this.lebar);
    }

    // public void addObjek(Furnitur furnitur, Point location) {}

    // public void removeObjek(Furnitur furnitur) {}
}
