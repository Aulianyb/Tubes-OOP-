/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.simplicity;
import java.io.IOException;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        // Game init
        Menu menu = new Menu();
        Scanner input = new Scanner(System.in);
        World world = new World(new Waktu());

        // Start Game
        boolean end = false;
        System.out.println(" __________");
        System.out.println("||  _______|   Sponsored by BNMO     +             +");
        System.out.println("|| |  O v O|   Tugas Besar OOP              +");
        System.out.println("|| |_______|   Made with <3 by Kelompok 7__________");
        System.out.println("|| +  o    |......                  \\ |  ________  | /");
        System.out.println("||         |      |                  \\| | ^ __ ^ | |/");
        System.out.println("-".repeat(21) + " WELCOME TO " + "-".repeat(21) );
        System.out.println("  ___ ___ __  __     ___ _    ___ ___ ___ _______   __");
        System.out.println(" / __|_ _|  \\/  |___| _ \\ |  |_ _/ __|_ _|_   _\\ \\ / /"); 
        System.out.println(" \\__ \\| || |\\/| |___|  _/ |__ | | (__ | |  | |  \\ V / "); 
        System.out.println(" |___/___|_|  |_|   |_| |____|___\\___|___| |_|   |_|  "); 
        System.out.println("-".repeat(53));

        while(!end) {
            menu.displayMainMenu("start");
            System.out.print("Masukkan Command : ");
            String cmd = input.nextLine().toLowerCase();
            switch (cmd) {
                case "start game":
                    // New User
                    world.addSim(input,"init");
                    end = true;
                    break;
                case "load game":
                    world = menu.load();
                    Menu.exit();
                case "help":
                    menu.help("start");
                    break;
                case "exit":
                    end = true;
                    Menu.exit();
                    break;
                default:
                    System.out.println("Input tidak valid, silahkan masukkan ulang input");
                    break;
            }
        }

        world.displayWorld();

        // Game interface
        end = false;
        while(!end) {
            world.displayCurrentRuangan();

            if(world.isInOwnHouse()) {
                menu.displayMainMenu("ownhouse");
            } else {
                menu.displayMainMenu("ingame");
            }
            System.out.print("Masukkan Command : ");
            String cmd = input.nextLine().toLowerCase();

            switch (cmd) {
                case "action":
                    menu.action(world);
                    break;
                case "list object":
                    menu.listObj(world);
                    break;
                case "go to object":
                    menu.goToObj(world);
                    break;
                case "move room":
                    menu.moveRoom(world);
                    break;
                case "edit room":
                    if(world.isInOwnHouse()) {
                        menu.editRoom();
                    } else {
                        System.out.println("Input tidak valid, silahkan masukkan ulang input");
                    }
                    break;
                case "view inventory":
                    menu.viewInventory();
                    break;
                case "view current location":
                    menu.viewCurrentLoc(world);
                    break;
                case "view sim info":
                    menu.viewSimInfo(world);
                    break;
                case "change sim":
                    World.changeSim(input);
                    break;
                case "add sim":
                    world.addSim(input,"");
                    world.displayWorld();
                    break;
                case "help":
                    menu.help("ingame");
                    break;
                case "save":
                    menu.save(world);
                    break;
                case "exit":
                    end = true;
                    Menu.exit();
                    break;
                default:
                    System.out.println("Input tidak valid, silahkan masukkan ulang input");
                    break;
            }
        }
    }
}
