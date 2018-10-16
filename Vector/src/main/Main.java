package main;

import vector.Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] array1 = {1, 2, 3};
        double[] array2 = {-1, 12, 3, 9, -3, 8};
        try {
            Vector vector1 = new Vector(4, array1);
            formattedPrint("Размерность вектора:", Integer.toString(vector1.getSize()));
            formattedPrint("Вектор 1:", Arrays.toString(vector1.getComponents()));

            Vector vector2 = new Vector(8, array2);
            formattedPrint("Вектор 2:", Arrays.toString(vector2.getComponents()));

            Vector addVector = vector1.addVector(vector2);
            formattedPrint("Вектор суммы:", Arrays.toString(addVector.getComponents()));

            Vector vectorsSum = Vector.getVectorsSum(vector1, vector2);
            formattedPrint("Сумма векторов:", Arrays.toString(vectorsSum.getComponents()));

            Vector vectorsDifference = vector1.subtractVector(vector2);
            formattedPrint("Вектор разности:", Arrays.toString(vectorsDifference.getComponents()));

            double vectorMultiplication = Vector.getVectorsMultiply(vector1, vector2);
            formattedPrint("Умножение векторов:", Double.toString(vectorMultiplication));

            Vector vectorTurning = vector1.turn();
            formattedPrint("Разворот вектора:", Arrays.toString(vectorTurning.getComponents()));

            vector1.setComponent(1, -10);
            formattedPrint("Установка компонента:", Arrays.toString(vector1.getComponents()));

            formattedPrint("Строковый вид:", vector2.toString());
            formattedPrint("Длина вектора:", Double.toString(vector2.getLength()));
            formattedPrint("Полученная компонента:", Double.toString(vector1.getComponent(1)));
            formattedPrint("Векторы равны:", Boolean.toString(vector1.equals(vector2)));
            formattedPrint("Произведение векторов:", Double.toString(vectorMultiplication));
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Ошибка выполнения программы: " + e.getMessage());
        }

        System.out.println();
    }

    private static void formattedPrint(String description, String value) {
        int descriptionLength = 25;

        StringBuilder builder = new StringBuilder();
        builder.append(description);

        for (int i = 0; i < descriptionLength - description.length(); ++i) {
            builder.append(' ');
        }

        System.out.println(builder.append(value).toString());
    }
}