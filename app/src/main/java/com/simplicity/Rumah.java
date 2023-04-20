package com.simplicity;

import java.util.*;

public class Rumah {
    private List<Ruangan> daftarRuangan = new ArrayList<Ruangan>();
    private Point lokasi;

    public List<Ruangan> getDaftarRuangan() {
        return this.daftarRuangan;
    }

    public Point getLokasi() {
        return this.lokasi;
    }

    public void setLokasi(Point point) {
        this.lokasi = point;
    }

    public void upgradeRumah(Ruangan ruangan) {
        daftarRuangan.add(ruangan);
    }
}