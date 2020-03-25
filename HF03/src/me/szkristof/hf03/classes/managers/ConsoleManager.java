package me.szkristof.hf03.classes.managers;

import me.szkristof.hf03.Main;
import me.szkristof.hf03.classes.equipment.Equipment;
import me.szkristof.hf03.classes.products.Product;

import java.io.IOException;
import java.util.List;

public class ConsoleManager {

    public ConsoleManager(){}

    /***
     * Ezzel az eljárással elindul a konzol vezérlő (Menü rendszer)
     */
    public void startConsole(){
        do {
            ClearScreen();

            System.out.print("=========[Main Menu]=========\n");
            System.out.print("1) List\n");
            System.out.print("2) Exit\n");
            System.out.print("Option: ");

            String line = Main.getScanner().nextLine();
            switch (line.trim()) {
                case "1":{ listing(); break; }  // Tovább megy a listázáshoz, majd folytatja a ciklust
                case "2":{ return; } // Leállítja a ciklust és kilép az eljárásból
                default:{ continue; } // Folytatja a ciklust
            }
        }while(true);
    }

    private void listing(){
        //Listázás előtti kérdés
        System.out.print("Do you want to sort the list by price and security level? (y/n): ");
        switch (Main.getScanner().nextLine().trim().toLowerCase()) {
            case "y":{ Main.getCore().sortBySecurityLevel(); Main.getCore().sortByPrice(); break; }  // Ha 'y' vagy 'Y' a válasz akkor rendezi a listákat!
            default:{break;} //Ha nem 'Y' a válasz hanem bármi más, akkor nem rendez és tovább halad!
        }

        //Listázás megkezdése
        do{
            ClearScreen();

            System.out.print("=========[List Menu]=========\n");
            System.out.print("1) Products\n");
            System.out.print("2) Equipments\n");
            System.out.print("3) All\n");
            System.out.print("4) Back to main menu\n");
            System.out.print("Option: ");

            String line = Main.getScanner().nextLine();
            switch (line.trim()) {
                case "1":{
                    ClearScreen();

                    System.out.print("Products:\n");

                    List<Product> productList = Main.getCore().getProductList();
                    for(int i = 0; i < productList.size(); i++){
                        System.out.printf("%d. %s\n", (i+1), productList.get(i).toString());
                    }

                    System.out.print("Press the enter button to continue...");
                    Main.getScanner().nextLine();
                    return;
                }  // Tovább megy a termékek kiírásához, majd vissza tér a főmenübe
                case "2":{
                    ClearScreen();
                    System.out.printf("Equipments:\n");

                    List<Equipment> equipmentList = Main.getCore().getEquipmentList();
                    for(int i = 0; i < equipmentList.size(); i++){
                        System.out.printf("%d. %s\n", (i+1), equipmentList.get(i).toString());
                    }

                    System.out.print("Press the enter button to continue...");
                    Main.getScanner().nextLine();
                    return;
                }  // Tovább megy a felszerelések kiírásához, majd vissza tér a főmenübe
                case "3":{
                    ClearScreen();

                    System.out.print("Products:\n");

                    List<Product> productList = Main.getCore().getProductList();
                    for(int i = 0; i < productList.size(); i++){
                        System.out.printf("%d. %s\n", (i+1), productList.get(i).toString());
                    }

                    System.out.printf("\nEquipments:\n");
                    List<Equipment> equipmentList = Main.getCore().getEquipmentList();
                    for(int i = 0; i < equipmentList.size(); i++){
                        System.out.printf("%d. %s\n", (i+1 + productList.size()), equipmentList.get(i).toString());
                    }

                    System.out.print("Press the enter button to continue...");
                    Main.getScanner().nextLine();

                    return;
                }  // Tovább megy a teljes kiíráshoz, majd vissza tér a főmenübe
                case "4":{ return; }  // Egyből vissza tér a főmenübe
                default:{ continue; } // Folytatja a ciklust
            }
        }while(true);
    }

    private void ClearScreen(){
        try {
            if(System.getProperty("os.name").toLowerCase().contains("windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }else{
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            System.out.printf("An error has occured! The error code is \n%s\nPress the enter button to continue...", e.getLocalizedMessage());
            Main.getScanner().nextLine();
        }
    }
}
