package edu.hw2.Task1;

public record Exponent(Expr firstValue, double secondValue) implements Expr {
    @Override
    public double evaluate() {
        return Math.pow(firstValue.evaluate(), secondValue);
    }
}
