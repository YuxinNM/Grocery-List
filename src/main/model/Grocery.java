package model;

import org.json.JSONObject;

import persistence.Writable;

// Represents a grocery with its name, price (in dollars), and food category
public class Grocery implements Writable {
    private String name;
    private Double price;
    private String category;

    // REQUIRES: price >= 0
    //           food category would be one of the following: vegetables, fruits, 
    //           grains, proteins, and others
    // EFFECTS: create a grocery entry with given name, price and food category.
    public Grocery(String name, Double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // MODIFIES: this
    // EFFECTS: change the grocery name to new name
    public void changeName(String newName) {
        this.name = newName;
    }
     
    // REQUIRES: newPrice >= 0
    // MODIFIES: this
    // EFFECTS: change the price to the new price
    public void changePrice(double newPrice) {
        this.price = newPrice;
    }

    // REQUIRES: newCategory would be one of the following: vegetables, proteins, 
    //          grains, fruits, and others
    // MODIFIES: this
    // EFFECTS: change the category label to the new label
    public void changeCategory(String newCategory) {
        this.category = newCategory;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getCategory() {
        return this.category;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("price", price);
        json.put("category", category);
        return json;
    }
}
