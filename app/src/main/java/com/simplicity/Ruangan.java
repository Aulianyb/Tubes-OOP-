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
        Toilet toilet = new Toilet("Toilet");
        matrixRuangan[5][5] = toilet.getNamaObjek()+1;
        daftarObjek.put(locToilet, toilet.getNamaObjek()+1);
        jumlahObjek.put(toilet, 1);
        // Default jam
        Point locJam = new Point(3, 0);
        Jam jam = new Jam("Jam");
        matrixRuangan[3][0] = jam.getNamaObjek()+1;
        daftarObjek.put(locJam, jam.getNamaObjek()+1);
        jumlahObjek.put(jam, 1);
        // Default kompor
        Point locKompor1 = new Point(1, 0);
        Point locKompor2 = new Point(2, 0);
        Kompor kompor = new Kompor("Kompor");
        for (int x = 1; x < 3; x++) {
            for (int y = 0; y < 1; y++) {
                matrixRuangan[x][y] = kompor.getNamaObjek()+1;
            }
        }
        daftarObjek.put(locKompor1, kompor.getNamaObjek()+1);
        daftarObjek.put(locKompor2, kompor.getNamaObjek()+1);
        jumlahObjek.put(kompor, 1);
        // Default kasur single
        Point locKasurSingle1 = new Point(5, 0);
        Point locKasurSingle2 = new Point(5, 1);
        Point locKasurSingle3 = new Point(5, 2);
        Point locKasurSingle4 = new Point(5, 3);
        KasurSingle kasurSingle =  new KasurSingle("KasurSingle");
        for (int x = 5; x < 6; x++) {
            for (int y = 0; y < 4; y++) {
                matrixRuangan[x][y] = kasurSingle.getNamaObjek()+1;
            }
        }
        daftarObjek.put(locKasurSingle1, kasurSingle.getNamaObjek()+1);
        daftarObjek.put(locKasurSingle2, kasurSingle.getNamaObjek()+1);
        daftarObjek.put(locKasurSingle3, kasurSingle.getNamaObjek()+1);
        daftarObjek.put(locKasurSingle4, kasurSingle.getNamaObjek()+1);
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
        MejaKursi mejaKursi = new MejaKursi("MejaKursi");
        for (int x = 1; x < 4; x++) {
            for (int y = 2; y < 5; y++) {
                matrixRuangan[x][y] = mejaKursi.getNamaObjek()+1;
            }
        }
        daftarObjek.put(locMejaKursi1, mejaKursi.getNamaObjek()+1);
        daftarObjek.put(locMejaKursi2, mejaKursi.getNamaObjek()+1);
        daftarObjek.put(locMejaKursi3, mejaKursi.getNamaObjek()+1);
        daftarObjek.put(locMejaKursi4, mejaKursi.getNamaObjek()+1);
        daftarObjek.put(locMejaKursi5, mejaKursi.getNamaObjek()+1);
        daftarObjek.put(locMejaKursi6, mejaKursi.getNamaObjek()+1);
        daftarObjek.put(locMejaKursi7, mejaKursi.getNamaObjek()+1);
        daftarObjek.put(locMejaKursi8, mejaKursi.getNamaObjek()+1);
        daftarObjek.put(locMejaKursi9, mejaKursi.getNamaObjek()+1);
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
        int j = 1;
        System.out.println("Daftar objek dalam ruangan: ");
        for (Map.Entry<Furnitur, Integer> entry : this.jumlahObjek.entrySet()) {
            for (int i = 1; i < entry.getValue()+1; i++) {
                if (i <= entry.getValue()) {
                    System.out.println(j + ". " + entry.getKey().getNamaObjek()+i);
                }
            }
            j++;
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
            //mungkin ntar pake method yang ada di inventory buat ngecek
            for (Map.Entry<ObjekGame, Integer> entry : ((Map<ObjekGame,Integer>) currentSim.getInventory().getInventory()).entrySet()) {
                if (entry.getKey() instanceof Furnitur) {
                    Furnitur furnitur = (Furnitur) entry.getKey();
                    if (furnitur.getNamaObjek().equals(namaBarang)) {
                        key = furnitur;
                        valid = true;
                    }
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
                Toilet toilet = new Toilet(namaBarang);
                addJumlah(namaBarang);
                int i = jumlahObjek.get(searchBarang(namaBarang));
                matrixRuangan[x][y] = toilet.getNamaObjek()+i;
                daftarObjek.put(locToilet, toilet.getNamaObjek()+i);
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
                KomporListrik komporListrik = new KomporListrik(namaBarang);
                addJumlah(namaBarang);
                int i = jumlahObjek.get(searchBarang(namaBarang));
                matrixRuangan[x][y] = komporListrik.getNamaObjek()+i;
                daftarObjek.put(locKomporListrik, komporListrik.getNamaObjek()+i);
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
                Jam jam = new Jam(namaBarang);
                addJumlah(namaBarang);
                int i = jumlahObjek.get(searchBarang(namaBarang));
                matrixRuangan[x][y] = jam.getNamaObjek()+i;
                daftarObjek.put(locJam, jam.getNamaObjek()+i);
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
                if (((x2 == x1+3 && y1 == y2) || (y2 == y1+3 && x1 == x2) || (x2 == x1-3 && y1 == y2) || (y2 == y1-3 && x1 == x2)) && cekPoint(x1, y1) && cekPoint(x2, y2)) {
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
                KasurSingle kasurSingle = new KasurSingle(namaBarang);
                addJumlah(namaBarang);
                int i = jumlahObjek.get(searchBarang(namaBarang));
                if (x1<=x2 && y1<=y2) {
                    for (int a = x1; a < x2+1; a++) {
                        for (int b = y1; b < y2+1; b++) {
                            matrixRuangan[a][b] = kasurSingle.getNamaObjek()+i;
                        }
                    }
                } else if (x1<=x2 && y1>y2) {
                    for (int a = x1; a < x2+1; a++) {
                        for (int b = y2; b < y1+1; b++) {
                            matrixRuangan[a][b] = kasurSingle.getNamaObjek()+i;
                        }
                    }
                } else if (x1>x2 && y1<=y2) {
                    for (int a = x2; a < x1+1; a++) {
                        for (int b = y1; b < y2+1; b++) {
                            matrixRuangan[a][b] = kasurSingle.getNamaObjek()+i;
                        }
                    }
                } else {
                    for (int a = x2; a < x1+1; a++) {
                        for (int b = y2; b < y1+1; b++) {
                            matrixRuangan[a][b] = kasurSingle.getNamaObjek()+i;
                        }
                    }
                }
                daftarObjek.put(locKasurSingle1, kasurSingle.getNamaObjek()+i);
                daftarObjek.put(locKasurSingle2, kasurSingle.getNamaObjek()+i);
                daftarObjek.put(locKasurSingle3, kasurSingle.getNamaObjek()+i);
                daftarObjek.put(locKasurSingle4, kasurSingle.getNamaObjek()+i);
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
                if (((x2 == x1+1 && y1 == y2) || (y2 == y1+1 && x1 == x2) || (x2 == x1-1 && y1 == y2) || (y2 == y1-1 && x1 == x2)) && cekPoint(x1, y1) && cekPoint(x2, y2)) {
                    valid = true;
                } else {
                    System.out.println("Titik tidak sesuai dengan dimensi!");
                }
            } while (!valid);
            Point locKomporGas1 = new Point(x1, y1);
            Point locKomporGas2 = new Point(x2, y2);
            if (!isAvailable(locKomporGas1) && !isAvailable(locKomporGas2)) {
                KomporGas komporGas = new KomporGas(namaBarang);
                addJumlah(namaBarang);
                int i = jumlahObjek.get(searchBarang(namaBarang));
                if (x1<=x2 && y1<=y2) {
                    for (int a = x1; a < x2+1; a++) {
                        for (int b = y1; b < y2+1; b++) {
                            matrixRuangan[a][b] = komporGas.getNamaObjek()+i;
                        }
                    }
                } else if (x1<=x2 && y1>y2) {
                    for (int a = x1; a < x2+1; a++) {
                        for (int b = y2; b < y1+1; b++) {
                            matrixRuangan[a][b] = komporGas.getNamaObjek()+i;
                        }
                    }
                } else if (x1>x2 && y1<=y2) {
                    for (int a = x2; a < x1+1; a++) {
                        for (int b = y1; b < y2+1; b++) {
                            matrixRuangan[a][b] = komporGas.getNamaObjek()+i;
                        }
                    }
                } else {
                    for (int a = x2; a < x1+1; a++) {
                        for (int b = y2; b < y1+1; b++) {
                            matrixRuangan[a][b] = komporGas.getNamaObjek()+i;
                        }
                    }
                }
                daftarObjek.put(locKomporGas1, komporGas.getNamaObjek()+i);
                daftarObjek.put(locKomporGas2, komporGas.getNamaObjek()+i);
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
                KasurQueenSize kasurQueenSize = new KasurQueenSize(namaBarang);
                addJumlah(namaBarang);
                int i = jumlahObjek.get(searchBarang(namaBarang));
                for (int a = x1; a < x4+1; a++) {
                    for (int b = y1; b < y4+1; b++) {
                        matrixRuangan[a][b] = kasurQueenSize.getNamaObjek()+i;
                    }
                }
                daftarObjek.put(locKasurQueenSize1, kasurQueenSize.getNamaObjek()+i);
                daftarObjek.put(locKasurQueenSize2, kasurQueenSize.getNamaObjek()+i);
                daftarObjek.put(locKasurQueenSize3, kasurQueenSize.getNamaObjek()+i);
                daftarObjek.put(locKasurQueenSize4, kasurQueenSize.getNamaObjek()+i);
                daftarObjek.put(locKasurQueenSize5, kasurQueenSize.getNamaObjek()+i);
                daftarObjek.put(locKasurQueenSize6, kasurQueenSize.getNamaObjek()+i);
                daftarObjek.put(locKasurQueenSize7, kasurQueenSize.getNamaObjek()+i);
                daftarObjek.put(locKasurQueenSize8, kasurQueenSize.getNamaObjek()+i);
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
                KasurKingSize kasurKingSize = new KasurKingSize(namaBarang);
                addJumlah(namaBarang);
                int i = jumlahObjek.get(searchBarang(namaBarang));
                for (int a = x1; a < x4+1; a++) {
                    for (int b = y1; b < y4+1; b++) {
                        matrixRuangan[a][b] = kasurKingSize.getNamaObjek()+i;
                    }
                }
                daftarObjek.put(locKasurKingSize1, kasurKingSize.getNamaObjek()+i);
                daftarObjek.put(locKasurKingSize2, kasurKingSize.getNamaObjek()+i);
                daftarObjek.put(locKasurKingSize3, kasurKingSize.getNamaObjek()+i);
                daftarObjek.put(locKasurKingSize4, kasurKingSize.getNamaObjek()+i);
                daftarObjek.put(locKasurKingSize5, kasurKingSize.getNamaObjek()+i);
                daftarObjek.put(locKasurKingSize6, kasurKingSize.getNamaObjek()+i);
                daftarObjek.put(locKasurKingSize7, kasurKingSize.getNamaObjek()+i);
                daftarObjek.put(locKasurKingSize8, kasurKingSize.getNamaObjek()+i);
                daftarObjek.put(locKasurKingSize9, kasurKingSize.getNamaObjek()+i);
                daftarObjek.put(locKasurKingSize10, kasurKingSize.getNamaObjek()+i);
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
                MejaKursi mejaKursi = new MejaKursi(namaBarang);
                addJumlah(namaBarang);
                int i = jumlahObjek.get(searchBarang(namaBarang));
                for (int a = x1; a < x4+1; a++) {
                    for (int b = y1; b < y4+1; b++) {
                        matrixRuangan[a][b] = mejaKursi.getNamaObjek()+i;
                    }
                }
                daftarObjek.put(locMejaKursi1, mejaKursi.getNamaObjek()+i);
                daftarObjek.put(locMejaKursi2, mejaKursi.getNamaObjek()+i);
                daftarObjek.put(locMejaKursi3, mejaKursi.getNamaObjek()+i);
                daftarObjek.put(locMejaKursi4, mejaKursi.getNamaObjek()+i);
                daftarObjek.put(locMejaKursi5, mejaKursi.getNamaObjek()+i);
                daftarObjek.put(locMejaKursi6, mejaKursi.getNamaObjek()+i);
                daftarObjek.put(locMejaKursi7, mejaKursi.getNamaObjek()+i);
                daftarObjek.put(locMejaKursi8, mejaKursi.getNamaObjek()+i);
                daftarObjek.put(locMejaKursi9, mejaKursi.getNamaObjek()+i);
                System.out.println(namaBarang + " berhasil dipasang!");
                currentSim.getInventory().reduceItem(key, 1);
            } else {
                System.out.println("Lokasi tidak tersedia, barang tidak dapat dipasang!");
            }
        }
        if (namaBarang.equals("Shower")) {
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
                if (((x2 == x1+1 && y1 == y2) || (y2 == y1+1 && x1 == x2) || (x2 == x1-1 && y1 == y2) || (y2 == y1-1 && x1 == x2)) && cekPoint(x1, y1) && cekPoint(x2, y2)) {
                    valid = true;
                } else {
                    System.out.println("Titik tidak sesuai dengan dimensi!");
                }
            } while (!valid);
            Point locShower1 = new Point(x1, y1);
            Point locShower2 = new Point(x2, y2);
            if (!isAvailable(locShower1) && !isAvailable(locShower2)) {
                Shower shower = new Shower(namaBarang);
                addJumlah(namaBarang);
                int i = jumlahObjek.get(searchBarang(namaBarang));
                if (x1<=x2 && y1<=y2) {
                    for (int a = x1; a < x2+1; a++) {
                        for (int b = y1; b < y2+1; b++) {
                            matrixRuangan[a][b] = shower.getNamaObjek()+i;
                        }
                    }
                } else if (x1<=x2 && y1>y2) {
                    for (int a = x1; a < x2+1; a++) {
                        for (int b = y2; b < y1+1; b++) {
                            matrixRuangan[a][b] = shower.getNamaObjek()+i;
                        }
                    }
                } else if (x1>x2 && y1<=y2) {
                    for (int a = x2; a < x1+1; a++) {
                        for (int b = y1; b < y2+1; b++) {
                            matrixRuangan[a][b] = shower.getNamaObjek()+i;
                        }
                    }
                } else {
                    for (int a = x2; a < x1+1; a++) {
                        for (int b = y2; b < y1+1; b++) {
                            matrixRuangan[a][b] = shower.getNamaObjek()+i;
                        }
                    }
                }
                daftarObjek.put(locShower1, shower.getNamaObjek()+i);
                daftarObjek.put(locShower2, shower.getNamaObjek()+i);
                System.out.println(namaBarang + " berhasil dipasang!");
                currentSim.getInventory().reduceItem(key, 1);
            } else {
                System.out.println("Lokasi tidak tersedia, barang tidak dapat dipasang!");
            }
        }
        if (namaBarang.equals("KursiPijat")) {
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
            Point locKursiPijat = new Point(x, y);
            if (!isAvailable(locKursiPijat)) {
                KursiPijat kursiPijat = new KursiPijat(namaBarang);
                addJumlah(namaBarang);
                int i = jumlahObjek.get(searchBarang(namaBarang));
                matrixRuangan[x][y] = kursiPijat.getNamaObjek()+i;
                daftarObjek.put(locKursiPijat, kursiPijat.getNamaObjek()+i);
                System.out.println(namaBarang + " berhasil dipasang!");
                currentSim.getInventory().reduceItem(key, 1);
            } else {
                System.out.println("Lokasi tidak tersedia, barang tidak dapat dipasang!");
            }
        }
        if (namaBarang.equals("Cermin")) {
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
            Point locCermin = new Point(x, y);
            if (!isAvailable(locCermin)) {
                Cermin cermin = new Cermin(namaBarang);
                addJumlah(namaBarang);
                int i = jumlahObjek.get(searchBarang(namaBarang));
                matrixRuangan[x][y] = cermin.getNamaObjek()+i;
                daftarObjek.put(locCermin, cermin.getNamaObjek()+i);
                System.out.println(namaBarang + " berhasil dipasang!");
                currentSim.getInventory().reduceItem(key, 1);
            } else {
                System.out.println("Lokasi tidak tersedia, barang tidak dapat dipasang!");
            }
        }
        if (namaBarang.equals("RakBuku")) {
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
                if (((x2 == x1+2 && y1 == y2) || (y2 == y1+2 && x1 == x2) || (x2 == x1-2 && y1 == y2) || (y2 == y1-2 && x1 == x2)) && cekPoint(x1, y1) && cekPoint(x2, y2)) {
                    valid = true;
                } else {
                    System.out.println("Titik tidak sesuai, coba ulangi!");
                }
            } while (!valid);
            Point locRakBuku1 = new Point(x1, y1);
            Point locRakBuku3 = new Point(x2, y2);
            Point locRakBuku2;
            if (x2 == x1+2) {
                locRakBuku2 = new Point(x1+1, y1);
            } else if (x2 == x1-2) {
                locRakBuku2 = new Point(x1-1, y1);
            } else if (y2 == y1+2) {
                locRakBuku2 = new Point(x1, y1+1);
            } else {
                locRakBuku2 = new Point(x1, y1-1);
            }
            if (!isAvailable(locRakBuku1) && !isAvailable(locRakBuku2) && !isAvailable(locRakBuku3)) {
                RakBuku rakBuku = new RakBuku(namaBarang);
                addJumlah(namaBarang);
                int i = jumlahObjek.get(searchBarang(namaBarang));
                if (x1<=x2 && y1<=y2) {
                    for (int a = x1; a < x2+1; a++) {
                        for (int b = y1; b < y2+1; b++) {
                            matrixRuangan[a][b] = rakBuku.getNamaObjek()+i;
                        }
                    }
                } else if (x1<=x2 && y1>y2) {
                    for (int a = x1; a < x2+1; a++) {
                        for (int b = y2; b < y1+1; b++) {
                            matrixRuangan[a][b] = rakBuku.getNamaObjek()+i;
                        }
                    }
                } else if (x1>x2 && y1<=y2) {
                    for (int a = x2; a < x1+1; a++) {
                        for (int b = y1; b < y2+1; b++) {
                            matrixRuangan[a][b] = rakBuku.getNamaObjek()+i;
                        }
                    }
                } else {
                    for (int a = x2; a < x1+1; a++) {
                        for (int b = y2; b < y1+1; b++) {
                            matrixRuangan[a][b] = rakBuku.getNamaObjek()+i;
                        }
                    }
                }
                daftarObjek.put(locRakBuku1, rakBuku.getNamaObjek()+i);
                daftarObjek.put(locRakBuku2, rakBuku.getNamaObjek()+i);
                daftarObjek.put(locRakBuku3, rakBuku.getNamaObjek()+i);
                System.out.println(namaBarang + " berhasil dipasang!");
                currentSim.getInventory().reduceItem(key, 1);
            } else {
                System.out.println("Lokasi tidak tersedia, barang tidak dapat dipasang!");
            }
        }
        if (namaBarang.equals("Wastafel")) {
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
            Point locWastafel = new Point(x, y);
            if (!isAvailable(locWastafel)) {
                Wastafel wastafel = new Wastafel(namaBarang);
                addJumlah(namaBarang);
                int i = jumlahObjek.get(searchBarang(namaBarang));
                matrixRuangan[x][y] = wastafel.getNamaObjek()+i;
                daftarObjek.put(locWastafel, wastafel.getNamaObjek()+i);
                System.out.println(namaBarang + " berhasil dipasang!");
                currentSim.getInventory().reduceItem(key, 1);
            } else {
                System.out.println("Lokasi tidak tersedia, barang tidak dapat dipasang!");
            }
        }
        if (namaBarang.equals("Treadmil")) {
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
                if (((x2 == x1+1 && y1 == y2) || (y2 == y1+1 && x1 == x2) || (x2 == x1-1 && y1 == y2) || (y2 == y1-1 && x1 == x2)) && cekPoint(x1, y1) && cekPoint(x2, y2)) {
                    valid = true;
                } else {
                    System.out.println("Titik tidak sesuai dengan dimensi!");
                }
            } while (!valid);
            Point locTreadmil1 = new Point(x1, y1);
            Point locTreadmil2 = new Point(x2, y2);
            if (!isAvailable(locTreadmil1) && !isAvailable(locTreadmil2)) {
                Treadmil treadmil = new Treadmil(namaBarang);
                addJumlah(namaBarang);
                int i = jumlahObjek.get(searchBarang(namaBarang));
                if (x1<=x2 && y1<=y2) {
                    for (int a = x1; a < x2+1; a++) {
                        for (int b = y1; b < y2+1; b++) {
                            matrixRuangan[a][b] = treadmil.getNamaObjek()+i;
                        }
                    }
                } else if (x1<=x2 && y1>y2) {
                    for (int a = x1; a < x2+1; a++) {
                        for (int b = y2; b < y1+1; b++) {
                            matrixRuangan[a][b] = treadmil.getNamaObjek()+i;
                        }
                    }
                } else if (x1>x2 && y1<=y2) {
                    for (int a = x2; a < x1+1; a++) {
                        for (int b = y1; b < y2+1; b++) {
                            matrixRuangan[a][b] = treadmil.getNamaObjek()+i;
                        }
                    }
                } else {
                    for (int a = x2; a < x1+1; a++) {
                        for (int b = y2; b < y1+1; b++) {
                            matrixRuangan[a][b] = treadmil.getNamaObjek()+i;
                        }
                    }
                }
                daftarObjek.put(locTreadmil1, treadmil.getNamaObjek()+i);
                daftarObjek.put(locTreadmil2, treadmil.getNamaObjek()+i);
                System.out.println(namaBarang + " berhasil dipasang!");
                currentSim.getInventory().reduceItem(key, 1);
            }
        }
        if (namaBarang.equals("Gramofon")) {
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
            Point locGramofon = new Point(x, y);
            if (!isAvailable(locGramofon)) {
                Gramofon gramofon = new Gramofon(namaBarang);
                addJumlah(namaBarang);
                int i = jumlahObjek.get(searchBarang(namaBarang));
                matrixRuangan[x][y] = gramofon.getNamaObjek()+i;
                daftarObjek.put(locGramofon, gramofon.getNamaObjek()+i);
                System.out.println(namaBarang + " berhasil dipasang!");
                currentSim.getInventory().reduceItem(key, 1);
            } else {
                System.out.println("Lokasi tidak tersedia, barang tidak dapat dipasang!");
            }
        }
    }

    public void move() {
        Scanner input = new Scanner(System.in);
        System.out.println("Available Object :");
        displayDaftarObjek();
        System.out.println("Pilih objek yang ingin dituju :");
        String obj = input.nextLine();
        boolean found = false;

        for(String namaFurnitur : daftarObjek.values()) {
            if(obj.equalsIgnoreCase(namaFurnitur)) {
                found = true;
                break;
            }
        }
        if(found) {
            for(Furnitur furnitur : jumlahObjek.keySet()) {
                if (obj.toLowerCase().contains(furnitur.getNamaObjek().toLowerCase())) {
                    currFurnitur = furnitur;
                    System.out.printf("Current object : %s%n", currFurnitur.getNamaObjek());
                    break;
                }
            }
        } else {
            System.out.println("Objek tidak ada diruangan ini!!");
        }

    }

    public Furnitur searchKey(String namaBarang) {
        Furnitur furnitur = null;
        for (Map.Entry<Furnitur, Integer> entry : this.jumlahObjek.entrySet()) {
            if (entry.getKey().getNamaObjek().equals(namaBarang)) {
                furnitur = entry.getKey();
            }
        }
        return furnitur;
    }

    public Furnitur searchBarang(String namaBarang) {
        Furnitur furnitur = null;
        Iterator <Map.Entry<Furnitur, Integer>> iterator = jumlahObjek.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Furnitur, Integer> entry  = iterator.next();
            if (entry.getKey().getNamaObjek().equals(namaBarang)){
                furnitur = entry.getKey();
            }
        }
        return furnitur;
    }

    public void removeBarang(Sim currentSim) {
        boolean valid = false;
        String namaBarang;
        Scanner input = new Scanner(System.in);
        do {
            this.displayDaftarObjek();
            System.out.print("Masukkan nama barang yang ingin dihapus: ");
            namaBarang = input.next();
            Iterator<Map.Entry<Point, String>> iter = daftarObjek.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Point, String> entry = iter.next();
                if (entry.getValue().equals(namaBarang)) {
                    valid = true;
                    iter.remove();
                }
            }
            if (!valid) {
                System.out.println("Barang tidak tersedia silahkan coba lagi!");
            }
        } while (!valid);

        String num[] = null;

        if (namaBarang.contains("Toilet")) {
            Toilet toilet = (Toilet) searchBarang("Toilet");
            toilet.setKategori("Nonmakanan");
            currentSim.getInventory().addItem(toilet, 1);
            jumlahObjek.put(toilet, Integer.valueOf(jumlahObjek.get(toilet)-1));
            num = namaBarang.split("Toilet");
        } else if (namaBarang.contains("KomporListrik")) {
            KomporListrik komporListrik = (KomporListrik) searchBarang("KomporListrik");
            komporListrik.setKategori("Nonmakanan");
            currentSim.getInventory().addItem(komporListrik, 1);
            jumlahObjek.put(komporListrik, Integer.valueOf(jumlahObjek.get(komporListrik)-1));
            num = namaBarang.split("KomporListrik");
        } else if (namaBarang.contains("Jam")) {
            Jam jam = (Jam) searchBarang("Jam");
            jam.setKategori("Nonmakanan");
            currentSim.getInventory().addItem(jam, 1);
            jumlahObjek.put(jam, Integer.valueOf(jumlahObjek.get(jam)-1));
            num = namaBarang.split("Jam");
        } else if (namaBarang.contains("KasurSingle")) {
            KasurSingle kasurSingle = (KasurSingle) searchBarang("KasurSingle");
            kasurSingle.setKategori("Nonmakanan");
            currentSim.getInventory().addItem(kasurSingle, 1);
            jumlahObjek.put(kasurSingle, Integer.valueOf(jumlahObjek.get(kasurSingle)-1));
            num = namaBarang.split("KasurSingle");
        } else if (namaBarang.contains("KomporGas")) {
            KomporGas komporGas = (KomporGas) searchBarang("KomporGas");
            komporGas.setKategori("Nonmakanan");
            currentSim.getInventory().addItem(komporGas, 1);
            jumlahObjek.put(komporGas, Integer.valueOf(jumlahObjek.get(komporGas)-1));
            num = namaBarang.split("KomporGas");
        } else if (namaBarang.contains("KasurQueenSize")) {
            KasurQueenSize kasurQueenSize = (KasurQueenSize) searchBarang("KasurQueenSize");
            kasurQueenSize.setKategori("Nonmakanan");
            currentSim.getInventory().addItem(kasurQueenSize, 1);
            jumlahObjek.put(kasurQueenSize, Integer.valueOf(jumlahObjek.get(kasurQueenSize)-1));
            num = namaBarang.split("KasurQueenSize");
        } else if (namaBarang.contains("KasurKingSize")) {
            KasurKingSize kasurKingSize = (KasurKingSize) searchBarang("KasurKingSize");
            kasurKingSize.setKategori("Nonmakanan");
            currentSim.getInventory().addItem(kasurKingSize, 1);
            jumlahObjek.put(kasurKingSize, Integer.valueOf(jumlahObjek.get(kasurKingSize)-1));
            num = namaBarang.split("KasurKingSize");
        } else if (namaBarang.contains("MejaKursi")) {
            MejaKursi mejaKursi = (MejaKursi) searchBarang("MejaKursi");
            mejaKursi.setKategori("Nonmakanan");
            currentSim.getInventory().addItem(mejaKursi, 1);
            jumlahObjek.put(mejaKursi, Integer.valueOf(jumlahObjek.get(mejaKursi)-1));
            num = namaBarang.split("MejaKursi");
        } else if (namaBarang.contains("Shower")) {
            Shower shower = (Shower) searchBarang("Shower");
            shower.setKategori("Nonmakanan");
            currentSim.getInventory().addItem(shower, 1);
            jumlahObjek.put(shower, Integer.valueOf(jumlahObjek.get(shower)-1));
            num = namaBarang.split("Shower");
        } else if (namaBarang.contains("KursiPijat")) {
            KursiPijat kursiPijat = (KursiPijat) searchBarang("KursiPijat");
            kursiPijat.setKategori("Nonmakanan");
            currentSim.getInventory().addItem(kursiPijat, 1);
            jumlahObjek.put(kursiPijat, Integer.valueOf(jumlahObjek.get(kursiPijat)-1));
            num = namaBarang.split("KursiPijat");
        } else if (namaBarang.contains("Cermin")) {
            Cermin cermin = (Cermin) searchBarang("Cermin");
            cermin.setKategori("Nonmakanan");
            currentSim.getInventory().addItem(cermin, 1);
            jumlahObjek.put(cermin, Integer.valueOf(jumlahObjek.get(cermin)-1));
            num = namaBarang.split("Cermin");
        } else if (namaBarang.contains("RakBuku")) {
            RakBuku rakBuku = (RakBuku) searchBarang("RakBuku");
            rakBuku.setKategori("Nonmakanan");
            currentSim.getInventory().addItem(rakBuku, 1);
            jumlahObjek.put(rakBuku, Integer.valueOf(jumlahObjek.get(rakBuku)-1));
            num = namaBarang.split("RakBuku");
        } else if (namaBarang.contains("Wastafel")) {
            Wastafel wastafel = (Wastafel) searchBarang("Wastafel");
            wastafel.setKategori("Nonmakanan");
            currentSim.getInventory().addItem(wastafel, 1);
            jumlahObjek.put(wastafel, Integer.valueOf(jumlahObjek.get(wastafel)-1));
            num = namaBarang.split("Wastafel");
        } else if (namaBarang.contains("Treadmil")) {
            Treadmil treadmil = (Treadmil) searchBarang("Treadmil");
            treadmil.setKategori("Nonmakanan");
            currentSim.getInventory().addItem(treadmil, 1);
            jumlahObjek.put(treadmil, Integer.valueOf(jumlahObjek.get(treadmil)-1));
            num = namaBarang.split("Treadmil");
        } else if (namaBarang.contains("Gramofon")) {
            Gramofon gramofon = (Gramofon) searchBarang("Gramofon");
            gramofon.setKategori("Nonmakanan");
            currentSim.getInventory().addItem(gramofon, 1);
            jumlahObjek.put(gramofon, Integer.valueOf(jumlahObjek.get(gramofon)-1));
            num = namaBarang.split("Gramofon");
        }

        for (Map.Entry<Point, String> entry : this.daftarObjek.entrySet()){
            if (namaBarang.contains("Toilet") && entry.getValue().contains("Toilet")) {
                String arr[] = entry.getValue().split("Toilet");
                if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                    daftarObjek.put(entry.getKey(), ("Toilet" + (Integer.parseInt(arr[1])-1)));
                }
            } else if (namaBarang.contains("KomporListrik") && entry.getValue().contains("KomporListrik")) {
                String arr[] = entry.getValue().split("KomporListrik");
                if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                    daftarObjek.put(entry.getKey(), ("KomporListrik" + (Integer.parseInt(arr[1])-1)));
                }
            } else if (namaBarang.contains("Jam") && entry.getValue().contains("Jam")) {
                String arr[] = entry.getValue().split("Jam");
                if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                    daftarObjek.put(entry.getKey(), ("Jam" + (Integer.parseInt(arr[1])-1)));
                }
            } else if (namaBarang.contains("KomporGas") && entry.getValue().contains("KomporGas")) {
                String arr[] = entry.getValue().split("KomporGas");
                if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                    daftarObjek.put(entry.getKey(), ("KomporGas" + (Integer.parseInt(arr[1])-1)));
                }
            } else if (namaBarang.contains("KasurQueenSize") && entry.getValue().contains("KasurQueenSize")) {
                String arr[] = entry.getValue().split("KasurQueenSize");
                if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                    daftarObjek.put(entry.getKey(), ("KasurQueenSize" + (Integer.parseInt(arr[1])-1)));
                }
            } else if (namaBarang.contains("KasurKingSize") && entry.getValue().contains("KasurKingSize")) {
                String arr[] = entry.getValue().split("KasurKingSize");
                if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                    daftarObjek.put(entry.getKey(), ("KasurKingSize" + (Integer.parseInt(arr[1])-1)));
                }
            } else if (namaBarang.contains("MejaKursi") && entry.getValue().contains("MejaKursi")) {
                String arr[] = entry.getValue().split("MejaKursi");
                if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                    daftarObjek.put(entry.getKey(), ("MejaKursi" + (Integer.parseInt(arr[1])-1)));
                }
            }
        }

        for (int x = 0; x < this.lebar; x++) {
            for (int y = 0; y < this.panjang; y++) {
                if (matrixRuangan[x][y].equals(namaBarang)) {
                    matrixRuangan[x][y] = "Kosong";
                } else if (namaBarang.contains("Toilet") && matrixRuangan[x][y].contains("Toilet")) {
                    String arr[] = matrixRuangan[x][y].split("Toilet");
                    if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                        matrixRuangan[x][y] = "Toilet" + (Integer.parseInt(arr[1])-1);
                    }
                } else if (namaBarang.contains("KomporListrik") && matrixRuangan[x][y].contains("KomporListrik")) {
                    String arr[] = namaBarang.split("KomporListrik");
                    if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                        matrixRuangan[x][y] = "KomporListrik" + (Integer.parseInt(arr[1])-1);
                    }
                } else if (namaBarang.contains("Jam") && matrixRuangan[x][y].contains("Jam")) {
                    String arr[] = namaBarang.split("Jam");
                    if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                        matrixRuangan[x][y] = "Jam" + (Integer.parseInt(arr[1])-1);
                    }
                } else if (namaBarang.contains("KasurSingle") && matrixRuangan[x][y].contains("KasurSingle")) {
                    String arr[] = namaBarang.split("KasurSingle");
                    if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                        matrixRuangan[x][y] = "KasurSingle" + (Integer.parseInt(arr[1])-1);
                    }
                } else if (namaBarang.contains("KomporGas") && matrixRuangan[x][y].contains("KomporGas")) {
                    String arr[] = namaBarang.split("KomporGas");
                    if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                        matrixRuangan[x][y] = "KomporGas" + (Integer.parseInt(arr[1])-1);
                    }
                } else if (namaBarang.contains("KasurQueenSize") && matrixRuangan[x][y].contains("KasurQueenSize")) {
                    String arr[] = namaBarang.split("KasurQueenSize");
                    if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                        matrixRuangan[x][y] = "KasurQueenSize" + (Integer.parseInt(arr[1])-1);
                    }
                } else if (namaBarang.contains("KasurKingSize") && matrixRuangan[x][y].contains("KasurKingSize")) {
                    String arr[] = namaBarang.split("KasurKingSize");
                    if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                        matrixRuangan[x][y] = "KasurKingSize" + (Integer.parseInt(arr[1])-1);
                    }
                } else if (namaBarang.contains("MejaKursi") && matrixRuangan[x][y].contains("MejaKursi")) {
                    String arr[] = namaBarang.split("MejaKursi");
                    if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                        matrixRuangan[x][y] = "MejaKursi" + (Integer.parseInt(arr[1])-1);
                    }
                } else if (namaBarang.contains("Shower") && matrixRuangan[x][y].contains("Shower")) {
                    String arr[] = namaBarang.split("Shower");
                    if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                        matrixRuangan[x][y] = "Shower" + (Integer.parseInt(arr[1])-1);
                    }
                } else if (namaBarang.contains("KursiPijat") && matrixRuangan[x][y].contains("KursiPijat")) {
                    String arr[] = namaBarang.split("KursiPijat");
                    if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                        matrixRuangan[x][y] = "KursiPijat" + (Integer.parseInt(arr[1])-1);
                    }
                } else if (namaBarang.contains("Cermin") && matrixRuangan[x][y].contains("Cermin")) {
                    String arr[] = namaBarang.split("Cermin");
                    if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                        matrixRuangan[x][y] = "Cermin" + (Integer.parseInt(arr[1])-1);
                    }
                } else if (namaBarang.contains("RakBuku") && matrixRuangan[x][y].contains("RakBuku")) {
                    String arr[] = namaBarang.split("RakBuku");
                    if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                        matrixRuangan[x][y] = "RakBuku" + (Integer.parseInt(arr[1])-1);
                    }
                } else if (namaBarang.contains("Wastafel") && matrixRuangan[x][y].contains("Wastafel")) {
                    String arr[] = namaBarang.split("Wastafel");
                    if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                        matrixRuangan[x][y] = "Wastafel" + (Integer.parseInt(arr[1])-1);
                    }
                } else if (namaBarang.contains("Treadmil") && matrixRuangan[x][y].contains("Treadmil")) {
                    String arr[] = namaBarang.split("Treadmil");
                    if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                        matrixRuangan[x][y] = "Treadmil" + (Integer.parseInt(arr[1])-1);
                    }
                } else if (namaBarang.contains("Gramofon") && matrixRuangan[x][y].contains("Gramofon")) {
                    String arr[] = namaBarang.split("Gramofon");
                    if (Integer.parseInt(arr[1])>Integer.parseInt(num[1])) {
                        matrixRuangan[x][y] = "Gramofon" + (Integer.parseInt(arr[1])-1);
                    }
                }
            }
        }
    }

    public Furnitur getCurrFurnitur() {
        return currFurnitur;
    }

    public void displayTitikObjek() {
        int i = 1;
        System.out.println("Daftar lokasi objek dalam ruangan: ");
        for (Map.Entry<Point, String> entry : this.daftarObjek.entrySet()) {
            System.out.println(i + ". <" + entry.getKey().displayPoint() + ", " + entry.getValue() + ">");
            i++;
        }
    }

    public void addJumlah (String namaBarang) {
        if (searchBarang(namaBarang)!=null) {
            jumlahObjek.put(searchBarang(namaBarang), jumlahObjek.get(searchBarang(namaBarang))+1);
        } else {
            if (namaBarang.equals("Toilet")) {
                Toilet toilet = new Toilet(namaBarang);
                jumlahObjek.put(toilet, 1);
            } else if (namaBarang.equals("KomporListrik")) {
                KomporListrik komporListrik = new KomporListrik(namaBarang);
                jumlahObjek.put(komporListrik, 1);
            } else if (namaBarang.equals("Jam")) {
                Jam jam = new Jam(namaBarang);
                jumlahObjek.put(jam, 1);
            } else if (namaBarang.equals("KasurSingle")) {
                KasurSingle kasurSingle = new KasurSingle(namaBarang);
                jumlahObjek.put(kasurSingle, 1);
            } else if (namaBarang.equals("KomporGas")) {
                KomporGas komporGas = new KomporGas(namaBarang);
                jumlahObjek.put(komporGas, 1);
            } else if (namaBarang.equals("KasurQueenSize")) {
                KasurQueenSize kasurQueenSize = new KasurQueenSize(namaBarang);
                jumlahObjek.put(kasurQueenSize, 1);
            } else if (namaBarang.equals("KasurKingSize")) {
                KasurKingSize kasurKingSize = new KasurKingSize(namaBarang);
                jumlahObjek.put(kasurKingSize, 1);
            } else if (namaBarang.equals("MejaKursi")) {
                MejaKursi mejaKursi = new MejaKursi(namaBarang);
                jumlahObjek.put(mejaKursi, 1);
            } else if (namaBarang.equals("Shower")) {
                Shower shower = new Shower(namaBarang);
                jumlahObjek.put(shower, 1);
            } else if (namaBarang.equals("KursiPijat")) {
                KursiPijat kursiPijat = new KursiPijat(namaBarang);
                jumlahObjek.put(kursiPijat, 1);
            } else if (namaBarang.equals("Cermin")) {
                Cermin cermin = new Cermin(namaBarang);
                jumlahObjek.put(cermin, 1);
            } else if (namaBarang.equals("RakBuku")) {
                RakBuku rakBuku = new RakBuku(namaBarang);
                jumlahObjek.put(rakBuku, 1);
            } else if (namaBarang.equals("Wastafel")) {
                Wastafel wastafel = new Wastafel(namaBarang);
                jumlahObjek.put(wastafel, 1);
            } else if (namaBarang.equals("Treadmil")) {
                Treadmil treadmil = new Treadmil(namaBarang);
                jumlahObjek.put(treadmil, 1);
            } else if (namaBarang.equals("Gramofon")) {
                Gramofon gramofon = new Gramofon(namaBarang);
                jumlahObjek.put(gramofon, 1);
            }
        }
    }
}