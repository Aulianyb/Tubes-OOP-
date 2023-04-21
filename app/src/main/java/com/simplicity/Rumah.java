package com.simplicity;

import java.util.*;

public class Rumah {
    private HashMap<Point, Ruangan> daftarRuangan = new HashMap<Point, Ruangan>();
    private Point lokasi;

    public HashMap<Point, Ruangan> getDaftarRuangan() {
        return this.daftarRuangan;
    }

    public Point getLokasi() {
        return this.lokasi;
    }

    public void setLokasi(Point lokasi) {
        this.lokasi = lokasi;
    }

    public void upgradeRumah(Point lokasi, Ruangan ruangan) {
        daftarRuangan.put(lokasi, ruangan);
    }

    public void pindahRuangan(Ruangan ruangan) {
        // to do
    }
}