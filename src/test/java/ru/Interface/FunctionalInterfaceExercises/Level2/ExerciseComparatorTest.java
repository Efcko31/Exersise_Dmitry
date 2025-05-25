package ru.Interface.FunctionalInterfaceExercises.Level2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ExerciseComparatorTest {
    @Test
    void test() {
        sortsListLinesLength();
    }

    public void sortsListLinesLength() {
        List<String> languageList = new ArrayList<>(List.of("Java", "Python", "C++", "Kotlin", "JavaScript"));
        Predicate<String> isMoreThreeChar = x -> x.length() >= 3;
        languageList.stream()
                .filter(isMoreThreeChar)
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
    }
}
