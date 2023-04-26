package com.simplicity;
import java.util.*;

public class Ruangan {
    private String namaRuangan;
    private String[][] matrixRuangan;
    private int panjang = 6;
    private int lebar = 6;
    private HashMap<Point, Furnitur> daftarObjek = new HashMap<Point, Furnitur>(); // Point objek mengarah ke titik paling atas kiri objek

    public Ruangan() {
        this.namaRuangan = "Default";
        this.matrixRuangan = new String[panjang][lebar];
        for (int x = 0; x < this.lebar; x++) {
            for (int y = 0; y < this.panjang; y++) {
                this.matrixRuangan[x][y] = "Kosong";
            }
        }
        // Default toilet
        Point locToilet = new Point(5, 5);
        Toilet toilet = new Toilet("Toilet");
        matrixRuangan[5][5] = "Toilet";
        daftarObjek.put(locToilet, toilet);
        // Default jam
        Point locJam = new Point(3, 0);
        Jam jam = new Jam("Jam");
        matrixRuangan[3][0] = "Jam";
        daftarObjek.put(locJam, jam);
        // Default kompor
        Point locKompor = new Point(1, 0);
        Kompor kompor = new Kompor("Kompor");
        for (int x = 1; x < 3; x++) {
            for (int y = 0; y < 1; y++) {
                matrixRuangan[x][y] = "Kompor";
            }
        }
        daftarObjek.put(locKompor, kompor);
        // Default kasur single
        Point locKasurSingle = new Point(5, 0);
        KasurSingle kasurSingle =  new KasurSingle("KasurSingle");
        for (int x = 5; x < 6; x++) {
            for (int y = 0; y < 4; y++) {
                matrixRuangan[x][y] = "KasurSingle";
            }
        }
        daftarObjek.put(locKasurSingle, kasurSingle);
        // Default meja dan kursi makan
        Point locMejaKursi = new Point(1, 2);
        MejaKursi mejaKursi = new MejaKursi("MejaKursi");
        for (int x = 1; x < 4; x++) {
            for (int y = 2; y < 5; y++) {
                matrixRuangan[x][y] = "MejaKursi";
            }
        }
        daftarObjek.put(locMejaKursi, mejaKursi);
    }

    public Ruangan(String namaRuangan) {
        this.namaRuangan = namaRuangan;
        this.matrixRuangan = new String[panjang][lebar];
        for (int x = 0; x < this.lebar; x++) {
            for (int y = 0; y < this.panjang; y++) {
                this.matrixRuangan[x][y] = "Kosong";
            }
        }
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

    public void displayDaftarObjek() {
        int i = 1;
        System.out.println("Daftar objek dalam ruangan: ");
        for (Map.Entry<Point, Furnitur> entry : this.daftarObjek.entrySet()) {
            System.out.println(i + ". <" + entry.getKey() + ", " + entry.getValue().getNamaObjek() + ">");
            i++;
        }
    }

    public void displayRuangan() {
        System.out.println("Tampilan ruangan saat ini: ");
        int maxLength = 0;
        for (int y = 0; y < this.panjang; y++) {
            for (int x = 0; x < this.lebar; x++) {
                if(matrixRuangan[x][y].length() > maxLength) {
                    maxLength = matrixRuangan[x][y].length();
                }
            }
        }
        for (int y = 0; y < this.panjang; y++) {
            for (int x = 0; x < this.lebar; x++) {
                String cell = matrixRuangan[x][y];
                int padding = maxLength - cell.length();
                System.out.print("| ");
                for(int z = 0; z < padding/2; z++) {
                    System.out.print(" ");
                }
                System.out.print(cell);
                for(int z = 0; z < (padding+1)/2; z++) {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
    }

    public void pasangBarang() {

    }

    public void moveBarang() {

    }

    public void removeBarang() {

    }
}