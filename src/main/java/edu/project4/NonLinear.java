package edu.project4;

public class NonLinear {

    public static double[] sin(double x, double y){
        return new double[]{Math.sin(x), Math.sin(y)};
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
    public static double[] polar(double x, double y){
        return new double[]{
            (Math.atan(y / x)) / 3.14,
            Math.sqrt(x * x + y * y) - 1};
    }

    public static double[] disc(double x, double y){
        return new double[]{
            (1 / 3.14) * Math.atan(y / x) * Math.sin(3.14 * Math.sqrt(x * x + y * y)),
            (1 / 3.14) * Math.atan(y / x) * Math.cos(3.14 * Math.sqrt(x * x + y * y))};
    }
    }

