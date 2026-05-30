package ru.Interface.FunctionalInterfaceExercises.Level1;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionalInterfaceExercise1 {

    @Test
    void predicateTest() {
        assertTrue(functionalInterfacePredicate(4));
        assertFalse(functionalInterfacePredicate(5));
    }
    public boolean functionalInterfacePredicate(Integer num) {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        return isEven.test(num);
    }

    @Test
    void functionalTest() {
        assertEquals(4, functionalInterfaceFunctional("book"));
        assertEquals(20, functionalInterfaceFunctional("qwertyuio pasdfghjkl"));
        assertEquals(0, functionalInterfaceFunctional(""));
    }

    public Integer functionalInterfaceFunctional(String sentence) {
        Function<String, Integer> lineLength = String::length;
        return lineLength.apply(sentence);
    }

    @Test
    void consumerAndSupplierTest() {
    functionalInterfaceConsumer("Hello Java!");
    functionalInterfaceSupplier();
    }

    public void functionalInterfaceConsumer(String sentence) {
        Consumer<String> upCaseSentence = x -> System.out.println(x.toUpperCase());
        upCaseSentence.accept(sentence);
    }

    public void functionalInterfaceSupplier() {
        Supplier<Double> randomNumb = Math::random;
        System.out.println(randomNumb.get());
    }
}
