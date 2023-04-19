package simplicity;
import java.util.*;
public class Menu {

    public Menu() {

    }

//    public void mainMenu() {
//        displayMainMenu("awal");
//
//    }
//
//    public void inGameMenu() {
//        displayMainMenu("ingame");
//    }

    public void displayMainMenu(String option) {
        String[] optionAwal = {"Start Game", "Help", "Exit"};
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
                "Exit"};
        if(option.equals("awal")) {
            System.out.println("Welcome to Sim-Plicity");
            for(int i = 1; i <= optionAwal.length; i++) {
                System.out.printf("%d. %s%n",i,optionAwal[i-1]);
            }
            System.out.println("");
        } else if(option.equals("ingame")) {
            System.out.println("In Game Menu");
            for(int i = 1; i <= optionInGame.length; i++) {
                System.out.printf("%d. %s%n",i,optionInGame[i-1]);
            }
            System.out.println("");
        }
    }

    public void startGame(Scanner inp) {
        boolean end = false;
        while(!end) {
            System.out.println("Masukkan Command: ");
            String cmd = inp.nextLine().toLowerCase();
            if(cmd.equals("start game")) {
                end = true;
            } else if(cmd.equals("help")) {
                help();
            } else if(cmd.equals("exit")) {
                end = true;
                exit();
            } else {
                System.out.println("Input tidak valid, silahkan masukkan ulang input");
            }
        }
    }

    public void help() {

    }

    public void exit() {
        System.out.println("Thanks for playing! Goodbye!");
        System.exit(0);
    }

    public void viewSimInfo() {

    }

    public void viewCurrentLoc() {

    }

    public void viewInventory() {

    }

    public void upgradeHouse() {

    }

    public void moveRoom() {

    }

    public void editRoom() {

    }

    public void addSim() {

    }

    public void changeSim() {

    }

    public void listObj() {

    }

    public void goToObj() {

    }

    public void action() {

    }



}