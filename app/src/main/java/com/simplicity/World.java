package com.simplicity;
import java.util.*;

public class World {
    private final int panjang = 64;
    private final int lebar = 64;
    private HashMap<Point, Rumah> daftarRumah = new HashMap<>();
    private Waktu waktu;
    private static Sim currentSim;
    private ArrayList<Sim> sims = new ArrayList<>();
    private static Point currentLoc;

    public World(Waktu waktu) {
        this.waktu = waktu;
    }

    public HashMap<Point, Rumah> getRumahList() {
        return this.daftarRumah;
    }

    public Waktu getWaktu() {
        return this.waktu;
    }

    public Rumah addRumah(String namaLengkap) {
        int x = 0;
        int y = 0;
        Point loc = new Point(x,y);
        Random rand = new Random();
        while(isAvailable(loc)) {
            loc.setX(rand.nextInt(panjang));
            loc.setY(rand.nextInt(lebar));
        }
        Rumah rumah = new Rumah(loc);
        rumah.setOwner(namaLengkap);
        daftarRumah.put(loc, rumah);
        return rumah;
    }

    public boolean isAvailable(Point loc) {
        return daftarRumah.containsKey(loc);
    }

    public void displayWorld() {
        for(Point key : daftarRumah.keySet()) {
            System.out.println(key + ": Rumah " + daftarRumah.get(key).getOwner());
        }
        System.out.println();
    }

    public void addSim(Scanner inp) {
        boolean end = false;
        List<String> names = new ArrayList<>();
        for(Sim sim : getSims()) {
            names.add(sim.getNama());
        }
        while(!end) {
            System.out.print("Masukkan nama sim baru : ");
            String namaLengkap = inp.nextLine();
            boolean found = names.contains(namaLengkap);
            if(found) {
                System.out.println("Nama Sim sudah ada! Silahkan masukkan nama lain!");
            } else {
                Rumah rumah = addRumah(namaLengkap);
                Sim sim = new Sim(namaLengkap, rumah);
                setCurrentSim(sim);
                sims.add(sim);
                end = true;
            }
        }
    }

    public void setCurrentSim(Sim sim) {
        currentSim = sim;
    }

    public static Sim getCurrentSim() {
        return currentSim;
    }

    public void setCurrentLoc(Point loc) {
        currentLoc = loc;
    }

    public Point getCurrentLoc() {
        return currentLoc;
    }

    public void displayCurrentLoc() {
        Rumah currentRumah = currentSim.getCurrentRumah();
        System.out.println("Lokasi saat ini:");
        System.out.println("Rumah: Rumah " + currentRumah.getOwner());
        System.out.println("Ruangan: " + currentRumah.getNamaCurrRuangan());
        System.out.println();
    }

    public Rumah getCurrentRumah() {
        return getCurrentSim().getCurrentRumah();
    }

    public void displaySims() {
        for(int i = 0; i < sims.size(); i++) {
            System.out.println(i+1 + ". " + sims.get(i).getNama());
        }
    }

    public ArrayList<Sim> getSims() {
        return sims;
    }

    public void displayCurrentRuangan() {
        getCurrentSim()
                .getCurrentRumah()
                .getCurrRuangan()
                .displayRuangan();
    }

    public void changeSim(Scanner inp) {
        if(getSims().size() > 1) {
            List<String> names = new ArrayList<>();
            for(Sim sim : getSims()) {
                names.add(sim.getNama());
            }
            boolean end = false;

            while(!end) {
                displaySims();
                System.out.print("Pilih sim : ");
                String namasim = inp.nextLine();
                boolean found = names.contains(namasim);

                if(found) {
                    for(Sim sim : getSims()) {
                        if(sim.getNama().equals(namasim)) {
                            setCurrentSim(sim);
                            end = true;
                        }
                    }
                } else {
                    System.out.println("Nama Sim tidak valid!! Silahkan input ulang!!");
                }
            }
        }
        else {
            System.out.println("Tidak ada sim lain!");
        }
    }

    public Furnitur getCurrFurnitur() {
        return getCurrentRumah().getCurrRuangan().getCurrFurnitur();
    }

    public HashMap<Point, Rumah> getDaftarRumah() {
        return daftarRumah;
    }
}