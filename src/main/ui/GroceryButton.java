package ui;

import javax.swing.*;
import java.awt.*;

// Creates the button for the grocery items
public class GroceryButton extends JButton {
    private final Color VEGECOLOR = new Color(240,255,240);
    private final Color FRUITCOLOR = new Color(255,228,225);
    private final Color PROTEINCOLOR = new Color(240,255,255);
    private final Color GRAINCOLOR = new Color(245,222,179);
    private final Color OTHERSCOLOR = new Color(216,191,216);
    private String content;
    private int price;
    private String category;

    // EFFECTS: creates a button for a grocery item with its name, price
    //          and background color corresponding to its category
    public GroceryButton(String name, int price, String category) {
        this.setPreferredSize(new Dimension(25,15));
        this.setFont(new Font("Arial", Font.BOLD, 10));
        this.setText(name);
        this.price = price;
        this.category = category;
        this.setCategoryColor(category);
    }

    // REQUIRES: category should be one of the followings: 
    //           vegetables, fruits, protein, grains, others
    // EFFECTS: sets the button color according to the category
    private void setCategoryColor(String category) {
        //stub
    }

    // EFFECTS: the button will display the name and price of the grocery
    @Override
    public void setText(String text) {
        content = text + " $ " + price;
        super.setText(content);
    }
}
