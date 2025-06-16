package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex4 {
    //Дан список строк. Необходимо сгруппировать их по длине и вывести количество строк
    // в каждой группе.
    @Test
    void test() {
        groupsWordsByTheirLength(Arrays.asList("apple", "banana", "kiwi", "orange", "pear"));
    }

    public void groupsWordsByTheirLength(List<String> words) {
        System.out.println(words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting())));
    }
}
