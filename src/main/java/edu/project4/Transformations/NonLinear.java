package edu.project4.Transformations;

import edu.project4.Generation.Point;

@SuppressWarnings("ReturnCount")
public class NonLinear {

    private final double pow;
    private final double r;
    private final double theta;
    private final double phi;
    private final String type;
    double x;
    double y;

    public NonLinear(Point point, String type) {
        x = point.x();
        y = point.y();
        this.type = type;
        pow = (x * x + y * y);
        r = Math.sqrt(pow);
        theta = Math.atan(x / y);
        phi = Math.atan(y / x);

    }

    private Point sphere() {
        return new Point(x / pow, y / pow);
    }

    private Point sin() {
        return new Point(Math.sin(x), Math.sin(y));
    }

    private Point heart() {
        return new Point(r * Math.sin(r * theta), -r * Math.cos(r * theta));
    }

    private Point polar() {
        return new Point(phi / Math.PI, r - 1);
    }

    private Point disc() {
        return new Point((1 / Math.PI) * phi * Math.sin(Math.PI * r), (1 / Math.PI) * phi * Math.cos(Math.PI * r));
    }

    public Point run() {
        switch (type) {
            case "sphere" -> {
                return sphere();
            }
            case "heart" -> {
                return heart();
            }
            case "polar" -> {
                return polar();
            }
            case "disc" -> {
                return disc();
            }
            default -> {
                return sin();
            }
        }
    }
}

