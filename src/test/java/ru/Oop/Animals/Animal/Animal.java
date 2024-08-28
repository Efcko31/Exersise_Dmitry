package ru.Oop.Animals.Animal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Animal {
    protected String name;
    protected String gender;
    protected Integer age;
    protected Integer weight;
    protected String color;
    protected ArrayList<String> diet;
    protected String description;

    public abstract String makeNoise();

    public abstract void eat();

    public abstract String getDescription();
}

