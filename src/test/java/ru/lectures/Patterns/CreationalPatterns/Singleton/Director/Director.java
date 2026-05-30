package ru.lectures.Patterns.CreationalPatterns.Singleton.Director;

public class Director {
    private static Director instance;

    private Director() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized");
        }
    }

    public static Director getInstance() {
        if (instance == null) {
            instance = new Director();
        }
        return instance;
    }

    public void checkShop(String shopName) {
        System.out.println("Checking shop: " + shopName);
    }
}
