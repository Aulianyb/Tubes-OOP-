package com.simplicity;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import com.google.gson.Gson;
public class Menu {

    public Menu() {

    }

    public void displayMainMenu(String option) {
        String[] optionAwal = {"Start Game", "Load Game", "Help", "Exit"};
        String[] optionInGame = {
                "Action",
                "List Object",
                "Go To Object",
                "Move Room",
                "Edit Room",
                "View Inventory",
                "View Current Location",
                "View Sim Info",
                "Change Sim",
                "Add Sim",
                "Help",
                "Save",
                "Exit"};

        if(option.equals("start")) {
            System.out.println("New Game Menu");
            for(int i = 1; i <= optionAwal.length; i++) {
                System.out.printf("%d. %s%n",i,optionAwal[i-1]);
            }
            System.out.println();
        } else if(option.equals("ingame")) {
            System.out.println("In Game Menu");
            for(int i = 1; i <= optionInGame.length; i++) {
                System.out.printf("%d. %s%n",i,optionInGame[i-1]);
            }
            System.out.println();
        }
    }

    public void help(String option) {
        if (option.equals("start")) {
            System.out.println(
                    "1. Start Game\t : Memulai permainan\n" +
                    "2. Exit\t\t : Keluar dari game\n");
        }
        else if(option.equals("ingame")) {
            System.out.println("1. Action\t\t : Melakukan sebuah aksi pada suatu objek\n" +
                    "2. List Object\t\t : Menampilkan daftar objek dalam sebuah ruangan\n" +
                    "3. Go to Object\t\t : Berjalan menuju suatu objek\n" +
                    "4. Move Room\t\t : Berganti ke ruangan yang ada pada rumah yang sedang ditempati\n" +
                    "5. Edit Room\t\t : Berisi opsi pembelian barang baru atau pemindahan barang\n" +
                    "6. View Inventory\t : Menampilkan isi inventory milik sebuah Sim\n" +
                    "7. View Current Location : Menampilkan lokasi Rumah dan Ruangan dari Sim\n" +
                    "8. View Sim Info\t : Menampilkan informasi setiap atribut dari Sim\n" +
                    "9. Change Sim\t\t : Memilih sebuah Sim yang dimainkan\n" +
                    "10. Add Sim\t\t : Menambahkan sebuah Sim\n" +
                    "11. Exit\t\t : Keluar dari game\n");
        }
    }

    public void exit() {
        System.out.println("Thanks for playing! Goodbye!");
        System.exit(0);
    }

    public void viewSimInfo(World world) {

        System.out.println("Current Sim Info");
        System.out.printf("Nama\t\t: %s%n", world.getCurrentSim().getNama());
        System.out.printf("Pekerjaan\t: %s%n",world.getCurrentSim().getPekerjaan().getPekerjaan());
        System.out.printf("Kesehatan\t: %d%n",world.getCurrentSim().getKesehatan());
        System.out.printf("Kekenyangan\t: %d%n",world.getCurrentSim().getKekeyangan());
        System.out.printf("Mood\t\t: %d%n",world.getCurrentSim().getMood());
        System.out.printf("Uang\t\t: %d%n",world.getCurrentSim().getUang());
    }

    public void viewCurrentLoc(World world) {
        world.displayCurrentLoc();
    }

    public void viewInventory(World world) {
        world.getCurrentSim().getInventory().lihatInventory();
    }

    public void upgradeHouse(World world) {
        world.getCurrentRumah().upgradeRumah();
    }

    public void moveRoom(World world) {
        world.getCurrentRumah().pindahRuangan();
    }

    public void editRoom() {

    }

    public void listObj(World world) {
        world.getCurrentRumah()
                .getCurrRuangan()
                .displayDaftarObjek();
    }

    public void goToObj(World world) {
        world.getCurrentRumah().getCurrRuangan().move();
    }

