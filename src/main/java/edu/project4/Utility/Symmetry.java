package edu.project4.Utility;

import edu.project4.Point;

public class Symmetry {

    private final double x;
    private final double y;
    double xMax = 1.777;
    double xMin = -1.777;
    double yMax = 1;
    double yMin = -1;

    public Symmetry(double x, double y) {
        this.x = x;
        this.y = y;

    }

    Point rotate() {
        double theta = 0.0;
        int symmetry = 1;
        for (int i = 0; i < symmetry; theta += Math.PI * 2 / symmetry, i++) {
            double newX = (x * Math.cos(theta) - y * Math.sin(theta));
            double newY = (x * Math.sin(theta) + y * Math.sin(theta));
            if (newX >= xMin && newX <= xMax && newY >= yMin && newY <= yMax) {
                return new Point(newX, newY);
            }
        }
        return new Point(x, y);
    }
}
