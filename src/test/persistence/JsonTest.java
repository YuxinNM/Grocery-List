package persistence;
// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Grocery;

public class JsonTest {
    protected void checkGroceryName(String name, Grocery grocery) {
        assertEquals(name, grocery.getName());
    }

    protected void checkGroceryPrice(double price, Grocery grocery) {
        assertEquals(price, grocery.getPrice());
    }

    protected void checkGroceryCategory(String category, Grocery grocery) {
        assertEquals(category, grocery.getCategory());
    }
}
