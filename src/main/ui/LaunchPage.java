
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// A launch window that asks user to laod saved file
public class LaunchPage implements ActionListener{
    JFrame loadFileFrame = new JFrame();
    JButton loadButton = new JButton();
    JButton notLoadButton = new JButton();

    // EFFECTS: a window that asks user to choose one of two buttons to load or 
    //          not load saved grocery list, leads to a new window with the given choice
    public LaunchPage() {
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
        loadFileFrame.setLayout(null);
        loadFileFrame.setVisible(true);
    }

    // EFFECTS: sets up a JButton
    public void setUpButton(JButton button) {
        button.setBounds(150, 150, 200, 50);
        button.setFocusable(false);
        button.addActionListener(this);
    }

    // EFFECTS: ctreates a new instance of GraphicalGroceryApp()
    //          with loaded or empty groceryList indicated by the button user clicks
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
