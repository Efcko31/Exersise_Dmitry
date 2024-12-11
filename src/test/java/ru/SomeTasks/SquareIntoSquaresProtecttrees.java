package ru.SomeTasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareIntoSquaresProtecttrees {
    @Test
    void test() {
        assertEquals("1 2 4 10", decompose(11L));
        assertEquals("1 2 3 7 9", decompose(12L));
        assertEquals("24 414 14328", decompose(14334L));
    }

    public String decompose(long n) {
//        long answer = 0;
//        StringBuilder f = new StringBuilder(" ");

        for (long i = n - 1; i >= 0; i--) {
            long answer = 0;
            StringBuilder f = new StringBuilder(" ");
            for (long j = i; j >= 0; j--) {
                if (j * j + answer <= n * n) {
                    answer += j * j;
                    f.insert(0, j);
                    f.insert(0, " ");
                }

                if (answer == n * n) {
                    return f.toString().trim();
                }

            }
            if (answer == n * n) {
                return f.toString().trim();
            }
        }

//        while (m > 0) {
//            if (m * m + answer <= n * n) {
//                answer+= m * m;
//                f.insert(0, m);
//                f.insert(0, " ");
//            }
//
//            if(answer == n * n) {
//                return f.toString().trim();
//            }
//            m--;
//        }
        return null;
    }
}
