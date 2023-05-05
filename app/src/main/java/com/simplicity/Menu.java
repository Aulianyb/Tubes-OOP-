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
        String[] optionAwal = {"Start Game", "Help", "Exit"};
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
            System.out.println();
            System.out.println("/".repeat(20) + " IN GAME MENU " + "/".repeat(20));
            System.out.println();
            
            for(int i = 1; i <= optionInGame.length; i++) {
                System.out.printf(" %d. %s%n",i,optionInGame[i-1]);
            }
            System.out.println();
        } else if(option.equals("ownhouse")) {
            System.out.println();
            System.out.println("/".repeat(20) + " IN GAME MENU " + "/".repeat(20));
            System.out.println();
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

    public void editRoom(World world) {
        System.out.println("Aksi Edit :");
        System.out.println("1. Pasang Barang");
        System.out.println("2. Pindahin Barang");
        System.out.println("3. Remove Barang");
        Scanner input = new Scanner(System.in);
        System.out.print("Pilih Aksi Edit : ");
        String action = input.nextLine().toLowerCase();
        switch(action) {
            case "pasang barang" :
                world.getCurrentRumah().getCurrRuangan().pasangBarang(World.getCurrentSim());
                break;
            case "pindahin barang" :

                break;
            case "remove barang" :
                world.getCurrentRumah().getCurrRuangan().removeBarang(World.getCurrentSim());
                break;
            default :
                System.out.println("Input tidak valid!!");
        }
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
                    currFurnitur.aksi(World.getCurrentSim());
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
                    if(World.getCurrentSim().getUang() < 1500) {
                        System.out.println("Uang tidak cukup untuk mengupgrade rumah!!");
                    } else {
                        World.getCurrentSim().setUang(-1500);
                        upgradeHouse(world);
                    }
                    break;
                case "beli barang" :
                    System.out.println("         __  __   _   ___ _  _____ _____ "); 
                    System.out.println("  +     |  \\/  | /_\\ | _ \\ |/ / __|_   _|   +"); 
                    System.out.println("     +  | |\\/| |/ _ \\|   / ' <| _|  | |       +"); 
                    System.out.println("   +    |_|  |_/_/ \\_\\_|_\\_|\\_\\___| |_|    +"); 
                    System.out.println("=================================================="); 
                    System.out.println("|_   _||_   _||_   _||_   _||_   _||_   _||_   _|"); 
                    System.out.println("  |_|    |_|    |_|    |_|    |_|    |_|    |_|    ");
                    System.out.println();
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
                        currFurnitur.aksi(World.getCurrentSim());
                    }
                    break;
                case "makan" :
                    currFurnitur = World.getCurrentSim().getCurrentRumah().getCurrRuangan().getCurrFurnitur();
                    if( currFurnitur instanceof MejaKursi) {
                        currFurnitur.aksi(World.getCurrentSim());
                    }
                    break;
                case "memasak" :
                    currFurnitur = World.getCurrentSim().getCurrentRumah().getCurrRuangan().getCurrFurnitur();
                    if( currFurnitur instanceof Kompor) {
                        currFurnitur.aksi(World.getCurrentSim());
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
                        currFurnitur.aksi(World.getCurrentSim());
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
                        currFurnitur.aksi(World.getCurrentSim());
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
        int[] harga = {5,3,10,12,3,3,2,2};
        System.out.println("-".repeat(14) + " LIST BAHAN MAKANAN " + "-".repeat(14));
        System.out.println("+----------------+-------+");
        System.out.println("| Bahan Makanan  | Harga |");
        System.out.println("+----------------+-------+");
        for(int i = 0; i < bahan.length; i++) {
            System.out.printf("| %-14s | %5d |%n",bahan[i],harga[i]);
        }
        System.out.println("+----------------+-------+");
        System.out.println();
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
        int[] harga = {50,100,150,50,100,200,50,10};
        System.out.println("-".repeat(17) + " LIST FURNITUR " + "-".repeat(17));
        System.out.println("+---------------------+-------+");
        System.out.println("| Furnitur            | Harga |");
        System.out.println("+---------------------+-------+");
        for(int i = 0; i < furnitur.length; i++) {
            System.out.printf("| %-19s | %5d |%n",furnitur[i],harga[i]);
        }
        System.out.println("+---------------------+-------+");
        System.out.println();
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

    public static void cheat(Scanner sc){
        System.out.println("INI MENU CHEAT MASUKIN ANGKA YA");
        System.out.println("1. Timepass -> masukin detik");
        System.out.println("2. Show Time");
        System.out.println("3. Unlimited Uang");
        System.out.println("4. kesehatan -79");
        System.out.println("5. mood -79");
        System.out.println("6. kekenyangan -79");
        int x = Integer.parseInt(sc.nextLine());
        switch (x) {
            case 1:
                int y = Integer.parseInt(sc.nextLine());
                World.getCurrentSim().testAction(y); 
                System.out.println("Tidur : " + World.getCurrentSim().getJamTidur().waktu);
                System.out.println("Tidur : " + World.getCurrentSim().getJamTidur().kondisi);
                break;
            case 2:
                Waktu.displayWaktu(); 
                break; 
            case 3:
                World.getCurrentSim().setUang(99999);
                break;
            case 4:
                World.getCurrentSim().setKesehatan(-79);
                break;
            case 5:
                World.getCurrentSim().setMood(-79);
                break;
            case 6:
                World.getCurrentSim().setKekenyangan(-79);
                break;
            default:
                break;
        }
    }
}