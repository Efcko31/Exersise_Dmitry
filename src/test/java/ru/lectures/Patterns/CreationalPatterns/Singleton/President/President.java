package ru.lectures.Patterns.CreationalPatterns.Singleton.President;

public class President {
    private static President instance;

    private President() {};// запрещает создание объекта извне

    public static President getInstance() {
        if (instance == null) {
            instance = new President();
        }
        return instance;
    }
}
