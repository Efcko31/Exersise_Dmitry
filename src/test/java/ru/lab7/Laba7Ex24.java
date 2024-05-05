package ru.lab7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Laba7Ex24 {
    // Дан знаменатель и n-й член геометрической прогрессии. Вычислить первый член прогрессии.
    @Test

    void test() {
        assertEquals("b1 = 1", calculateFirstTermGeometricProgression(81,3));

        assertEquals("b1 = 5", calculateFirstTermGeometricProgression(405,3));

        assertEquals("b1 = 13", calculateFirstTermGeometricProgression(13,1));

        assertEquals("b1 = 17", calculateFirstTermGeometricProgression(17,3));

        assertEquals("b1 = 13", calculateFirstTermGeometricProgression(13,0));

        assertEquals("b1 = 5", calculateFirstTermGeometricProgression(320,-8));


        assertEquals("b1 = 1", calculateFirstTermGeometricProgressionByRecursion(81,3));

        assertEquals("b1 = 5", calculateFirstTermGeometricProgressionByRecursion(405,3));

        assertEquals("b1 = 13", calculateFirstTermGeometricProgressionByRecursion(13,1));

        assertEquals("b1 = 17", calculateFirstTermGeometricProgressionByRecursion(17,3));

        assertEquals("b1 = 13", calculateFirstTermGeometricProgressionByRecursion(13,0));

        assertEquals("b1 = 5", calculateFirstTermGeometricProgressionByRecursion(320,-8));
    }

    private String calculateFirstTermGeometricProgression(int bn, int q) {
        if (q == 1 || q == 0 || q == -1) {
            return String.format("b1 = %d", (bn));
        }

        while (bn % q == 0) {
            bn /= q;
        }

        return String.format("b1 = %d", (bn));
    }

    private String calculateFirstTermGeometricProgressionByRecursion(int bn, int q) {
        if (q == 1 || q == 0 || q == -1) {
            return String.format("b1 = %d", (bn));
        }
        return recursion(bn, q);
    }

    private String recursion(int bn , int q) {
        if (bn % q != 0) {
            return String.format("b1 = %d", (bn));
        }
        bn /= q;
    return recursion(bn, q);
    }
}
