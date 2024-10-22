package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

import model.GroceryList;
import model.Grocery;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads GroceryList (groceryList) from file and returns it;
    //          throws IOException if an error occurs reading data from file
    public GroceryList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseGroceryList(jsonObject);
    }

    // EFFECTS: helper for read(), reads source file as string and returns it
    //          throws IOException if an error occurs reading data from file
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: helper for read(), parses GroceryList from JSON object and returns it
    private GroceryList parseGroceryList(JSONObject jsonObject) {
        GroceryList groceryList = new GroceryList();
        addGroceries(groceryList, jsonObject);
        return groceryList;
    }

    // MODIFIES: groceryList
    // EFFECTS: helper for parseGroceryList, parses Grocery objects from JSON object
    //          and adds them to groceryList
    private void addGroceries(GroceryList groceryList, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("groceries");
        for (Object json : jsonArray) {
            JSONObject nextGrocery = (JSONObject) json;
            addGrocery(groceryList, nextGrocery);
        }
    }

    // MODIFIES: groceryList
    // EFFECTS: helper for addGroceries, parses Grocery from JSON object and adds it to groceryList
    private void addGrocery(GroceryList groceryList, JSONObject nextGrocery) {
        String name = nextGrocery.getString("name");
        double price = nextGrocery.getDouble("price");
        String category = nextGrocery.getString("category");
        Grocery grocery = new Grocery(name, price, category);
        groceryList.addGrocery(grocery);
    }
}
