package com.simplicity;

import java.util.*;

public class Rumah {
    private HashMap<Point, Ruangan> daftarRuangan = new HashMap<Point, Ruangan>();
    int x = 0;
    int y = 0;
    Point defaultPoint = new Point(x, y);
    private Ruangan currRuangan = daftarRuangan.get(defaultPoint);
    private Point lokasi;
    private String owner;

    public Rumah(Point lokasi, String owner) {
        setLokasi(lokasi);
        this.owner = owner;
    }
    public HashMap<Point, Ruangan> getDaftarRuangan() {
        return this.daftarRuangan;
    }

    public String getNamaCurrRuangan() {
        return this.currRuangan.getNama();
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

    public boolean containsRuangan (String namaRuangan) {
        boolean valid;
        valid = false;
        for (Map.Entry<Point, Ruangan> entry : this.daftarRuangan.entrySet()) {
            if (entry.getValue().getNama().equals(namaRuangan)) {
                valid = true;
                break;
            }
        }
        return valid;
    }

    public void upgradeRumah() {
        int x;
        int y;
        boolean valid = true;
        int initialX = 0;
        int initialY = 0;
        Point locAcuan = new Point(initialX, initialY);
        this.displayDaftarRuangan();
        Scanner input = new Scanner(System.in);
        if (daftarRuangan.size() > 1) {
            do {
                System.out.print("Masukkan ruangan acuan: ");
                String pilihRuangan = input.next();
                if (!containsRuangan(pilihRuangan)) {
                    valid = false;
                    System.out.println("Ruangan tidak tersedia, silakan coba lagi!");
                } else {
                    valid = true;
                }
                for (Map.Entry<Point, Ruangan> entry : this.daftarRuangan.entrySet()) {
                    if (entry.getValue().getNama().equals(pilihRuangan)) {
                        locAcuan = entry.getKey();
                    }
                }
            } while(!valid);
        }
        System.out.print("Masukkan nama ruangan yang ingin ditambahkan: ");
        String namaRuangan = input.next();
        System.out.print("Masukkan lokasi ruangan (ATAS/BAWAH/KANAN/KIRI): ");
        String pilihLokasi = input.next();
        if (pilihLokasi.equals("ATAS")) {
            x = locAcuan.getX();
            y = locAcuan.getY()+1;
            Point locRuangan = new Point(x, y);
            if (!isAvailable(locRuangan)) {
                Ruangan ruangan = new Ruangan(namaRuangan);
                daftarRuangan.put(locRuangan, ruangan);
            } else {
                valid = false;
            }
        } else if (pilihLokasi.equals("BAWAH")) {
            x = locAcuan.getX();
            y = locAcuan.getY()-1;
            Point locRuangan = new Point(x, y);
            if (!isAvailable(locRuangan)) {
                Ruangan ruangan = new Ruangan(namaRuangan);
                daftarRuangan.put(locRuangan, ruangan);
            } else {
                valid = false;
            }
        } else if (pilihLokasi.equals("KANAN")) {
            x = locAcuan.getX()+1;
            y = locAcuan.getY();
            Point locRuangan = new Point(x, y);
            if (!isAvailable(locRuangan)) {
                Ruangan ruangan = new Ruangan(namaRuangan);
                daftarRuangan.put(locRuangan, ruangan);
            } else {
                valid = false;
            }
        } else if (pilihLokasi.equals("KIRI")) {
            x = locAcuan.getX()-1;
            y = locAcuan.getY();
            Point locRuangan = new Point(x, y);
            if (!isAvailable(locRuangan)) {
                Ruangan ruangan = new Ruangan(namaRuangan);
                daftarRuangan.put(locRuangan, ruangan);
            } else {
                valid = false;
            }
        } else {
            valid = false;
        }
        if (valid) {
            System.out.println("Ruangan berhasil ditambahkan!");
            this.displayDaftarRuangan();
        } else {
            System.out.println("Ruangan tidak bisa ditambahkan!");
        }
    }

    public void pindahRuangan() {
        boolean avail = false;
        this.displayDaftarRuangan();
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan ruangan yang ingin dituju: ");
        String pilihRuangan = input.next();
        for (Map.Entry<Point, Ruangan> entry : this.daftarRuangan.entrySet()) {
            if (entry.getValue().getNama().equals(pilihRuangan)) {
                this.currRuangan = entry.getValue();
                avail = true;
            }
        }
        if (avail) {
            System.out.println("Sekarang Sim sudah berada di " + this.currRuangan.getNama() + "!");
        } else {
            System.out.println("Ruangan yang dipilih tidak tersedia!");
        }
    }

    public String getOwner() {
        return owner;
    }
}