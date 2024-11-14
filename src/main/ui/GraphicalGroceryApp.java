package ui;

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
    private JPanel viewListPanel;
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
        //mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
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

        saveFile.addActionListener(this);
        viewNutrition.addActionListener(this);
        removeGrocery.addActionListener(this);
        
        menuBar.add(analyze);
        menuBar.add(saveFile);

        analyze.add(addGrocery);
        analyze.add(removeGrocery);
        analyze.add(calcTotalPrice);
        analyze.add(viewNutrition);
        analyze.add(viewGroceries);
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
        //groceryFrame.pack();
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
            JButton emptyListButton = new JButton("No items in the list");
            setUpButton(emptyListButton);
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

    // EFFECTS: sets up a JButton
    public void setUpButton(JButton button) {
        button.setSize(200, 250);
        button.setFocusable(false);
        button.setVisible(true);
    }
    
    // EFFECTS: saves the file to a Json object to the destination
    private void saveFile() {
        try {
            jsonWriter.open();
            jsonWriter.write(groceryList);
            jsonWriter.close();
            JPanel saveSuccessPanel = new JPanel();    
            JButton saveSuccessButton = new JButton("Your grocery list has been successfully saved to " + JSON_DESTINATION);
            setUpButton(saveSuccessButton);
            mainPanel.removeAll();
            saveSuccessPanel.add(saveSuccessButton);
            mainPanel.add(saveSuccessPanel);
            groceryFrame.add(mainPanel);
            groceryFrame.pack();
        } catch (FileNotFoundException e) {
            JPanel saveFailPanel = new JPanel();    
            JButton errorButton = new JButton("Unable to save file to" + JSON_DESTINATION);
            setUpButton(errorButton);
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
        JPanel removeSuccessPanel = new JPanel();    
        JButton removeSuccessButton = new JButton("Your grocery has been removed");
        setUpButton(removeSuccessButton);
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
