package com.simplicity;
import java.util.*;

public class Ruangan {
    private String namaRuangan;
    private String[][] matrixRuangan;
    private final int panjang = 6;
    private final int lebar = 6;
    private HashMap<Point, String> daftarObjek = new HashMap<Point, String>();
    private HashMap<Furnitur, Integer> jumlahObjek = new HashMap<Furnitur, Integer>();

    private Furnitur currFurnitur;
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
        Toilet toilet = new Toilet("Toilet1");
        matrixRuangan[5][5] = toilet.getNamaObjek();
        daftarObjek.put(locToilet, toilet.getNamaObjek());
        jumlahObjek.put(toilet, 1);
        // Default jam
        Point locJam = new Point(3, 0);
        Jam jam = new Jam("Jam1");
        matrixRuangan[3][0] = "Jam1";
        daftarObjek.put(locJam, jam.getNamaObjek());
        jumlahObjek.put(jam, 1);
        // Default kompor
        Point locKompor1 = new Point(1, 0);
        Point locKompor2 = new Point(2, 0);
        Kompor kompor = new Kompor("Kompor1");
        for (int x = 1; x < 3; x++) {
            for (int y = 0; y < 1; y++) {
                matrixRuangan[x][y] = kompor.getNamaObjek();
            }
        }
        daftarObjek.put(locKompor1, kompor.getNamaObjek());
        daftarObjek.put(locKompor2, kompor.getNamaObjek());
        jumlahObjek.put(kompor, 1);
        // Default kasur single
        Point locKasurSingle1 = new Point(5, 0);
        Point locKasurSingle2 = new Point(5, 1);
        Point locKasurSingle3 = new Point(5, 2);
        Point locKasurSingle4 = new Point(5, 3);
        KasurSingle kasurSingle =  new KasurSingle("KasurSingle1");
        for (int x = 5; x < 6; x++) {
            for (int y = 0; y < 4; y++) {
                matrixRuangan[x][y] = kasurSingle.getNamaObjek();
            }
        }
        daftarObjek.put(locKasurSingle1, kasurSingle.getNamaObjek());
        daftarObjek.put(locKasurSingle2, kasurSingle.getNamaObjek());
        daftarObjek.put(locKasurSingle3, kasurSingle.getNamaObjek());
        daftarObjek.put(locKasurSingle4, kasurSingle.getNamaObjek());
        jumlahObjek.put(kasurSingle, 1);
        // Default meja dan kursi makan
        Point locMejaKursi1 = new Point(1, 2);
        Point locMejaKursi2 = new Point(1, 3);
        Point locMejaKursi3 = new Point(1, 4);
        Point locMejaKursi4 = new Point(2, 2);
        Point locMejaKursi5 = new Point(2, 3);
        Point locMejaKursi6 = new Point(2, 4);
        Point locMejaKursi7 = new Point(3, 2);
        Point locMejaKursi8 = new Point(3, 3);
        Point locMejaKursi9 = new Point(3, 4);
        MejaKursi mejaKursi = new MejaKursi("MejaKursi1");
        for (int x = 1; x < 4; x++) {
            for (int y = 2; y < 5; y++) {
                matrixRuangan[x][y] = mejaKursi.getNamaObjek();
            }
        }
        daftarObjek.put(locMejaKursi1, mejaKursi.getNamaObjek());
        daftarObjek.put(locMejaKursi2, mejaKursi.getNamaObjek());
        daftarObjek.put(locMejaKursi3, mejaKursi.getNamaObjek());
        daftarObjek.put(locMejaKursi4, mejaKursi.getNamaObjek());
        daftarObjek.put(locMejaKursi5, mejaKursi.getNamaObjek());
        daftarObjek.put(locMejaKursi6, mejaKursi.getNamaObjek());
        daftarObjek.put(locMejaKursi7, mejaKursi.getNamaObjek());
        daftarObjek.put(locMejaKursi8, mejaKursi.getNamaObjek());
        daftarObjek.put(locMejaKursi9, mejaKursi.getNamaObjek());
        jumlahObjek.put(mejaKursi, 1);
        currFurnitur = null;
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

