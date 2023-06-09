package com.simplicity;
import java.util.*;

public class World {
    private final int panjang = 64;
    private final int lebar = 64;

    private static World instance; 
    private HashMap<Point, Rumah> daftarRumah = new HashMap<>();
    private Waktu waktu;
    private Sim currentSim;
    private static ArrayList<Sim> sims = new ArrayList<>();
    private boolean addSim = false;

    private World() {
        waktu = Waktu.getInstance();
    }

    public static World getInstance() {
        if (instance == null) {
            instance = new World(); 
        }
        return instance; 
    }

    public HashMap<Point, Rumah> getRumahList() {
        return this.daftarRumah;
    }

    public Waktu getWaktu() {
        return waktu;
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
            System.out.println(key.displayPoint() + ": Rumah " + daftarRumah.get(key).getOwner());
        }
        System.out.println();
    }

    public void addSim(Scanner inp, String conditional) {
        boolean end = false;
        if(addSim) {
            System.out.println("Add sim hanya dapat dilakukan sekali per hari!! Silahkan tunggu hari selanjutnya!!");
        } else {
            addSim = true;
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
                    if(conditional.equals("init")) {
                        setCurrentSim(sim);
                    }
                    sims.add(sim);
                    end = true;
                }
            }
        }
    }

    public void setCurrentSim(Sim sim) {
        currentSim = sim;
    }

    public Sim getCurrentSim() {
        return currentSim;
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

    public static void displaySims() {
        for(int i = 0; i < sims.size(); i++) {
            System.out.println(i+1 + ". " + sims.get(i).getNama());
        }
    }

    public static ArrayList<Sim> getSims() {
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
                    for(int i = 0; i < sims.size(); i++) {
                        if(sims.get(i).getNama().equals(getCurrentSim().getNama())) {
                            sims.set(i,getCurrentSim());
                        }
                        if(sims.get(i).getNama().equals(namasim)) {
                            setCurrentSim(sims.get(i));
                            end=true;
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

    public void checkDeath(){
        // cek currsim mati
        boolean currSimDead = currentSim.isDie();

        // replace state current sim ke arraylist sims
        setCurrentSimState();

        // sim cuma 1
        if(sims.size() < 2 && currSimDead) {
            currentSim.printDeathMessage();
            System.out.println("                        OH NO!");
            System.out.println("                 ___________________   ");
            System.out.println(" :(        _    |   ______________   |   _    :(");
            System.out.println("          \\ \\   |  |              |  |  / /");
            System.out.println("     :(    \\ \\  |  |  X        X  |  | / /        :(");
            System.out.println("            \\ \\ |  |    ______    |  |/ /");
            System.out.println(" :(          \\ \\|  |   |      |   |  | /     :(");
            System.out.println("-------- TIDAK ADA SIM LAGI YANG TERSEDIA ! ---------");
            System.out.println(""); 
            System.out.println("      ___   _   __  __ ___    _____   _____ ___ ");
            System.out.println("     / __| /_\\ |  \\/  | __|  / _ \\ \\ / / __| _ \\");
            System.out.println("    | (_ |/ _ \\| |\\/| | _|  | (_) \\ V /| _||   /");
            System.out.println("     \\___/_/ \\_\\_|  |_|___|  \\___/ \\_/ |___|_|_\\");
            System.out.println("-".repeat(53)); 

            Menu.getInstance().exit();
        } else {
            updateSim();
        }

        // kalo current sim mati
        boolean valid = false;
        Scanner input = new Scanner(System.in);
        String choice;
        if(currSimDead) {
            System.out.println("GANTI SIM atau GAME OVER?");
            System.out.print("Masukan pilihan : ");
            choice = input.nextLine().toUpperCase();
            if (choice.equals("GANTI SIM") && sims.size() > 1){
                changeSim(input);
            }else if (choice.equals("GANTI SIM")){
                System.out.println("Hanya tersisa 1 Sim!");
                System.out.println("Change sim ke sim yang tersisa");
                setCurrentSim(sims.get(0));
            }else if (choice.equals("GAME OVER")){
                Menu.getInstance().exit();
            } else{
                while (!valid){
                    System.out.println("Input tidak valid!");
                    System.out.println("Masukan ulang pilihan : ");
                    if (choice.equals("GANTI SIM")){
                        valid = true;
                        changeSim(input);
                    } else if (choice.equals("GAME OVER")){
                        valid = true;
                        Menu.getInstance().exit();
                    }
                }
            }
        }
    }
    
    public void updateSim(){
        Iterator<Sim> iter = sims.iterator();
        while(iter.hasNext()) {
            Sim sim = iter.next();
            if(sim.isDie()){
                System.out.println("Oh no! " + sim.getNama() + " telah meninggal..");
                sim.printDeathMessage();
                // hapus sim dan rumahnya
                updateDaftarRumah(sim.getNama());
                iter.remove();
            }
        }
    }

    public void updateHarian(){
        addSim = false;
        for (Sim sim : sims){
            sim.setJamTidur(0, "Belum tidur");
        }
    }

    public void updateDaftarRumah(String deadSim) {
        for(Sim sim : sims) {
            if(sim.getCurrentRumah().getOwner().equals(deadSim)) {
                 sim.setCurrentRumah(getOwnHouse(sim,daftarRumah));
            }
        }

        for(Map.Entry<Point,Rumah> entry : daftarRumah.entrySet()) {
            if(entry.getValue().getOwner().equals(deadSim)) {
                daftarRumah.remove(entry.getKey(),entry.getValue());
                break;
            }
        }
    }

    public static Rumah getOwnHouse(Sim sim, HashMap<Point, Rumah> daftarRumah) {
        for(Rumah rumah : daftarRumah.values()) {
            if(rumah.getOwner().equals(sim.getNama())) {
                return rumah;
            }
        }
        return null;
    }

    public void setCurrentSimState() {
        for(int i = 0; i < sims.size(); i++) {
            if(sims.get(i).getNama().equals(currentSim.getNama())) {
                sims.set(i,currentSim);
                break;
            }
        }
    }

    public boolean isInOwnHouse() {
        return currentSim.getCurrentRumah().getOwner().equals(currentSim.getNama());
    }

    // SIM nambahin atributnya 
    // Waktu -> nambahin atributnya -> ngecek tiap sim nambahin / ngurangin waktu setelah tidur / makan
    // bakalan kereset tiap hari

    // tidur -> 10 menit -> dapet penalti
    // besok harinya timer diubah jadi 10 lagi atau gak
}