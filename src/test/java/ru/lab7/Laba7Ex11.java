package ru.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba7Ex11 {

    /* Даны две последовательности:
    x1 = y1 = 1, xi = xi−1 + ((yi−1) / 2), yi = yi−1 + ((xi−1) / 3) для i >= 2.
    Вычислить n-е члены этих последовательностей. */

    @Test
    void test() {
        assertEquals("x12 = 48,05; y12 = 39,24;", calculateAllNElementsSequence(12));

        assertEquals("x6 = 6,15; y6 = 5,04;", calculateAllNElementsSequence(6));

        assertEquals("x1 = 1,00; y1 = 1,00;", calculateAllNElementsSequence(1));

        assertEquals("n не должен равняться 0!", calculateAllNElementsSequence(0));



        assertEquals("x12 = 48,05; y12 = 39,24;", calculateAllNElementsSequenceByRecursion(12));

        assertEquals("x6 = 6,15; y6 = 5,04;", calculateAllNElementsSequenceByRecursion(6));

        assertEquals("x1 = 1,00; y1 = 1,00;", calculateAllNElementsSequenceByRecursion(1));

        assertEquals("n не должен равняться 0!", calculateAllNElementsSequenceByRecursion(0));

    }

    private String calculateAllNElementsSequence(int n) {
        if (n == 0) {
            return "n не должен равняться 0!";
        }

        float[] xIyI = new float[n * 2];
        xIyI[0] = 1;
        xIyI[1] = 1;

        for (int i = 2; i < n * 2; i += 2) {
            xIyI[i] = xIyI[i - 2] + xIyI[i - 1] / 2;
            xIyI[i + 1] = xIyI[i - 1] + xIyI[i - 2] / 3;
        }
        return String.format("x%d = %.2f; y%d = %.2f;", n, xIyI[n * 2 - 1 - 1], n, xIyI[n * 2 - 1]);
    }


    private String calculateAllNElementsSequenceByRecursion(int n) {
        if (n == 0) {
            return "n не должен равняться 0!";
        }

        float[] xIyI = new float[n * 2];
        xIyI[0] = 1;
        xIyI[1] = 1;

        return recursion(n, xIyI, 2);
    }

    private String recursion(int n, float[] xIyI, int i) {
        if (i >= n * 2) {
            return String.format("x%d = %.2f; y%d = %.2f;", n, xIyI[n * 2 - 1 - 1], n, xIyI[n * 2 - 1]);
        }

        xIyI[i] = xIyI[i - 2] + xIyI[i - 1] / 2;
        xIyI[i + 1] = xIyI[i - 1] + xIyI[i - 2] / 3;
        i += 2;
        return recursion(n, xIyI, i);
    }
}
