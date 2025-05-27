package ru.Interface.FunctionalInterfaceExercises.Level2;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseStreamAPI {
    @Test
    void test() {
        assertEquals("{a=5, r=2, b=2, c=1, d=1}", countsNumberCharactersInString("abracadabra"));
        assertEquals("{g=7, f=6, e=5, d=4, c=3, b=2, a=1}",
                countsNumberCharactersInString("abbcccddddeeeeeffffffggggggg"));
    }

    public String countsNumberCharactersInString(String str) {
        Map<Character, Long> numberChar = str.chars()
                .mapToObj(c -> (char) Character.toLowerCase(c))
                .collect(groupingBy(c -> c, Collectors.counting()));

        Map<Character, Long> sortedNumberChar = numberChar.entrySet().stream()
                .sorted(Map.Entry.<Character, Long> comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
        return sortedNumberChar.toString();
    }
}
