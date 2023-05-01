package com.simplicity;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
// import com.google.gson.Gson;
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
                "View Inventory",
                "View Current Location",
                "View Sim Info",
                "Change Sim",
                "Add Sim",
                "Help",
                "Save",
                "Exit"};
        String[] optionOwnHouse = {
                "Action",
                "List Object",
                "Go To Object",
                "Move Room",
                "View Inventory",
                "View Current Location",
                "View Sim Info",
                "Change Sim",
                "Add Sim",
                "Edit Room",
                "Help",
                "Save",
                "Exit"
        };

        if(option.equals("start")) {
            System.out.println("/".repeat(19) + " NEW GAME MENU " + "/".repeat(19));
            System.out.println("");
            for(int i = 1; i <= optionAwal.length; i++) {
                System.out.printf(" %d. %s%n",i,optionAwal[i-1]);
            }
            System.out.println();
        } else if(option.equals("ingame")) {
            System.out.println("");
            System.out.println("/".repeat(20) + " IN GAME MENU " + "/".repeat(20));
            System.out.println("");
            
            for(int i = 1; i <= optionInGame.length; i++) {
                System.out.printf(" %d. %s%n",i,optionInGame[i-1]);
            }
            System.out.println();
        } else if(option.equals("ownhouse")) {
            System.out.println("In Game Menu");
            for(int i = 1; i <= optionInGame.length; i++) {
                System.out.printf("%d. %s%n",i,optionOwnHouse[i-1]);
            }
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

    public static void exit() {
        System.out.println("Thanks for playing! Goodbye!");
        System.exit(0);
    }

    public void viewSimInfo(World world) {

        System.out.println("Current Sim Info");
        System.out.printf("Nama\t\t: %s%n", World.getCurrentSim().getNama());
        System.out.printf("Pekerjaan\t: %s%n",World.getCurrentSim().getPekerjaan().getPekerjaan());
        System.out.printf("Kesehatan\t: %d%n",World.getCurrentSim().getKesehatan());
        System.out.printf("Kekenyangan\t: %d%n",World.getCurrentSim().getKekeyangan());
        System.out.printf("Mood\t\t: %d%n",World.getCurrentSim().getMood());
        System.out.printf("Uang\t\t: %d%n",World.getCurrentSim().getUang());
    }

    public void viewCurrentLoc(World world) {
        world.displayCurrentLoc();
    }

    public void viewInventory() {
        World.getCurrentSim().getInventory().lihatInventory();
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
        world.displayCurrentRuangan();
        world.getCurrentRumah()
                .getCurrRuangan()
                .displayDaftarObjek();
    }

    public void goToObj(World world) {
        world.displayCurrentRuangan();
        Scanner input = new Scanner(System.in);
        world.getCurrentRumah().getCurrRuangan().move();
        Furnitur currFurnitur = world.getCurrFurnitur();
        if(currFurnitur != null) {
            System.out.printf("Aksi yang bisa dilakukan pada objek ini adalah %s.%n", currFurnitur.getValidAction().getStatus());
            System.out.println("Apakah ingin melakukan aksi tersebut?");
            System.out.print("Input jawaban (YA/TIDAK): ");
            String jawaban = input.nextLine();
            boolean jawabanvalid = false;
            while(!jawabanvalid) {
                jawabanvalid = jawaban.equalsIgnoreCase("ya") || jawaban.equalsIgnoreCase("tidak");
                if(jawaban.equalsIgnoreCase("ya")) {
                    if(currFurnitur instanceof Kasur) {
                        ((Kasur) currFurnitur).tidur(World.getCurrentSim());
                    } else if(currFurnitur instanceof Kompor) {
                        ((Kompor) currFurnitur).masak(World.getCurrentSim());
                    } else if(currFurnitur instanceof MejaKursi) {
                        ((MejaKursi) currFurnitur).makan(World.getCurrentSim());
                    } else if(currFurnitur instanceof Toilet) {
                        ((Toilet) currFurnitur).buangAir(World.getCurrentSim());
                    } else {
                        System.out.println("Objek tidak valid!!");
                    }
                } else  {
                    System.out.println("Silahkan memilih aksi lain!!");
                }

                if(!jawabanvalid) {
                    System.out.println("Silahkan input ulang (YA/TIDAK)!!");
                    System.out.print("Input jawaban (YA/TIDAK) : ");
                    jawaban = input.nextLine();
                }
            }
        }
    }

    public void action(World world) {
        Scanner input = new Scanner(System.in);
        List<String> actions = new ArrayList<>();
        boolean ownHouse = false;

        // Get valid action from currFurnitur
         if(!(world.getCurrFurnitur() == null)) {
             String action = world.getCurrFurnitur()
                                    .getValidAction()
                                    .getStatus();
             actions.add(action);
         }

         // Get valid action to upgrade house and edit room (only in own house)
        if(world.getCurrentRumah().getOwner().equals(World.getCurrentSim().getNama())) {
            actions.add("Upgrade rumah");
            actions.add("Edit Room");
            ownHouse = true;
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
        actions.add("Beli Barang");

        // Get valid action to change job
        if(World.getCurrentSim().getPekerjaan().getDaysSince() > 0) {
            actions.add("Ganti Pekerjaan");
        }


        // Display valid action
        System.out.println("");
        System.out.println("/".repeat(20) + " LIST ACTION " + "/".repeat(20));
        System.out.println("");
        for(int i = 0; i < actions.size(); i++) {
            System.out.printf(" %d. %s%n",i+1,actions.get(i));
        }
        System.out.println("");

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
            Furnitur currFurnitur;
            switch(actioninput) {
                case "ganti pekerjaan" :
                    Pekerjaan.displayPekerjaanValid();
                    System.out.print("\nInput nama pekerjaan baru : ");
                    String namapekerjaan = input.nextLine();
                    World.getCurrentSim().changePekerjaan(namapekerjaan);
                case "upgrade rumah" :
                    upgradeHouse(world);
                    break;
                case "beli barang" :
                    displayBahanMakanan();
                    displayFurnitur();
                    System.out.println("Input detail barang");
                    System.out.print("Nama barang : ");
                    String namabarang = input.nextLine().toLowerCase();
                    System.out.print("Jumlah barang : ");
                    int jumlah = input.nextInt();
                    BisaDibeli barang = createObjekGame(namabarang);
                    if(barang != null) {
                        World.getCurrentSim().beliBarang(barang,jumlah);
                    }
                    break;
                case "kerja" :
                    System.out.print("Input durasi : ");
                    durasi = input.nextInt();
                    World.getCurrentSim().getPekerjaan().kerja(World.getCurrentSim(), durasi);
                    break;
                case "olahraga" :
                    System.out.print("Input durasi : ");
                    durasi = input.nextInt();
                    World.getCurrentSim().olahraga(durasi);
                    break;
                case "tidur" :
                    currFurnitur = World.getCurrentSim().getCurrentRumah().getCurrRuangan().getCurrFurnitur();
                    if( currFurnitur instanceof Kasur) {
                        ((Kasur) currFurnitur).tidur(World.getCurrentSim());
                    }
                    break;
                case "makan" :
                    currFurnitur = World.getCurrentSim().getCurrentRumah().getCurrRuangan().getCurrFurnitur();
                    if( currFurnitur instanceof MejaKursi) {
                        ((MejaKursi) currFurnitur).makan(World.getCurrentSim());
                    }
                    break;
                case "memasak" :
                    currFurnitur = World.getCurrentSim().getCurrentRumah().getCurrRuangan().getCurrFurnitur();
                    if( currFurnitur instanceof Kompor) {
                        ((Kompor) currFurnitur).masak(World.getCurrentSim());
                    }
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
                        World.getCurrentSim().berkunjung(rumahtujuan);
                        World.getCurrentSim().setCurrentRumah(rumahtujuan);
                    }
                    break;
                case "buang air" :
                    currFurnitur = World.getCurrentSim().getCurrentRumah().getCurrRuangan().getCurrFurnitur();
                    if( currFurnitur instanceof Toilet) {
                        ((Toilet) currFurnitur).buangAir(World.getCurrentSim());
                    }
                    break;
                case "meditasi" :
                    System.out.print("Input durasi : ");
                    durasi = input.nextInt();
                    World.getCurrentSim().meditasi(durasi);
                    break;
                case "berkelahi" :
                    World.displaySims();
                    System.out.print("Input lawan berkelahi: ");
                    String lawan = input.nextLine().toLowerCase();
                    Sim simlawan = null;
                    for(Sim sim : World.getSims()) {
                        if (sim.getNama().equalsIgnoreCase(lawan)) {
                            simlawan = sim;
                        }
                    }
                    if(simlawan == null || simlawan.getNama().equals(World.getCurrentSim().getNama())) {
                        System.out.println("Lawan tidak valid!!");
                    } else {
                        World.getCurrentSim().berkelahi(simlawan);
                    }
                    break;
                case "nyanyi" :
                    System.out.print("Input durasi : ");
                    durasi = input.nextInt();
                    World.getCurrentSim().nyanyi(durasi);
                    break;
                case "menari" :
                    System.out.print("Input durasi : ");
                    durasi = input.nextInt();
                    World.getCurrentSim().menari(durasi);
                    break;
                case "daydreaming" :
                    World.getCurrentSim().daydreaming();
                    break;
                case "monolog" :
                    System.out.print("Input durasi : ");
                    durasi = input.nextInt();
                    World.getCurrentSim().monolog(durasi);
                    break;
                case "lelucon" :
                    World.displaySims();
                    System.out.print("Input target Sim: ");
                    String target = input.nextLine().toLowerCase();
                    Sim simtarget = null;
                    for(Sim sim : World.getSims()) {
                        if (sim.getNama().equalsIgnoreCase(target)) {
                            simtarget = sim;
                        }
                    }
                    if(simtarget == null || simtarget.getNama().equals(World.getCurrentSim().getNama())) {
                        System.out.println("Target tidak valid!!");
                    } else {
                        World.getCurrentSim().lelucon(simtarget);
                    }
                    break;
                case "melihat waktu" :
                    currFurnitur = World.getCurrentSim().getCurrentRumah().getCurrRuangan().getCurrFurnitur();
                    if( currFurnitur instanceof Jam) {
                        ((Jam) currFurnitur).lihatJam(World.getCurrentSim());
                    }
                    break;
                default :
                    System.out.println("Aksi tidak valid!!");
            }
        }
    }

    public void displayBahanMakanan() {
        String[] bahan = {
                "Nasi",
                "Kentang",
                "Ayam",
                "Sapi",
                "Wortel",
                "Bayam",
                "Kacang",
                "Susu",
        };
        System.out.println("List Bahan Makanan");
        for(int i = 1; i <= bahan.length; i++) {
            System.out.printf("%d. %s%n",i,bahan[i-1]);
        }
    }

    public void displayFurnitur() {
        String[] furnitur = {
                "Kasur Single",
                "Kasur Queen Size",
                "Kasur King Size",
                "Toilet",
                "Kompor Gas",
                "Kompor Listrik",
                "Meja dan Kursi",
                "Jam",
        };
        System.out.println("List Furnitur");
        for(int i = 1; i <= furnitur.length; i++) {
            System.out.printf("%d. %s%n",i,furnitur[i-1]);
        }
    }

    public BisaDibeli createObjekGame(String name) {
        switch(name) {
            case "nasi" :
                return new BahanMakanan("Nasi");
            case "kentang" :
                return new BahanMakanan("Kentang");
            case "ayam" :
                return new BahanMakanan("Ayam");
            case "sapi" :
                return new BahanMakanan("Sapi");
            case "wortel" :
                return new BahanMakanan("Wortel");
            case "bayam" :
                return new BahanMakanan("Bayam");
            case "kacang" :
                return new BahanMakanan("Kacang");
            case "susu" :
                return new BahanMakanan("Susu");
            case "kasur single" :
                return new KasurSingle("KasurSingle");
            case "kasur queen size" :
                return new KasurQueenSize("KasurQueenSize");
            case "kasur king size" :
                return new KasurKingSize("KasurKingSize");
            case "toilet" :
                return new Toilet("Toilet");
            case "kompor gas" :
                return new KomporGas("KomporGas");
            case "kompor listrik" :
                return new KomporListrik("KomporListrik");
            case "meja dan kursi" :
                return new MejaKursi("MejaDanKursi");
            case "jam" :
                return new Jam("Jam");
            default :
                System.out.println("Barang tidak tersedia!!");
                return null;
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
        return new World(new Waktu());
    }
}