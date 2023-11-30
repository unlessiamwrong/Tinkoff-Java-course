package edu.project4;

import java.awt.Color;
import java.util.Random;

public class Affine {

    private double a;
    private double b;
    private double d;
    private double e;
    private final double c;
    private final double f;


    Random random = new Random();

    final int red = random.nextInt(256);
    final int green = random.nextInt(256);
    final int blue = random.nextInt(256);;


    public Affine() {

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

        } while ((a * a + b * b + d * d + e * e) >
            (1 + (a * e - d * b) * (a * e - d * b)));
    }
    public double[] transform(double x, double y) {

        return new double[]{x * a + y * b + c, x * d + y * e + f};
    }

}



