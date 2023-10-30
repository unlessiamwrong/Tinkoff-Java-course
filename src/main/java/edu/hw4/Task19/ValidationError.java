package edu.hw4.Task19;

import edu.hw4.Animal;
import java.util.HashSet;

public class ValidationError {

    private ValidationError(String errorName) {
    }

    public static HashSet<ValidationError> validateField(Animal animal) {
        HashSet<ValidationError> result = new HashSet<>();
        if (animal.name().isEmpty()) {
            result.add(new ValidationError("EmptyNameError"));
        }
        if (animal.weight() < 0) {
            result.add(new ValidationError("NegativeWeightError"));
        }
        if (animal.age() < 0) {
            result.add(new ValidationError("NegativeAgeError"));
        }
        return result;
    }
}
