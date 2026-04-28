package com.paintapp.model;

public class Point implements Shape {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    @Override
    public double getArea() { return 0; }
    @Override
    public double getPerimeter() { return 0; }

    @Override
    public double distanceTo(Point p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }

    @Override
    public Point getCenter() { return this; }

    @Override
    public void move(double dx, double dy) {
        this.x += dx; this.y += dy;
    }

    @Override
    public void zoom(double ratio) {}

    @Override
    public void rotate(double angle) {}

    @Override
    public String toString() { return "Point(" + x + ", " + y + ")"; }
}