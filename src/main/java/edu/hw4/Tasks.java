package edu.hw4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("MagicNumber")
public class Tasks {

    private Tasks() {

    }

    public static List<Animal> task1(List<Animal> animals) {
        return animals
            .stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .toList();
    }

    public static List<Animal> task2(List<Animal> animals) {
        return animals
            .stream()
            .sorted(Comparator.comparingInt(Animal::weight)
                .reversed())
            .toList();
    }

    public static Map<Animal.Type, Integer> task3(List<Animal> animals) {
        return animals
            .stream()
            .collect(Collectors.toMap(Animal::type, i -> 1, Integer::sum));
    }

    public static Animal task4(List<Animal> animals) {
        return animals
            .stream()
            .max(Comparator.comparingInt(animal -> animal.name().length()))
            .orElse(null);

    }

    public static Animal.Sex task5(List<Animal> animals) {
        return Objects.requireNonNull(animals
                .stream()
                .collect(Collectors.toMap(Animal::sex, i -> 1, Integer::sum))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null))
            .getKey();

    }

    public static Map<Animal.Type, Animal> task6(List<Animal> animals) {
        return animals
            .stream()
            .collect(Collectors.groupingBy(Animal::type))
            .entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getKey, weight -> weight
                .getValue()
                .stream()
                .max(Comparator.comparingInt(Animal::weight))
                .get()));

    }

    public static Animal task7(List<Animal> animals, int k) {
        return animals
            .stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .skip(k - 1)
            .findFirst()
            .orElse(null);

    }

    public static Optional<Animal> task8(List<Animal> animals, int k) {
        return animals
            .stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight));

    }

    public static Integer task9(List<Animal> animals) {
        return animals
            .stream()
            .mapToInt(Animal::paws).sum();

    }

    public static List<Animal> task10(List<Animal> animals) {
        return animals
            .stream()
            .filter(animal -> animal.age() != animal.paws())
            .toList();

    }

    public static List<Animal> task11(List<Animal> animals) {
        return animals
            .stream()
            .filter(Animal::bites)
            .filter(animal -> animal.height() > 100)
            .toList();

    }

    public static Integer task12(List<Animal> animals) {
        return Math.toIntExact(animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count());

    }

    public static List<Animal> task13(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> Arrays.stream(animal.name().split("\\s+")).count() > 1)
            .toList();

    }

    public static Boolean task14(List<Animal> animals, int k) {
        return Math.toIntExact(animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG)
            .filter(animal -> animal.height() > k).count()) > 0;

    }

    public static Integer task15(List<Animal> animals, int k, int i) {
        return animals.stream()
            .filter(animal -> animal.age() >= k)
            .filter(animal -> animal.age() <= i)
            .mapToInt(Animal::weight)
            .sum();

    }

    public static List<Animal> task16(List<Animal> animals) {
        return animals
            .stream()
            .sorted(Comparator.comparing(Animal::type))
            .sorted(Comparator.comparing(Animal::sex))
            .sorted(Comparator.comparing(Animal::name)).toList();

    }

    public static Boolean task17(List<Animal> animals) {
        long spiders = animals.stream().filter(animal -> animal.type() == Animal.Type.SPIDER && animal.bites()).count();
        long dogs = animals.stream().filter(animal -> animal.type() == Animal.Type.DOG && animal.bites()).count();
        return spiders > dogs;

    }

    public static Animal task18(List<Animal> animalsOne, List<Animal> animalsTwo) {
        return Stream.of(animalsOne, animalsTwo)
            .flatMap(List::stream)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);

    }

}
