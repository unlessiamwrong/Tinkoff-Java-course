package edu.hw2.Task2;

public class Rectangle {
    private final int width;
    private final int height;

    public Rectangle() {
        this(0, 0);
    }
    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }


    public Rectangle setWidth(int width) {
        return new Rectangle(this.height, width);

    }

    public Rectangle setHeight(int height) {
        return new Rectangle(height, this.width);

    }

    public int area() {
        return width * height;
    }
}

