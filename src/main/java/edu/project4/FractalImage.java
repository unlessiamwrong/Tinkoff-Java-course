package edu.project4;

import edu.project4.Utility.AffineTransformation;
import edu.project4.Utility.NonLinearTransformation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class FractalImage {

    private final int width;
    private final int height;
    private final Random random = new Random();
    private final List<AffineTransformation> affineTransformations = new ArrayList<>();
    private final Pixel[][] pixels;
    double xMax = 1.777;
    double xMin = -1.777;
    double yMax = 1;
    double yMin = -1;

    Objects[] config;

    public FractalImage(int width, int height) {
        this.width = width;
        this.height = height;

        for (int i = 0; i < 3; i++) {
            affineTransformations.add(new AffineTransformation());
        }
        pixels = new Pixel[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[x][y] = new Pixel();
            }
        }

    }

    public Pixel[][] generate() {
        int it = 1000;
        for (int i = 0; i < 20000; i++) {

            double x = random.nextDouble() * (xMax - xMin) + xMin;
            double y = random.nextDouble() * (yMax - yMin) + yMin;

            for (int step = -20; step < it; step++) {
                AffineTransformation affineTransformation =
                    affineTransformations.get(random.nextInt(affineTransformations.size()));
                Point point = affineTransformation.transform(x, y);
                NonLinearTransformation nlt = new NonLinearTransformation(point);
                Point nlPoint = nlt.sphere();
                x = nlPoint.x();
                y = nlPoint.y();
                if (step >= 0 && x >= xMin && x <= xMax && y >= yMin && y <= yMax) {
                    int newX = width - (int) (((xMax - x) / (xMax - xMin)) * width);
                    int newY = height - (int) (((yMax - y) / (yMax - yMin)) * height);
                    if (newX < width && newY < height) {
                        if (pixels[newX][newY].counter == 0) {
                            pixels[newX][newY].red = affineTransformation.red;
                            pixels[newX][newY].green = affineTransformation.green;
                            pixels[newX][newY].blue = affineTransformation.blue;
                        } else {
                            pixels[newX][newY].red = (pixels[newX][newY].red + affineTransformation.red) / 2;
                            pixels[newX][newY].green = (pixels[newX][newY].green + affineTransformation.green) / 2;
                            pixels[newX][newY].blue = (pixels[newX][newY].blue + affineTransformation.blue) / 2;
                        }

                        pixels[newX][newY].counter++;
                    }

                }
            }
        }
        return pixels;
    }

}
