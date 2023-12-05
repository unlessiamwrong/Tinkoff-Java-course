package edu.project4.Utility;

import edu.project4.Pixel;

public class GammaCorrection {

    private final Pixel[][] pixels;

    private final int width;
    private final int height;

    public GammaCorrection(Pixel[][] pixels) {
        this.pixels = pixels;
        width = pixels.length;
        height = pixels[0].length;

    }

    public Pixel[][] run() {
        double max = 0.0;
        double gamma = 2.2;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Pixel currentPixel = pixels[x][y];
                if (currentPixel.counter != 0) {
                    currentPixel.normal = Math.log10(currentPixel.counter);
                    if (currentPixel.normal > max) {
                        max = currentPixel.normal;
                    }
                }
            }
        }
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Pixel currentPixel = pixels[x][y];
                currentPixel.normal /= max;
                currentPixel.red = (int) (currentPixel.red * Math.pow(currentPixel.normal, (1.0 / gamma)));
                currentPixel.green = (int) (currentPixel.green * Math.pow(currentPixel.normal, (1.0 / gamma)));
                currentPixel.blue = (int) (currentPixel.blue * Math.pow(currentPixel.normal, (1.0 / gamma)));
            }
        }
        return pixels;
    }
}
