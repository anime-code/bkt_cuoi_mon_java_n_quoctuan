package com.paintapp.model;

public class Line implements Shape {
    private Point p1, p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1; this.p2 = p2;
    }

    @Override
    public double getArea() { return 0; }
    @Override
    public double getPerimeter() { return p1.distanceTo(p2); }

    @Override
    public double distanceTo(Point p) { return getCenter().distanceTo(p); }

    @Override
    public Point getCenter() {
        return new Point((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
    }

    @Override
    public void move(double dx, double dy) {
        p1.move(dx, dy); p2.move(dx, dy);
    }

    @Override
    public void zoom(double ratio) {
        Point center = getCenter();
        zoomOnePoint(p1, center, ratio);
        zoomOnePoint(p2, center, ratio);
    }

    private void zoomOnePoint(Point p, Point center, double ratio) {
        p.setX(center.getX() + (p.getX() - center.getX()) * ratio);
        p.setY(center.getY() + (p.getY() - center.getY()) * ratio);
    }

    @Override
    public void rotate(double angle) {}
}