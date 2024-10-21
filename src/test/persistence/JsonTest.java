package persistence;
// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Grocery;

public class JsonTest {
    protected void checkGroceryName(String name, double price, String category, Grocery grocery) {
        assertEquals(name, grocery.getName());
        assertEquals(price, grocery.getPrice());
        assertEquals(category, grocery.getCategory());
    }
}
