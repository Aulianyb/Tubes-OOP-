package com.simplicity;
import java.util.*;

public class World {
    private final int panjang = 64;
    private final int lebar = 64;
    private HashMap<Point, Rumah> daftarRumah = new HashMap<>();
    private Waktu waktu;
    private Sim currentSim;
    private ArrayList<Sim> sims = new ArrayList<>();
    private static Point currentLoc;

    public World(Waktu waktu, Sim currentSim, Point currentLoc) {
        this.waktu = waktu;
        setCurrentSim(currentSim);
        setCurrentLoc(currentLoc);
    }

    public HashMap<Point, Rumah> getRumahList() {
        return this.daftarRumah;
    }

    public Waktu getWaktu() {
        return this.waktu;
    }

    public Rumah addRumah() {
        int x = 0;
        int y = 0;
        Point loc = new Point(x,y);
        Random rand = new Random();
        while(isAvailable(loc)) {
            loc.setX(rand.nextInt(panjang));
            loc.setY(rand.nextInt(lebar));
        }
        Rumah rumah = new Rumah(loc);
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
    }

    public void addSim(String namaLengkap) {
        Rumah rumah = addRumah();
        Sim sim = new Sim(namaLengkap, rumah);
        setCurrentSim(sim);
        sims.add(sim);
    }

    public void setCurrentSim(Sim sim) {
        currentSim = sim;
    }

    public Sim getCurrentSim() {
        return currentSim;
    }

    public void setCurrentLoc(Point loc) {
        currentLoc = loc;
    }

    public Point getCurrentLoc() {
        return currentLoc;
    }

    public void displayCurrentLoc() {
        Rumah currentRumah = getCurrentRumah();
        System.out.println("Lokasi saat ini:");
        System.out.println("Rumah: Rumah " + currentRumah.getOwner());
        System.out.println("Ruangan: " + currentRumah.getNamaCurrRuangan());
    }

    public Rumah getCurrentRumah() {
        return daftarRumah.get(currentLoc);
    }

    public void displaySims() {
        for(int i = 0; i < sims.size(); i++) {
            System.out.println(i+1 + ". " + sims.get(i).getNama());
        }
    }

    public ArrayList<Sim> getSims() {
        return sims;
    }
}