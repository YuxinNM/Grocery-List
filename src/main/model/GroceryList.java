package model;

import java.util.*;

public class GroceryList {
    private ArrayList<Grocery> groceries;
    private int vegeCount;
    private int fruitCount;
    private int grainsCount;
    private int proteinCount;
    private int othersCount;

    private double vegePerct;
    private double fruitPerct;
    private double grainsPerct;
    private double proteinPerct;
    private double othersPerct;

    private double totalPrice;

    // EFFECTS: Create an empty list of groceries 
    //          with counts of the groceries in different food categories,
    //          percentages of different food categories of the list,
    //          and the total price of all the goceries
    public GroceryList() {
        groceries = new ArrayList<Grocery>();

        vegeCount = 0;
        fruitCount = 0;
        grainsCount = 0;
        proteinCount = 0;
        othersCount = 0;

        vegePerct = 0.0;
        fruitPerct = 0.0;
        grainsPerct = 0.0;
        proteinPerct = 0.0;
        othersPerct = 0.0;

        totalPrice = 0.00;
    }

    // MODIFIES: this
    // EFFECTS: add a new grocery to the list,
    //          increment the corresponding counts of the category,
    //          increase the total price with the grocery's price
    public void addGrocery(Grocery grocery) {
        groceries.add(grocery);
        countUp(grocery.getCategory());
        totalPrice += grocery.getPrice();
    }

    // MODIFIES: this
    // EFFECTS: helpder for addGrocery() 
    //          increment the counts of the category 
    //          corresponding to the given grocery's category
    public void countUp(String category) {
        if (category.equals("vegetables")) {
            vegeCount++;
        } else if (category.equals("fruits")) {
            fruitCount++;
        } else if (category.equals("grains")) {
            grainsCount++;
        } else if (category.equals("proteins")) {
            proteinCount++;
        } else {
            othersCount++;
        }
    }

    // REQUIRES: grocery is in the list
    // MODIFIES: this
    // EFFECTS: remove a new grocery to the list, 
    //          decrease the corresponding counts of categories,
    //          decrease the total price with the grocery's price
    public void removeGrocery(Grocery grocery) {
        groceries.remove(grocery);
        countDown(grocery.getCategory());
        totalPrice -= grocery.getPrice();
    }
    
    // MODIFIES: this
    // EFFECTS: helper for removeGrocery()
    //          decrease the counts of the category 
    //          corresponding to the given grocery's category
    public void countDown(String category) {
        if (category.equals("vegetables")) {
            vegeCount--;
        } else if (category.equals("fruits")) {
            fruitCount--;
        } else if (category.equals("grains")) {
            grainsCount--;
        } else if (category.equals("proteins")) {
            proteinCount--;
        } else {
            othersCount--;
        }
    }

    // MODIFIES: this
    // EFFECTS: calculate the percentages of each category to ones digit 
    //          counts of each category / the size of the list
    public void calcPercent() {
        int size = getGroceries().size();
        this.vegePerct = getVegeCount() * 100 / size;
        this.fruitPerct = getFruitCount() * 100 / size;
        this.grainsPerct = getGrainsCount() * 100 / size;
        this.proteinPerct = getProteinCount() * 100 / size;
        this.othersPerct = getOthersCount() * 100 / size;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getVegeCount() {
        return vegeCount;
    }

    public int getFruitCount() {
        return fruitCount;
    }

    public int getGrainsCount() {
        return grainsCount;
    }

    public int getProteinCount() {
        return proteinCount;
    }

    public int getOthersCount() {
        return othersCount;
    }

    public double getVegePerct() {
        return vegePerct;
    }

    public double getFruitPerct() {
        return fruitPerct;
    }

    public double getGrainsPerct() {
        return grainsPerct;
    }

    public double getProteinPerct() {
        return proteinPerct;
    }

    public double getOthersPerct() {
        return othersPerct;
    }

    public ArrayList<Grocery> getGroceries() {
        return groceries;
    }
}
