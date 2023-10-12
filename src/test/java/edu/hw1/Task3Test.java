package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Check if one array can be nestable to another")
    void simpleCheckTest() {
        int[] array1;
        int[] array2;
        boolean checker;

        array1 = new int[] {1, 2, 3, 4};
        array2 = new int[] {0, 5};

        checker = Task3.isNestable(array1, array2);
        assertThat(checker).isTrue();

        array1 = new int[] {0, 2, 3, 4};
        array2 = new int[] {0, 5};

        checker = Task3.isNestable(array1, array2);
        assertThat(checker).isFalse();

        array1 = new int[] {1, 2, 3, 5};
        array2 = new int[] {0, 5};

        checker = Task3.isNestable(array1, array2);
        assertThat(checker).isFalse();

    }
}
