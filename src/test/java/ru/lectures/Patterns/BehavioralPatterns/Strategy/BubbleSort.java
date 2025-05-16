package ru.lectures.Patterns.BehavioralPatterns.Strategy;

public class BubbleSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("Сортировка пузырьков");

    }
}
