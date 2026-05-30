package ru.Interface.FunctionalInterfaceExercises.Level1;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CombiningPredicate {
    @Test
    void predicatesTest() {
        assertTrue(predicates("Java and Predicates"));
        assertFalse(predicates("Hello Java"));
    }
    public boolean predicates(String string) {
        Predicate<String> isNotEmpty = x -> !x.isEmpty();
        Predicate<String> itStartWithJ = x -> x.startsWith("J");

        Predicate<String> isEmptyAndItStartWithJ = isNotEmpty.and(itStartWithJ);
        return isEmptyAndItStartWithJ.test(string);
    }
}
