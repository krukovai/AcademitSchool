package main;

import vector.Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] array1 = {1, 2, 3};
        double[] array2 = {-1, 12, 3, 9, -3, 8};
        try {
            Vector vector1 = new Vector(3, array1);
            Vector vector2 = new Vector(8, array2);
            Vector addVector = vector1.addVector(vector2);
            Vector vectorsSum = Vector.getVectorsSum(vector1, vector2);
            Vector vectorsDifference = vector1.subtractVector(vector2);
            double vectorMultiplication = Vector.getVectorsMultiply(vector1, vector2);
            Vector vectorTurning = vector1.expandVector();

            formattedPrint("Размер:", Integer.toString(vector1.getN()));
            formattedPrint("Вектор 1:", Arrays.toString(vector1.getVector()));
            formattedPrint("Вектор 2:", Arrays.toString(vector2.getVector()));
            formattedPrint("Вектор суммы:", Arrays.toString(addVector.getVector()));
            formattedPrint("Вектор разности:", Arrays.toString(vectorsDifference.getVector()));
            formattedPrint("Разворот вектора:", Arrays.toString(vectorTurning.getVector()));
            formattedPrint("Сумма векторов:", Arrays.toString(vectorsSum.getVector()));
            formattedPrint("Строковый вид:", vector2.toString());
            formattedPrint("Умножение векторов:", Double.toString(vectorMultiplication));
            formattedPrint("Длина вектора:", Double.toString(vector1.getVectorLength()));
            formattedPrint("Полученная компонента:", Double.toString(vector1.getVectorComponent(1)));
            vector1.setVectorComponent(1, -10);
            formattedPrint("Установка компонента:", Arrays.toString(vector1.getVector()));
            formattedPrint("Векторы равны:", Boolean.toString(vector1.equals(vector2)));
            formattedPrint("Произведение векторов:", Double.toString(vectorMultiplication));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка выполнения программы:" + e.getMessage());
        }
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