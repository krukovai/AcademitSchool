package ru.academits.krukova.shapes.shapes;

public class Triangle {
    private double side1;
    private double side2;
    private double side3;


    protected Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
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
        return (this.width + this.heigh) *2;
    }
}
