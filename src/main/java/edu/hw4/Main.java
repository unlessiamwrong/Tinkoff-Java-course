package edu.hw4;

import edu.hw4.Tasks;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Vasyaaaaa", Animal.Type.CAT, Animal.Sex.M, 10, 10, 10, true));
        animals.add(new Animal("Vitya", Animal.Type.DOG, Animal.Sex.M, 20, 20, 20, false));
        animals.add(new Animal("M", Animal.Type.CAT, Animal.Sex.F, 30, 30, 30, true));
        animals.add(new Animal("Katya", Animal.Type.BIRD, Animal.Sex.F, 40, 40, 40, false));
        animals.add(new Animal("Sas", Animal.Type.FISH, Animal.Sex.M, 50, 50, 50, true));
        Stream<Animal> animalsStream = animals.stream();
        var result = Tasks.task6(animalsStream);
        System.out.println(result);
    }
}
