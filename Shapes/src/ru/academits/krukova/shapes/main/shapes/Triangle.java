package ru.academits.krukova.shapes.main.shapes;

import java.util.Objects;

public class Triangle implements Shape {
    private double x1;
    private double x2;
    private double x3;
    private double y1;
    private double y2;
    private double y3;

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getX3() {
        return x3;
    }

    public double getY1() {
        return y1;
    }

    public double getY2() {
        return y2;
    }

    public double getY3() {
        return y3;
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    public double getWidth() {
        return Math.max(Math.max(this.x1, this.x2), this.x3);
    }

    public double getHeight() {
        return Math.max(Math.max(this.y1, this.y2), this.y3);
    }

    public double getArea() {
        double side1 = getSideLength(this.x1, this.y1, this.x2, this.y2);
        double side2 = getSideLength(this.x2, this.y2, this.x3, this.y3);
        double side3 = getSideLength(this.x1, this.y1, this.x3, this.y3);

        double halfMeter = getPerimeter() / 2;

        return Math.sqrt(halfMeter * (halfMeter - side1) * (halfMeter - side2) * (halfMeter - side3));
    }

    public double getPerimeter() {
        double side1 = getSideLength(this.x1, this.y1, this.x2, this.y2);
        double side2 = getSideLength(this.x2, this.y2, this.x3, this.y3);
        double side3 = getSideLength(this.x1, this.y1, this.x3, this.y3);

        return side1 + side2 + side3;
    }

    public static double getSideLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Triangle triangle = (Triangle) o;

        return triangle.x1 == x1 &&
                triangle.x2 == x2 &&
                triangle.x3 == x3 &&
                triangle.y1 == y1 &&
                triangle.y2 == y2 &&
                triangle.y3 == y3;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(x1) + Double.hashCode(x2) + Double.hashCode(x3) + Double.hashCode(y1) + Double.hashCode(y2) + Double.hashCode(y3);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                ", x3=" + x3 +
                ", y1=" + y1 +
                ", y2=" + y2 +
                ", y3=" + y3 +
                '}';
    }
}
