package ui;

import java.util.Scanner;

import model.Grocery;
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

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
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
        } else if (command.equals("n")) {
            printGroupsPerct();
        } else if (command.equals("s")) {
            printSuggestedPerct();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: print out the suggested distributions of food groups
    private void printSuggestedPerct() {
        System.out.println("\nSuggested Distributions of Food Groups:");
        System.out.println("\tVegetables: 30%");
        System.out.println("\tFruits: 10%");
        System.out.println("\tGrains: 38%");
        System.out.println("\tProteins: 20%");
        System.out.println("\tOthers: 2%");
    }

    // EFFECTS: print the percentages of food groups of the groceries in the list
    private void printGroupsPerct() {
        if (groceryList.getGroceries().size() > 0) {
            groceryList.calcPercent();
            System.out.println("\nNutrition Report: Distribution of Food Groups");
            System.out.println("\tVegetables: " + groceryList.getVegePerct() + "%");
            System.out.println("\tFruits: " + groceryList.getFruitPerct() + "%");
            System.out.println("\tGrains: " + groceryList.getGrainsPerct() + "%");
            System.out.println("\tProteins: " + groceryList.getProteinPerct() + "%");
            System.out.println("\tOthers: " + groceryList.getOthersPerct() + "%");
        } else {
            System.out.println("Please add groceries in the list first.");
        }
    }

    // EFFECTS: print the total price of groceries in the list
    private void printPrice() {
        System.out.println("\nThe total price of the groceries in the list: $" + groceryList.getTotalPrice());
    }

    // EFFECTS: print the list of groceries with its name & price
    private void printList() {
        if (groceryList.getGroceries().size() > 0) {
            System.out.println("\nHere is the list of groceries:");
            for (Grocery next: groceryList.getGroceries()) {
                System.out.println(next.getName() + "   $" + next.getPrice() + "    " + next.getCategory());
            }
        } else {
            System.out.println("There is no grocery in the list yet.");
        }
    }

    // MODIFIES: this
    // EFFECTS: remove a grocery from the list
    private void removeGrocery() {
        if (groceryList.getGroceries().size() > 0) {
            System.out.println("\nPlease enter the name of the grocery you want to remove:");
            System.out.println("Note: it removes one grocery at a time.");
            System.out.println("If there are duplicates, the first one in the list will be removed.");
            String nameToRemove = input.next();
            boolean nameInList = removeFirstInList(groceryList, nameToRemove);
            if (nameInList) {
                System.out.println(nameToRemove + " has been successfully removed");
            } else {
                System.out.println("\nThe grocery is not in the list...");
            }
        } else {
            System.out.println("There is no grocery in the list yet.");
        }
    }

    // MODIFIES: this
    // EFFECTS: removes the first grocery with given name in the groceryList
    //          return true if grocery was in the list, false if cannot find it
    private boolean removeFirstInList(GroceryList groceryList, String nameToRemove) {
        for (int i = 0; i < groceryList.getGroceries().size(); i++) {
            Grocery current =  groceryList.getGroceries().get(i);
            if (current.getName().equals(nameToRemove)) {
                groceryList.removeGrocery(current);
                return true;
            }
        }
        return false;
    }

    // MODIFIES: this
    // EFFECTS: add a grocery to the list
    private void addGrocery() {
        System.out.println("\nPlease enter the name of the grocery:");
        String name = input.next();

        System.out.println("\nPlease enter the price of the grocery with 2 decimals: $");
        double price;
        if (input.hasNextDouble()) {
            price = input.nextDouble();
            if (price < 0) {
                System.out.println("Invalid price");
            } else {
                printCategories();
                String category = sortCategory(input.next());
    
                Grocery newGrocery = new Grocery(name, price, category);
                groceryList.addGrocery(newGrocery);
    
                System.out.println("You have successfully added the grocery!");
            }    
        } else {
            String invalidInput = input.next();
            System.out.println("Invalid input.");
        }
    }

    // EFFECTS: helper for addGrocery(), print all grocery categories
    private void printCategories() {
        System.out.println("\nPlease select from one of the following categories of the grocery:");
        System.out.println("\tvegetables");
        System.out.println("\tproteins");
        System.out.println("\tgrains");
        System.out.println("\tfruits");
        System.out.println("\tothers");
        System.out.println("Note: any category that is not listed above will count as others.");
    }

    // EFFECTS: categorize the input as "others" if it is not any of the given options
    private String sortCategory(String category) {
        if (category.equals("vegetables") 
                || category.equals("proteins") 
                || category.equals("grains") 
                || category.equals("fruits")) {
            return category;
        } else {
            return "others";
        }
    }

    // EFFECTS: displays the options of commands user can make
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add a grocery");
        System.out.println("\tr -> remove a grocery");
        System.out.println("\tv -> view grocery list");
        System.out.println("\tp -> view total price of groceries");
        System.out.println("\tn -> view nutritional distributions of groceries' food groups");
        System.out.println("\ts -> view the suggested distributions of food groups");
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
