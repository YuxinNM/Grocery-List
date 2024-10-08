package model;

// Represents a grocery with its name, price (in dollars), and food category
public class Grocery {
    private String name;
    private Double price;
    private String category;

    // REQUIRES: price >= 0, name is not an empty string
    //          food category would be one of the following: vegetables, fruits, 
    //          grains, dairy, and others
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

    }
     
    // REQUIRES: newPrice >= 0
    // MODIFIES: this
    // EFFECTS: change the price to the new price
    public void changePrice(double newPrice) {

    }

    // REQUIRES: newCategory would be one of the following: vegetables, fruits, 
    //          grains, dairy, and others
    // MODIFIES: this
    // EFFECTS: change the category label to the new label
    public void changeCategory(String newCategory) {

    }

    public String getName() {
        return "";
    }

    public double getPrice() {
        return 0.0;
    }

    public String getCategory() {
        return "";
    }
}
