package ru.academits.krukova.shapes.main.main;

import ru.academits.krukova.shapes.main.shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle(20);
        Circle circle2 = new Circle(10);
        Square square1 = new Square(100);
        Square square2 = new Square(1);
        Triangle triangle1 = new Triangle(0, 0, 3, 2, 6, 9);
        Triangle triangle2 = new Triangle(0, 0, 0, 0, 0, 0);
        Rectangle rectangle1 = new Rectangle(1, 1);
        Rectangle rectangle2 = new Rectangle(100, 100);
        Shape[] shapes = {square1, square2, circle1, circle2, rectangle1, rectangle2, triangle1, triangle2};

        try {
            System.out.println("Фигура с максимальной площадью:");
            System.out.println("==========================================================");
            printArray(getMaxArea(shapes));
            System.out.println();

            System.out.println("Фигура со вторым по величине периметром");
            System.out.println("==========================================================");
            printArray(getSecondPerimeter(shapes));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка выполнения программы: " + e.getMessage());
        }
    }

    private static Shape[] getMaxArea(Shape[] shapes) {
        int shapesArrayLength = shapes.length;

        if (shapesArrayLength == 0) {
            throw new IllegalArgumentException("исходный массив фигур пуст !");
        }

        if (shapesArrayLength == 1) {
            return shapes;
        }

        Arrays.sort(shapes, new ShapeAreaComparator());

        int i = shapesArrayLength - 2;

        while (shapes[i].getArea() == shapes[shapesArrayLength - 1].getArea()) {
            i--;

            if (i < 0) {
                return shapes;
            }
        }

        Shape[] maxAreaShapes = new Shape[shapesArrayLength - 1 - i];
        System.arraycopy(shapes, i + 1, maxAreaShapes, 0, shapesArrayLength - 1 - i);

        return maxAreaShapes;
    }

    private static Shape[] getSecondPerimeter(Shape[] shapes) {
        int shapesArrayLength = shapes.length;

        if (shapesArrayLength == 0) {
            throw new IllegalArgumentException("исходный массив фигур пуст !");
        }

        if (shapesArrayLength == 1) {
            return new Shape[0];
        }

        Arrays.sort(shapes, new ShapePerimeterComparator());

        int i = 1;

        while (shapes[i].getPerimeter() == shapes[0].getPerimeter()) {
            i++;

            if (i > shapes.length - 1) {
                return new Shape[0];
            }
        }

        double secondPerimeter = shapes[i].getPerimeter();

        int j = i;

        while (shapes[j].getPerimeter() == secondPerimeter) {
            j++;
        }

        Shape[] maxPerimeterShapes = new Shape[j - i];
        System.arraycopy(shapes, i, maxPerimeterShapes, 0, j - i);

        return maxPerimeterShapes;
    }

    private static void printArray(Shape[] array) {
        for (Shape element : array) {
            System.out.println(element);
        }
    }
}
