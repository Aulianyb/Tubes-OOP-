package com.simplicity;

import java.util.*;

public class Rumah {
    private HashMap<Point, Ruangan> daftarRuangan = new HashMap<Point, Ruangan>();
    private Point lokasi;
    private String owner;

    public Rumah(Point lokasi, String owner) {
        setLokasi(lokasi);
        this.owner = owner;
    }
    public HashMap<Point, Ruangan> getDaftarRuangan() {
        return this.daftarRuangan;
    }

    public Point getLokasi() {
        return this.lokasi;
    }

    public void setLokasi(Point lokasi) {
        this.lokasi = lokasi;
    }

    public void displayDaftarRuangan() {
        int i = 1;
        for (Map.Entry<Point, Ruangan> entry : this.daftarRuangan.entrySet()) {
            System.out.println(i + ". <" + entry.getKey() + ", " + entry.getValue().getNama() + ">");
            i++;
        }
    }

    public boolean isAvailable(Point lokasi) {
        return daftarRuangan.containsKey(lokasi);
    }

    public void upgradeRumah(Point lokasi, Ruangan ruangan) {
        int x = 0;
        int y = 0;
        Point locRuangan = new Point(x, y);
        if (daftarRuangan.size() > 1) {
            this.displayDaftarRuangan();
            Scanner input = new Scanner(System.in);
            String pilihRuangan = input.next();
            input.close();
            for (Map.Entry<Point, Ruangan> entry : this.daftarRuangan.entrySet()) {
                if (entry.getValue().getNama().equals(pilihRuangan)) {
                    locRuangan = entry.getKey();
                }
            }
            if (((lokasi.getX() == locRuangan.getX()+1 || lokasi.getX() == locRuangan.getX()-1) && lokasi.getY() == 0 && !isAvailable(lokasi)) || ((lokasi.getY() == locRuangan.getY()+1 || lokasi.getY() == locRuangan.getY()-1) && lokasi.getX() == 0 && !isAvailable(lokasi))) {
                daftarRuangan.put(lokasi, ruangan);
            } else {
                System.out.println("Ruangan tidak bisa ditambahkan");
            }
        }
    }

    public void pindahRuangan(Ruangan ruangan) {
        // to do
    }

    public String getOwner() {
        return owner;
    }
}