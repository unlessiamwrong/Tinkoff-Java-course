package edu.hw3;

import edu.hw4.Animal;
import edu.hw4.Task19.Task19;
import edu.hw4.Task20.Task20;
import edu.hw4.Tasks;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TasksTests {

    public static List<Animal> createCollection() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Vasya", Animal.Type.SPIDER, Animal.Sex.M, 4, 101, 40, true));
        animals.add(new Animal("Vitalya", Animal.Type.SPIDER, Animal.Sex.F, 5, 21, 20, true));
        animals.add(new Animal("Misha", Animal.Type.DOG, Animal.Sex.F, 6, 3, 4, true));
        animals.add(new Animal("Katya", Animal.Type.FISH, Animal.Sex.F, 40, 40, 41, true));
        animals.add(new Animal("Oleg", Animal.Type.FISH, Animal.Sex.F, 1, 1, 1, true));
        animals.add(new Animal("M J", Animal.Type.FISH, Animal.Sex.F, 1, 1, 1, true));
        return animals;
    }

    public static List<Animal> createCollectionForTaskFrom18To20() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("V", Animal.Type.SPIDER, Animal.Sex.M, 4, 101, 40, true));
        animals.add(new Animal("V1", Animal.Type.SPIDER, Animal.Sex.F, 5, 21, 20, true));
        animals.add(new Animal("M", Animal.Type.DOG, Animal.Sex.F, 6, 3, 4, true));
        animals.add(new Animal("K", Animal.Type.FISH, Animal.Sex.F, 40, 40, 333, true));
        animals.add(new Animal("O", Animal.Type.FISH, Animal.Sex.F, 1, 1, 1, true));
        animals.add(new Animal("M2", Animal.Type.FISH, Animal.Sex.F, -1, 1, 1, true));
        animals.add(new Animal("M3", Animal.Type.FISH, Animal.Sex.F, -1, -1, -1, true));
        return animals;
    }

    @Test
    void Task1Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.task1(animals);

        //Assert
        assertThat(result.getFirst().name()).isEqualTo("Oleg");

    }

    @Test
    void Task2Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.task2(animals);

        //Assert
        assertThat(result.getFirst().name()).isEqualTo("Katya");

    }

    @Test
    void Task3Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.task3(animals);

        //Assert
        assertThat(result.get(Animal.Type.FISH)).isEqualTo(3);

    }

    @Test
    void Task4Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.task4(animals);

        //Assert
        assertThat(result.name()).isEqualTo("Vitalya");

    }

    @Test
    void Task5Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.task5(animals);

        //Assert
        assertThat(result).isEqualTo(Animal.Sex.F);

    }

    @Test
    void Task6Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.task6(animals);

        //Assert
        assertThat(result.get(Animal.Type.FISH).name()).isEqualTo("Katya");

    }

    @Test
    void Task7Test() {
        //Arrange
        var animals = createCollection();
        int k = 3;

        //Act
        var result = Tasks.task7(animals, k);

        //Assert
        assertThat(result.name()).isEqualTo("Vitalya");

    }

    @Test
    void Task8Test() {
        //Arrange
        var animals = createCollection();
        int k = 10;

        //Act
        var result = Tasks.task8(animals, k);

        //Assert
        assertThat(result.get().name()).isEqualTo("Misha");

    }

    @Test
    void Task9Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.task9(animals);

        //Assert
        assertThat(result).isEqualTo(20);

    }

    @Test
    void Task10Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.task10(animals);

        //Assert
        assertThat(result.getFirst().name()).isEqualTo("Vasya");
        assertThat(result.getLast().name()).isEqualTo("M J");

    }

    @Test
    void Task11Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.task11(animals);

        //Assert
        assertThat(result.getFirst().name()).isEqualTo("Vasya");

    }

    @Test
    void Task12Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.task12(animals);

        //Assert
        assertThat(result).isEqualTo(2);

    }

    @Test
    void Task13Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.task13(animals);

        //Assert
        assertThat(result.getFirst().name()).isEqualTo("M J");

    }

    @Test
    void Task14Test() {
        //Arrange
        var animals = createCollection();
        int k = 10;

        //Act
        var result = Tasks.task14(animals, k);

        //Assert
        assertThat(result).isFalse();

    }

    @Test
    void Task15Test() {
        //Arrange
        var animals = createCollection();
        int k = 1;
        int i = 10;

        //Act
        var result = Tasks.task15(animals, k, i);

        //Assert
        assertThat(result).isEqualTo(66);

    }

    @Test
    void Task16Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.task16(animals);

        //Assert
        assertThat(result.getFirst().name()).isEqualTo("Katya");
    }

    @Test
    void Task17Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.task17(animals);

        //Assert
        assertThat(result).isTrue();
    }

    @Test
    void Task18Test() {
        //Arrange
        var animalsOne = createCollection();
        var animalsTwo = createCollectionForTaskFrom18To20();

        //Act
        var result = Tasks.task18(animalsOne, animalsTwo);

        //Assert
        assertThat(result.name()).isEqualTo("K");
    }

    @Test
    void Task19Test() {
        //Arrange
        var animals = createCollectionForTaskFrom18To20();

        //Act
        var result = Task19.task19(animals);

        //Assert
        assertThat(result).isNotNull();
    }

    @Test
    void Task20Test() {
        //Arrange
        var animals = createCollectionForTaskFrom18To20();

        //Act
        var result = Task20.task20(animals);

        //Assert
        assertThat(result.get("M3")).isNotNull();
    }

}
