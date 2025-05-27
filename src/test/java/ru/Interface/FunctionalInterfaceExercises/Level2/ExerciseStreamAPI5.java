package ru.Interface.FunctionalInterfaceExercises.Level2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseStreamAPI5 {
    @Test
    void test() {
        assertEquals("the", searchForMostFrequentWordInText("The quick brown fox jumps over " +
                "the lazy dog. The dog barks, and the fox runs away!"));
    }

    public String searchForMostFrequentWordInText(String sentence) {
        Map<String, Long> wordCounter = Arrays.stream(sentence.split(" "))
                .map(w -> w.replaceAll("[^A-Za-zА-Яа-я]", "").toLowerCase())
                .collect(groupingBy(w -> w, Collectors.counting()));
        return Collections.max(wordCounter.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
