package com.simplicity;
import java.util.*;

public class World {
    private final int panjang = 64;
    private final int lebar = 64;
    private static HashMap<Point, Rumah> rumahList;
    private Waktu waktu;
    private Sim currentSim;
    private ArrayList<Sim> sims = new ArrayList<>();
    private static Point currentLoc;


    public World(Waktu waktu, Sim currentSim, Point currentLoc) {
        rumahList = new HashMap<>();
        this.waktu = waktu;
        setCurrentSim(currentSim);
        setCurrentLoc(currentLoc);
    }

    public HashMap<Point, Rumah> getRumahList() {
        return this.rumahList;
    }

    public Waktu getWaktu() {
        return this.waktu;
    }

    public void addRumah(String owner) {
        int x = 0;
        int y = 0;
        Point loc = new Point(x,y);
        Random rand = new Random();
        while(isAvailable(loc)) {
            loc.setX(rand.nextInt(panjang));
            loc.setY(rand.nextInt(lebar));
        }
        Rumah rumah = new Rumah(loc,owner);
        rumahList.put(loc, rumah);
    }

    public boolean isAvailable(Point loc) {
        return rumahList.containsKey(loc);
    }

    public void displayWorld() {
        for(Point key: rumahList.keySet()) {
            System.out.printf("%s : %s's house%n",key, rumahList.get(key).getOwner());
        }
    }

    public void addSim(String namaLengkap) {
        Sim sim = new Sim(namaLengkap);
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
        System.out.println("Current location :");
        System.out.printf("Rumah : %s's house%n",currentRumah.getOwner());
        System.out.printf("Ruangan : %s%n", currentRumah.getNamaCurrRuangan());
    }

    public Rumah getCurrentRumah() {
        return rumahList.get(currentLoc);
    }

    public void displaySims() {
        for(int i = 0; i < sims.size(); i++) {
            System.out.printf("%d. %s%n",i+1,sims.get(i).getNama());
        }
    }

    public ArrayList<Sim> getSims() {
        return sims;
    }

}