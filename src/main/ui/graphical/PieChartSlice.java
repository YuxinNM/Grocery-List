package ui.graphical;

import java.awt.Color;

// Represents a slice in the pie chart
public class PieChartSlice {
    private double sliceSize;
    private Color sliceColor;

    //EFFECTS: creates a slice in the pie chart with given size and color
    public PieChartSlice(double size, Color color) {
        this.sliceSize = size;
        this.sliceColor = color;
    }

    public double getSliceSize() {
        return sliceSize;
    }

    public Color getColor() {
        return sliceColor;
    }

    // EFFECTS: calculates the angle for the slice should be and return it
    public int getArcAngle() {
        return (int) sliceSize * 360 / 100; 
    }
}
