package me.szkristof.hf03;

import me.szkristof.hf03.classes.equipment.Equipment;
import me.szkristof.hf03.classes.equipment.Gloves;
import me.szkristof.hf03.classes.equipment.Mask;
import me.szkristof.hf03.classes.managers.ConsoleManager;
import me.szkristof.hf03.classes.managers.Core;
import me.szkristof.hf03.classes.products.Notebook;
import me.szkristof.hf03.classes.products.Pencil;
import me.szkristof.hf03.classes.products.Product;

import java.io.Console;
import java.util.List;
import java.util.Scanner;

public class Main {

    //Változók
    private static Core core;
    private static ConsoleManager consoleManager;
    private static Scanner scanner;

    /**
     * Main metódus, amely a program indítása során hívódik meg!
     *
     * @param args Szöveg tömb ami a bejövő utasításokat tárolja, ebben a programban ez nincs kihasználva!
     * */
    public static void main(String[] args) {
        setupProject();
        setDefaults();

        consoleManager.startConsole();
    }

    /***
     * Ez az eljárás feltölti a feladatban kértek alapján a listákat minden típúsból 4-4 elemmel
     */
    private static void setDefaults() {
        //4 Ceruza hozzáadása
        core.addItem(new Pencil(350, "Red"));
        core.addItem(new Pencil(400, "Black"));
        core.addItem(new Pencil(425, "Black-White"));
        core.addItem(new Pencil(375, "Red-Blue"));

        //4 Jegyzetfüzet hozzáadása
        core.addItem(new Notebook(50, 40));
        core.addItem(new Notebook(70, 60));
        core.addItem(new Notebook(40, 35));
        core.addItem(new Notebook(120, 100));

        //4 Maszk hozzáadása
        core.addItem(new Mask(8, "Type-S"));
        core.addItem(new Mask(9, "Type-E"));
        core.addItem(new Mask(7, "Type-E"));
        core.addItem(new Mask(12, "Type-V"));

        //4 Kesztyű hozzáadása
        core.addItem(new Gloves(2, 8));
        core.addItem(new Gloves(3, 9));
        core.addItem(new Gloves(1, 10));
        core.addItem(new Gloves(5, 11));
    }

    /***
     * Ez az eljárás definiálja a projektben szükséges változók értékeit
     */
    private static void setupProject() {
        core = new Core();
        scanner = new Scanner(System.in);

        consoleManager = new ConsoleManager();
    }

    /***
     * Vissza tér a Core nevű vezérlővel, ez a fő tároló
     */
    public static Core getCore() {
        return core;
    }

    /***
     * Vissza tér a Scanner-el, így nem kell minden alkalommal újat indítani
     */
    public static Scanner getScanner() {
        return scanner;
    }

    /***
     * Vissza tér a Konzol kezelővel
     */
    public static ConsoleManager getConsoleManager() {
        return consoleManager;
    }
}// Osztály vége
