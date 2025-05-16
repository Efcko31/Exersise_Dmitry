package ru.lectures.Patterns.BehavioralPatterns.Strategy;

public class Sorter {
    private SortingStrategy strategy;

    void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    void executeSort(int[] array) {
        strategy.sort(array);
    }
}
