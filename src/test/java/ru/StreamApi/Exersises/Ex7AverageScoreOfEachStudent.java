package ru.StreamApi.Exersises;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex7AverageScoreOfEachStudent {
    //Дан список студентов, где каждый студент имеет имя (name) и список оценок (grades).
    //Необходимо найти средний балл каждого студента и вывести имя студента и его средний балл.
    @Test
    void test() {
        assertEquals("Alice", findsTheAverageScoreOfEachStudent(Arrays.asList(
                new StudentsForEx7("Alice", Arrays.asList(85, 90, 78)),
                new StudentsForEx7("Bob", Arrays.asList(75, 80, 92)),
                new StudentsForEx7("Charlie", Arrays.asList(88, 84, 90)))).getFirst().getName());
    }

    public List<DTOForEx7> findsTheAverageScoreOfEachStudent(List<StudentsForEx7> students) {
        return  students.stream()
                .map(s -> Ex7Mapper.INSTACE.toDTOForEx7(s,
                        s.getGrades().stream()
                                .mapToDouble(n -> n)
                                .average()
                                .orElse(0.0d)))
               .toList();

    }
}
