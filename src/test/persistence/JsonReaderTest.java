package persistence;

import org.junit.jupiter.api.Test;

import model.Grocery;
import model.GroceryList;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Test JsonReader() by extending JsonTest()
class JsonReaderTest extends JsonTest {
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // exception thrown as expected
        }
    }

    @Test
    void testReaderEmptyGroceryList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyGroceryList.json");
        try {
            GroceryList groceryList  = reader.read();

            assertEquals(0, groceryList.getFruitCount());
            assertEquals(0, groceryList.getVegeCount());
            assertEquals(0, groceryList.getGrainsCount());
            assertEquals(0, groceryList.getProteinCount());
            assertEquals(0, groceryList.getOthersCount());
            
            assertEquals(0.0, groceryList.getFruitPerct());
            assertEquals(0.0, groceryList.getVegePerct());
            assertEquals(0.0, groceryList.getGrainsPerct());
            assertEquals(0.0, groceryList.getProteinPerct());
            assertEquals(0.0, groceryList.getOthersPerct());
            
            assertEquals(0, groceryList.getGroceries().size());

            assertEquals(0.0, groceryList.getTotalPrice());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralGroceryList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralGroceryList.json");
        try {
            GroceryList groceryList = reader.read();

            testGroceryListCounts(groceryList);

            groceryList.calcPercent();
            assertEquals(20.0, groceryList.getFruitPerct());
            assertEquals(20.0, groceryList.getVegePerct());
            assertEquals(20.0, groceryList.getGrainsPerct());
            assertEquals(20.0, groceryList.getProteinPerct());
            assertEquals(20.0, groceryList.getOthersPerct());

            assertEquals(27.5, groceryList.getTotalPrice());

            ArrayList<Grocery> groceries = groceryList.getGroceries();
            assertEquals(5, groceries.size());

            checkGrocery("apples",3.50, "fruits", groceries.get(0));
            checkGrocery("carrots",5.00, "vegetables", groceries.get(1));
            checkGrocery("bread",5.00, "grains", groceries.get(2));
            checkGrocery("fish",8.00, "proteins", groceries.get(3));
            checkGrocery("cookies",6.00, "others", groceries.get(4));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    private void testGroceryListCounts(GroceryList groceryList) {
        assertEquals(1, groceryList.getFruitCount());
        assertEquals(1, groceryList.getVegeCount());
        assertEquals(1, groceryList.getGrainsCount());
        assertEquals(1, groceryList.getProteinCount());
        assertEquals(1, groceryList.getOthersCount());
    }
}