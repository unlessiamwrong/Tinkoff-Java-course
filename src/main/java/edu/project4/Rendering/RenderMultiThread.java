package edu.project4.Rendering;

import edu.project4.FractalConfig;
import edu.project4.Generation.FractalMultiThread;
import edu.project4.Transformations.GammaCorrection;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RenderMultiThread {

    private final static int THREADS_COUNT = 5;
    private final int width;
    private final int height;
    private final FractalConfig config;

    public RenderMultiThread(int width, int height, FractalConfig config) {
        this.width = width;
        this.height = height;
        this.config = config;

    }

    public void run() {
        FractalMultiThread fractalMt = new FractalMultiThread(width, height, config);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.createGraphics();
        var pixels = fractalMt.generate(THREADS_COUNT);
        GammaCorrection gammaCorrection = new GammaCorrection(pixels);
        pixels = gammaCorrection.run();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int red = pixels[x][y].red;
                int green = pixels[x][y].green;
                int blue = pixels[x][y].blue;
                g.setColor(new Color(red, green, blue));
                g.drawLine(x, y, x, y);

            }
        }
        g.dispose();
        JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(image)));

    }
}
