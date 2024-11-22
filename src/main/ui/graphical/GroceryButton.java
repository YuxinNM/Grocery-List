package ui.graphical;

import javax.swing.*;
import java.awt.*;

// Creates the button for the grocery items
public class GroceryButton extends JButton {
    private static final Color VEGE_COLOR = new Color(152,200,152);
    private static final Color FRUIT_COLOR = new Color(255,228,225);
    private static final Color PROTEIN_COLOR = new Color(240,255,250);
    private static final Color GRAIN_COLOR = new Color(245,222,179);
    private static final Color OTHERS_COLOR = new Color(216,191,216);
    private String content;
    private double price;

    // EFFECTS: creates a button for a grocery item with its name, price
    //          and background color corresponding to its category
    public GroceryButton(String name, double price, String category) {
        this.setFont(new Font("Comics", Font.ITALIC, 15));
        this.price = price;
        this.setText(name);
        this.setCategoryColor(category);
        this.setFocusable(false);        
    }

    // EFFECTS: sets the button color according to the category
    private void setCategoryColor(String category) {
        Color color;
        if (category.equals("vegetables")) {
            color = VEGE_COLOR;
        } else if (category.equals("fruits")) {
            color = FRUIT_COLOR;
        } else if (category.equals("grains")) {
            color = GRAIN_COLOR;
        } else if (category.equals("proteins")) {
            color = PROTEIN_COLOR;
        } else {
            color = OTHERS_COLOR;
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
