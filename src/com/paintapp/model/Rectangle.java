package com.paintapp.model;

public class Rectangle implements Shape {
    private Point topLeft;
    private double width, height;

    public Rectangle(Point topLeft, double width, double height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() { return width * height; }
    @Override
    public double getPerimeter() { return 2 * (width + height); }

    @Override
    public double distanceTo(Point p) { return getCenter().distanceTo(p); }

    @Override
    public Point getCenter() {
        return new Point(topLeft.getX() + width/2, topLeft.getY() + height/2);
    }

    @Override
    public void move(double dx, double dy) { topLeft.move(dx, dy); }

    @Override
    public void zoom(double ratio) {
        Point oldCenter = getCenter();
        this.width *= ratio;
        this.height *= ratio;
        topLeft.setX(oldCenter.getX() - width/2);
        topLeft.setY(oldCenter.getY() - height/2);
    }

    @Override
    public void rotate(double angle) { }
}