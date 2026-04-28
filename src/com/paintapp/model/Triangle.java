package com.paintapp.model;

public class Triangle implements Shape {
    private Point p1, p2, p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public double getArea() {
        return Math.abs((p1.getX()*(p2.getY()-p3.getY()) + p2.getX()*(p3.getY()-p1.getY()) + p3.getX()*(p1.getY()-p2.getY())) / 2.0);
    }

    @Override
    public double getPerimeter() {
        return p1.distanceTo(p2) + p2.distanceTo(p3) + p3.distanceTo(p1);
    }

    @Override
    public Point getCenter() {
        return new Point((p1.getX() + p2.getX() + p3.getX())/3, (p1.getY() + p2.getY() + p3.getY())/3);
    }

    @Override
    public double distanceTo(Point p) {
        return getCenter().distanceTo(p);
    }

    @Override
    public void zoom(double ratio) {
        Point center = getCenter();
        zoomOnePoint(p1, center, ratio);
        zoomOnePoint(p2, center, ratio);
        zoomOnePoint(p3, center, ratio);
    }

    private void zoomOnePoint(Point p, Point center, double ratio) {
        p.setX(center.getX() + (p.getX() - center.getX()) * ratio);
        p.setY(center.getY() + (p.getY() - center.getY()) * ratio);
    }

    @Override
    public void move(double dx, double dy) {
        p1.move(dx, dy);
        p2.move(dx, dy);
        p3.move(dx, dy);
    }

    @Override
    public void rotate(double angle) {
        Point center = getCenter();
        double rad = Math.toRadians(angle);

        rotateOnePoint(p1, center, rad);
        rotateOnePoint(p2, center, rad);
        rotateOnePoint(p3, center, rad);
    }


    private void rotateOnePoint(Point p, Point c, double rad) {
        double dx = p.getX() - c.getX();
        double dy = p.getY() - c.getY();

        // Công thức ma trận xoay
        double newX = c.getX() + dx * Math.cos(rad) - dy * Math.sin(rad);
        double newY = c.getY() + dx * Math.sin(rad) + dy * Math.cos(rad);

        p.setX(newX);
        p.setY(newY);
    }
}