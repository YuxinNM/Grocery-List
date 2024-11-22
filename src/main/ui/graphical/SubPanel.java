package ui.graphical;

import javax.swing.*;

import java.awt.*;

// Sets up subpanels that are to be added to the main panel on the frame 
public class SubPanel extends JPanel {
    private static final Color BACKGROUND = new Color(224,255,255);
    private static final GridLayout LAYOUT = new GridLayout(0, 1, 0, 3);
    private static final Dimension PANE_DIMENSION = new Dimension(550, 500);

    // EFFECTS: constructs the subpanel with desired background, layout, and sets to visible
    public SubPanel() {
        this.setPreferredSize(PANE_DIMENSION);
        this.setBackground(BACKGROUND);
        this.setLayout(LAYOUT);
        this.setVisible(true);
    }
}
