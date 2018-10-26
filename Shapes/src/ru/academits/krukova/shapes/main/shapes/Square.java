package ru.academits.krukova.shapes.main.shapes;

public class Square implements Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getWidth() {
        return this.sideLength;
    }

    public double getHeight() {
        return this.sideLength;
    }

    public double getArea() {
        return Math.pow(this.sideLength, 2);
    }

    public double getPerimeter() {
        return this.sideLength * 4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Square square = (Square) o;

        return square.sideLength == sideLength;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(sideLength);
    }

    @Override
    public String toString() {
        return "Square{" +
                "sideLength=" + sideLength +
                '}';
    }
}
