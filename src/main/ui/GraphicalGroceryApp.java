package ui;

import javax.swing.*;

// Creates the GUI panel of the grocery list app 
public class GraphicalGroceryApp {
    private JFrame groceryFrame;

    public GraphicalGroceryApp() {
        displayFrame();
    }

    //EFFECTS: setup the window
    public void displayFrame() {
        groceryFrame = new JFrame();
        groceryFrame.setTitle("Grocery List");
        groceryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        groceryFrame.setSize(500, 500);
        groceryFrame.setResizable(false);
        groceryFrame.setVisible(true);
    }

}
