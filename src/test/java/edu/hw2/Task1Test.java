package edu.hw2;

import edu.hw2.Task1.Expr.Addition;
import edu.hw2.Task1.Expr.Constant;
import edu.hw2.Task1.Expr.Exponent;
import edu.hw2.Task1.Expr.Multiplication;
import edu.hw2.Task1.Expr.Negate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    @DisplayName("Creation of Object Test")
    void expr_CreateObject_Test() {
        Constant tempObject = new Constant(2);
        assertThat(tempObject).isInstanceOf(Constant.class);
    }

    @Test
    @DisplayName("Negate of Value Test")
    void expr_NegateValue_Test() {
        Negate tempObject = new Negate(new Constant(1));
        assertThat(tempObject.evaluate()).isEqualTo(-1);
    }

    @Test
    @DisplayName("Addition of Values Test")
    void expr_AdditionValues_Test() {
        Addition tempObject = new Addition(new Constant(2), new Constant(4));

        assertThat(tempObject.evaluate()).isEqualTo(6);
    }

    @Test
    @DisplayName("Multiplication of Values Test")
    void expr_MultiplicationValues_Test() {
        Multiplication tempObject = new Multiplication(new Constant(2), new Constant(4));

        assertThat(tempObject.evaluate()).isEqualTo(8);
    }

    @Test
    @DisplayName("Exponent Test")
    void expr_ExponentValue_Test() {
        Exponent tempObject = new Exponent(new Constant(8), 2);

        assertThat(tempObject.evaluate()).isEqualTo(64);
    }
}
