package edu.hw10.Task2;

public class FibCalculatorImpl implements FibCalculator {

    @Cache(persist = true) @Override public long fib(int number) {
        if (number <= 1) {
            return number;
        } else {
            return fib(number - 1) + fib(number - 2);
        }
    }
}
