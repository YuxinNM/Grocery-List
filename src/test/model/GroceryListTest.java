package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ui.Main;

public class GroceryListTest {
    private GroceryList groceryListTest;
    private Grocery grocery1;
    private Grocery grocery2;

    @BeforeEach
    void runBefore() {
        groceryListTest = new GroceryList();
        grocery1 = new Grocery("bread", 5.00, "grains");
        grocery2 = new Grocery("apples", 6.00, "fruits");
    }

    @Test
    void testConstrutor() {
        assertEquals(0, groceryListTest.getGroceries().size());

        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getDairyCount());
        assertEquals(0, groceryListTest.getOthersCount());

        assertEquals(0.0, groceryListTest.getVegePerct());
        assertEquals(0.0, groceryListTest.getFruitPerct());
        assertEquals(0.0, groceryListTest.getGrainsPerct());
        assertEquals(0.0, groceryListTest.getDairyPerct());
        assertEquals(0.0, groceryListTest.getOthersPerct());

        assertEquals(0.00, groceryListTest.getTotalPrice());
    }

    @Test
    void testAddGrocery(){
        groceryListTest.addGrocery(grocery1);
        assertEquals(1, groceryListTest.getGroceries().size());
        Grocery firstGrocery = groceryListTest.getGroceries().get(0);
        assertEquals("bread", firstGrocery.getName());
        assertEquals(5.00, firstGrocery.getPrice());
        assertEquals("grains", firstGrocery.getCategory());
        assertEquals(0, groceryListTest.getOthersCount());
        assertEquals(1, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getDairyCount());
        assertEquals(5.00, groceryListTest.getTotalPrice());

        groceryListTest.addGrocery(grocery2);
        assertEquals(2, groceryListTest.getGroceries().size());
        Grocery secGrocery = groceryListTest.getGroceries().get(1);
        assertEquals("apples", secGrocery.getName());
        assertEquals(6.00, secGrocery.getPrice());
        assertEquals("fruits", secGrocery.getCategory());
        assertEquals(1, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(1, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getDairyCount());
        assertEquals(0, groceryListTest.getOthersCount());
        assertEquals(11.00, groceryListTest.getTotalPrice());
    }

    @Test
    void testRemoveGrocery(){
        groceryListTest.addGrocery(grocery1);
        groceryListTest.removeGrocery(grocery1);
        assertEquals(0, groceryListTest.getGroceries().size());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getDairyCount());
        assertEquals(0, groceryListTest.getOthersCount());
        assertEquals(0.00, groceryListTest.getTotalPrice());

        groceryListTest.addGrocery(grocery1);
        groceryListTest.addGrocery(grocery2);
        groceryListTest.removeGrocery(grocery1);
        assertEquals(1, groceryListTest.getGroceries().size());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(1, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getDairyCount());
        assertEquals(0, groceryListTest.getOthersCount());
        assertEquals(6.00, groceryListTest.getTotalPrice());

        groceryListTest.removeGrocery(grocery2);
        assertEquals(0, groceryListTest.getGroceries().size());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getDairyCount());
        assertEquals(0, groceryListTest.getOthersCount());
        assertEquals(0.00, groceryListTest.getTotalPrice());
    }

    @Test 
    void testCalcPercent() {
        groceryListTest.addGrocery(grocery1);
        groceryListTest.calcPercent();
        assertEquals(100.0, groceryListTest.getGrainsPerct());
        assertEquals(0.0, groceryListTest.getVegePerct());
        assertEquals(0.0, groceryListTest.getFruitPerct());
        assertEquals(0.0, groceryListTest.getDairyPerct());
        assertEquals(0.0, groceryListTest.getOthersPerct());
    }

    @Test 
    void testCalcPercentMultiple() {
        groceryListTest.addGrocery(grocery1);
        groceryListTest.addGrocery(grocery2);
        Grocery grocery3 = new Grocery("milk", 7.00, "dairy products");
        groceryListTest.addGrocery(grocery3);

        groceryListTest.calcPercent();
       
        assertEquals(33.0, groceryListTest.getGrainsPerct());
        assertEquals(0.0, groceryListTest.getVegePerct());
        assertEquals(33.0, groceryListTest.getFruitPerct());
        assertEquals(33.0, groceryListTest.getDairyPerct());
        assertEquals(0.0, groceryListTest.getOthersPerct());
    }
}
