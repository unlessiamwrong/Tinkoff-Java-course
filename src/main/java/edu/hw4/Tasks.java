package edu.hw4;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tasks {
    public void setStream() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Vasya", Animal.Type.CAT, Animal.Sex.M, 10, 10, 10, true));
        animals.add(new Animal("Vitya", Animal.Type.CAT, Animal.Sex.M, 5, 20, 20, false));
        animals.add(new Animal("Masha", Animal.Type.CAT, Animal.Sex.F, 30, 30, 30, true));
        animals.add(new Animal("Katya", Animal.Type.CAT, Animal.Sex.F, 40, 40, 40, false));
        animals.add(new Animal("Sasha", Animal.Type.CAT, Animal.Sex.M, 50, 50, 50, true));
        Stream<Animal> animalsStream = animals.stream();

    }

    static List<Animal> task1(Stream<Animal> animalsStream) {
        return animalsStream.sorted(Comparator.comparingInt(Animal::height)).toList();
    }

    static List<Animal> task2(Stream<Animal> animalsStream) {
        return animalsStream.sorted(Comparator.comparingInt(Animal::weight).reversed()).toList();
    }

    static Map<Animal.Type, Integer> task3(Stream<Animal> animalsStream) {
        return animalsStream.collect(Collectors.toMap(Animal::type, i -> 1, Integer::sum));
    }

    static Animal task4(Stream<Animal> animalsStream) {
        return animalsStream
            .max(Comparator.comparingInt(animal -> animal.name().length()))
            .get();

    }

    static Animal.Sex task5(Stream<Animal> animalsStream) {
        return animalsStream.collect(Collectors.toMap(Animal::sex, i -> 1, Integer::sum))
            .entrySet()
            .stream()
            .max(Comparator.comparing(Map.Entry::getValue))
            .get()
            .getKey();


    }
    static Map<Animal.Type, Animal> task6(Stream<Animal> animalsStream) {
        return animalsStream.collect(Collectors.groupingBy(Animal::type))
            .entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getKey, weight -> weight.getValue().stream().max(Comparator.comparingInt(Animal::weight)).get()));


    }

}1
