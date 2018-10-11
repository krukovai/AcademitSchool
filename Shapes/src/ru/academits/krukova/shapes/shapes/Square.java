package ru.academits.krukova.shapes.shapes;

public class Rectangle extends Shapes {
    private double width;
    private double heigh;

    protected Rectangle(double width, double heigh) {
        this.width = width;
        this.heigh = heigh;
    }

    @Override
    protected double getWidth() {
        return this.width;
    }

    @Override
    protected double getHeight() {
        return this.heigh;
    }

    @Override
    protected double getArea() {
        return this.width * this.heigh;
    }

    @Override
    protected double getPerimeter() {
        return (this.width + this.heigh) * 2;
    }
}
