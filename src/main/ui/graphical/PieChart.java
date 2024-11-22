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

        // graphics2d.setPaint(Color.blue);
        // graphics2d.setStroke(new BasicStroke(5));
        // graphics2d.fillRect(0, 0, 100, 100);
    }

    // EFFECTS: helper for paint, draws a pie chart 
    private void drawPieChart(Graphics2D g, ArrayList<PieChartSlice> slices) {
        // int startAngle = 0;
        // double curSize = 0.0;
        // int arcAngle = 0;
        // for (int i = 0; i < slices.size(); i++) {
        //     startAngle = (int) (curSize / 100 * 360);
        //     arcAngle = (int) slices.get(i).getSliceSize() / 100 * 360;
        //     g.setColor(slices.get(i).getColor());
        //     g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
        //     curSize += slices.get(i).getSliceSize();
        // }
        int startAngle = 0;
        
        //int arcAngle = 0;
        for (int i = 0; i < slices.size(); i++) {
            //int curAngle = 0;
            int arcAngle = (int) slices.get(i).getArcAngle();
            g.setPaint(slices.get(i).getColor());
            g.setStroke(new BasicStroke(5));
            g.fillArc(PIE_CHART_DIMENSION.width / 2 - 125, PIE_CHART_DIMENSION.height / 2 - 125, 250, 250, startAngle, arcAngle);
    

            // int arcAngle = slices.get(i).getArcAngle();
            // g.setPaint(slices.get(i).getColor());
            // g.setStroke(new BasicStroke(5));
            // g.drawArc(PIE_CHART_DIMENSION.width / 2 - 50, PIE_CHART_DIMENSION.height / 2 - 50, 100, 100, startAngle, arcAngle);

            //g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
            //arcAngle += slices.get(i).getArcAngle();

            startAngle += arcAngle;
        }
        // int arcAngle = (int) slices.get(0).getArcAngle();
        // g.setPaint(slices.get(0).getColor());
        // g.setStroke(new BasicStroke(5));
        // g.fillArc(PIE_CHART_DIMENSION.width / 2 - 50, PIE_CHART_DIMENSION.height / 2 - 50, 100, 100, startAngle, arcAngle);
        
        // int arcAngle2 = slices.get(1).getArcAngle();
        // g.setPaint(slices.get(0).getColor());
        // g.setStroke(new BasicStroke(5));
        // g.fillArc(PIE_CHART_DIMENSION.width / 2 - 50, PIE_CHART_DIMENSION.height / 2 - 50, 100, 100, startAngle, 34);

        // g.setPaint(Color.blue);
        // g.setStroke(new BasicStroke(5));
        // //g.fillRect(0, 0, 100, 100);
        // g.drawArc(PIE_CHART_DIMENSION.width / 2 - 50, PIE_CHART_DIMENSION.height / 2 - 50, 100, 100, 0, 180);
    }

    // void drawPieChart(Graphics2D g, Rectangle area, ArrayList<PieChartSlice> slices) {
    //     double total = 0.0;
        
    //     for (int i = 0; i < slices.size(); i++) {
    //        total += slices.get(i).getSliceSize();
    //     }
    //     double curValue = 0.0;
    //     int startAngle = 0;
    //     for (int i = 0; i < slices.size(); i++) {
    //        startAngle = (int) (curValue * 360 / total);
    //        int arcAngle = (int) (slices.get(i).getSliceSize() * 360 / total);
    //        g.setColor(slices.get(i).getColor());
    //        g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
    //        curValue += slices.get(i).getSliceSize();
    //     }
    //  }
}
