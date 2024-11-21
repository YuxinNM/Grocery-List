package ui.graphical;

import java.awt.*;

import javax.swing.*;

import java.util.*;

// Creates a piechart with given slices
public class PieChart extends JComponent {
    private static final Color VEGE_COLOR = new Color(152,200,152);
    private static final Color FRUIT_COLOR = new Color(255,228,225);
    private static final Color PROTEIN_COLOR = new Color(240,255,255);
    private static final Color GRAIN_COLOR = new Color(245,222,179);
    private static final Color OTHERS_COLOR = new Color(216,191,216);

    private ArrayList<PieChartSlice> slices;
    private PieChartSlice vegeSlice;
    private PieChartSlice fruitSlice;
    private PieChartSlice proteinSlice;
    private PieChartSlice grainSlice;
    private PieChartSlice otherSlice;

    // EFFECTS: creates a list of slices in the pie chart with given percentages
    public PieChart(double vegeSize, double fruitSize, double proteinSize, double grainSize, double otherSize) {
        slices = new ArrayList<>();
        this.vegeSlice = new PieChartSlice(vegeSize / 100, VEGE_COLOR);
        this.fruitSlice = new PieChartSlice(fruitSize / 100, FRUIT_COLOR);
        this.proteinSlice = new PieChartSlice(proteinSize / 100, PROTEIN_COLOR);
        this.grainSlice = new PieChartSlice(grainSize / 100, GRAIN_COLOR);
        this.otherSlice = new PieChartSlice(otherSize / 100, OTHERS_COLOR);
        slices.add(vegeSlice);
        slices.add(fruitSlice);
        slices.add(proteinSlice);
        slices.add(grainSlice);
        slices.add(otherSlice);
    }
    
    // EFFECTS: paint a pie chart with the list of slices
    @Override
    public void paint(Graphics g) {
        drawPieChart((Graphics2D) g, getBounds(), slices);
    }

    // EFFECTS: helper for paint, draws a pie chart 
    private void drawPieChart(Graphics2D g, Rectangle bounds, ArrayList<PieChartSlice> slices) {
        
    }
}
