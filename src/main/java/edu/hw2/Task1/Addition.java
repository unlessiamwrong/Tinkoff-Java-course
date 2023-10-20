package edu.hw2.Task1;

public record Addition(Expr firstValue, Expr secondValue) implements Expr {
    @Override
    public double evaluate() {
        return firstValue.evaluate() + secondValue.evaluate();
    }
}
