package ru.Interface.FunctionalInterfaceExercises.Level1.StringProcessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Function;

public class FunctionalAndOptional {
    @Test
    void test() {
        Assertions.assertEquals("OPTIONAL[IT'S WORKS?]LOOOL",
                ifStringContainsCharacterItPerformsFunction(Optional.of("it's works?"), x->x.toUpperCase() + "LOOOL"));
    }

    public String ifStringContainsCharacterItPerformsFunction(
            Optional<String> optSentence,
            Function<String, String> func) {
        return optSentence.map(func).orElse("Empty!");

    }
}
