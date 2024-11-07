package ru.SomeTasks;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class ExOfCodeWarsLastDigitLargeNumber {
    // Дается число a в степени b, найдите последнюю цифру числа a при возведении в степень b.

    @Test
    void test() {
        assertEquals(8, searchAnswer(new BigInteger("2"), new BigInteger("7")));
        assertEquals(4, searchAnswer(new BigInteger("4"), new BigInteger("1")));
        assertEquals(6, searchAnswer(new BigInteger("4"), new BigInteger("2")));
        assertEquals(9, searchAnswer(new BigInteger("9"), new BigInteger("7")));
        assertEquals(6, searchAnswer(new BigInteger("1783993602"), new BigInteger("1619283424")));
        assertEquals(6, searchAnswer(new BigInteger("198792"), new BigInteger("239380")));
        assertEquals(0, searchAnswer(new BigInteger(
                "255929366625312215525949965411708479166141158276976263208737588669657201750251580106660070"),
                new BigInteger(
                        "736354978608325230748378411669353961406469895476099750034105020021105863197424540114654283")));

    }
    public int searchAnswer(BigInteger n1, BigInteger n2) {
        if (n2.compareTo(new BigInteger("1")) > 0) {
            return degreeGreaterThanOne(n1, n2);
        } else {
            return n2.intValue() == 0 ? 1 : n1.intValue();
        }
    }

    public static int degreeGreaterThanOne(BigInteger n1, BigInteger n2) {
        BigInteger lastDigitN1 = n1.remainder(BigInteger.TEN);
        switch (lastDigitN1.intValue()) {
            case 0:
            case 1:
            case 5:
            case 6:
                return lastDigitN1.intValue();

            case 4:
            case 9:
                int lastDigitN2 = n2.remainder(new BigInteger("2")).intValue();
                if (lastDigitN2 == 0) {
                    return lastDigitN1.intValue() == 4 ? 6 : 1;
                } else {
                    return lastDigitN1.intValue();
                }

            case 2:
            case 3:
            case 7:
            case 8:
                BigInteger s = n2.remainder(new BigInteger("4"));
                BigInteger s2 = new BigInteger("1");
                if (s.intValue() == 0) {
                    s = s.add(new BigInteger("4"));
                }
                for (int i = 0; i < s.intValue(); i++) {
                    s2 = s2.multiply(n1);
                }


                return s2.compareTo(BigInteger.TEN) > 0 ? s2.remainder(BigInteger.TEN).intValue() : s2.intValue();
        }
        return 0;
    }
}
