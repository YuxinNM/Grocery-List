package ui.graphical;

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
public class GraphicalGroceryApp implements ActionListener {
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

    private SubPanel addGroceryPanel;
    private String newName;
    private double price;
    private MessageButton vegeButton;
    private MessageButton proteinButton;
    private MessageButton grainButton;
    private MessageButton fruitButton;
    private MessageButton otherButton;
    private String category;

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

    // MODIFIES: this
    // EFFECTS: add a panel that allows viewing grocery list
    public void viewListPanel() {
        viewListPanel = new SubPanel();
        addGroceryButtons();
        mainPanel.add(viewListPanel);
    }

    // MODIFIES: this
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
        } else if (e.getSource() == vegeButton) {
            category = "vegetables";
        } else if (e.getSource() == proteinButton) {
            category = "proteins";
        } else if (e.getSource() == grainButton) {
            category = "grains";
        } else if (e.getSource() == fruitButton) {
            category = "fruits";
        }
    }   

    // EFFECTS: saves the file to a Json object to the destination
    private void saveFile() {
        try {
            jsonWriter.open();
            jsonWriter.write(groceryList);
            jsonWriter.close();
            SubPanel saveSuccessPanel = new SubPanel();    
            MessageButton saveSuccessButton = new MessageButton("Your grocery list has been successfully saved to " 
                                                                + JSON_DESTINATION);
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
        addGroceryPanel = new SubPanel();
        mainPanel.removeAll();
        mainPanel.add(addGroceryPanel);
        askNamePanel();
    }

    // EFFECTS: ask for name panel
    private void askNamePanel() {
        SubPanel askNamePanel = new SubPanel();
        MessageButton askNameButton = new MessageButton("Please enter the name of the grocery (enter to submit)");
        JTextFieldUserInput nameTextInput = new JTextFieldUserInput(10);
        askNamePanel.add(askNameButton);
        askNamePanel.add(nameTextInput);
        addGroceryPanel.add(askNamePanel);
        groceryFrame.pack();
        nameTextInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newName = nameTextInput.getText();
                addGroceryPanel.removeAll();
                askPricePanel();
            }
        });
    }

    // EFFECTS: ask price panel for adding a grocery
    private void askPricePanel() {
        SubPanel askPricePanel = new SubPanel();
        MessageButton askPriceButton = new MessageButton("Please enter the price of the grocery (enter to submit)");
        JTextFieldUserInput priceTextInput = new JTextFieldUserInput(10);
        askPricePanel.add(askPriceButton);
        askPricePanel.add(priceTextInput);
        addGroceryPanel.add(askPricePanel);
        groceryFrame.pack();
        priceTextInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                price = Double.parseDouble(priceTextInput.getText());
                if (price < 0) {
                    MessageButton invalidPriceButton = new MessageButton("Invalid price");
                    addGroceryPanel.removeAll();
                    addGroceryPanel.add(invalidPriceButton);
                    groceryFrame.pack();
                } else {
                    askCategoryPanel();
                }
            }
        });
    }

    // EFFECTS: ask for the category for the grocery added
    private void askCategoryPanel() {
        addGroceryPanel.removeAll();
        prepareCategoryButtons();
        SubPanel askCategoryPanel = new SubPanel();
        MessageButton askCategoryButton = new MessageButton("Please select a category by clicking on the options.");
        askCategoryPanel.add(askCategoryButton);
        askCategoryPanel.add(vegeButton);
        askCategoryPanel.add(proteinButton);   
        askCategoryPanel.add(grainButton);
        askCategoryPanel.add(fruitButton);       
        askCategoryPanel.add(otherButton);
        addGroceryPanel.add(askCategoryPanel);
        groceryFrame.pack();
            
    }
    

    // EFFECTS: prepare the buttons for each category
    private void prepareCategoryButtons() {
        vegeButton = new MessageButton("vegetables");
        proteinButton = new MessageButton("proteins");
        grainButton = new MessageButton("grains");
        fruitButton = new MessageButton("fruits");
        otherButton = new MessageButton("others");
        addActionListenerToCategory();
    }

    // EFFECTS: addActionListener to the category buttons
    private void addActionListenerToCategory() {
        vegeButton.addActionListener(this);
        proteinButton.addActionListener(this);
        grainButton.addActionListener(this);
        fruitButton.addActionListener(this);
        otherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                category = "others";
            }
        });
    }

    // EFFECTS: get total price of the groceryList and display it on a JPanel
    private void displayTotalPrice() {
    }

    
}
