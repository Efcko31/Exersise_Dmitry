package ru.SomeTasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExOfCodeWars2cubicRoot {
    /*Дано число m, проверить, можно ли из суммы чисел от 1^3 до n^3 получить число m.
    Если да - вернуть число n, нет - -1*/
    @Test
    void test() {
        assertEquals(45, findNb(1071225));
        assertEquals(-1, findNb(24723578342962L));
        assertEquals(2022, findNb(4183059834009L));
        assertEquals(4824, findNb(135440716410000L));
        assertEquals(3568, findNb(40539911473216L));
        assertEquals(-1, findNb(1613039195003040001L));
        assertEquals(-1, findNb(2078065436661612226L));
        assertEquals(-1, findNb(1768256963550315226L));
        assertEquals(54434, findNb(2195012314679186025L));
        assertEquals(54894, findNb(2270154126080394225L));
    }

    public long findNb(long m) {
        long sum = 1;
        long n = 2;
        while (sum < m) {
            sum = sum + n * n * n;
            n++;
        }
        if (sum == m) {
            return n - 1;
        } else {
            return -1;
        }

//        int summ = 0;
//        double sqrt = Math.sqrt(m);
//        for (int i = 1; i < sqrt / 2; i++) {
//            summ += i;
//            if (summ == sqrt && m - (long) (sqrt * sqrt) == 0) {
//                return i;
//            }
//        }
//
//        return -1;
    }
}
