package ru.lectures.Patterns.CreationalPatterns.Prototype;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.Cloneable;

@Getter
@AllArgsConstructor
public class Sheep implements Cloneable {
    private String name;

    @Override
    public Sheep clone() {
        return new Sheep(this.name);
    }

}
