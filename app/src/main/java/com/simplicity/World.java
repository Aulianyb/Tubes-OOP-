package com.simplicity;
import java.util.*;

public class World {
    private int panjang = 64;
    private int lebar = 64;
    private HashMap<Point, Rumah> rumahList = new HashMap<Point, Rumah>();
    private Waktu waktu;

    public World(Waktu waktu) {
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

    public void addRumah(Point lokasi, Rumah rumah) {
        rumahList.put(lokasi, rumah);
    }
}