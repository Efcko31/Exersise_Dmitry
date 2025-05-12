package ru.lectures.Patterns.CreationalPatterns.Prototype;

public class Prototype {
    public static void main(String[] args) {
        Sheep original = new Sheep("Долли");
        Sheep clone = original.clone();
        System.out.printf("Оригинал: %s\nКопия: %s", original.getName(), clone.getName());
    }
}
