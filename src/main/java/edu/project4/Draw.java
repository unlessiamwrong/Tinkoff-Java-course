package edu.project4;

import edu.project4.Utility.GammaCorrection;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Draw {

    private final int width;
    private final int height;
    public Draw(int width, int height){
        this.width = width;
        this.height = height;

    }
    protected void paintComponent(){
        FractalImage fractalImage = new FractalImage(width, height);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.createGraphics();
        var pixels = fractalImage.generate();
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
