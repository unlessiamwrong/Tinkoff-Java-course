package edu.project4.Transformations;

import edu.project4.Generation.Point;

public class Symmetry {

    private static final double X_MAX = 1.777;
    private static final double X_MIN = -1.777;
    private static final double Y_MAX = 1;
    private static final double Y_MIN = -1;
    private static final int SYMMETRY = 1000;
    private static final double THETA = 1.1;
    private final double x;
    private final double y;

    public Symmetry(double x, double y) {
        this.x = x;
        this.y = y;

    }

    public Point rotate() {
        double theta = THETA;
        for (int i = 0; i < SYMMETRY; theta += Math.PI * 2 / SYMMETRY, i++) {
            double newX = (x * Math.cos(theta) - y * Math.sin(theta));
            double newY = (x * Math.sin(theta) + y * Math.sin(theta));
            if (newX >= X_MIN && newX <= X_MAX && newY >= Y_MIN && newY <= Y_MAX) {
                return new Point(newX, newY);
            }
        }
        return new Point(x, y);
    }
}
