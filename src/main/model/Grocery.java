package model;

// Represents a grocery with its name, price (in dollars), and food category
public class Grocery {
    private String name;
    private Double price;
    private String category;

    // REQUIRES: price >= 0 & price should have 2 decimial places, name is not an empty string
    //          food category would be one of the following: vegetables, proteins, 
    //          grains, dairy products, and others
    // EFFECTS: create a grocery entry with given name, price and food category.
    
    public Grocery(String name, Double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // REQUIRES: newName is not an empty string
    // MODIFIES: this
    // EFFECTS: change the grocery name to new name
    public void changeName(String newName) {
        this.name = newName;
    }
     
    // REQUIRES: newPrice >= 0 & it should have 2 decimial places
    // MODIFIES: this
    // EFFECTS: change the price to the new price
    public void changePrice(double newPrice) {
        this.price = newPrice;
    }

    // REQUIRES: newCategory would be one of the following: vegetables, proteins, 
    //          grains, dairy products, and others
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
}
