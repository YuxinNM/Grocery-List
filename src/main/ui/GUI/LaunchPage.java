
package ui.GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.GroceryList;
import persistence.JsonReader;

// A launch window that asks user to laod saved file
public class LaunchPage implements ActionListener{
    private static final String JSON_DESTINATION = "./data/grocerylist.json";
    JFrame loadFileFrame = new JFrame();
    MessageButton loadButton = new MessageButton("Load Previous Grocery List");
    MessageButton notLoadButton = new MessageButton("Not Load Previous Grocery List");
    private GroceryList groceryList;
    private JsonReader jsonReader;

    // EFFECTS: a window that asks user to choose one of two buttons to load or 
    //          not load saved grocery list, leads to a new window with the given choice
    public LaunchPage() {
        jsonReader = new JsonReader(JSON_DESTINATION);
        setUpFrame();
        setUpButton(loadButton);
        setUpButton(notLoadButton);
        loadFileFrame.add(loadButton);
        loadFileFrame.add(notLoadButton);
    }

    // EFFECTS: sets up a JFrame
    public void setUpFrame() {
        loadFileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadFileFrame.setSize(500,500);
        loadFileFrame.setLayout(new GridLayout(2, 1, 5, 5));
        loadFileFrame.setVisible(true);
    }

    // EFFECTS: sets up a JButton
    public void setUpButton(JButton button) {
        button.addActionListener(this);
    }

    // EFFECTS: ctreates a new instance of GraphicalGroceryApp()
    //          with loaded or empty groceryList indicated by the button user clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadButton) {
            loadFileFrame.dispose();
            try {
                groceryList = jsonReader.read();
                new GraphicalGroceryApp(groceryList);
            } catch (IOException readerror) {
                JFrame errorFrame = new JFrame();
                JButton errorButton = new JButton("Unable to read from file" + JSON_DESTINATION);
                setUpButton(errorButton);
                errorFrame.add(errorButton);
                errorFrame.setVisible(true);
            }
        } else if (e.getSource() == notLoadButton) {
            loadFileFrame.dispose();
            new GraphicalGroceryApp(new GroceryList());
        }
    }
}
