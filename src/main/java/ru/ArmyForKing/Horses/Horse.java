package ru.ArmyForKing.Horses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Horse {
    private String name;
    private String gender;
    private Integer age;
}
