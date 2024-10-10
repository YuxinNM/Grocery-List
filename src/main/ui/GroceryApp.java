package ui;

import java.util.Scanner;

import model.GroceryList;

public class GroceryApp {
    private GroceryList groceryList;
    private Scanner input;

    // EFFECTS: runs the console 
    public GroceryApp() {
        runConsole();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runConsole() {
        boolean keepGoing = true;
        String command = null;

        init();

        while(keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if(command.equals("q")){
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addGrocery();
        } else if (command.equals("r")) {
            removeGrocery();
        } else if (command.equals("v")) {
            printList();
        } else if (command.equals("p")) {
            printPrice();
        } else if (command.equals("n")){
            printGroupsPerct();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: print the percentages of food groups of the groceries
    private void printGroupsPerct() {
        System.out.println("\nNutrition Report: Distribution of Food Groups");
        System.out.println("\tVegetables: " + groceryList.getVegePerct() + "%");
        System.out.println("\tFruits: " + groceryList.getFruitPerct() + "%");
        System.out.println("\tGrains: " + groceryList.getGrainsPerct() + "%");
        System.out.println("\tDairy Products: " + groceryList.getDairyPerct() + "%");
        System.out.println("\tOthers: " + groceryList.getOthersPerct() + "%");
    }

    // EFFECTS: print the total price of groceries
    private void printPrice() {
       System.out.println("\nThe total price of the groceries in the list: $" + groceryList.getTotalPrice());
    }

    // EFFECTS: print the list of groceries 
    private void printList() {
        System.out.println(groceryList.getGroceries());
    }

    // MODIFIES: this
    // EFFECTS: remove a grocery from the list
    private void removeGrocery() {
        
    }

    // MODIFIES: this
    // EFFECTS: add a grocery to the list
    private void addGrocery() {
        
    }

    // EFFECTS: displays the options of commands user can make
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add a grocery");
        System.out.println("\tr -> remove a grocery");
        System.out.println("\tv -> view grocery list");
        System.out.println("\tp -> view total price of groceries");
        System.out.println("\tn -> view nutritional distributions of groceries' food groups");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: initializes the grocery list
    private void init() {
       groceryList = new GroceryList(); 
       input = new Scanner(System.in);
       input.useDelimiter("\r?\n|\r");
    }



}
