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

        addGroceryButtons();

        viewListPanel.setVisible(true);
        groceryFrame.add(viewListPanel, BorderLayout.CENTER);
    }

    // EFFECTS: add grocery buttons to the viewListPanel if applicable,
    //          add button indicating empty grocery list if needed.
    public void addGroceryButtons() {

    }
}
