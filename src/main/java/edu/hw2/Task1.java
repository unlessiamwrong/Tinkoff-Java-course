package edu.hw2;

public class Task1 {

    public sealed interface Expr {
        double evaluate();

        record Constant(double value) implements Expr {
            @Override
            public double evaluate() {
                return value;
            }
        }

        record Negate(Expr value) implements Expr {
            @Override
            public double evaluate() {
                return -value.evaluate();
            }
        }

        record Exponent(Expr firstValue, double secondValue) implements Expr {
            @Override
            public double evaluate() {
                return Math.pow(firstValue.evaluate(), secondValue);
            }
        }

        record Addition(Expr firstValue, Expr secondValue) implements Expr {
            @Override
            public double evaluate() {
                return firstValue.evaluate() + secondValue.evaluate();
            }
        }

        record Multiplication(Expr firstValue, Expr secondValue) implements Expr {
            @Override
            public double evaluate() {
                return firstValue.evaluate() * secondValue.evaluate();
            }
        }
    }
}
