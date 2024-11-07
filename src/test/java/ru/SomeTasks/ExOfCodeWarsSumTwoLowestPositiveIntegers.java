package ru.SomeTasks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ExOfCodeWarsSumTwoLowestPositiveIntegers {
    //Вернуть сумму 2-х наименьщих чисел массива

    @Test
    void test() {
        assertEquals(13L, sumTwoSmallestNumbers(new long []{5, 8, 12, 19, 22}));
        assertEquals(6L, sumTwoSmallestNumbers(new long []{15, 28, 4, 2, 43}));
        assertEquals(6L, sumTwoSmallestNumbers(new long []{3, 87, 3, 12, 7}));
        assertEquals(24L, sumTwoSmallestNumbers(new long []{23, 71, 33, 82, 1}));
        assertEquals(16L, sumTwoSmallestNumbers(new long []{52, 76, 14, 12, 4}));
    }

    public Long sumTwoSmallestNumbers(long[] numbers) {
        Arrays.sort(numbers);
        return numbers[0] + numbers[1];
    }
//        ArrayList<Long> copyNum = new ArrayList<>();
//        addInArray(copyNum, numbers);
//        copyNum.sort(Comparator.naturalOrder());
//        return copyNum.get(0) + copyNum.get(1);
//    }
//
//    public void addInArray(ArrayList<Long> copyNum, long[] numbers) {
//        for (long n : numbers) {
//            copyNum.add(n);
//        }
//    }
}
