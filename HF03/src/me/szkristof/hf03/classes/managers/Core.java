package me.szkristof.hf03.classes.managers;

import me.szkristof.hf03.classes.equipment.Equipment;
import me.szkristof.hf03.classes.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Core {

    //Tárolók
    private List<Product> productList;
    private List<Equipment> equipmentList;

    //Konstruktor
    public Core() {
        productList = new ArrayList<>();
        equipmentList = new ArrayList<>();
    }

    /***
     * Ezzel az eljárással lehet hozzá adni egy terméket a listához
     *
     * @param product Termék típusú változó, ezt fogja a listához hozzá adni
     */
    public void addItem(Product product){
        productList.add(product);
    }

    /***
     * Ezzel az eljárással lehet hozzá adni egy felszerelést a listához
     *
     * @param equipment Felszerelés típusú változó, ezt fogja a listához hozzá adni
     */
    public void addItem(Equipment equipment){
        equipmentList.add(equipment);
    }

    /***
     * Ez az eljárás rendezi a termékek listát ár szerint
     */
    public void sortByPrice(){
        for(int i = 0; i < productList.size(); i++){
            for (int j = 0; j < productList.size() - 1; j++) {

                Product temp1 = productList.get(j),
                        temp2 = productList.get(j + 1);

                if(temp1.getPrice() > temp2.getPrice()){

                    Product temp3 = temp1;
                    productList.set(j, temp2);
                    productList.set(j + 1, temp3);

                }
            }
        }
    }

    /***
     * Ez az eljárás rendezi a felszerelések listát biztonsági szint szerint
     */
    public void sortBySecurityLevel(){
        for(int i = 0; i < equipmentList.size(); i++){
            for (int j = 0; j < equipmentList.size() - 1; j++) {

                Equipment temp1 = equipmentList.get(j),
                          temp2 = equipmentList.get(j + 1);

                if(temp1.getSecurityLevel() > temp2.getSecurityLevel()){

                    Equipment temp3 = temp1;
                    equipmentList.set(j, temp2);
                    equipmentList.set(j + 1, temp3);

                }
            }
        }
    }

    /***
     * Ezzel a függvénnyel lehet kikérni a termékek listát
     */
    public List<Product> getProductList() {
        return productList;
    }

    /***
     * Ezzel a függvénnyel lehet kikérni a felszerelések listát
     */
    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

} //Osztály vége
