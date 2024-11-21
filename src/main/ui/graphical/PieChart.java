package ui.graphical;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import java.util.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;

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
    //          specify the percentages of each slice in order of: 
    //          vegetable, fruit, protein, grain, other
    public PieChart(double vegeSize, double fruitSize, double proteinSize, double grainSize, double otherSize) {
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
        drawPieChart((Graphics2D)graphics2d, getBounds(), slices);
    }

    // EFFECTS: helper for paint, draws a pie chart 
    private void drawPieChart(Graphics2D g, Rectangle area, ArrayList<PieChartSlice> slices) {
        int startAngle = 0;
        double curSize = 0.0;
        int arcAngle = 0;
        for (int i = 0; i < slices.size(); i++) {
            startAngle = (int) (curSize / 100 * 360);
            arcAngle = (int) slices.get(i).getSliceSize() / 100 * 360;
            g.setColor(slices.get(i).getColor());
            g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
            curSize += slices.get(i).getSliceSize();
        }
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
