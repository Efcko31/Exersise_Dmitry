package ru.Interface.FunctionalInterfaceExercises.Level2.TriFunction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriFunctionTest {
    @Test
    void test() {
        Assertions.assertEquals(10, triFuncTest(2,3,4));
    }

    public Integer triFuncTest(Integer a, Integer b, Integer c) {
        TriFunctionInt<Integer, Integer, Integer, Integer> func =
                (num1, num2, num3) ->  num1 * num2 + num3;
        return func.apply(a,b,c);
    }
}
