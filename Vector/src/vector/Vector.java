package vector;

import java.util.Arrays;
import java.util.Objects;

public class Vector {
    private int n;
    private double[] vector;
    private static final int TURNING_INDEX = -1;

    public Vector(int n) throws IllegalArgumentException {
        if (n <= 0) {
            throw new IllegalArgumentException("Некорректно задана размерность вектора");
        }

        vector = new double[n];
        this.n = n;

        for (int i = 0; i < n; ++i) {
            vector[i] = 0;
        }
    }

    public Vector(Vector vector) {
        this.vector = vector.vector;
        this.n = vector.n;
    }

    public Vector(double[] array) {
        this.vector = array;
        n = array.length;
    }

    public Vector(int n, double[] array) throws IllegalArgumentException {
        if (n <= 0) {
            throw new IllegalArgumentException("Некорректно задана размерность вектора");
        }

        vector = new double[n];
        this.n = n;

        for (int i = 0; i < n; ++i) {
            if (i >= array.length) {
                this.vector[i] = 0;
            } else {
                this.vector[i] = array[i];
            }
        }
    }

    public int getN() {
        return n;
    }

    public double[] getVector() {
        return vector;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setVector(double[] vector) {
        this.vector = vector;
    }

    public int getSize() {
        return n;
    }


    public String toString() {
        String s = String.join(", ", Arrays.toString(this.vector));

        return "{" + s.substring(1, s.length() - 1) + "}";
    }

    public Vector addVector(Vector vector) throws IllegalArgumentException {
        Vector vectorSum = new Vector(Math.max(this.n, vector.n));

        int minLength = Math.min(this.n, vector.n);
        for (int i = 0; i < vectorSum.n; ++i) {
            if ((i >= minLength) && (minLength == vector.n)) {
                vectorSum.vector[i] = this.vector[i];
            } else if ((i >= minLength) && (minLength == this.n)) {
                vectorSum.vector[i] = vector.vector[i];
            } else {
                vectorSum.vector[i] = this.vector[i] + vector.vector[i];
            }
        }

        return vectorSum;
    }

    public Vector subtractVector(Vector vector) throws IllegalArgumentException {
        Vector vectorDifference = new Vector(Math.max(this.n, vector.n));

        int minLength = Math.min(this.n, vector.n);
        for (int i = 0; i < vectorDifference.n; ++i) {
            if ((i >= minLength) && (minLength == vector.n)) {
                vectorDifference.vector[i] = this.vector[i];
            } else if ((i >= minLength) && (minLength == this.n)) {
                vectorDifference.vector[i] = 0 - vector.vector[i];
            } else {
                vectorDifference.vector[i] = this.vector[i] - vector.vector[i];
            }
        }

        return vectorDifference;
    }

    public Vector multiplyScalar(double scalar) throws IllegalArgumentException {
        Vector vectorMultiplication = new Vector(this.n);

        for (int i = 0; i < this.n; ++i) {
            vectorMultiplication.vector[i] = this.vector[i] * scalar;
        }

        return vectorMultiplication;
    }

    public Vector expandVector() throws IllegalArgumentException {
        Vector vectorTurning = new Vector(this.n);

        for (int i = 0; i < this.n; ++i) {
            vectorTurning.vector[i] = this.vector[i] * TURNING_INDEX;
        }

        return vectorTurning;
    }

    public double getVectorLength() {
        double sum = 0;

        for (int i = 0; i < this.n; ++i) {
            sum += Math.pow(this.vector[i], 2);
        }
        return Math.sqrt(sum);
    }

    public double getVectorComponent(int componentIndex) throws IllegalArgumentException {
        if (componentIndex >= vector.length || componentIndex < 0) {
            throw new IllegalArgumentException("Значение индекса за пределами массива");
        }

        return this.vector[componentIndex];
    }

    public void setVectorComponent(int componentIndex, double component) {
        this.vector[componentIndex] = component;
    }

    public static Vector getVectorsSum(Vector vector1, Vector vector2) throws IllegalArgumentException {
        Vector vectorSum = new Vector(Math.max(vector1.n, vector2.n));

        int minLength = Math.min(vector1.n, vector2.n);
        for (int i = 0; i < vectorSum.n; ++i) {
            if ((i >= minLength) && (minLength == vector2.n)) {
                vectorSum.vector[i] = vector1.vector[i];
            } else if ((i >= minLength) && (minLength == vector1.n)) {
                vectorSum.vector[i] = vector2.vector[i];
            } else {
                vectorSum.vector[i] = vector1.vector[i] + vector2.vector[i];
            }
        }

        return vectorSum;
    }

    public static Vector getVectorsSubtract(Vector vector1, Vector vector2) throws IllegalArgumentException {
        Vector vectorDifference = new Vector(Math.max(vector1.n, vector2.n));

        int minLength = Math.min(vector1.n, vector2.n);
        for (int i = 0; i < vectorDifference.n; ++i) {
            if ((i >= minLength) && (minLength == vector2.n)) {
                vectorDifference.vector[i] = vector1.vector[i];
            } else if ((i >= minLength) && (minLength == vector1.n)) {
                vectorDifference.vector[i] = 0 - vector2.vector[i];
            } else {
                vectorDifference.vector[i] = vector1.vector[i] - vector2.vector[i];
            }
        }

        return vectorDifference;
    }

    public static double getVectorsMultiply(Vector vector1, Vector vector2) {
        double sum = 0;

        int minLength = Math.min(vector1.n, vector2.n);
        for (int i = 0; i < minLength; ++i) {
            sum += vector1.vector[i] * vector2.vector[i];
        }

        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector1 = (Vector) o;
        return n == vector1.n && Arrays.equals(vector, vector1.vector);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(n);
        result = 31 * result + Arrays.hashCode(vector);
        return result;
    }
}

