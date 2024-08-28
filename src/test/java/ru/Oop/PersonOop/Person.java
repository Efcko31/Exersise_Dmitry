package ru.Oop.PersonOop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String fullName;
    private int age;


    void talk( String text) {
        System.out.println(fullName + " говорит: " + text);
    }

    void move(String text) {
        System.out.println(fullName + " " + text);
    }
}
