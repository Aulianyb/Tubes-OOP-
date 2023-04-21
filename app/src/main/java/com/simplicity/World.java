package com.simplicity;
import java.util.*;

public class World {
    private final int panjang = 64;
    private final int lebar = 64;
    private HashMap<Point, Rumah> rumahList;
    private Waktu waktu;

    public World(Waktu waktu) {
        rumahList = new HashMap<>();
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

    public void addRumah(String owner) {
        int x = 0;
        int y = 0;
        Point loc = new Point(x,y);
        Random rand = new Random();
        while(isAvailable(loc)) {
            loc.setX(rand.nextInt(64));
            loc.setY(rand.nextInt(64));
        }
        Rumah rumah = new Rumah(loc,owner);
        rumahList.put(loc, rumah);
    }

    public boolean isAvailable(Point loc) {
        return rumahList.containsKey(loc);
    }

    public void displayWorld() {
        for(Point key: rumahList.keySet()) {
            System.out.printf("%s : %s's house%n",key, rumahList.get(key).getOwner());
        }
    }
}