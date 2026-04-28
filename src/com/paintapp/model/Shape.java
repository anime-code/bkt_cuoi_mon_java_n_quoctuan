package com.paintapp.model;

public interface Shape {
    double getArea();
    double getPerimeter();

    double distanceTo(Point p);

    Point getCenter();

    void move(double dx, double dy);
    void zoom(double ratio);
    void rotate(double angle);
}