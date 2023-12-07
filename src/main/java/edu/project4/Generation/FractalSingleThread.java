package edu.project4.Generation;

import edu.project4.FractalConfig;
import edu.project4.Transformations.Affine;
import edu.project4.Transformations.NonLinear;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FractalSingleThread {

    private static final double X_MAX = 1.777;
    private static final double X_MIN = -1.777;
    private static final double Y_MAX = 1;
    private static final double Y_MIN = -1;
    private static final int OFFSET = -20;
    private final int width;
    private final int height;
    private final FractalConfig config;
    private final Random random = new Random();
    private final List<Affine> affines = new ArrayList<>();
    private final Pixel[][] pixels;

    public FractalSingleThread(int width, int height, FractalConfig config) {
        this.width = width;
        this.height = height;
        this.config = config;

        for (int i = 0; i < config.affinesCount(); i++) {
            affines.add(new Affine());
        }
        pixels = new Pixel[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[x][y] = new Pixel();
            }
        }

    }

    public Pixel[][] generate() {
        for (int i = 0; i < config.samplesCount(); i++) {

            double x = random.nextDouble() * (X_MAX - X_MIN) + X_MIN;
            double y = random.nextDouble() * (Y_MAX - Y_MIN) + Y_MIN;

            for (int step = OFFSET; step < config.iterationsCount(); step++) {
                Affine affine = affines.get(random.nextInt(affines.size()));
                Point point = affine.transform(x, y);
                NonLinear nlt = new NonLinear(point, config.nonLinearType());
                Point nlPoint = nlt.run();
                x = nlPoint.x();
                y = nlPoint.y();
                if (step >= 0 && x >= X_MIN && x <= X_MAX && y >= Y_MIN && y <= Y_MAX) {
                    int newX = width - (int) (((X_MAX - x) / (X_MAX - X_MIN)) * width);
                    int newY = height - (int) (((Y_MAX - y) / (Y_MAX - Y_MIN)) * height);
                    if (newX < width && newY < height) {
                        if (pixels[newX][newY].counter == 0) {
                            pixels[newX][newY].red = affine.red;
                            pixels[newX][newY].green = affine.green;
                            pixels[newX][newY].blue = affine.blue;
                        } else {
                            pixels[newX][newY].red = (pixels[newX][newY].red + affine.red) / 2;
                            pixels[newX][newY].green = (pixels[newX][newY].green + affine.green) / 2;
                            pixels[newX][newY].blue = (pixels[newX][newY].blue + affine.blue) / 2;
                        }

                        pixels[newX][newY].counter++;
                    }

                }
            }
        }
        return pixels;
    }

}
