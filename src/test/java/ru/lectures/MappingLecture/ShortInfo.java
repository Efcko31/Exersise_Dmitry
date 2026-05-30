package ru.lectures.MappingLecture;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShortInfo {
    private String firstName;
    private String lastName;
    private String patronymic;
    private BigDecimal amount;
    private String residentOf;
}
