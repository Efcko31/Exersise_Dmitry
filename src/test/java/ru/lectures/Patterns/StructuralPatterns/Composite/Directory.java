package ru.lectures.Patterns.StructuralPatterns.Composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent {
    private List<FileSystemComponent> children = new ArrayList<>();
    private String name;


    public Directory(String name) {
        this.name = name;
    }

    void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void print() {
        System.out.println("Directore "+ name);
        for (FileSystemComponent child : children) {
            child.print();
        }
    }
}
