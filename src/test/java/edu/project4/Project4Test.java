package edu.project4;

import edu.project4.Generation.FractalSingleThread;
import edu.project4.Generation.Pixel;
import edu.project4.Generation.Point;
import edu.project4.Transformations.Affine;
import edu.project4.Transformations.GammaCorrection;
import edu.project4.Transformations.NonLinear;
import edu.project4.Transformations.Symmetry;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Project4Test {
    @Test
    void fractalGeneration_Test() {
        //Arrange
        FractalConfig config = new FractalConfig(20000, 1000, 5, "sphere");
        FractalSingleThread fst = new FractalSingleThread(1920, 1080, config);
        Pixel[][] pixels = new Pixel[1920][1080];

        //Act
        Pixel[][] result = fst.generate();

        //Assert
        assertThat(Arrays.deepEquals(pixels, result)).isFalse();
    }

    @Test
    void gammaCorrection_Test() {
        //Arrange
        Pixel[][] pixels = new Pixel[10][10];
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                pixels[x][y] = new Pixel();
                pixels[x][y].red = 100;
                pixels[x][y].green = 150;
                pixels[x][y].blue = 200;
                pixels[x][y].counter = x + y;
            }
        }

        //Act
        GammaCorrection gammaCorrection = new GammaCorrection(pixels);
        pixels = gammaCorrection.run();

        //Assert
        assertThat(pixels[0][0].red).isEqualTo(0);
        assertThat(pixels[1][1].green).isEqualTo(78);
        assertThat(pixels[2][2].blue).isEqualTo(143);
    }

    @Test
    void nonLinearTransformation_Test() {
        //Arrange
        Point point = new Point(1, 1);

        //Act
        NonLinear nonLinear = new NonLinear(point, "sin");
        Point pointSin = nonLinear.run();

        //Assert
        assertThat(point.x()).isNotEqualTo(pointSin.x());
        assertThat(point.y()).isNotEqualTo(pointSin.y());
    }

    @Test
    void affineTransformation_Test() {
        //Arrange
        Point point = new Point(1, 1);

        //Act
        Affine affine = new Affine();
        Point pointAffine = affine.transform(point.x(), point.y());

        //Assert
        assertThat(point.x()).isNotEqualTo(pointAffine.x());
        assertThat(point.y()).isNotEqualTo(pointAffine.y());
    }

    @Test
    void symmetry_Test() {
        //Arrange
        Point point = new Point(1, 1);

        //Act
        Symmetry symmetry = new Symmetry(point.x(), point.y());
        Point pointSymmetry = symmetry.rotate();

        //Assert
        assertThat(point.x()).isNotEqualTo(pointSymmetry.x());
        assertThat(point.y()).isNotEqualTo(pointSymmetry.y());
    }
}
