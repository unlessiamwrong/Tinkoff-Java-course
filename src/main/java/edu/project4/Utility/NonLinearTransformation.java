package edu.project4.Utility;

import edu.project4.Point;

public class NonLinearTransformation {

    private final double pow;
    private final double r;
    private final double theta;
    private final double phi;
    double x;
    double y;

    public NonLinearTransformation(Point point) {
        x = point.x();
        y = point.y();
        pow = (x * x + y * y);
        r = Math.sqrt(pow);
        theta = Math.atan(x / y);
        phi = Math.atan(y / x);

    }

    public Point sphere() {
        return new Point(x / pow, y / pow);
    }

    public Point sin() {
        return new Point(Math.sin(x), Math.sin(y));
    }

    public Point heart() {
        return new Point(r * Math.sin(r * theta), -r * Math.cos(r * theta));
    }

    public Point polar() {
        return new Point(phi / Math.PI, r - 1);
    }

    public Point disc() {
        return new Point((1 / Math.PI) * phi * Math.sin(Math.PI * r), (1 / Math.PI) * phi * Math.cos(Math.PI * r));
    }
}

