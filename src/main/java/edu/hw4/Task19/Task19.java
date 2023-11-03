package edu.hw4.Task19;

import edu.hw4.Animal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task19 {
    private Task19() {

    }

    public static Map<Integer, HashSet<ValidationError>> collectObjectsWithValidationErrors(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(Animal::hashCode, ValidationError::validateField));

    }
}
