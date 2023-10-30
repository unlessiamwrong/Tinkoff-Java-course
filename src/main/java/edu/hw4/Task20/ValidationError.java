package edu.hw4.Task20;

import edu.hw4.Animal;
import java.util.HashSet;

public class ValidationError {

    private ValidationError(String errorName) {
    }

    public static HashSet<String> validateField(Animal animal) {
        HashSet<String> result = new HashSet<>();
        if (animal.name().isEmpty()) {
            result.add(("EmptyNameError"));
        }
        if (animal.weight() < 0) {
            result.add("NegativeWeightError");
        }
        if (animal.age() < 0) {
            result.add("NegativeAgeError");
        }
        return result;
    }
}

