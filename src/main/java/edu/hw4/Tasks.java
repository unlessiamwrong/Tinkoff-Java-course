package edu.hw4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("MagicNumber")
public class Tasks {

    private Tasks() {

    }

    public static List<Animal> collectSortByHeight(List<Animal> animals) {
        return animals
            .stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .toList();
    }

    public static List<Animal> collectReversedSortByWeight(List<Animal> animals) {
        return animals
            .stream()
            .sorted(Comparator.comparingInt(Animal::weight)
                .reversed())
            .toList();
    }

    public static Map<Animal.Type, Long> collectCountByType(List<Animal> animals) {
        return animals
            .stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
    }

    public static Animal longestName(List<Animal> animals) {
        return animals
            .stream()
            .max(Comparator.comparingInt(animal -> animal.name().length()))
            .orElse(null);

    }

    public static Animal.Sex biggestSex(List<Animal> animals) {
        return Objects.requireNonNull(animals
                .stream()
                .collect(Collectors.toMap(Animal::sex, i -> 1, Integer::sum))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null))
            .getKey();

    }

    public static Map<Animal.Type, Animal> collectEveryTypeWithMostWeight(List<Animal> animals) {
        return animals
            .stream()
            .collect(Collectors.toMap(
                Animal::type,
                Function.identity(),
                BinaryOperator.maxBy(Comparator.comparingInt(Animal::weight))
            ));

    }

    public static Animal kOldest(List<Animal> animals, int k) {
        return animals
            .stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .skip(k - 1)
            .findFirst()
            .orElse(null);

    }

    public static Optional<Animal> mostWeightBelowKHeight(List<Animal> animals, int k) {
        return animals
            .stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight));

    }

    public static Integer countPaws(List<Animal> animals) {
        return animals
            .stream()
            .mapToInt(Animal::paws).sum();

    }

    public static List<Animal> collectWhereAgeNotEqualPaws(List<Animal> animals) {
        return animals
            .stream()
            .filter(animal -> animal.age() != animal.paws())
            .toList();

    }

    public static List<Animal> collectBitesTrueAboveKHeight(List<Animal> animals) {
        return animals
            .stream()
            .filter(Animal::bites)
            .filter(animal -> animal.height() > 100)
            .toList();

    }

    public static Integer countWeightAboveHeight(List<Animal> animals) {
        return Math.toIntExact(animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count());

    }

    public static List<Animal> collectNameConsistMoreThanTwoWords(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> Arrays.stream(animal.name().split("\\s+")).count() > 1)
            .toList();

    }

    public static Boolean ifTypeDogAboveKHeight(List<Animal> animals, int k) {
        return Math.toIntExact(animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG)
            .filter(animal -> animal.height() > k).count()) > 0;

    }

    public static Integer countWeightFromKtoIAge(List<Animal> animals, int k, int i) {
        return animals.stream()
            .filter(animal -> animal.age() >= k)
            .filter(animal -> animal.age() <= i)
            .mapToInt(Animal::weight)
            .sum();

    }

    public static List<Animal> collectSortByTypeBySexByName(List<Animal> animals) {
        return animals
            .stream()
            .sorted(Comparator.comparing(Animal::type))
            .sorted(Comparator.comparing(Animal::sex))
            .sorted(Comparator.comparing(Animal::name)).toList();

    }

    public static Boolean ifSpidersBiteMoreThanDogs(List<Animal> animals) {
        long spiders = animals.stream().filter(animal -> animal.type() == Animal.Type.SPIDER && animal.bites()).count();
        long dogs = animals.stream().filter(animal -> animal.type() == Animal.Type.DOG && animal.bites()).count();
        return spiders > dogs;

    }

    public static Animal mostWeightFromTwoCollections(List<Animal> animalsOne, List<Animal> animalsTwo) {
        return Stream.of(animalsOne, animalsTwo)
            .flatMap(List::stream)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);

    }

}
