package com.simplicity;
import java.util.*;

public class World {
    private int panjang;
    private int lebar;
    private HashMap<Point, Rumah> rumahList = new HashMap<Point, Rumah>();
    private Waktu waktu;

    public World(int panjang, int lebar, Waktu waktu) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.waktu = waktu;
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

    public HashMap<Point, Rumah> getRumahList() {
        return this.rumahList;
    }

    public Waktu getWaktu() {
        return this.waktu;
    }

    public void addRumah(Point location, Rumah rumah) {
        rumahList.put(location, rumah);
    }
}