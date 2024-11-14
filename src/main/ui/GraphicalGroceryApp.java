package ui;

import javax.swing.*;
import java.awt.*;

// Creates the GUI panel of the grocery list app 
public class GraphicalGroceryApp {
    private JFrame groceryFrame;
    private JPanel viewListPanel;

    public GraphicalGroceryApp() {
        displayFrame();
    }

    //EFFECTS: setup the window
    public void displayFrame() {
        groceryFrame = new JFrame();
        groceryFrame.setTitle("Grocery List");
        groceryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        groceryFrame.setSize(500, 500);
        groceryFrame.setResizable(true);
        groceryFrame.setVisible(true);

        viewListPanel(); 
    }

    // EFFECTS: add a panel that allows viewing grocery list
    public void viewListPanel() {
        viewListPanel = new JPanel();
        viewListPanel.setBackground(new Color(224,255,255));
        viewListPanel.setLayout(new GridLayout(0, 1, 0, 3));

        // just examples to test buttons: need to add groceries in the list instead
        viewListPanel.setSize(new Dimension(60, 500));
        GroceryButton exbutton = new GroceryButton("apple", 3.00, "fruits");
        viewListPanel.add(exbutton);
        GroceryButton ex2button = new GroceryButton("milk", 7.00, "proteins");
        viewListPanel.add(ex2button);
        GroceryButton ex3button = new GroceryButton("cookie", 6.00, "others");
        viewListPanel.add(ex3button);
        GroceryButton ex4button = new GroceryButton("lettuce", 6.00, "vegetables");
        viewListPanel.add(ex4button);
        GroceryButton ex5button = new GroceryButton("bread", 4.00, "grains");
        viewListPanel.add(ex5button);

        viewListPanel.setVisible(true);
        groceryFrame.add(viewListPanel, BorderLayout.CENTER);
    }

}
