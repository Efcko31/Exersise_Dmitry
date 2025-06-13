package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex5 {
    //Дан список чисел. Необходимо проверить, все ли числа положительные,
    // и вернуть true, если это так, иначе false.
    @Test
    void test() {
        assertFalse(checksThatAllNumbersArePositive(Arrays.asList(1, 2, 3, -4, 5)));
        assertTrue(checksThatAllNumbersArePositive(Arrays.asList(1, 2, 3, 4, 5)));

    }
    public boolean checksThatAllNumbersArePositive(List<Integer> nums) {
        return nums.stream().allMatch(n -> n > 0);
    }
}
