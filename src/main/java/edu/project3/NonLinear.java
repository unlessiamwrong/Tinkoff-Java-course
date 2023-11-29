package edu.project3;

public class NonLinear {

    public static double sin(double cord){
        return Math.sin(cord);
    }

    public static double[] sphere(double x, double y){
        return new double[]{x / (x * x + y * y), y / (x * x + y * y)};
    }

    public static double[] heart(double x, double y){
        return new double[]{
            Math.sqrt(x * x + y * y) * Math.sin(Math.sqrt(x * x + y * y) *  Math.atan(x / y)),
           -Math.sqrt(x * x + y * y) * Math.cos(Math.sqrt(x * x + y * y) *  Math.atan(x / y))
        };
    }
}
