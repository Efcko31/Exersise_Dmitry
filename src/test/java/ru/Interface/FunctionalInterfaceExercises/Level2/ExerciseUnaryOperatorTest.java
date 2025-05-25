package ru.Interface.FunctionalInterfaceExercises.Level2;

import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

public class ExerciseUnaryOperatorTest {
    @Test
    void test() {
        removesVowelsAndRaisesUpperCase("lambda");
    }

    public void removesVowelsAndRaisesUpperCase(String word) {
        UnaryOperator<String> operator = x -> "PREFIX_"
                + x.toUpperCase().replaceAll("[AEIOU]", "");
        System.out.println(operator.apply(word));

    }
}
