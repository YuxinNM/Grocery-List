package ui;

import javax.swing.*;

import model.Grocery;

import java.awt.*;

import model.GroceryList;
import persistence.JsonReader;
import persistence.JsonWriter;

// Creates the GUI panel of the grocery list app 
public class GraphicalGroceryApp {
    private static final String JSON_DESTINATION = "./data/grocerylist.json";
    private JFrame groceryFrame;
    private JPanel viewListPanel;
    private GroceryList groceryList;
    private JMenuBar menuBar;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: takes the groceryList passed in, initialize the groceryList field
    //          displays the grocery list
    public GraphicalGroceryApp(GroceryList groceryList) {
        this.groceryList = groceryList;
        menuBar = new JMenuBar();
        displayFrame();
        displayMenu();
    }

    // EFFECTS: display menu with menu items: add new grocery item,
    //          remove grocery item, calculates the total price, 
    //          view nutritional report, save list
    private void displayMenu() {
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
            emptyLisButton.setFocusable(false);
            emptyLisButton.setVisible(true);
            viewListPanel.add(emptyLisButton);
        }
    }


}
