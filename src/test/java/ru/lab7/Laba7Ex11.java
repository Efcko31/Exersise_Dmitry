package ru.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Laba7Ex11 {

    /* Даны две последовательности:
    x1 = y1 = 1, xi = xi−1 + ((yi−1) / 2), yi = yi−1 + ((xi−1) / 3) для i >= 2.
    Вычислить n-е члены этих последовательностей. */

    @Test
    void test() throws Exception {
        assertEquals("x12 = 48,05; y12 = 39,24;", calculateAllNElementsSequence(12, 1, 1));
        assertEquals("x12 = 48,05; y12 = 39,24;", calculateAllNElementsSequenceByRecursion(12, 1, 1, 0));

        assertEquals("x6 = 6,15; y6 = 5,04;", calculateAllNElementsSequence(6, 1, 1));
        assertEquals("x6 = 6,15; y6 = 5,04;", calculateAllNElementsSequenceByRecursion(6, 1, 1, 0));

        assertThrows(IllegalArgumentException.class, () -> calculateAllNElementsSequence(1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> calculateAllNElementsSequenceByRecursion(1, 1, 1, 0));

        assertThrows(IllegalArgumentException.class, () -> calculateAllNElementsSequence(0, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> calculateAllNElementsSequenceByRecursion(0, 1, 1, 0));

    }

    private String calculateAllNElementsSequence(int n, float xi, float yi) {
        try {
            if (n < 2) {
                throw new IllegalArgumentException("Не соблюдение условия задачи!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }

        for (int i = 1; i < n; i++) {
            float xn = xi + yi / 2;
            float yn = yi + xi / 3;
            xi = xn;
            yi = yn;
        }
        return String.format("x%d = %.2f; y%d = %.2f;", n, xi, n, yi);
    }


    private String calculateAllNElementsSequenceByRecursion(int n, float xi, float yi, int i) {
        try {
            if (n < 2) {
                throw new IllegalArgumentException("Не соблюдение условия задачи!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }

        if (i == n - 1) {
            return String.format("x%d = %.2f; y%d = %.2f;", n, xi, n, yi);
        }

        float xn = xi + yi / 2;
        float yn = yi + xi / 3;
        xi = xn;
        yi = yn;

        i++;

        return calculateAllNElementsSequenceByRecursion(n, xi, yi, i);
    }
}
