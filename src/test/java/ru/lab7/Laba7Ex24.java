package ru.lab7;

import org.junit.jupiter.api.Test;
import ru.lab7.exception.WrongSequenceSizeException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Laba7Ex24 {
    // Дан знаменатель и n-й член геометрической прогрессии. Вычислить первый член прогрессии.
    @Test
    void test() throws WrongSequenceSizeException {
        assertEquals("b1 = 1", calculateFirstTermGeometricProgression(81, 3));
        assertEquals("b1 = 1", calculateFirstTermGeometricProgressionByRecursion(81, 3));

        assertEquals("b1 = 5", calculateFirstTermGeometricProgression(405, 3));
        assertEquals("b1 = 5", calculateFirstTermGeometricProgressionByRecursion(405, 3));

        assertThrows(WrongSequenceSizeException.class, () -> calculateFirstTermGeometricProgression(13, 1));
        assertThrows(WrongSequenceSizeException.class, () -> calculateFirstTermGeometricProgressionByRecursion(13, 1));

        assertEquals("b1 = 17", calculateFirstTermGeometricProgression(17, 3));
        assertEquals("b1 = 17", calculateFirstTermGeometricProgressionByRecursion(17, 3));

        assertThrows(WrongSequenceSizeException.class, () -> calculateFirstTermGeometricProgression(13, 0));
        assertThrows(WrongSequenceSizeException.class, () -> calculateFirstTermGeometricProgressionByRecursion(13, 0));

        assertEquals("b1 = 5", calculateFirstTermGeometricProgression(320, -8));
        assertEquals("b1 = 5", calculateFirstTermGeometricProgressionByRecursion(320, -8));


    }

    private String calculateFirstTermGeometricProgression(int bn, int significant) throws WrongSequenceSizeException {
        try {
            if (significant == 1 || significant == 0 || significant == -1) {
                throw new WrongSequenceSizeException("Знаменатель не должен быть равен -1; 0; 1");
            }
        } catch (WrongSequenceSizeException e) {
            System.out.println(e.getMessage());
            throw e;
        }

        while (bn % significant == 0) {
            bn /= significant;
        }

        return String.format("b1 = %d", (bn));
    }

    private String calculateFirstTermGeometricProgressionByRecursion(int bn, int significant) throws WrongSequenceSizeException {
        try {
            if (significant == 1 || significant == 0 || significant == -1) {
                throw new WrongSequenceSizeException("Знаменатель не должен быть равен -1; 0; 1");
            }
        } catch (WrongSequenceSizeException e) {
            System.out.println(e.getMessage());
            throw e;
        }

        if (bn % significant != 0) {
            return String.format("b1 = %d", (bn));
        }
        bn /= significant;
        return calculateFirstTermGeometricProgressionByRecursion(bn, significant);
    }
}
