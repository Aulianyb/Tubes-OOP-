/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.simplicity;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Menu game = new Menu();
        game.displayMainMenu("awal");
        Scanner input = new Scanner(System.in);
        game.startGame(input);

    }
}