package com.simplicity;
import java.util.*;
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

    public void viewSimInfo(Sim sim) {
        System.out.println("Current Sim Info");
        System.out.printf("Nama\t\t: %s%n",sim.getNama());
        System.out.printf("Pekerjaan\t: %s%n",sim.getPekerjaan().getPekerjaan());
        System.out.printf("Kesehatan\t: %d%n",sim.getKesehatan());
        System.out.printf("Kekenyangan\t: %d%n",sim.getKekeyangan());
        System.out.printf("Mood\t\t: %d%n",sim.getMood());
        System.out.printf("Uang\t\t: %d%n",sim.getUang());
    }

    public void viewCurrentLoc(World world) {
        world.displayCurrentLoc();
    }

    public void viewInventory(Sim sim) {
        sim.getInventory().lihatInventory();
    }

    public void upgradeHouse(Sim sim, World world, Scanner inp) {

    }

    public void moveRoom() {

    }

    public void editRoom() {

    }

    public void listObj() {

    }

    public void goToObj() {

    }

    public void action() {

    }

    public void save() {

    }
    public void load() {

    }
}