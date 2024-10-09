package ui;

import java.util.Scanner;

import model.GroceryList;

public class GroceryApp {
    private GroceryList grocerylist;
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
        
    }


}
