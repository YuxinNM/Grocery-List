package ui.graphical;

import javax.swing.*;
import java.awt.*;

// Set up buttons that can be used for messaging users
public class MessageButton extends JButton {
    private static final Dimension BUTTON_SIZE = new Dimension(200, 250);
    private static final Color BUTTON_COLOR = new Color(255,248,220);

    // EFFECTS: sets up the button with desired size and color, not focusable, visiable
    public MessageButton(String message) {
        super(message);
        this.setSize(BUTTON_SIZE);
        this.setFocusable(false);
        this.setVisible(true);
        this.setBackground(BUTTON_COLOR);
    }
}
