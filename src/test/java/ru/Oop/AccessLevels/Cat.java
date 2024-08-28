package ru.Oop.AccessLevels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat {
    protected String name;

    public static void main(String[] args) {
        TestAccessLevels.example11();
        TestAccessLevels.example12();
        TestAccessLevels.example13();

    }
}
