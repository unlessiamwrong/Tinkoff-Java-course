package edu.project4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DrawCanvas extends JComponent {
    private final int width;
    private final int height;

    private final Random random = new Random();
    private final List<Affine> affines = new ArrayList<>();


    private final Pixel[][] pixels;

    public DrawCanvas(int w, int h) {
        width = w;
        height = h;

        for(int i = 0; i < 35; i++){
            affines.add(new Affine());
        }
        pixels = new Pixel[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[x][y] = new Pixel();
            }
        }

    }

    public static void main(String[] args) {
        BufferedImage image = new BufferedImage(1920,1080,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        DrawCanvas d = new DrawCanvas(1920, 1080);
        d.paintComponent(g);

        g.dispose();

        JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(image)));
    }

    protected void paintComponent(Graphics g) {
        int it = 1000;
        for(int i = 0; i < 20000; i++) {
            double xMax = 1.777;
            double xMin = -1.777;
            double yMax = 1;
            double yMin = -1;

            double newX = random.nextDouble() * (xMax - xMin) + xMin;
            double newY = random.nextDouble() * (yMax - yMin) + yMin;

            for (int step = -20; step < it; step++) {
                Affine affine = affines.get(random.nextInt(affines.size()));
                double[] xy = affine.transform(newX, newY);
                double[] xy1 = NonLinear.disc(xy[0], xy[1]);

                newX = xy1[0];
                newY = xy1[1];

                if (step >= 0 && (newX >= xMin && newX <= xMax) && (newY >= yMin && newY <= yMax)) {
                    int x1 = width - (int) (((xMax - newX) / (xMax - xMin)) * width);
                    int y1 = height - (int) (((yMax - newY) / (yMax - yMin)) * height);
                    if (x1 < width && y1 < height) {
                        if (pixels[x1][y1].counter == 0) {
                            pixels[x1][y1].red = affine.red;
                            pixels[x1][y1].green = affine.green;
                            pixels[x1][y1].blue = affine.blue;
                        } else {
                            pixels[x1][y1].red = (pixels[x1][y1].red + affine.red) / 2;
                            pixels[x1][y1].green = (pixels[x1][y1].green + affine.green) / 2;
                            pixels[x1][y1].blue = (pixels[x1][y1].blue + affine.blue) / 2;
                        }
                        pixels[x1][y1].counter++;
                    }

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
                g.drawLine(x, y, x, y);

            }
        }
    }

    void gammaCorrection(int width, int height){
        double max = 0.0;
        double gamma = 2.2;
        for(int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                Pixel currentPixel = pixels[x][y];
                if(currentPixel.counter != 0){
                    currentPixel.normal = Math.log10(currentPixel.counter);
                    if(currentPixel.normal > max){
                        max = currentPixel.normal;
                    }
                }
            }
        }
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                Pixel currentPixel = pixels[x][y];
                currentPixel.normal /= max;
                currentPixel.red = (int) (currentPixel.red * Math.pow(currentPixel.normal, (1.0 / gamma)));
                currentPixel.green = (int) (currentPixel.green * Math.pow(currentPixel.normal, (1.0 / gamma)));
                currentPixel.blue = (int) (currentPixel.blue * Math.pow(currentPixel.normal, (1.0 / gamma)));
            }
        }
    }

}
