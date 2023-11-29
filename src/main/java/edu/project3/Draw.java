package edu.project3;

import javax.swing.*;

public class Draw {
    public static void main(String[] args) {
        int w = 1920;
        int h = 1080;
        JFrame f = new JFrame();
        DrawCanvas2 dc = new DrawCanvas2(w, h);
        f.setSize(w,h);
        f.add(dc);
        f.setTitle("LOL");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
