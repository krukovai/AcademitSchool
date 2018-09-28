package ru.academist.krukova.range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число для проверки вхождения в диапазон");
        double number = scanner.nextDouble();

        Range range1 = new Range(4, 21);
        Range range2 = new Range(-8, 5);
        Range crossRange = range1.getCrossing(range2);
        Range[] mergerRange = range1.getMerger(range2);
        Range[] residualRange = range1.getResidual(range2);

        System.out.println("Длина диапазона: " + range1.getLength());
        System.out.println("Число принадлежит диапазону: " + range1.isInside(number));

        if (crossRange != null) {
            System.out.println("Диапазон пересечения: " + crossRange.getFrom() + " .. " + crossRange.getTo());
        } else {
            System.out.println("Диапазоны не пересекаются ");
        }

        if (mergerRange[1] == null) {
            System.out.println("Диапазон объединения: " + mergerRange[0].getFrom() + " .. " + mergerRange[0].getTo());
        } else {
            System.out.println("Диапазон объединения: " + mergerRange[0].getFrom() + " .. " + mergerRange[0].getTo() + ", " + mergerRange[1].getFrom() + " .. " + mergerRange[1].getTo());
        }

        if (residualRange[0] == null && residualRange[1] == null) {
            System.out.println("Диапазон разности: пустой диапазон");
        } else if (residualRange[1] == null) {
            System.out.println("Диапазон разности: " + residualRange[0].getFrom() + " .. " + residualRange[0].getTo());
        } else {
            System.out.println("Диапазон разности: " + residualRange[0].getFrom() + " .. " + residualRange[0].getTo() + ", " + residualRange[1].getFrom() + " .. " + residualRange[1].getTo());
        }
    }
}

