package edu.hw4;

import edu.hw4.Task19.Task19;
import edu.hw4.Task20.Task20;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TasksTests {

    public static List<Animal> createCollection() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Vasya", Animal.Type.SPIDER, Animal.Sex.M, 4, 101, 40, true));
        animals.add(new Animal("Vitalya", Animal.Type.SPIDER, Animal.Sex.F, 5, 21, 20, true));
        animals.add(new Animal("M J", Animal.Type.FISH, Animal.Sex.F, 1, 1, 1, true));
        return animals;
    }

    public static List<Animal> createCollectionForTaskFrom18To20() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("V", Animal.Type.SPIDER, Animal.Sex.M, 4, 101, 40, true));
        animals.add(new Animal("M2", Animal.Type.FISH, Animal.Sex.F, -1, 1, 1, true));
        animals.add(new Animal("M3", Animal.Type.FISH, Animal.Sex.F, -1, -1, -1, true));
        return animals;
    }

    @Test
    void collectSortByHeight_IsFirstMJ_Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.collectSortByHeight(animals);

        //Assert
        assertThat(result.getFirst().name()).isEqualTo("M J");

    }

    @Test
    void collectReversedSortByWeight_IsFirstVasya_Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.collectReversedSortByWeight(animals);

        //Assert
        assertThat(result.getFirst().name()).isEqualTo("Vasya");

    }

    @Test
    void collectCountByType_FishEqualsOne_Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.collectCountByType(animals);

        //Assert
        assertThat(result.get(Animal.Type.FISH)).isEqualTo(1);

    }

    @Test
    void longestName_EqualsVitalya_Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.longestName(animals);

        //Assert
        assertThat(result.name()).isEqualTo("Vitalya");

    }

    @Test
    void biggestSex_EqualsF_Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.biggestSex(animals);

        //Assert
        assertThat(result).isEqualTo(Animal.Sex.F);

    }

    @Test
    void collectEveryTypeWithMostWeight_IsFishEqualsMJ_Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.collectEveryTypeWithMostWeight(animals);

        //Assert
        assertThat(result.get(Animal.Type.FISH).name()).isEqualTo("M J");

    }

    @Test
    void ThirdOldest_EqualsMJ_Test() {
        //Arrange
        var animals = createCollection();
        int k = 3;

        //Act
        var result = Tasks.kOldest(animals, k);

        //Assert
        assertThat(result.name()).isEqualTo("M J");

    }

    @Test
    void mostWeightBelowHeightTen_EqualsMJ_Test() {
        //Arrange
        var animals = createCollection();
        int k = 10;

        //Act
        var result = Tasks.mostWeightBelowKHeight(animals, k);

        //Assert
        assertThat(result.get().name()).isEqualTo("M J");

    }

    @Test
    void countPaws_EqualsSixteen_Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.countPaws(animals);

        //Assert
        assertThat(result).isEqualTo(16);

    }

    @Test
    void collectWhereAgeNotEqualPaws_IsFirstVasya_IsLastMJ_Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.collectWhereAgeNotEqualPaws(animals);

        //Assert
        assertThat(result.getFirst().name()).isEqualTo("Vasya");
        assertThat(result.getLast().name()).isEqualTo("M J");

    }

    @Test
    void collectBitesTrueAboveKHeight_IsFirstVasya_Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.collectBitesTrueAboveKHeight(animals);

        //Assert
        assertThat(result.getFirst().name()).isEqualTo("Vasya");

    }

    @Test
    void countWeightAboveHeight_EqualsZero_Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.countWeightAboveHeight(animals);

        //Assert
        assertThat(result).isEqualTo(0);

    }

    @Test
    void collectNameConsistMoreThanTwoWords_IsFirstMJ_Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.collectNameConsistMoreThanTwoWords(animals);

        //Assert
        assertThat(result.getFirst().name()).isEqualTo("M J");

    }

    @Test
    void ifTypeDogAboveKHeight_EqualsFalse_Test() {
        //Arrange
        var animals = createCollection();
        int k = 10;

        //Act
        var result = Tasks.ifTypeDogAboveKHeight(animals, k);

        //Assert
        assertThat(result).isFalse();

    }

    @Test
    void countWeightFromKtoIAge_EqualsSixtyOne_Test() {
        //Arrange
        var animals = createCollection();
        int k = 1;
        int i = 10;

        //Act
        var result = Tasks.countWeightFromKtoIAge(animals, k, i);

        //Assert
        assertThat(result).isEqualTo(61);

    }

    @Test
    void collectSortByTypeBySexByName_IsFirstMJ_Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.collectSortByTypeBySexByName(animals);

        //Assert
        assertThat(result.getFirst().name()).isEqualTo("M J");
    }

    @Test
    void ifSpidersBiteMoreThanDogs_EqualsTrue_Test() {
        //Arrange
        var animals = createCollection();

        //Act
        var result = Tasks.ifSpidersBiteMoreThanDogs(animals);

        //Assert
        assertThat(result).isTrue();
    }

    @Test
    void mostWeightFromTwoCollections_EqualsMJ_Test() {
        //Arrange
        var animalsOne = createCollection();
        var animalsTwo = createCollectionForTaskFrom18To20();

        //Act
        var result = Tasks.mostWeightFromTwoCollections(animalsOne, animalsTwo);

        //Assert
        assertThat(result.name()).isEqualTo("M J");
    }

    @Test
    void collectObjectsWithValidationErrors() {
        //Arrange
        var animals = createCollectionForTaskFrom18To20();

        //Act
        var result = Task19.collectObjectsWithValidationErrors(animals);

        //Assert
        assertThat(result).isNotNull();
    }

    @Test
    void prettyCollectObjectsWithValidationErrors_Test() {
        //Arrange
        var animals = createCollectionForTaskFrom18To20();

        //Act
        var result = Task20.prettyCollectObjectsWithValidationErrors(animals);

        //Assert
        assertThat(result.get("M3")).isNotNull();
    }

}
