package com.simplicity;
import java.util.*;

public class Rumah {
    private HashMap<Point, Ruangan> daftarRuangan = new HashMap<Point, Ruangan>();
    private Ruangan currRuangan;
    private Point lokasi;
    private String owner;
    private String namaRuangan; 
    private Point locRuangan; 
    private String ongoingUpgrade; 
    private boolean upgrading; 

    public Rumah(Point lokasi) {
        Point defaultPoint = new Point(0, 0);
        this.currRuangan = new Ruangan();
        daftarRuangan.put(defaultPoint, this.currRuangan);
        this.lokasi = lokasi;
        upgrading = false; 
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
        System.out.println("Daftar ruangan dalam rumah: ");
        for (Map.Entry<Point, Ruangan> entry : this.daftarRuangan.entrySet()) {
            //ini getKey kenapa ya :'v uhhhh ngebug
            System.out.println(i + ". <" + entry.getKey().displayPoint() + ", " + entry.getValue().getNama() + ">");
            i++;
        }
    }

    public boolean isAvailable(Point lokasi) {
        return daftarRuangan.containsKey(lokasi);
    }

    public boolean containsRuangan(String namaRuangan) {
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
            } while (!valid);
        }
        System.out.print("Masukkan nama ruangan yang ingin ditambahkan: ");
        namaRuangan = input.next();
        System.out.print("Masukkan lokasi ruangan (ATAS/BAWAH/KANAN/KIRI): ");
        ongoingUpgrade = input.next();
        if (ongoingUpgrade.equals("ATAS")) {
            x = locAcuan.getX();
            y = locAcuan.getY() + 1;
            locRuangan = new Point(x, y);
            if (isAvailable(locRuangan)) {
                valid = false;
            }
        } else if (ongoingUpgrade.equals("BAWAH")) {
            x = locAcuan.getX();
            y = locAcuan.getY() - 1;
            locRuangan = new Point(x, y);
            if (isAvailable(locRuangan)) {
                valid = false;
            }
        } else if (ongoingUpgrade.equals("KANAN")) {
            x = locAcuan.getX() + 1;
            y = locAcuan.getY();
            locRuangan = new Point(x, y);
            if (isAvailable(locRuangan)) {
                valid = false;
            } 
        } else if (ongoingUpgrade.equals("KIRI")) {
            x = locAcuan.getX() - 1;
            y = locAcuan.getY();
            locRuangan = new Point(x, y);
            if (isAvailable(locRuangan)) {
                valid = false;
            }
        } else {
            valid = false;
        }
        if (valid) {
            System.out.println("[NOTICE UPGRADE] Proses upgrade rumah dimulai!");
            upgrading = true; 
            Waktu.addUpgrade(this);
        } else {
            System.out.println("[NOTICE UPGRADE] Ruangan tidak bisa ditambahkan!");
        }
    }

    public void implementUpgrade(){
        Ruangan ruangan = new Ruangan(namaRuangan);
        daftarRuangan.put(locRuangan, ruangan);
        System.out.println("[NOTICE UPGRADE] Ruangan berhasil ditambahkan!");
        upgrading = false;
        this.displayDaftarRuangan();
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

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Ruangan getCurrRuangan() {
        return currRuangan;
    }

    public boolean getUpgradeStatus(){
        return upgrading; 
    }
}