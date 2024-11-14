package ui.GUI;

import javax.swing.*;
import java.awt.*;

// Creates the button for the grocery items
public class GroceryButton extends JButton {
    private final Color VEGECOLOR = new Color(152,200,152);
    private final Color FRUITCOLOR = new Color(255,228,225);
    private final Color PROTEINCOLOR = new Color(240,255,255);
    private final Color GRAINCOLOR = new Color(245,222,179);
    private final Color OTHERSCOLOR = new Color(216,191,216);
    private String content;
    private double price;

    // EFFECTS: creates a button for a grocery item with its name, price
    //          and background color corresponding to its category
    public GroceryButton(String name, double price, String category) {
        this.setFont(new Font("Comics", Font.BOLD, 15));
        this.price = price;
        this.setText(name);
        this.setCategoryColor(category);
        this.setFocusable(false);        
    }

    // EFFECTS: sets the button color according to the category
    private void setCategoryColor(String category) {
        Color color;
        if (category.equals("vegetables")) {
            color = VEGECOLOR;
        } else if (category.equals("fruits")) {
            color = FRUITCOLOR;
        } else if (category.equals("grains")) {
            color = GRAINCOLOR;
        } else if (category.equals("proteins")) {
            color = PROTEINCOLOR;
        } else {
            color = OTHERSCOLOR;
        }
        this.setBackground(color);
        this.setOpaque(true);
    }

    // EFFECTS: the button will display the name and price of the grocery
    @Override
    public void setText(String text) {
        this.content = text + " $" + this.price;
        super.setText(this.content);
    }
}
