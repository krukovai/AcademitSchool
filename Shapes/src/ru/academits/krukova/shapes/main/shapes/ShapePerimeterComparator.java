package ru.academits.krukova.shapes.main.shapes;

import java.util.Comparator;

public class ShapePerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return (int) (o1.getPerimeter() - o2.getPerimeter());
    }
}
