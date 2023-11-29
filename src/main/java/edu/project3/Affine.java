package edu.project3;

import java.util.Random;

public class Affine {

    private final double a;
    private final double b;
    private final double d;
    private final double e;
    private final double c;
    private final double f;

    int red;

    int green;
    int blue;


    public Affine() {
        Random random = new Random();
        red = random.nextInt(256);
        green = random.nextInt(256);
        blue = random.nextInt(256);
        a = random.nextDouble() * 2 - 1;
        b = random.nextDouble() * 2 - 1;
        d = random.nextDouble() * 2 - 1;
        e = random.nextDouble() * 2 - 1;
        f = random.nextDouble() * 2 - 1;
        c = random.nextDouble() * 2 - 1;

    }

    public double[] transform(double x, double y) {
        return new double[]{x * a + y * b + c, x * d + y * e + f, red, green, blue};
    }

}

