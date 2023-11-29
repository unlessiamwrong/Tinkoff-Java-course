package edu.project3;

import java.util.Random;

public class Affine2 {

    private final double a;
    private final double b;
    private final double d;
    private final double e;
    private final double c;
    private final double f;

    int red;

    int green;
    int blue;


    public Affine2(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.d = d;
        this.e = e;
        this.f = f;
        this.c = c;
        Random random = new Random();
        red = random.nextInt(256);
        green = random.nextInt(256);
        blue = random.nextInt(256);

    }

    public double[] transform(double x, double y) {
        return new double[]{x * a + y * b + c, x * d + y * e + f, red, green, blue};
    }
}
