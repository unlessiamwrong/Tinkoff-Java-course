package edu.hw10;

import edu.hw10.Task1.PersonClass;
import edu.hw10.Task1.PersonExtender;
import edu.hw10.Task1.PersonRecord;
import edu.hw10.Task1.RandomObjectGenerator;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test void PersonClass_Annotations_Test()
        throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        //Arrange
        RandomObjectGenerator rog = new RandomObjectGenerator();

        //Act
        PersonClass result = rog.nextObject(PersonClass.class);

        //Assert
        assertThat(result.getName()).isNotNull();
        assertThat(result.getAge()).isGreaterThan(0);
        assertThat(result.getAge()).isLessThan(15);

    }

    @Test void PersonExtender_Annotations_Test()
        throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        //Arrange
        RandomObjectGenerator rog = new RandomObjectGenerator();

        //Act
        PersonExtender result = rog.nextObject(PersonExtender.class);

        //Assert
        assertThat(result.getName()).isNotNull();
        assertThat(result.getAge()).isGreaterThan(0);
        assertThat(result.getAge()).isLessThan(15);

    }

    @Test void PersonRecord_Annotations_Test()
        throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        //Arrange
        RandomObjectGenerator rog = new RandomObjectGenerator();

        //Act
        PersonRecord result = rog.nextObject(PersonRecord.class);

        //Assert
        assertThat(result.name()).isNotNull();
        assertThat(result.age()).isGreaterThan(0);
        assertThat(result.age()).isLessThan(15);

    }
}
