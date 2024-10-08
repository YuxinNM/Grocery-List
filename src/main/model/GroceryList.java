package model;
import java.util.*;

public class GroceryList {
    private ArrayList<Grocery> groceries;
    private int vegeCount;
    private int fruitCount;
    private int grainsCount;
    private int dairyCount;
    private int othersCount;

    private double vegePerct;
    private double fruitPerct;
    private double grainsPerct;
    private double dairyPerct;
    private double othersPerct;

    private double totalPrice;

    // EFFECTS: Create an empty list of groceries 
    //          with counts of the groceries in different food categories,
    //          percentages of different food categories of the list,
    //          and the total price of all the goceries
    public void GroceryList() {
        groceries = new ArrayList<Grocery>();

        vegeCount = 0;
        fruitCount = 0;
        grainsCount = 0;
        dairyCount = 0;
        othersCount = 0;

        vegePerct = 0.0;
        fruitPerct = 0.0;
        grainsPerct = 0.0;
        dairyPerct = 0.0;
        othersPerct = 0.0;

        totalPrice = 0.00;
    }

    // MODIFIES: this
    // EFFECTS: add a new grocery to the list, there can be duplicates
    //          increment the corresponding counts of categories,
    //          increase the total price with the grocery's price
    public void addGrocery(Grocery grocery) {

    }

    // REQUIRES: grocery is in the list
    // MODIFIES: this
    // EFFECTS: remove a new grocery to the list, 
    //          decrease the corresponding counts of categories,
    //          decrease the total price with the grocery's price
    public void removeGrocery(Grocery grocery){

    }
    
    // MODIFIES: this
    // EFFECTS: sum up the prices of all groceries in the list
    public void sumPrice() {

    }

    // MODIFIES: this
    // EFFECTS: calculate the percentages of each category 
    //          and adjust each category's percentage
    public void calcPercent(String category){

    }


    public double getTotalPrice() {
        return 0.00;
    }

    public int getVegeCount() {
        return 0;
    }

    public int getFruitCount() {
        return 0;
    }

    public int getGrainsCount() {
        return 0;
    }

    public int getDairyCount() {
        return 0;
    }

    public int getOthersCount() {
        return 0;
    }
}
