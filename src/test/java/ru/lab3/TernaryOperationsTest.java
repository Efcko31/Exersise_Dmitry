package ru.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TernaryOperationsTest {

    private static final String NEGATIVE = "negative";
    private static final String POSITIVE = "positive";


    @Test
    public void ternaryOperationTest(){
        Assertions.assertEquals(NEGATIVE, identifyNumberWithoutTernaryOperation(-6));
        Assertions.assertEquals(NEGATIVE, identifyNumber(-6));
        Assertions.assertEquals(POSITIVE, identifyNumberWithoutTernaryOperation(6));
        Assertions.assertEquals(POSITIVE, identifyNumber(6));
    }

    private String identifyNumber (int number) {
        return number < 0 ? NEGATIVE : POSITIVE;
    }

    private String identifyNumberWithoutTernaryOperation (int number) {
        if (number < 0) {
            return NEGATIVE;
        } else {
            return POSITIVE;
        }
    }

}
