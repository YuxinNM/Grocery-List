package persistence;

import java.io.IOException;

import org.json.JSONObject;

import model.GroceryList;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class JsonReader {
    private String source;
    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        
    }

    // EFFECTS: reads GroceryList (groceryList) from file and returns it;
    //          throws IOException if an error occurs reading data from file
    public GroceryList read() throws IOException {
        return null;
    }

    // EFFECTS: helper for read(), reads source file as string and returns it
    //          throws IOException if an error occurs reading data from file
    private String readFile(String source) throws IOException {
        return "";
    }

    // EFFECTS: helper for read(), parses GroceryList from JSON object and returns it
    private GroceryList parseGrocery(JSONObject JSONObject) {
        return null;
    }

    // MODIFIES: groceryList
    // EFFECTS: helper for parseWorkRoom, parses Grocery objects from JSON object
    //          and adds them to GroceryList
    private void addGroceries(GroceryList groceryList, JSONObject jsonObject) {

    }

    // MODIFIES: groceryList
    // EFFECTS: helper for addGrocery, parses Grocery from JSON object and adds it to GroceryList
    private void addGrocery(GroceryList groceryList, JSONObject jsonObject) {

    }
}
