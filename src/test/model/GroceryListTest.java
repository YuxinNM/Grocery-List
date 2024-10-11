package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GroceryListTest {
    private GroceryList groceryListTest;
    private Grocery bread;
    private Grocery apples;
    private Grocery milk;

    @BeforeEach
    void runBefore() {
        groceryListTest = new GroceryList();
        bread = new Grocery("bread", 5.00, "grains");
        apples = new Grocery("apples", 6.00, "fruits");
        milk = new Grocery("milk", 7.00, "proteins");
    }

    @Test
    void testConstrutor() {
        assertEquals(0, groceryListTest.getGroceries().size());

        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());

        assertEquals(0.0, groceryListTest.getVegePerct());
        assertEquals(0.0, groceryListTest.getFruitPerct());
        assertEquals(0.0, groceryListTest.getGrainsPerct());
        assertEquals(0.0, groceryListTest.getProteinPerct());
        assertEquals(0.0, groceryListTest.getOthersPerct());

        assertEquals(0.00, groceryListTest.getTotalPrice());
    }

    @Test
    void testAddGrocery() {
        groceryListTest.addGrocery(bread);
        assertEquals(1, groceryListTest.getGroceries().size());
        assertEquals(0, groceryListTest.getOthersCount());
        assertEquals(1, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(5.00, groceryListTest.getTotalPrice());
        groceryListTest.addGrocery(apples);
        assertEquals(2, groceryListTest.getGroceries().size());
        assertEquals(1, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(1, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
        assertEquals(11.00, groceryListTest.getTotalPrice());
    }

    @Test
    void testCountUpVege() {
        groceryListTest.countUp("vegetables");
        assertEquals(1, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
        groceryListTest.countUp("vegetables");
        assertEquals(2, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
    }

    @Test
    void testCountUpProtein() {
        groceryListTest.countUp("proteins");
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(1, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
        groceryListTest.countUp("proteins");
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(2, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
    }


    @Test
    void testCountUpOthers() {
        groceryListTest.countUp("others");
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(1, groceryListTest.getOthersCount());
        groceryListTest.countUp("others");
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(2, groceryListTest.getOthersCount());
    }

    @Test
    void testCountUpProteins() {
        groceryListTest.countUp("proteins");
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(1, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
        groceryListTest.countUp("proteins");
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(2, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
    }

    @Test
    void testCountUpGrain() {
        groceryListTest.countUp("grains");
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(1, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
        groceryListTest.countUp("grains");
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(2, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
    }

    @Test
    void testRemoveGrocery() {
        groceryListTest.addGrocery(bread);
        groceryListTest.removeGrocery(bread);
        assertEquals(0, groceryListTest.getGroceries().size());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
        assertEquals(0.00, groceryListTest.getTotalPrice());

        groceryListTest.addGrocery(bread);
        groceryListTest.addGrocery(apples);
        groceryListTest.removeGrocery(bread);
        groceryListTest.removeGrocery(apples);
        assertEquals(0, groceryListTest.getGroceries().size());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
        assertEquals(0.00, groceryListTest.getTotalPrice());
    }

    @Test
    void testCountDownVege() {
        groceryListTest.countUp("vegetables");
        groceryListTest.countDown("vegetables");
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
    }

    @Test
    void testCountDownFruits() {
        groceryListTest.countUp("fruits");
        groceryListTest.countDown("fruits");
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
    }

    @Test
    void testCountDownOthers() {
        groceryListTest.countUp("others");
        groceryListTest.countDown("others");
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
    }

    @Test
    void testCountDownProteins() {
        groceryListTest.countUp("proteins");
        groceryListTest.countDown("proteins");
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
    }

    @Test
    void testCountDownGrains() {
        groceryListTest.countUp("grains");
        groceryListTest.countDown("grains");
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
    }

    @Test
    void testCountDownTwiceVege() {
        groceryListTest.countUp("vegetables");
        groceryListTest.countUp("vegetables");
        groceryListTest.countDown("vegetables");
        groceryListTest.countDown("vegetables");
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
    }

    @Test
    void testCountDownTwiceProtein() {
        groceryListTest.countUp("proteins");
        groceryListTest.countUp("proteins");
        groceryListTest.countDown("proteins");
        groceryListTest.countDown("proteins");
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
    }

    @Test
    void testCountDownTwiceOthers() {
        groceryListTest.countUp("others");
        groceryListTest.countUp("others");
        groceryListTest.countDown("others");
        groceryListTest.countDown("others");
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
    }

    @Test
    void testCountDownTwiceFruit() {
        groceryListTest.countUp("fruits");
        groceryListTest.countUp("fruits");
        groceryListTest.countDown("fruits");
        groceryListTest.countDown("fruits");
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
    }

    @Test
    void testCountDownTwiceGrain() {
        groceryListTest.countUp("grains");
        groceryListTest.countUp("grains");
        groceryListTest.countDown("grains");
        groceryListTest.countDown("grains");
        assertEquals(0, groceryListTest.getVegeCount());
        assertEquals(0, groceryListTest.getGrainsCount());
        assertEquals(0, groceryListTest.getFruitCount());
        assertEquals(0, groceryListTest.getProteinCount());
        assertEquals(0, groceryListTest.getOthersCount());
    }

    @Test 
    void testCalcPercent() {
        groceryListTest.addGrocery(bread);
        groceryListTest.calcPercent();
        assertEquals(100.0, groceryListTest.getGrainsPerct());
        assertEquals(0.0, groceryListTest.getVegePerct());
        assertEquals(0.0, groceryListTest.getFruitPerct());
        assertEquals(0.0, groceryListTest.getProteinPerct());
        assertEquals(0.0, groceryListTest.getOthersPerct());
    }

    @Test 
    void testCalcPercentMultiple() {
        groceryListTest.addGrocery(bread);
        groceryListTest.addGrocery(apples);
        groceryListTest.calcPercent();
        assertEquals(50.0, groceryListTest.getGrainsPerct());
        assertEquals(0.0, groceryListTest.getVegePerct());
        assertEquals(50.0, groceryListTest.getFruitPerct());
        assertEquals(0.0, groceryListTest.getProteinPerct());
        assertEquals(0.0, groceryListTest.getOthersPerct());

        groceryListTest.addGrocery(milk);
        groceryListTest.calcPercent();
        assertEquals(33.0, groceryListTest.getGrainsPerct());
        assertEquals(0.0, groceryListTest.getVegePerct());
        assertEquals(33.0, groceryListTest.getFruitPerct());
        assertEquals(33.0, groceryListTest.getProteinPerct());
        assertEquals(0.0, groceryListTest.getOthersPerct());
    }
}
