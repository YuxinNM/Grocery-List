package ui.graphical;

import java.awt.*;

import javax.swing.*;

import java.util.*;

// Creates a piechart with given slices
public class PieChart extends JPanel {
    private static final Color VEGE_COLOR = new Color(152,200,152);
    private static final Color FRUIT_COLOR = new Color(255,205,225);
    private static final Color PROTEIN_COLOR = new Color(225,230,255);
    private static final Color GRAIN_COLOR = new Color(245,222,179);
    private static final Color OTHERS_COLOR = new Color(216,191,216);
    private static final Dimension PIE_CHART_DIMENSION = new Dimension(500, 500);

    private ArrayList<PieChartSlice> slices;
    private PieChartSlice vegeSlice;
    private PieChartSlice fruitSlice;
    private PieChartSlice proteinSlice;
    private PieChartSlice grainSlice;
    private PieChartSlice otherSlice;

    // EFFECTS: creates a list of slices in the pie chart with given percentages
    //          specify the percentages of each slice in order of: 
    //          vegetable, fruit, protein, grain, other
    public PieChart(double vegeSize, double fruitSize, double proteinSize, double grainSize, double otherSize) {
        this.setPreferredSize(PIE_CHART_DIMENSION);
        slices = new ArrayList<>();
        this.vegeSlice = new PieChartSlice(vegeSize, VEGE_COLOR);
        this.fruitSlice = new PieChartSlice(fruitSize, FRUIT_COLOR);
        this.proteinSlice = new PieChartSlice(proteinSize, PROTEIN_COLOR);
        this.grainSlice = new PieChartSlice(grainSize, GRAIN_COLOR);
        this.otherSlice = new PieChartSlice(otherSize, OTHERS_COLOR);
        slices.add(vegeSlice);
        slices.add(fruitSlice);
        slices.add(proteinSlice);
        slices.add(grainSlice);
        slices.add(otherSlice);
    }
    
    // EFFECTS: paint a pie chart with the list of slices
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D) g;
        drawPieChart((Graphics2D)graphics2d, slices);
    }

    // EFFECTS: helper for paint, draws a pie chart 
    private void drawPieChart(Graphics2D g, ArrayList<PieChartSlice> slices) {
        int startAngle = 0;
        
        for (int i = 0; i < slices.size() - 1; i++) {
            int arcAngle = (int) slices.get(i).getArcAngle();
            g.setPaint(slices.get(i).getColor());
            //g.setStroke(new BasicStroke(5));
            g.fillArc(PIE_CHART_DIMENSION.width / 2 - 150, PIE_CHART_DIMENSION.height / 2 - 150, 300, 300, startAngle, arcAngle);
            startAngle += arcAngle;
        }
        g.setPaint(slices.get(slices.size() - 1).getColor());
        //g.setStroke(new BasicStroke(5));
        g.fillArc(PIE_CHART_DIMENSION.width / 2 - 150, PIE_CHART_DIMENSION.height / 2 - 150, 300, 300, startAngle, 360 - startAngle);

        
    }
}
