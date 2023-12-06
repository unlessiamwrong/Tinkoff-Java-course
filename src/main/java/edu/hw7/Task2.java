package edu.hw7;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

    private Task2() {

    }

    public static int parallelFactorial(int value) {
        List<Integer> factorialSequence = new ArrayList<>();
        for (int i = 1; i - 1 < value; i++) {
            factorialSequence.add(i);
        }
        return factorialSequence.parallelStream().reduce(1, (a, b) -> a * b);
    }
}
