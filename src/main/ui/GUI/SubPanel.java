package ui.GUI;

import javax.swing.*;

import java.awt.*;

// Sets up subpanels that are to be added to the main panel on the frame 
public class SubPanel extends JPanel {
    private Color background = new Color(224,255,255);
    private GridLayout panelLayout = new GridLayout(0, 1, 0, 3);
    private Dimension panelSize = new Dimension(500, 300);
    
    // EFFECTS: constructs the subpanel with desired background, layout, and sets to visible
    public SubPanel() {
        this.setPreferredSize(panelSize);
        this.setBackground(background);
        this.setLayout(panelLayout);
        this.setVisible(true);
    }
}