    public void action(World world) {
        Scanner input = new Scanner(System.in);
        List<String> actions = new ArrayList<>();

        // Get valid action from currFurnitur
         if(!(world.getCurrFurnitur() == null)) {
             String action = world.getCurrFurnitur()
                                    .getValidAction()
                                    .getStatus();
             actions.add(action);
         }

         // Get valid action to upgrade house
        if(world.getCurrentRumah().getOwner().equals(world.getCurrentSim().getNama())) {
            actions.add("Upgrade rumah");
        }

        // Add sim valid actions
        actions.add("Kerja");
        actions.add("Olahraga");
        actions.add("Berkunjung");
        actions.add("Meditasi");
        actions.add("Berkelahi");
        actions.add("Nyanyi");
        actions.add("Menari");
        actions.add("Daydreaming");
        actions.add("Monolog");
        actions.add("Lelucon");

        // Display valid action
        System.out.println("Valid Action");
        for(int i = 0; i < actions.size(); i++) {
            System.out.printf("%d. %s%n",i+1,actions.get(i));
        }

        // Choose action
        System.out.print("Pilih aksi yang ingin dilakukan : ");
        String actioninput = input.nextLine().toLowerCase();

        boolean found = false;
        for(String validaction : actions) {
            if (validaction.equalsIgnoreCase(actioninput)) {
                found = true;
                break;
            }
        }

        // Action conditional
        if(!found) {
            System.out.println("Aksi yang dimasukkan tidak valid!!");
        } else {
            int durasi;
            switch(actioninput) {
                case "upgrade rumah" :
                    upgradeHouse(world);
                    break;
                case "kerja" :
                    world.getCurrentSim();
                    break;
                case "olahraga" :
                    System.out.print("Input durasi : ");
                    durasi = input.nextInt();
                    world.getCurrentSim().olahraga(durasi);
                    break;
                case "tidur" :
                    System.out.print("Input durasi : ");
                    durasi = input.nextInt();
                    world.getCurrentSim();
                    break;
                case "makan" :
                    System.out.print("Input durasi : ");
                    durasi = input.nextInt();
                    world.getCurrentSim();
                    break;
                case "memasak" :
                    System.out.print("Input durasi : ");
                    durasi = input.nextInt();
                    world.getCurrentSim();
                    break;
                case "berkunjung" :
                    world.displayWorld();
                    System.out.print("Input tujuan berkunjung : ");
                    String tujuan = input.nextLine().toLowerCase();
                    Rumah rumahtujuan = null;
                    for(Rumah rumah : world.getDaftarRumah().values()) {
                        if(rumah.getOwner().equalsIgnoreCase(tujuan)) {
                            rumahtujuan = rumah;
                        }
                    }
                    if(rumahtujuan == null) {
                        System.out.println("Rumah tujuan tidak valid!!");
                    } else {
                        world.getCurrentSim().berkunjung(rumahtujuan);
                        world.getCurrentSim().setCurrentRumah(rumahtujuan);
                    }
                    break;
                case "buang air" :
                    world.getCurrentSim();
                    break;
                case "meditasi" :
                    System.out.print("Input durasi : ");
                    durasi = input.nextInt();
                    world.getCurrentSim().meditasi(durasi);
                    break;
                case "berkelahi" :
                    world.displaySims();
                    System.out.print("Input lawan berkelahi: ");
                    String lawan = input.nextLine().toLowerCase();
                    Sim simlawan = null;
                    for(Sim sim : world.getSims()) {
                        if (sim.getNama().equalsIgnoreCase(lawan)) {
                            simlawan = sim;
                        }
                    }
                    if(simlawan == null) {
                        System.out.println("Lawan tidak valid!!");
                    } else {
                        world.getCurrentSim().berkelahi(simlawan);
                    }
                    break;
                case "nyanyi" :
                    System.out.print("Input durasi : ");
                    durasi = input.nextInt();
                    world.getCurrentSim().nyanyi(durasi);
                    break;
                case "menari" :
                    System.out.print("Input durasi : ");
                    durasi = input.nextInt();
                    world.getCurrentSim().menari(durasi);
                    break;
                case "daydreaming" :
                    world.getCurrentSim().daydreaming();
                    break;
                case "monolog" :
                    System.out.print("Input durasi : ");
                    durasi = input.nextInt();
                    world.getCurrentSim().monolog(durasi);
                    break;
                case "lelucon" :
                    world.displaySims();
                    System.out.print("Input target Sim: ");
                    String target = input.nextLine().toLowerCase();
                    Sim simtarget = null;
                    for(Sim sim : world.getSims()) {
                        if (sim.getNama().equalsIgnoreCase(target)) {
                            simtarget = sim;
                        }
                    }
                    if(simtarget == null) {
                        System.out.println("Target tidak valid!!");
                    } else {
                        world.getCurrentSim().lelucon(simtarget);
                    }
                    break;
                default :
                    System.out.println("Aksi tidak valid!!");
            }
        }
    }

    public void save(World world) {
//        Gson gson = new Gson();
//        try (FileWriter writer = new FileWriter("save.json")) {
//            gson.toJson(world, writer);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
    public World load() {
//        Gson gson = new Gson();
//        try {
//            FileReader reader = new FileReader("save.json");
//            World world = gson.fromJson(reader, World.class);
//            return world;
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        return new World(new Waktu(0,0,0));
    }
}