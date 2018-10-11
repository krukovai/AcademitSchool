package ru.academits.krukova.shapes.shapes;

public class Square {
    private double side;

    protected Square(double side) {
        this.side = side;
    }

    @Override
    protected double getWidth() {
        return this.side;
    }

    @Override
    protected double getHeight() {
        return this.side;
    }

    @Override
    protected double getArea() {
        return Math.pow(this.side, 2);
    }

    @Override
    protected double getPerimeter() {
        return 4 * this.side;
    }
}
