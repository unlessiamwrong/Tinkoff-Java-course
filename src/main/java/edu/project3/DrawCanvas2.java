package edu.project3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JComponent;

public class DrawCanvas2 extends JComponent {
    private final int width;
    private final int height;

    private final double xMax = 1.777;

    private final double xMin = -1.777;

    private final int yMax = 1;

    private final double yMin = -1;

    private final Random random = new Random();
    private final List<Affine> affines = new ArrayList<>();

    private final List<Affine2> affines2 = new ArrayList<>();
    private final Pixel[][] pixels;

    public DrawCanvas2(int w, int h) {
        width = w;
        height = h;
        affines2.add(new Affine2(0.2, -1.26, 0.223, 0.2422, 0, 1.23));
        affines2.add(new Affine2(-.15, 0.28, 0.2336, 0.244, 0, 0.4455));
        affines2.add(new Affine2(0.2, 0.25, 0.223, 0.244, 0, 1.23));
        affines2.add(new Affine2(-0.15, -1.26, 0.2336, 0.2422, 0, 0.4455));
        for(int i = 0; i < 3; i++){
            affines.add(new Affine());
        }
        pixels = new Pixel[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pixels[i][j] = new Pixel();
            }
        }

    }

    protected void paintComponent(Graphics g) {
        int step = -20;
        for(int i = 0; i < 1000000; i++){
            step++;

            double newX = random.nextDouble() * 2 * xMax - xMax;
            double newY = random.nextDouble() * 2 - yMax;
//            Affine randomAffine = affines.get(random.nextInt(affines.size()));
//            double[] xy = randomAffine.transform(newX, newY);
            Affine2 randomAffine2 = affines2.get(random.nextInt(affines2.size()));
            double[] xy = randomAffine2.transform(newX, newY);
            double x = xy[0];
            double y = xy[1];
            x = NonLinear.heart(x, y)[0];
            y = NonLinear.heart(x, y)[1];

            if(step >= 0 && x >= xMin && x <= xMax && y >= yMin && y <= yMax ){
                int x1 = (int) (width - Math.round(((xMax - x) / (xMax - xMin)) * width));
                int y1 = (int) (height - Math.round(((yMax - y) / (yMax - yMin)) * height));
                if(x1 < width && y1 < height){
                    if(pixels[x1][y1].counter == 0){
                        pixels[x1][y1].red = (int) xy[2];
                        pixels[x1][y1].green = (int) xy[3];
                        pixels[x1][y1].blue = (int) xy[4];
                    } else{
                        pixels[x1][y1].red = (pixels[x1][y1].red + (int) xy[2]) / 2;
                        pixels[x1][y1].green = (pixels[x1][y1].green + (int) xy[3]) / 2;
                        pixels[x1][y1].blue = (pixels[x1][y1].blue + (int) xy[4]) / 2;
                    }
                    pixels[x1][y1].counter++;
                }

            }
        }
        gammaCorrection(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int red = pixels[x][y].red;
                int green = pixels[x][y].green;
                int blue = pixels[x][y].blue;
                g.setColor(new Color(red, green, blue));
                g.fillRect(x, y, 2, 2);
            }
        }
    }

    void gammaCorrection(int width, int height){
        for(int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                int red = pixels[x][y].red;
                int green = pixels[x][y].green;
                int blue = pixels[x][y].blue;
                red = (int) (255 * Math.pow((red / 255.0), (1.0 / 2.2)));
                green = (int) (255 * Math.pow((green / 255.0), (1.0 / 2.2)));
                blue = (int) (255 * Math.pow((blue / 255.0), (1.0 / 2.2)));
                pixels[x][y].red = red;
                pixels[x][y].green = green;
                pixels[x][y].blue = blue;
            }
        }

    }

}
