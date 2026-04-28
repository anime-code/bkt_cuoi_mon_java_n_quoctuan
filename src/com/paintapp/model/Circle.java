package com.paintapp.model;

public class Circle implements Shape {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double getArea() { return Math.PI * radius * radius; }

    @Override
    public double getPerimeter() { return 2 * Math.PI * radius; }

    @Override
    public double distanceTo(Point p) {
        double d = center.distanceTo(p);
        return Math.abs(d - radius);
    }

    @Override
    public Point getCenter() { return center; }

    @Override
    public void move(double dx, double dy) { center.move(dx, dy); }

    @Override
    public void zoom(double ratio) {
        this.radius *= ratio;
    }

    @Override
    public void rotate(double angle) { /* Hình tròn xoay quanh tâm không đổi */ }
}