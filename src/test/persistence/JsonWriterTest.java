package persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import model.Grocery;
import model.GroceryList;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class JsonWriterTest extends JsonTest {
    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/\0illegal:fileName.json");
            writer.open();
            fail("no fileNotFoundException thrown");
        } catch (FileNotFoundException e) {
            // expected
        }
    }

    @Test
    void testWriterEmptyGroceryList() {
        try {
            GroceryList groceryList = new GroceryList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyGroceryList.json");
            writer.open();
            writer.write(groceryList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyGroceryList.json");
            groceryList = reader.read();
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
        } catch (FileNotFoundException e) {
            fail("FileNotFoundException is not expected when open file");
        } catch (IOException e) {
            fail("IOException is not expected when read");
        }
    }

    @Test
    void testWriterGeneralGroceryList() {
        try {
            GroceryList groceryList = new GroceryList();
            groceryList.addGrocery(new Grocery("apples", 3.50, "fruits"));
            groceryList.addGrocery(new Grocery("carrots", 5.00, "vegetables"));
            groceryList.addGrocery(new Grocery("bread", 5.00, "grains"));
            groceryList.addGrocery(new Grocery("fish", 8.00, "proteins"));
            groceryList.addGrocery(new Grocery("cookies", 6.00, "others"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralGroceryList.json");
            writer.open();
            writer.write(groceryList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralGroceryList.json");
            groceryList = reader.read();
            
            assertEquals(1, groceryList.getFruitCount());
            assertEquals(1, groceryList.getVegeCount());
            assertEquals(1, groceryList.getGrainsCount());
            assertEquals(1, groceryList.getProteinCount());
            assertEquals(1, groceryList.getOthersCount());

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
        } catch (FileNotFoundException e) {
            fail("FileNotFoundException is not expected");
        } catch (IOException e) {
            fail("Cannot read the file");
        }
    }
}
