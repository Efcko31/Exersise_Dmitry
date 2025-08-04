package ru.lectures.Patterns.BehavioralPatterns.Strategy.Sorts;

public class Strategy {
    //Стратегия - инкапсулирует алгоритмы в отдельные классы, делая их взаимозаменяемыми.

    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        sorter.setStrategy(new QuickSort());
        sorter.executeSort(new int[]{5, 2, 9});
    }

    // + Легко добавить новый алгоритм.
    // - Усложняет код, если стратегий мало.

}
