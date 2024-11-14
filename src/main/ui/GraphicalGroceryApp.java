package ui;

import javax.swing.*;

import model.Grocery;

import java.awt.*;
import java.util.Scanner;

import model.GroceryList;
import persistence.JsonReader;
import persistence.JsonWriter;

// Creates the GUI panel of the grocery list app 
public class GraphicalGroceryApp {
    private JFrame groceryFrame;
    private JPanel viewListPanel;
    private static final String JSON_DESTINATION = "./data/grocerylist.json";
    private GroceryList groceryList;
    JsonWriter jsonWriter;
    JsonReader jsonReader;

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
         if (groceryList.getGroceries().size() > 0) {
            for (Grocery next: groceryList.getGroceries()) {
                GroceryButton groceryButton = new GroceryButton(next.getName(), next.getPrice(), next.getCategory());
                viewListPanel.add(groceryButton);
            }
        } else {
            JButton emptyLisButton = new JButton("No items in the list");
            emptyLisButton.setVisible(true);
            viewListPanel.add(emptyLisButton);
        }
    }
}
