package edu.hw2;


import edu.hw2.Task1.Exponent;
import edu.hw2.Task1.Expr;
import edu.hw2.Task1.Negate;
import edu.hw2.Task1.Addition;
import edu.hw2.Task1.Multiplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import edu.hw2.Task1.Constant;


public class Task1Test {



    @Test
    @DisplayName("Creation of Object Test")
    void expr_CreateObject_Test() {
        //Arrange
        Expr tempObject = new Constant(2);

        //Act
        double result = tempObject.evaluate();

        //Assert
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("Negate of Value Test")
    void expr_NegateValue_Test() {
        //Arrange
        Expr tempObject = new Negate(new Constant(2));

        //Act
        double result = tempObject.evaluate();

        //Assert
        assertThat(result).isEqualTo(-2);
    }

    @Test
    @DisplayName("Addition of Values Test")
    void expr_AdditionValues_Test() {
        //Arrange
        Expr tempObjectOne = new Constant(2);
        Expr tempObjectTwo = new Constant(3);
        Expr addition = new Addition(tempObjectOne, tempObjectTwo);

        //Act
        double result = addition.evaluate();

        //Assert
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("Multiplication of Values Test")
    void expr_MultiplicationValues_Test() {
        //Arrange
        Expr tempObjectOne = new Constant(2);
        Expr tempObjectTwo = new Constant(3);
        Expr addition = new Multiplication(tempObjectOne, tempObjectTwo);

        //Act
        double result = addition.evaluate();

        //Assert
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("Exponent Test")
    void expr_ExponentValue_Test() {
        //Arrange
        Expr tempObjectOne = new Constant(8);
        Expr exponent = new Exponent(tempObjectOne, 2);

        //Act
        double result = exponent.evaluate();

        //Assert
        assertThat(result).isEqualTo(64);
    }
}
