package ui.graphical;

import javax.swing.*;

import model.Grocery;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import model.GroceryList;
import persistence.JsonWriter;

import java.util.ArrayList;

// Creates the GUI panel of the grocery list app 
public class GraphicalGroceryApp implements ActionListener {
    private static final String JSON_DESTINATION = "./data/grocerylist.json";
    private JFrame groceryFrame;
    private SubPanel viewListPanel;
    private JPanel mainPanel;

    private GroceryList groceryList;
    private JMenuBar menuBar;
    private JMenu action;
    private JMenuItem addGrocery;
    private JMenuItem removeGrocery;
    private JMenuItem calcTotalPrice;
    private JMenuItem viewNutrition;
    private JMenuItem viewGroceries;
    private JMenuItem saveFile;

    private JsonWriter jsonWriter;

    private SubPanel addGroceryPanel;
    private String newName;
    private double price;
    private MessageButton vegeButton;
    private MessageButton proteinButton;
    private MessageButton grainButton;
    private MessageButton fruitButton;
    private MessageButton otherButton;
    private String category;

    private ArrayList<Grocery> currentList;

    // EFFECTS: takes the groceryList passed in, initialize the groceryList field
    //          displays the grocery list
    public GraphicalGroceryApp(GroceryList groceryList) {
        mainPanel = new JPanel();
        mainPanel.setSize(550, 500);
        mainPanel.setLayout(new GridLayout(0, 1, 0, 3));
        jsonWriter = new JsonWriter(JSON_DESTINATION);
        this.groceryList = groceryList;
        menuBar = new JMenuBar();
        displayFrame();
        displayMenu();
    }

    // MODIFIES: this
    // EFFECTS: display menu with menu items: add new grocery item,
    //          remove grocery item, calculates the total price, 
    //          view nutritional report, save list
    private void displayMenu() {
        action = new JMenu("Actions");
        
        addGrocery = new JMenuItem("Add grocery item");
        removeGrocery = new JMenuItem("Remove grocery item");
        calcTotalPrice = new JMenuItem("Calculate total price");
        viewNutrition = new JMenuItem("View nutritional report");
        viewGroceries = new JMenuItem("View groceries");
        saveFile = new JMenuItem("Save file");
 
        menuBar.add(action);
        menuBar.add(saveFile);

        action.add(addGrocery);
        action.add(removeGrocery);
        action.add(calcTotalPrice);
        action.add(viewNutrition);
        action.add(viewGroceries);
        addActionListenerToMenu();
    }

    // MODIFIES: this
    //EFFECTS: addActionListener to the JMenuItems
    private void addActionListenerToMenu() {
        addGrocery.addActionListener(this);
        removeGrocery.addActionListener(this);
        calcTotalPrice.addActionListener(this);
        viewNutrition.addActionListener(this);
        viewGroceries.addActionListener(this);
        saveFile.addActionListener(this);
    }

    // MODIFIES: this
    //EFFECTS: setup the window
    public void displayFrame() {
        groceryFrame = new JFrame();
        groceryFrame.setTitle("Grocery List");
        groceryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        groceryFrame.setLocation(350, 80);;
        groceryFrame.setSize(550, 500);
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
        mainPanel.removeAll();
        mainPanel.add(viewListPanel);
        groceryFrame.pack();
    }

    // MODIFIES: this
    // EFFECTS: add grocery buttons to the viewListPanel if applicable,
    //          add button indicating empty grocery list if needed.
    public void addGroceryButtons() {
        currentList = groceryList.getGroceries();
        if (currentList.size() > 0) {
            for (Grocery next: currentList) {
                GroceryButton groceryButton = new GroceryButton(next.getName(), next.getPrice(), next.getCategory());
                viewListPanel.add(groceryButton);
            }
        } else {
            MessageButton emptyListButton = new MessageButton("No items in the list");
            viewListPanel.add(emptyListButton);
        }
    }

