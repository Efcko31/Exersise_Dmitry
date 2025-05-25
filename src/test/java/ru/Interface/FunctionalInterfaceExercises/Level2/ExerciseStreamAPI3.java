package ru.Interface.FunctionalInterfaceExercises.Level2;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseStreamAPI3 {
    //
    @Test
    void test() {
        assertEquals("[PREFIX_HELLO, A, PREFIX_WORLD, PREFIX_JAVA, GFG, DD]",
                appliesChainsFunctionsList(List.of(" hello ", "         a ", " world ", " java ", " gfg ", " ", "dd")));
    }

    public String appliesChainsFunctionsList(List<String> listStr) {
        Function<String, String> function = s -> s.trim().length() > 3
                ? "PREFIX_" + s.trim().toUpperCase()
                : s.trim().toUpperCase();

        List<String> answer = listStr.stream().filter(s -> !s.trim().isEmpty())
                .map(function)
                .toList();
        return answer.toString();


    }
}
