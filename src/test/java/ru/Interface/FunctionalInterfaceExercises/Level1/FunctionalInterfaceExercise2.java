package ru.Interface.FunctionalInterfaceExercises.Level1;

import org.junit.jupiter.api.Test;
import ru.Interface.FunctionalInterfaceExercises.Level1.StringProcessor.StringProcessor;

import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionalInterfaceExercise2 {
    @Test
    void compositionTest() {
        assertEquals("16 and 13", functionComposition(5));
    }
    public String functionComposition(Integer num) {
        Function<Integer, Integer> multiplyByTwo = x -> x * 2;
        Function<Integer, Integer> addThree = x -> x + 3;

        Function<Integer,Integer> multiplyByTwoAndAddThree = addThree.compose(multiplyByTwo);
        Function<Integer, Integer> addThreeAndMultiplyByRwo = multiplyByTwo.compose(addThree);

        return addThreeAndMultiplyByRwo.apply(num) + " and " + multiplyByTwoAndAddThree.apply(num);
    }

    @Test
    void myInterfaceTest() {
        assertEquals("qwe_rty_uio", stringProcessorTest("qwe rty uio"));
        assertEquals("q_w_e___jkfhg_vbn", stringProcessorTest("q w e   jkfhg vbn"));
    }

    public String stringProcessorTest(String sentence) {
        StringProcessor<String> str = x -> x.replaceAll(" ", "_");
        return str.process(sentence);
    }

    @Test
    void test() {
         assertEquals(8.0d, biFunctionTest(2.0d, 3.0d));
    }

    public Double biFunctionTest(Double a, Double b) {
        BiFunction<Double, Double, Double> biFunction = Math::pow;
        return biFunction.apply(a, b);
    }
}
