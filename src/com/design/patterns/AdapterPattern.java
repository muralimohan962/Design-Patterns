package com.design.patterns;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Circle {
    private int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    void drawCircle(Graphics graphics) {
        graphics.drawOval(0, 0, radius, radius);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
}

interface Shape {
    void draw(Graphics graphics);
}

class Rectangle implements Shape {
    private int width;
    private int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawRect(0, 0, width, height);
    }
}

/**
 * Client.
 */
class MyFrame extends JFrame {
    private ArrayList<Shape> myShapes = new ArrayList<>();

    void addShape(Shape shape) {
        myShapes.add(shape);
    }

    @Override
    public void paint(Graphics g) {
        for (Shape shape: myShapes)
            shape.draw(g);
    }
}

/**
 *  A Circle Adapter.
 */
class CircleAdapter implements Shape {
    private Circle circle;

    CircleAdapter(Circle circle) {
        this.circle = circle;
    }

    @Override
    public void draw(Graphics graphics) {
        circle.drawCircle(graphics);
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();

        frame.addShape(new Rectangle(50,50));
        frame.addShape(new CircleAdapter(new Circle(50)));


        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
