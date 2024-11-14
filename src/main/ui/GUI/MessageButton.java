package ui.GUI;

import javax.swing.*;
import java.awt.*;

// Set up buttons that can be used for messaging users
public class MessageButton extends JButton {
    private final Dimension buttonSize = new Dimension(200, 250);
    private final Color buttonColor = new Color(255,248,220);

    public MessageButton(String message) {
        super(message);
        this.setSize(buttonSize);
        this.setFocusable(false);
        this.setVisible(true);
        this.setBackground(buttonColor);
    }
}
