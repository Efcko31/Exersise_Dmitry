package ru.lectures.Patterns.BehavioralPatterns.Strategy;

public class QuickSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("Быстрая сортировка");
    }

}
