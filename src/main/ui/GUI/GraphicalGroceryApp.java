package ui.GUI;

import javax.swing.*;

import model.Grocery;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import model.GroceryList;
import persistence.JsonReader;
import persistence.JsonWriter;

// Creates the GUI panel of the grocery list app 
public class GraphicalGroceryApp implements ActionListener{
    private static final String JSON_DESTINATION = "./data/grocerylist.json";
    private JFrame groceryFrame;
    private SubPanel viewListPanel;
    private JPanel mainPanel;

    private GroceryList groceryList;
    private JMenuBar menuBar;
    private JMenu analyze;
    private JMenuItem addGrocery;
    private JMenuItem removeGrocery;
    private JMenuItem calcTotalPrice;
    private JMenuItem viewNutrition;
    private JMenuItem viewGroceries;
    private JMenuItem saveFile;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: takes the groceryList passed in, initialize the groceryList field
    //          displays the grocery list
    public GraphicalGroceryApp(GroceryList groceryList) {
        mainPanel = new JPanel();
        mainPanel.setSize(500, 500);
        mainPanel.setLayout(new GridLayout(0, 1, 0, 3));
        jsonWriter = new JsonWriter(JSON_DESTINATION);
        this.groceryList = groceryList;
        menuBar = new JMenuBar();
        displayFrame();
        displayMenu();
    }

    // EFFECTS: display menu with menu items: add new grocery item,
    //          remove grocery item, calculates the total price, 
    //          view nutritional report, save list
    private void displayMenu() {
        analyze = new JMenu("Analyze");
        
        addGrocery = new JMenuItem("Add grocery item");
        removeGrocery = new JMenuItem("Remove grocery item");
        calcTotalPrice = new JMenuItem("Calculate total price");
        viewNutrition = new JMenuItem("View nutritional report");
        viewGroceries = new JMenuItem("View groceries");
        saveFile = new JMenuItem("Save file");
 
        menuBar.add(analyze);
        menuBar.add(saveFile);

        analyze.add(addGrocery);
        analyze.add(removeGrocery);
        analyze.add(calcTotalPrice);
        analyze.add(viewNutrition);
        analyze.add(viewGroceries);
        addActionListenerToMenu();
    }

    //EFFECTS: addActionListener to the JMenuItems
    private void addActionListenerToMenu() {
        addGrocery.addActionListener(this);
        removeGrocery.addActionListener(this);
        calcTotalPrice.addActionListener(this);
        viewNutrition.addActionListener(this);
        viewGroceries.addActionListener(this);
        saveFile.addActionListener(this);
    }

    //EFFECTS: setup the window
    public void displayFrame() {
        groceryFrame = new JFrame();
        groceryFrame.setTitle("Grocery List");
        groceryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        groceryFrame.setSize(500, 500);
        groceryFrame.setResizable(true);
        
        groceryFrame.setJMenuBar(menuBar);
        groceryFrame.add(mainPanel);
        groceryFrame.setVisible(true);

        viewListPanel(); 
    }

    // EFFECTS: add a panel that allows viewing grocery list
    public void viewListPanel() {
        viewListPanel = new SubPanel();
        addGroceryButtons();
        mainPanel.add(viewListPanel);
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
            MessageButton emptyListButton = new MessageButton("No items in the list");
            viewListPanel.add(emptyListButton);
        }
    }

    // EFFECTS: acts upon selections of the menu items as their name indicates
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addGrocery) {
            addGroceryPanel();
        } else if (e.getSource() == calcTotalPrice) {
            displayTotalPrice();
        } else if (e.getSource() == removeGrocery) {
            removeGroceryPanel();
        } else if (e.getSource() == viewNutrition) {
            displayNutrition();
        } else if (e.getSource() == viewGroceries) {
            displayFrame();
        } else if (e.getSource() == saveFile) {
            saveFile();
        }
    }

    // EFFECTS: saves the file to a Json object to the destination
    private void saveFile() {
        try {
            jsonWriter.open();
            jsonWriter.write(groceryList);
            jsonWriter.close();
            SubPanel saveSuccessPanel = new SubPanel();    
            MessageButton saveSuccessButton = new MessageButton("Your grocery list has been successfully saved to " + JSON_DESTINATION);
            mainPanel.removeAll();
            saveSuccessPanel.add(saveSuccessButton);
            mainPanel.add(saveSuccessPanel);
            groceryFrame.add(mainPanel);
            groceryFrame.pack();
        } catch (FileNotFoundException e) {
            SubPanel saveFailPanel = new SubPanel();    
            MessageButton errorButton = new MessageButton("Unable to save file to" + JSON_DESTINATION);
            saveFailPanel.add(errorButton);
            mainPanel.removeAll();
            mainPanel.add(saveFailPanel);
            groceryFrame.add(mainPanel);
            groceryFrame.pack();
         }
    }

    // EFFECTS: panel that displays the nutrition distribution by a pie chart
    private void displayNutrition() {
       
    }

    // EFFECTS: panel that allows removing a grocery item
    private void removeGroceryPanel() {
        SubPanel removeSuccessPanel = new SubPanel();    
        MessageButton removeSuccessButton = new MessageButton("Your grocery has been removed");
        removeSuccessPanel.add(removeSuccessButton);
        mainPanel.removeAll();
        mainPanel.add(removeSuccessPanel);
        groceryFrame.add(mainPanel);
        groceryFrame.pack();
    }

    // EFFECTS: panel that allows adding a grocery item
    private void addGroceryPanel() {
    }

    // EFFECTS: get total price of the groceryList and display it on a JPanel
    private void displayTotalPrice() {
    }

    
}
