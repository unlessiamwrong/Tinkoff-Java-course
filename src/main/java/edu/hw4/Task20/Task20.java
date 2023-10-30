package edu.hw4.Task20;

import edu.hw4.Animal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task20 {

    private Task20() {

    }

    public static Map<String, HashSet<String>> task20(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(Animal::name, ValidationError::validateField));
    }
}
