package ru.Interface.FunctionalInterfaceExercises.Level2.TriFunction;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseOptionalPlusStreamAPI {
    @Test
    void test() {
        assertEquals("No words found", searchesForLongestWordInList(List.of()));
        assertEquals("Optional[elephant]",
                searchesForLongestWordInList(List.of("cat", "elephant", "dog", "dragon", "fox")));
    }
    public String searchesForLongestWordInList(List<String> words) {

        Optional<String> answer = words.stream().max(Comparator.comparingInt(String::length));

        return answer.isPresent() ? answer.toString() : "No words found";
    }
}
