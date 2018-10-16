package vector;

import java.util.Arrays;

public class Vector {
    private double[] components;
    private static final int TURNING_INDEX = -1;

    public Vector(int vectorSize) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("некорректно задана размерность вектора");
        }

        this.components = new double[vectorSize];
    }

    public Vector(Vector vector) {
        this.components = vector.components.clone();
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("некорректно задана размерность вектора");
        }

        this.components = array.clone();
    }

    public Vector(int vectorSize, double[] arrayRow) {
        if (arrayRow.length == 0 || vectorSize <= 0) {
            throw new IllegalArgumentException("некорректно задана размерность вектора");
        }

        this.components = Arrays.copyOf(arrayRow, vectorSize);
    }

    public double[] getComponents() {
        return this.components.clone();
    }

    public int getSize() {
        return this.components.length;
    }

    public String toString() {
        String s = Arrays.toString(this.components);

        return "{" + s.substring(1, s.length() - 1) + "}";
    }

    public Vector addVector(Vector vector) {
        int maxLength = Math.max(this.components.length, vector.components.length);
        int minLength = Math.min(this.components.length, vector.components.length);

        if (maxLength != this.components.length) {
            this.components = Arrays.copyOf(this.components, maxLength);
        }

        for (int i = 0; i < maxLength; ++i) {
            if (i == minLength && minLength == vector.components.length) {
                break;
            } else {
                this.components[i] += vector.components[i];
            }
        }

        return this;
    }

    public Vector subtractVector(Vector vector) {
        int maxLength = Math.max(this.components.length, vector.components.length);
        int minLength = Math.min(this.components.length, vector.components.length);

        if (maxLength != this.components.length) {
            this.components = Arrays.copyOf(this.components, maxLength);
        }

        for (int i = 0; i < maxLength; ++i) {
            if (i == minLength && minLength == vector.components.length) {
                break;
            } else {
                this.components[i] -= vector.components[i];
            }
        }

        return this;
    }

    public Vector multiplyScalar(double scalar) {
        for (int i = 0; i < this.components.length; ++i) {
            this.components[i] *= scalar;
        }

        return this;
    }

    public Vector turn() {
        return this.multiplyScalar(TURNING_INDEX);
    }

    public double getLength() {
        double sum = 0;

        for (double e : this.components) {
            sum += Math.pow(e, 2);
        }

        return Math.sqrt(sum);
    }

    public double getComponent(int componentIndex) throws IndexOutOfBoundsException {
        if (componentIndex >= this.components.length || componentIndex < 0) {
            throw new IndexOutOfBoundsException("значение указанного индекса за пределами массива");
        }

        return this.components[componentIndex];
    }

    public void setComponent(int componentIndex, double component) throws IndexOutOfBoundsException {
        if (componentIndex >= this.components.length || componentIndex < 0) {
            throw new IndexOutOfBoundsException("значение указанного индекса за пределами массива");
        }

        this.components[componentIndex] = component;
    }

    public static Vector getVectorsSum(Vector vector1, Vector vector2) {
        Vector vectorSum = new Vector(vector1);

        return vectorSum.addVector(vector2);
    }

    public static Vector getVectorsSubtract(Vector vector1, Vector vector2) {
        Vector vectorDifference = new Vector(vector1);

        return vectorDifference.subtractVector(vector2);
    }

    public static double getVectorsMultiply(Vector vector1, Vector vector2) {
        double sum = 0;

        int minLength = Math.min(vector1.components.length, vector2.components.length);
        for (int i = 0; i < minLength; ++i) {
            sum += vector1.components[i] * vector2.components[i];
        }

        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }
}

