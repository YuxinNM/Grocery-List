package ui.graphical;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextField;

// sets up JTextFields that can be used to take user input
public class JTextFieldUserInput extends JTextField {
    private static final Font textFont = new Font("Comics", Font.ITALIC, 15);
    private static final Insets textMargins = new Insets(5, 220, 5, 10);

    // EFFECTS: sets the textbox size as desired, font, tool tip text, margins
    public JTextFieldUserInput(int size) {
        super(size);
        this.setFont(textFont);
        this.setToolTipText("Enter Your Input Here");
        this.setMargin(textMargins);
    }
}
