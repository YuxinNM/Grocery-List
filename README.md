# Nutritional Grocery List

## What will the application do?
The application will be a budget and nutrition planner for grocery shopping (food). 
Users can enter each grocery item they purchased or plan to purchase with:
- name
- price
- a category out of the five main groups the food belongs to or "others" if they do not belong to any,
e.g. vegetables, fruits, grains, dairy, proteins, or others. 

With the given entries, the application will 
- calculate the total amount of money users have spent or plan to spend.
- generate a pie chart based on the distribution of the indicated food groups (based on entries)
- generate a recommended pie chart beside the user's pie chart for comparison (pre-designed, based on the government health website)

If the user removes or adds items, the total amount of money and the pie chart based on entries will be updated accordingly.

## Who will use it?
- People who wish to keep track of &/ budget their grocery expenses
- People who need guidance on nutrition for grocery shopping
- People who like to plan a lot

## Why is this project of interest to you?
I started grocery shopping recently. As a huge planner, I like writing my grocery list beforehand, yet I still shop for unexpected groceries. I also realize some unbalanced nutrition. And I never have a sense of my expenses except the moment I pay. It would just be nice to have everything in the same place and have some real-time reports. This application aims to allow that and generate a **real-time summary for expenses and nutrition** before checking out. It would be healthier and more budget-friendly. While carrying a laptop and using the application in real-time may not be practical, it can pave the way for the transition to mobile applications. It would also be a great tool to **keep track of expenses and nutrition after shopping so we can adjust and balance nutrition next time**. 

## User Stories
- As a user, I want to be able to add a grocery item with its name, price, and category to my grocery list. 
- As a user, I want to be able to view a list of the names and the prices of the items in my grocery list.
- As a user, I want to be able to remove a grocery item from my list.
- As a user, I want to be able to know the total amount of expense of my grocery list.
- As a user, I want to view the pie chart displaying the distribution of the food groups based on my items.
- As a user, I want to view the pie chart of the recommended distribution of the good groups
- As a user, when I select the quit option from the application menu, I want to be reminded to save my to-do list to file and have the option to do so or not.
- As a user, when I start the application, I want to be given the option to load my to-do list from file.

# Instructions for End User
- You can generate the first required action related to the user story "adding multiple Xs to a Y" by:
    - clicking on the *Actions* menu bar, there will be a drop down menu
    - clicking on *Remove grocery item*
    - following the instruction shown on the window:
        - enter the name of the grocery that is going to be removed
    - the grocery item will be removed from the list successfully if the name entered matches the grocery item in the list, *successfully removed* message will be shown
    - no grocery items will be removed from the list if the name entered does not match any grocery items in the list, *the grocery is not in the list* message will be shown

- You can generate the second required action related to the user story "adding multiple Xs to a Y" by:
    - clicking on the *Actions* menu bar, there will be a drop down menu
    - clicking on the *Calculate total price*

- You can locate my visual component by:
    - clicking on the *Actions* menu bar, there will be a drop down menu
    - clicking on the *View nutritional report*

- You can save the state of my application by:
    - clicking on the *save file* menu item on the top left corner of the window

- You can reload the state of my application by:
    - when the user runs the program, there will be a pop-up window that has 2 buttons
    - clicking on the button that says *Load Previous Grocery List* can reload the state of my application
    - clicking on the button that says *Not Load Previous Grocery List* will then not do so.

## How to add a Grocery item to the GroceryList?
After the user selected to load or not load their previous list of groceries, there will be a menu bar at the top left corner. 
- click on the *Actions* menu bar, there will be a drop down menu
- click on *Add grocery item*
- follow the instructions shown on the window for each step:
    - enter the name of the grocery, enter to submit
    - enter the price of the grocery, enter to submit
        - *invalid price* message when price is < 0, or not a number
        - can click on the *Add grocery item* again from drop down menu to restart
    - select a category by clicking on the given options
- a grocery item will be added successfully!

## How to view all the grocery items added in the list?
- click on the *Actions* menu bar, there will be a drop down menu
- click on *View groceries*

# Phase 4: Task 2
- An example would be removing a grocery item from the list: 
The code is copied here from the GroceryList class:

public void removeGrocery(Grocery grocery) {\
        \tgroceries.remove(grocery);\
        \tcountDown(grocery.getCategory());\
        \ttotalPrice -= grocery.getPrice();\
        \tEventLog.getInstance().logEvent(new Event("A grocery item is removed \tfrom the list"));\
    }


