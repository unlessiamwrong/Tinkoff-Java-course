package edu.hw3;

import edu.hw3.Task6.Stock;
import edu.hw3.Task6.Task6;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {

    @Test
    void stockMarket_AddMethod_Test() {
        //Arrange
        Stock tempObject = new Stock("123", 123);

        //Act
        Task6.add(tempObject);

        //Assert
        assertThat(tempObject).isInstanceOf(Stock.class);

    }

    @Test
    void stockMarket_RemoveMethod_Test() {
        //Arrange
        Stock tempObject = new Stock("123", 123);
        int expectedPQLength = Task6.stocks.size();

        //Act
        Task6.add(tempObject);
        Task6.remove(tempObject);
        int actualPQLength = Task6.stocks.size();

        //Assert
        assertThat(actualPQLength).isEqualTo(expectedPQLength);

    }

    @Test
    void stockMarket_mostValuableStockMethod_Test() {
        //Arrange
        Stock tempObjectOne = new Stock("123", 123);
        Stock tempObjectTwo = new Stock("456", 456);

        //Act
        Task6.add(tempObjectOne);
        Task6.add(tempObjectTwo);
        Stock result = Task6.mostValuableStock();

        //Assert
        assertThat(result).isEqualTo(tempObjectTwo);

    }
}
