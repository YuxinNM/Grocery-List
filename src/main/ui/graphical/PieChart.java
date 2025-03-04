package ui.graphical;

import java.awt.*;

import javax.swing.*;

import java.util.*;

// Creates a piechart with given slices
public class PieChart extends JPanel {
    private static final Color VEGE_COLOR = new Color(152,200,152);
    private static final Color FRUIT_COLOR = new Color(255,205,225);
    private static final Color PROTEIN_COLOR = new Color(233,225,255);
    private static final Color GRAIN_COLOR = new Color(245,222,179);
    private static final Color OTHERS_COLOR = new Color(216,191,216);
    private static final Dimension PIE_CHART_DIMENSION = new Dimension(550, 500);
    private static final Font font = new Font("Comics", Font.BOLD, 18);
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
    
    // MODIFIES: this
    // EFFECTS: paint a pie chart with the list of slices
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D) g;
        drawPieChart(graphics2d, slices);
        drawLegend(graphics2d);
    }

    // MODIFIES: this
    // EFFECTS: write legend for the colors in the pie chart
    private void drawLegend(Graphics2D g) {
        g.setPaint(VEGE_COLOR);
        g.setFont(font);
        g.drawString(vegeSlice.getSliceSize() + "%vegetables", 30, 50);

        g.setPaint(FRUIT_COLOR);
        g.setFont(font);
        g.drawString(fruitSlice.getSliceSize() + "% fruits", 30, 70);

        g.setPaint(PROTEIN_COLOR);
        g.setFont(font);
        g.drawString(proteinSlice.getSliceSize() + "% proteins", 30, 90);

        g.setPaint(GRAIN_COLOR);
        g.setFont(font);
        g.drawString(grainSlice.getSliceSize() + "% grains", 30, 110);

        g.setPaint(OTHERS_COLOR);
        g.setFont(font);
        g.drawString(otherSlice.getSliceSize() + "% others", 30, 130);
    }

    // MODIFIES: this
    // EFFECTS: helper for paint, draws a pie chart 
    private void drawPieChart(Graphics2D g, ArrayList<PieChartSlice> slices) {
        int startAngle = 0;
        int x = PIE_CHART_DIMENSION.width / 2 - 150;
        int y = PIE_CHART_DIMENSION.height / 2 - 150;
        for (int i = 0; i < slices.size() - 1; i++) {
            int arcAngle = (int) slices.get(i).getArcAngle();
            g.setPaint(slices.get(i).getColor());
            g.fillArc(x, y, 300, 300, startAngle, arcAngle);
            startAngle += arcAngle;
        }
        g.setPaint(slices.get(slices.size() - 1).getColor());
        g.fillArc(x, y, 300, 300, startAngle, 360 - startAngle);
    }
}
