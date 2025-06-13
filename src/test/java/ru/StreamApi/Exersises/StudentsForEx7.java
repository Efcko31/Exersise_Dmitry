package ru.StreamApi.Exersises;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentsForEx7 {
    private String name;
    private List<Integer> grades;
}
