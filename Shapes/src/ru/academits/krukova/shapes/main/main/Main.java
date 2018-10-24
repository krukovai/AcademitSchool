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
        Rectangle rectangle2 = new Rectangle(12, 44);
        Shape[] shapes = {square1, square2, circle1, circle2, rectangle1, rectangle2, triangle1, triangle2};

        try {
            System.out.println("Фигура с максимальной площадью:");
            System.out.println("==========================================================");
            System.out.println(getMaxAreaShape(shapes));

            System.out.println("Фигура со вторым по величине периметром");
            System.out.println("==========================================================");
            System.out.println(getSecondPerimeterShape(shapes));

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка выполнения программы: " + e.getMessage());
        }
    }

    private static Shape getMaxAreaShape(Shape[] shapes) {
        int shapesArrayLength = shapes.length;

        if (shapesArrayLength == 0) {
            throw new IllegalArgumentException("исходный массив фигур пуст !");
        }

        if (shapesArrayLength == 1) {
            return shapes[0];
        }

        Arrays.sort(shapes, new ShapeAreaComparator());

        return shapes[shapes.length - 1];
    }

    private static Shape getSecondPerimeterShape(Shape[] shapes) {
        int shapesArrayLength = shapes.length;

        if (shapesArrayLength == 0) {
            throw new IllegalArgumentException("исходный массив фигур пуст !");
        }

        if (shapesArrayLength == 1) {
            return null;
        }

        Arrays.sort(shapes, new ShapePerimeterComparator());

        return shapes[shapes.length - 2];
    }

    private static void printArray(Shape[] array) {
        for (Shape element : array) {
            System.out.println(element);
        }
    }
}