    // MODIFIES: this
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
            viewListPanel();
        } else if (e.getSource() == saveFile) {
            saveFile();
        } else if (e.getSource() == vegeButton) {
            category = "vegetables";
            addingGrocery();
        } else if (e.getSource() == proteinButton) {
            category = "proteins";
            addingGrocery();
        } else if (e.getSource() == grainButton) {
            category = "grains";
            addingGrocery();
        }
    }   

    // MODIFIES: this
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

    // MODIFIES: this
    // EFFECTS: panel that displays the nutrition distribution by a pie chart
    private void displayNutrition() {
        if (currentList.size() > 0) {
            groceryList.calcPercent();
            double vegePerct = groceryList.getVegePerct();
            double fruitPerct = groceryList.getFruitPerct();
            double proteinPerct = groceryList.getProteinPerct();
            double grainsPerct = groceryList.getGrainsPerct();
            double othersPerct = groceryList.getOthersPerct();
    
            mainPanel.removeAll();
            PieChart pieChart = new PieChart(vegePerct, fruitPerct, proteinPerct, grainsPerct, othersPerct);
            pieChart.setVisible(true);
            mainPanel.add(pieChart);
            groceryFrame.pack();
        } else {
            mainPanel.removeAll();
            SubPanel noItemSubPanel = new SubPanel();
            MessageButton noItemButton = new MessageButton("Please add groceries in the list first.");
            noItemSubPanel.add(noItemButton);
            mainPanel.add(noItemSubPanel);
            groceryFrame.pack();
        }
    }

    //MODIFIES: this
    //EFFECTS: panel to get the name of grocery to remove, 
    //         removes the item in the list with given name,
    //         moves on to the removeSuccess panel
    private void removeGroceryPanel() {
        SubPanel askRemoveNamePanel = new SubPanel();
        String askNameRemove = "Please enter the name of the grocery you want to remove:";
        MessageButton askRemoveNameButton = new MessageButton(askNameRemove);
        String notes = "Notes: if there are duplicates, the first one in the list will be removed.";
        MessageButton notesButton = new MessageButton(notes);
        JTextFieldUserInput nameToRemove = new JTextFieldUserInput(10);
        askRemoveNamePanel.add(askRemoveNameButton);
        askRemoveNamePanel.add(nameToRemove);
        askRemoveNamePanel.add(notesButton);
        
        mainPanel.removeAll();
        mainPanel.add(askRemoveNamePanel);
        groceryFrame.pack();

        nameToRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameForRemoving = nameToRemove.getText();
                boolean nameInList = removeFirstInList(groceryList, nameForRemoving);
                removeSuccessPanel(nameInList);
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: removes the first grocery with given name in the groceryList
    //          return true if grocery was in the list, false if cannot find it
    private boolean removeFirstInList(GroceryList groceryList, String nameToRemove) {
        for (int i = 0; i < currentList.size(); i++) {
            Grocery current =  currentList.get(i);
            if (current.getName().equals(nameToRemove)) {
                groceryList.removeGrocery(current);
                return true;
            }
        }
        return false;
    }

    // MODIFIES: this
    // EFFECTS: display remove success message
    private void removeSuccessPanel(boolean nameInList) {
        SubPanel removeSuccessPanel = new SubPanel();    
        MessageButton removeSuccessButton = new MessageButton("Your grocery has been removed successfully!");
        MessageButton removeUnsuccessButton = new MessageButton("The grocery is not in the list...");
       
        mainPanel.removeAll();
        if (nameInList) {
            removeSuccessPanel.add(removeSuccessButton);
        } else {
            removeSuccessPanel.add(removeUnsuccessButton);
        }
        mainPanel.add(removeSuccessPanel);
        groceryFrame.pack();
    }
    
    // MODIFIES: this
    // EFFECTS: panel that allows adding a grocery item
    private void addGroceryPanel() {
        addGroceryPanel = new SubPanel();
        mainPanel.removeAll();
        mainPanel.add(addGroceryPanel);
        askNamePanel();
    }

    // MODIFIES: this
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

    // MODIFIES: this
    // EFFECTS: ask price panel for adding a grocery
    private void askPricePanel() {
        SubPanel askPricePanel = new SubPanel();
        MessageButton askPriceButton = new MessageButton("Please enter the price of the grocery (enter to submit)");
        JTextFieldUserInput priceTextInput = new JTextFieldUserInput(10);
        askPricePanel.add(askPriceButton);
        askPricePanel.add(priceTextInput);
        addGroceryPanel.add(askPricePanel);
        groceryFrame.pack();
        addPriceInputListener(priceTextInput);
    }

    // MODIFIES: this
    // EFFECTS: accepts the price if >0 and is a number, move on to the asking for category panel,
    //          otherwise output invalid price panel
    private void addPriceInputListener(JTextFieldUserInput priceTextInput) {
        priceTextInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    price = Double.parseDouble(priceTextInput.getText());
                    if (price > 0) {
                        category = "unknown";
                        askCategoryPanel();
                    } else {
                        MessageButton invalidPriceButton = new MessageButton("Invalid price");
                        addGroceryPanel.removeAll();
                        addGroceryPanel.add(invalidPriceButton);
                        groceryFrame.pack();
                    }
                } catch (Exception exception) {
                    MessageButton invalidPriceButton = new MessageButton("Invalid price");
                    addGroceryPanel.removeAll();
                    addGroceryPanel.add(invalidPriceButton);
                    groceryFrame.pack();
                }
            }
        });
    }

    // MODIFIES: this
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
        addingGrocery();
    }
    
    // MODIFIES: this
    // EFFECTS: finally add a grocery item with given name, price, and category
    //          report to the user with a successful message
    private void addingGrocery() {
        if (category.equals("vegetables")
                || category.equals("fruits")
                || category.equals("proteins")
                || category.equals("grains")
                || category.equals("others")) {
            addGroceryPanel.removeAll();
            MessageButton successfulButton = new MessageButton("Successfully added a grocery!");
            addGroceryPanel.add(successfulButton);
            groceryFrame.pack();
            Grocery newGrocery = new Grocery(newName, price, category);
            groceryList.addGrocery(newGrocery);
        }
    }

    // MODIFIES: this
    // EFFECTS: prepare the buttons for each category
    private void prepareCategoryButtons() {
        vegeButton = new MessageButton("vegetables");
        proteinButton = new MessageButton("proteins");
        grainButton = new MessageButton("grains");
        fruitButton = new MessageButton("fruits");
        otherButton = new MessageButton("others");
        addActionListenerToCategory();
    }

    // MODIFIES: this
    // EFFECTS: addActionListener to the category buttons
    private void addActionListenerToCategory() {
        vegeButton.addActionListener(this);
        proteinButton.addActionListener(this);
        grainButton.addActionListener(this);
        fruitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                category = "fruits";
                addingGrocery();
            }
        });
        otherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                category = "others";
                addingGrocery();
            }
        });
    }

    // MODIFIES: this
    // EFFECTS: get total price of the groceryList and display it on a JPanel
    private void displayTotalPrice() {
        mainPanel.removeAll();
        SubPanel  displayPricePanel = new SubPanel();
        String messageString = "The total price of the groceries in the list: $";
        String price = String.format("%.4g%n", groceryList.getTotalPrice());
        MessageButton tellPriceButton = new MessageButton(messageString + price);
        displayPricePanel.add(tellPriceButton);
        mainPanel.add(displayPricePanel);
        groceryFrame.pack();
    }
}
