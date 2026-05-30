package ru.lectures.Patterns.BehavioralPatterns.Iterator.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private List<Person> children = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public List<Person> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }
}
