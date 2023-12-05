package edu.project4.Utility;

import edu.project4.Point;
import java.util.Random;

public class AffineTransformation {

    private final double c;
    private final double f;
    private final Random random = new Random();
    public final int red = random.nextInt(256);
    public final int green = random.nextInt(256);
    public final int blue = random.nextInt(256);
    private double a;
    private double b;
    private double d;
    private double e;

    public AffineTransformation() {

        f = random.nextDouble() * 2 - 1;
        c = random.nextDouble() * 2 - 1;
        do {
            do {
                a = random.nextDouble();
                d = random.nextDouble();
            } while ((a * a + d * d) > 1);
            do {
                b = random.nextDouble();
                e = random.nextDouble();
            } while ((b * b + e * e) > 1);

        } while ((a * a + b * b + d * d + e * e) > (1 + (a * e - d * b) * (a * e - d * b)));
    }

    public Point transform(double x, double y) {

        return new Point(x * a + y * b + c, x * d + y * e + f);
    }
}