    public void displayDaftarObjek() {
        int i = 1;
        System.out.println("Daftar objek dalam ruangan: ");
        for (Map.Entry<Point, String> entry : this.daftarObjek.entrySet()) {
            System.out.println(i + ". <" + entry.getKey() + ", " + entry.getValue() + ">");
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
        String horizontal = "-";
        String vertical = "|";
        for (int y = 0; y < this.panjang; y++) {
            for (int x = 0; x < maxLength+2; x++) {
                horizontal = horizontal + "-";
            }
        }
        System.out.println(horizontal + "-");
        for (int y = 0; y < this.panjang; y++) {
            for (int x = 0; x < this.lebar; x++) {
                String cell = matrixRuangan[x][y];
                int padding = maxLength - cell.length();
                System.out.print(vertical + " ");
                for (int k=0; k<padding/2; k++) {
                    System.out.print(" ");
                }
                System.out.print(cell);
                for (int z = 0; z < (padding+1)/2; z++) {
                    System.out.print(" ");
                }
            }
            System.out.print(" ");
            System.out.println(vertical);
            System.out.println(horizontal + "-");
        }
    }

    public boolean isAvailable(Point lokasi) {
        return daftarObjek.containsKey(lokasi);
    }

    public boolean cekPoint(int x, int y) {
        return(x>=0 && x<=6 && y>=0 && y<=6);
    }

    public void pasangBarang(Sim currentSim) {
        boolean valid = false;
        String namaBarang;
        Furnitur key = null;
        Scanner input = new Scanner(System.in);
        do {
            currentSim.getInventory().lihatInventory();
            System.out.print("Masukkan nama barang yang ingin dipasang: ");
            namaBarang = input.next();
            for (Map.Entry<Furnitur, Integer> entry : ((Map<Furnitur,Integer>) currentSim.getInventory().getInventoryPeralatan()).entrySet()){
                if (entry.getKey().getNamaObjek().equals(namaBarang)) {
                    key = entry.getKey();
                    valid = true;
                }
            }
            if (!valid) {
                System.out.println("Barang tidak tersedia silahkan coba lagi!");
            }
        } while (!valid);
        if (namaBarang.equals("Toilet")) {
            valid = false;
            int x, y;
            do {
                System.out.println("Masukkan lokasi objek: ");
                System.out.print("x: ");
                x = input.nextInt();
                System.out.print("y: ");
                y = input.nextInt();
                if (cekPoint(x, y)) {
                    valid = true;
                } else {
                    System.out.println("Titik tidak sesuai, coba ulangi!");
                }
            } while (!valid);
            Point locToilet = new Point(x, y);
            if (!isAvailable(locToilet)) {
                int i = 0;
                for (Map.Entry<Point, String> entry : this.daftarObjek.entrySet()) {
                    if (entry.getValue().contains("Toilet")) {
                        i++;
                        break;
                    }
                }
                Toilet toilet = new Toilet(namaBarang+(i+1));
                matrixRuangan[x][y] = toilet.getNamaObjek();
                daftarObjek.put(locToilet, toilet.getNamaObjek());
                jumlahObjek.put(toilet, i+1);
                System.out.println(namaBarang + " berhasil dipasang!");
                currentSim.getInventory().reduceItem(key, 1);
            } else {
                System.out.println("Lokasi tidak tersedia, barang tidak dapat dipasang!");
            }
        }
        if (namaBarang.equals("KomporListrik")) {
            valid = false;
            int x, y;
            do {
                System.out.println("Masukkan lokasi objek: ");
                System.out.print("x: ");
                x = input.nextInt();
                System.out.print("y: ");
                y = input.nextInt();
                if (cekPoint(x, y)) {
                    valid = true;
                } else {
                    System.out.println("Titik tidak sesuai, coba ulangi!");
                }
            } while (!valid);
            Point locKomporListrik = new Point(x, y);
            if (!isAvailable(locKomporListrik)) {
                int i = 0;
                for (Map.Entry<Point, String> entry : this.daftarObjek.entrySet()) {
                    if (entry.getValue().contains("KomporListrik")) {
                        i++;
                        break;
                    }
                }
                KomporListrik komporListrik = new KomporListrik(namaBarang+(i+1));
                matrixRuangan[x][y] = komporListrik.getNamaObjek();
                daftarObjek.put(locKomporListrik, komporListrik.getNamaObjek());
                jumlahObjek.put(komporListrik, i+1);
                System.out.println(namaBarang + " berhasil dipasang!");
                currentSim.getInventory().reduceItem(key, 1);
            } else {
                System.out.println("Lokasi tidak tersedia, barang tidak dapat dipasang!");
            }
        }
        if (namaBarang.equals("Jam")) {
            valid = false;
            int x, y;
            do {
                System.out.println("Masukkan lokasi objek: ");
                System.out.print("x: ");
                x = input.nextInt();
                System.out.print("y: ");
                y = input.nextInt();
                if (cekPoint(x, y)) {
                    valid = true;
                } else {
                    System.out.println("Titik tidak sesuai, coba ulangi!");
                }
            } while (!valid);
            Point locJam = new Point(x, y);
            if (!isAvailable(locJam)) {
                int i = 0;
                for (Map.Entry<Point, String> entry : this.daftarObjek.entrySet()) {
                    if (entry.getValue().contains("Jam")) {
                        i++;
                        break;
                    }
                }
                Jam jam = new Jam(namaBarang+(i+1));
                matrixRuangan[x][y] = jam.getNamaObjek();
                daftarObjek.put(locJam, jam.getNamaObjek());
                jumlahObjek.put(jam, i+1);
                System.out.println(namaBarang + " berhasil dipasang!");
                currentSim.getInventory().reduceItem(key, 1);
            } else {
                System.out.println("Lokasi tidak tersedia, barang tidak dapat dipasang!");
            }
        }
        if (namaBarang.equals("KasurSingle")) {
            valid = false;
            int x1, y1, x2, y2;
            do {
                System.out.println("Masukkan lokasi objek (titik awal): ");
                System.out.print("x: ");
                x1 = input.nextInt();
                System.out.print("y: ");
                y1 = input.nextInt();
                System.out.println("Masukkan lokasi objek (titik akhir): ");
                System.out.print("x: ");
                x2 = input.nextInt();
                System.out.print("y: ");
                y2 = input.nextInt();
                if (((x2 == x1+3 && y1 == y2) || (y2 == y1+3 && x1 == x2) || (x2 == x1-3 && y1 == y2) || (y2 == y1+3 && x1 == x2)) && cekPoint(x1, y1) && cekPoint(x2, y2)) {
                    valid = true;
                } else {
                    System.out.println("Titik tidak sesuai, coba ulangi!");
                }
            } while (!valid);
            Point locKasurSingle1 = new Point(x1, y1);
            Point locKasurSingle4 = new Point(x2, y2);
            Point locKasurSingle2;
            Point locKasurSingle3;
            if (x2 == x1+3) {
                locKasurSingle2 = new Point(x1+1, y1);
                locKasurSingle3 = new Point(x1+2, y2);
            } else if (x2 == x1-3) {
                locKasurSingle2 = new Point(x1-1, y1);
                locKasurSingle3 = new Point(x1-2, y2);
            } else if (y2 == y1+3) {
                locKasurSingle2 = new Point(x1, y1+1);
                locKasurSingle3 = new Point(x2, y1+2);
            } else {
                locKasurSingle2 = new Point(x1, y1-1);
                locKasurSingle3 = new Point(x2, y2-2);
            }
            if (!isAvailable(locKasurSingle1) && !isAvailable(locKasurSingle2) && !isAvailable(locKasurSingle3) && !isAvailable(locKasurSingle4)) {
                int i = 0;
                for (Map.Entry<Point, String> entry : this.daftarObjek.entrySet()) {
                    if (entry.getValue().contains("KasurSingle")) {
                        i++;
                        break;
                    }
                }
                KasurSingle kasurSingle = new KasurSingle(namaBarang+(i+1));
                if (x1<=x2 && y1<=y2) {
                    for (int a = x1; a < x2+1; a++) {
                        for (int b = y1; b < y2+1; b++) {
                            matrixRuangan[a][b] = kasurSingle.getNamaObjek();
                        }
                    }
                } else if (x1<=x2 && y1>y2) {
                    for (int a = x1; a < x2+1; a++) {
                        for (int b = y2; b < y1+1; b++) {
                            matrixRuangan[a][b] = kasurSingle.getNamaObjek();
                        }
                    }
                } else if (x1>x2 && y1<=y2) {
                    for (int a = x2; a < x1+1; a++) {
                        for (int b = y1; b < y2+1; b++) {
                            matrixRuangan[a][b] = kasurSingle.getNamaObjek();
                        }
                    }
                } else {
                    for (int a = x2; a < x1+1; a++) {
                        for (int b = y2; b < y1+1; b++) {
                            matrixRuangan[a][b] = kasurSingle.getNamaObjek();
                        }
                    }
                }
                daftarObjek.put(locKasurSingle1, kasurSingle.getNamaObjek());
                daftarObjek.put(locKasurSingle2, kasurSingle.getNamaObjek());
                daftarObjek.put(locKasurSingle3, kasurSingle.getNamaObjek());
                daftarObjek.put(locKasurSingle4, kasurSingle.getNamaObjek());
                jumlahObjek.put(kasurSingle, i+1);
                System.out.println(namaBarang + " berhasil dipasang!");
                currentSim.getInventory().reduceItem(key, 1);
            } else {
                System.out.println("Lokasi tidak tersedia, barang tidak dapat dipasang!");
            }
        }
        if (namaBarang.equals("KomporGas")) {
            valid = false;
            int x1, y1, x2, y2;
            do {
                System.out.println("Masukkan lokasi objek (titik awal): ");
                System.out.print("x: ");
                x1 = input.nextInt();
                System.out.print("y: ");
                y1 = input.nextInt();
                System.out.println("Masukkan lokasi objek (titik akhir): ");
                System.out.print("x: ");
                x2 = input.nextInt();
                System.out.print("y: ");
                y2 = input.nextInt();
                if ((x2 == x1+1 || y2 == y1+1 || x2 == x1-1 || y2 == y1-1) && cekPoint(x1, y1) && cekPoint(x2, y2)) {
                    valid = true;
                } else {
                    System.out.println("Titik tidak sesuai dengan dimensi!");
                }
            } while (!valid);
            Point locKomporGas1 = new Point(x1, y1);
            Point locKomporGas2 = new Point(x2, y2);
            if (!isAvailable(locKomporGas1) && !isAvailable(locKomporGas2)) {
                int i = 0;
                for (Map.Entry<Point, String> entry : this.daftarObjek.entrySet()) {
                    if (entry.getValue().contains("KomporGas")) {
                        i++;
                        break;
                    }
                }
                KomporGas komporGas = new KomporGas(namaBarang+(i+1));
                if (x1<=x2 && y1<=y2) {
                    for (int a = x1; a < x2+1; a++) {
                        for (int b = y1; b < y2+1; b++) {
                            matrixRuangan[a][b] = komporGas.getNamaObjek();
                        }
                    }
                } else if (x1<=x2 && y1>y2) {
                    for (int a = x1; a < x2+1; a++) {
                        for (int b = y2; b < y1+1; b++) {
                            matrixRuangan[a][b] = komporGas.getNamaObjek();
                        }
                    }
                } else if (x1>x2 && y1<=y2) {
                    for (int a = x2; a < x1+1; a++) {
                        for (int b = y1; b < y2+1; b++) {
                            matrixRuangan[a][b] = komporGas.getNamaObjek();
                        }
                    }
                } else {
                    for (int a = x2; a < x1+1; a++) {
                        for (int b = y2; b < y1+1; b++) {
                            matrixRuangan[a][b] = komporGas.getNamaObjek();
                        }
                    }
                }
                daftarObjek.put(locKomporGas1, komporGas.getNamaObjek());
                daftarObjek.put(locKomporGas2, komporGas.getNamaObjek());
                jumlahObjek.put(komporGas, i+1);
                System.out.println(namaBarang + " berhasil dipasang!");
                currentSim.getInventory().reduceItem(key, 1);
            } else {
                System.out.println("Lokasi tidak tersedia, barang tidak dapat dipasang!");
            }
        }
        if (namaBarang.equals("KasurQueenSize")) {
            valid = false;
            int x1, y1, x2, y2, x3, y3, x4, y4;
            do {
                System.out.println("Masukkan lokasi objek (titik kiri atas): ");
                System.out.print("x: ");
                x1 = input.nextInt();
                System.out.print("y: ");
                y1 = input.nextInt();
                System.out.println("Masukkan lokasi objek (titik kanan atas): ");
                System.out.print("x: ");
                x2 = input.nextInt();
                System.out.print("y: ");
                y2 = input.nextInt();
                System.out.println("Masukkan lokasi objek (titik kiri bawah): ");
                System.out.print("x: ");
                x3 = input.nextInt();
                System.out.print("y: ");
                y3 = input.nextInt();
                System.out.println("Masukkan lokasi objek (titik kanan bawah): ");
                System.out.print("x: ");
                x4 = input.nextInt();
                System.out.print("y: ");
                y4 = input.nextInt();
                if ((x2 == x1+3 && y3 == y1+1 && x4 == x3+3 && y4 == y2+1) || (x2 == x1+1 && y3 == y1+3 && x4 == x3+1 && y4 == y2+3) && cekPoint(x1, y1) && cekPoint(x2, y2) && cekPoint(x3, y3) && cekPoint(x4, y4)) {
                    valid = true;
                } else {
                    System.out.println("Titik tidak sesuai, coba ulangi!");
                }
            } while (!valid);
            Point locKasurQueenSize1 = new Point(x1, y1);
            Point locKasurQueenSize4 = new Point(x2, y2);
            Point locKasurQueenSize5 = new Point(x3, y3);
            Point locKasurQueenSize8 = new Point(x4, y4);
            Point locKasurQueenSize2;
            Point locKasurQueenSize3;
            Point locKasurQueenSize6;
            Point locKasurQueenSize7;
            if (x2 == x1+3 && y3 == y1+1 && x4 == x3+3 && y4 == y2+1) {
                locKasurQueenSize2 = new Point(x1+1, y1);
                locKasurQueenSize3 = new Point(x1+2, y1);
                locKasurQueenSize6 = new Point(x1+1, y1+1);
                locKasurQueenSize7 = new Point(x1+2, y1+1);
            } else {
                locKasurQueenSize2 = new Point(x1, y1+1);
                locKasurQueenSize3 = new Point(x1, y1+2);
                locKasurQueenSize6 = new Point(x1+1, y1+1);
                locKasurQueenSize7 = new Point(x1+1, y1+2);
            }
            if (!isAvailable(locKasurQueenSize1) && !isAvailable(locKasurQueenSize2) && !isAvailable(locKasurQueenSize3) && !isAvailable(locKasurQueenSize4) && !isAvailable(locKasurQueenSize5) && !isAvailable(locKasurQueenSize6) && !isAvailable(locKasurQueenSize7) && !isAvailable(locKasurQueenSize8)) {
                int i = 0;
                for (Map.Entry<Point, String> entry : this.daftarObjek.entrySet()) {
                    if (entry.getValue().contains("KasurQueenSize")) {
                        i++;
                        break;
                    }
                }
                KasurQueenSize kasurQueenSize = new KasurQueenSize(namaBarang+(i+1));
                for (int a = x1; a < x4+1; a++) {
                    for (int b = y1; b < y4+1; b++) {
                        matrixRuangan[a][b] = kasurQueenSize.getNamaObjek();
                    }
                }
                daftarObjek.put(locKasurQueenSize1, kasurQueenSize.getNamaObjek());
                daftarObjek.put(locKasurQueenSize2, kasurQueenSize.getNamaObjek());
                daftarObjek.put(locKasurQueenSize3, kasurQueenSize.getNamaObjek());
                daftarObjek.put(locKasurQueenSize4, kasurQueenSize.getNamaObjek());
                daftarObjek.put(locKasurQueenSize5, kasurQueenSize.getNamaObjek());
                daftarObjek.put(locKasurQueenSize6, kasurQueenSize.getNamaObjek());
                daftarObjek.put(locKasurQueenSize7, kasurQueenSize.getNamaObjek());
                daftarObjek.put(locKasurQueenSize8, kasurQueenSize.getNamaObjek());
                jumlahObjek.put(kasurQueenSize, i+1);
                System.out.println(namaBarang + " berhasil dipasang!");
                currentSim.getInventory().reduceItem(key, 1);
            } else {
                System.out.println("Lokasi tidak tersedia, barang tidak dapat dipasang!");
            }
        }
        if (namaBarang.equals("KasurKingSize")) {
            valid = false;
            int x1, y1, x2, y2, x3, y3, x4, y4;
            do {
                System.out.println("Masukkan lokasi objek (titik kiri atas): ");
                System.out.print("x: ");
                x1 = input.nextInt();
                System.out.print("y: ");
                y1 = input.nextInt();
                System.out.println("Masukkan lokasi objek (titik kanan atas): ");
                System.out.print("x: ");
                x2 = input.nextInt();
                System.out.print("y: ");
                y2 = input.nextInt();
                System.out.println("Masukkan lokasi objek (titik kiri bawah): ");
                System.out.print("x: ");
                x3 = input.nextInt();
                System.out.print("y: ");
                y3 = input.nextInt();
                System.out.println("Masukkan lokasi objek (titik kanan bawah): ");
                System.out.print("x: ");
                x4 = input.nextInt();
                System.out.print("y: ");
                y4 = input.nextInt();
                if ((x2 == x1+4 && y3 == y1+1 && x4 == x3+4 && y4 == y2+1) || (x2 == x1+1 && y3 == y1+4 && x4 == x3+1 && y4 == y2+4) && cekPoint(x1, y1) && cekPoint(x2, y2) && cekPoint(x3, y3) && cekPoint(x4, y4)) {
                    valid = true;
                } else {
                    System.out.println("Titik tidak sesuai, coba ulangi!");
                }
            } while (!valid);
            Point locKasurKingSize1 = new Point(x1, y1);
            Point locKasurKingSize5 = new Point(x2, y2);
            Point locKasurKingSize6 = new Point(x3, y3);
            Point locKasurKingSize10 = new Point(x4, y4);
            Point locKasurKingSize2;
            Point locKasurKingSize3;
            Point locKasurKingSize4;
            Point locKasurKingSize7;
            Point locKasurKingSize8;
            Point locKasurKingSize9;
            if (x2 == x1+4 && y3 == y1+1 && x4 == x3+4 && y4 == y2+1) {
                locKasurKingSize2 = new Point(x1+1, y1);
                locKasurKingSize3 = new Point(x1+2, y1);
                locKasurKingSize4 = new Point(x1+3, y1);
                locKasurKingSize7 = new Point(x1+1, y1+1);
                locKasurKingSize8 = new Point(x1+2, y1+1);
                locKasurKingSize9 = new Point(x1+3, y1+1);
            } else {
                locKasurKingSize2 = new Point(x1, y1+1);
                locKasurKingSize3 = new Point(x1, y1+2);
                locKasurKingSize4 = new Point(x1, y1+3);
                locKasurKingSize7 = new Point(x1+1, y1+1);
                locKasurKingSize8 = new Point(x1+1, y1+2);
                locKasurKingSize9 = new Point(x1+1, y1+3);
            }
            if (!isAvailable(locKasurKingSize1) && !isAvailable(locKasurKingSize2) && !isAvailable(locKasurKingSize3) && !isAvailable(locKasurKingSize4) && !isAvailable(locKasurKingSize5) && !isAvailable(locKasurKingSize6) && !isAvailable(locKasurKingSize7) && !isAvailable(locKasurKingSize8) && !isAvailable(locKasurKingSize9) && !isAvailable(locKasurKingSize10)) {
                int i = 0;
                for (Map.Entry<Point, String> entry : this.daftarObjek.entrySet()) {
                    if (entry.getValue().contains("KasurKingSize")) {
                        i++;
                        break;
                    }
                }
                KasurKingSize kasurKingSize = new KasurKingSize(namaBarang+(i+1));
                for (int a = x1; a < x4+1; a++) {
                    for (int b = y1; b < y4+1; b++) {
                        matrixRuangan[a][b] = kasurKingSize.getNamaObjek();
                    }
                }
                daftarObjek.put(locKasurKingSize1, kasurKingSize.getNamaObjek());
                daftarObjek.put(locKasurKingSize2, kasurKingSize.getNamaObjek());
                daftarObjek.put(locKasurKingSize3, kasurKingSize.getNamaObjek());
                daftarObjek.put(locKasurKingSize4, kasurKingSize.getNamaObjek());
                daftarObjek.put(locKasurKingSize5, kasurKingSize.getNamaObjek());
                daftarObjek.put(locKasurKingSize6, kasurKingSize.getNamaObjek());
                daftarObjek.put(locKasurKingSize7, kasurKingSize.getNamaObjek());
                daftarObjek.put(locKasurKingSize8, kasurKingSize.getNamaObjek());
                daftarObjek.put(locKasurKingSize9, kasurKingSize.getNamaObjek());
                daftarObjek.put(locKasurKingSize10, kasurKingSize.getNamaObjek());
                jumlahObjek.put(kasurKingSize, i+1);
                System.out.println(namaBarang + " berhasil dipasang!");
                currentSim.getInventory().reduceItem(key, 1);
            } else {
                System.out.println("Lokasi tidak tersedia, barang tidak dapat dipasang!");
            }
        }
        if (namaBarang.equals("MejaKursi")) {
            valid = false;
            int x1, y1, x2, y2, x3, y3, x4, y4;
            do {
                System.out.println("Masukkan lokasi objek (titik kiri atas): ");
                System.out.print("x: ");
                x1 = input.nextInt();
                System.out.print("y: ");
                y1 = input.nextInt();
                System.out.println("Masukkan lokasi objek (titik kanan atas): ");
                System.out.print("x: ");
                x2 = input.nextInt();
                System.out.print("y: ");
                y2 = input.nextInt();
                System.out.println("Masukkan lokasi objek (titik kiri bawah): ");
                System.out.print("x: ");
                x3 = input.nextInt();
                System.out.print("y: ");
                y3 = input.nextInt();
                System.out.println("Masukkan lokasi objek (titik kanan bawah): ");
                System.out.print("x: ");
                x4 = input.nextInt();
                System.out.print("y: ");
                y4 = input.nextInt();
                if ((x2 == x1+2) && (x4 == x3+2) && (y3 == y1+2) && (y4 == y2+2) && cekPoint(x1, y1) && cekPoint(x2, y2) && cekPoint(x3, y3) && cekPoint(x4, y4)) {
                    valid = true;
                } else {
                    System.out.println("Titik tidak sesuai, coba ulangi!");
                }
            } while (!valid);
            Point locMejaKursi1 = new Point(x1, y1);
            Point locMejaKursi9 = new Point(x2, y2);
            Point locMejaKursi2 = new Point(x1+1, y1);
            Point locMejaKursi3 = new Point(x1+2, y1);
            Point locMejaKursi4 = new Point(x1, y1+1);
            Point locMejaKursi5 = new Point(x1, y1+2);
            Point locMejaKursi6 = new Point(x1+1, y1+1);
            Point locMejaKursi7 = new Point(x1+2, y1+1);
            Point locMejaKursi8 = new Point(x1+1, y1+2);
            if (!isAvailable(locMejaKursi1) && !isAvailable(locMejaKursi2) && !isAvailable(locMejaKursi3) && !isAvailable(locMejaKursi4) && !isAvailable(locMejaKursi5)  && !isAvailable(locMejaKursi6) && !isAvailable(locMejaKursi7) && !isAvailable(locMejaKursi8) && !isAvailable(locMejaKursi9)) {
                int i = 0;
                for (Map.Entry<Point, String> entry : this.daftarObjek.entrySet()) {
                    if (entry.getValue().contains("MejaKursi")) {
                        i++;
                        break;
                    }
                }
                MejaKursi mejaKursi = new MejaKursi(namaBarang+(i+1));
                for (int a = x1; a < x4+1; a++) {
                    for (int b = y1; b < y4+1; b++) {
                        matrixRuangan[a][b] = mejaKursi.getNamaObjek();
                    }
                }
                daftarObjek.put(locMejaKursi1, mejaKursi.getNamaObjek());
                daftarObjek.put(locMejaKursi2, mejaKursi.getNamaObjek());
                daftarObjek.put(locMejaKursi3, mejaKursi.getNamaObjek());
                daftarObjek.put(locMejaKursi4, mejaKursi.getNamaObjek());
                daftarObjek.put(locMejaKursi5, mejaKursi.getNamaObjek());
                daftarObjek.put(locMejaKursi6, mejaKursi.getNamaObjek());
                daftarObjek.put(locMejaKursi7, mejaKursi.getNamaObjek());
                daftarObjek.put(locMejaKursi8, mejaKursi.getNamaObjek());
                daftarObjek.put(locMejaKursi9, mejaKursi.getNamaObjek());
                jumlahObjek.put(mejaKursi, i+1);
                System.out.println(namaBarang + " berhasil dipasang!");
                currentSim.getInventory().reduceItem(key, 1);
            } else {
                System.out.println("Lokasi tidak tersedia, barang tidak dapat dipasang!");
            }
        }
    }

    public void move() {
        // belom diliat lagi bentar ya
        Scanner input = new Scanner(System.in);
        System.out.println("Available Object :");
        displayDaftarObjek();
        System.out.println("Pilih objek yang ingin dituju :");
        String obj = input.nextLine();
        boolean found = false;
        for(String furnitur : daftarObjek.values()) {
            if(obj.equals(furnitur)) {
                // currFurnitur = furnitur;
                found = true;
            }
        }
        if(found) {
            System.out.printf("Current object : %s%n", currFurnitur.getNamaObjek());
        } else {
            System.out.println("Objek tidak ada diruangan ini!!");
        }
    }

    public void removeBarang() {
        // otwwww
    }

    public Furnitur getCurrFurnitur() {
        return currFurnitur;
    }
}