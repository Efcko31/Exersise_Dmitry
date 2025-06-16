package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex16Students {
    //Для каждого студента найти количество уникальных курсов.
    @Test
    void test() {
        findsTheNumberOfUniqueCourses( Arrays.asList(
                new StudentForEx16("S1", "Math"),
                new StudentForEx16("S1", "Physics"),
                new StudentForEx16("S2", "Math"),
                new StudentForEx16("S1", "Math") // Дубликат
        ));
    }

    public void findsTheNumberOfUniqueCourses(List<StudentForEx16> enrollments) {
        Map<String, Integer> answer = enrollments.stream()
                .collect(Collectors.groupingBy(
                        StudentForEx16::getStudentId,
                        Collectors.mapping(
                                StudentForEx16::getCurseName,
                                Collectors.toSet())))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, c -> c.getValue().size()));
        System.out.println(answer);

    }
}
