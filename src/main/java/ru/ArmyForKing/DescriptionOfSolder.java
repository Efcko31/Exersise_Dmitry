package ru.ArmyForKing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DescriptionOfSolder {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String company;
    private String post;
    private String equipment;
}


