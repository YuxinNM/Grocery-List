package model;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GroceryTest {
    private Grocery groceryTest;

    @BeforeEach
    void runBefore() {
        groceryTest = new Grocery("bread", 5.00, "grains");
    }

    @Test
    void testConstructor() {
        assertEquals("bread", groceryTest.getName());
        assertEquals(5.00, groceryTest.getPrice());
        assertEquals("grains", groceryTest.getCategory());
    }

    @Test
    void testChangeName() {
        groceryTest.changeName("oats");
        assertEquals("oats", groceryTest.getName());
        groceryTest.changeName("cereals");
        assertEquals("cereals", groceryTest.getName());
    }

    @Test
    void testChangePrice() {
        groceryTest.changePrice(6.00);
        assertEquals(6.00, groceryTest.getPrice());
        groceryTest.changePrice(7.00);
        assertEquals(7.00, groceryTest.getPrice());
    }

    @Test
    void testChangeCategory() {
        groceryTest.changeCategory("dairy products");
        assertEquals("dairy products", groceryTest.getCategory());
        groceryTest.changeCategory("vegetables");
        assertEquals("vegetables", groceryTest.getCategory());
    }
}
