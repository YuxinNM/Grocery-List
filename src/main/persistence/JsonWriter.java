package persistence;

import model.GroceryList;

import org.json.JSONObject;

import java.io.*;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Represents a writer that writes JSON representation of groceryList to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot be found
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }   

    // MODIFIES: this
    // EFFECTS: writes JSON representation of groceryList to file
    public void write(GroceryList groceryList) {
        JSONObject json = groceryList.toJason();
        saveToFile(json.toString(TAB)); 
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {

    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {

    }
}
