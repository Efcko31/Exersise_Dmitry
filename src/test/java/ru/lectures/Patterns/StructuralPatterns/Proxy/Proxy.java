package ru.lectures.Patterns.StructuralPatterns.Proxy;

public class Proxy {
    // Контролирует доступ к объекту, добавляя дополнительную логику (ленивая загрузка, кеширование).
    public static void main(String[] args) {
        Image image = new ProxyImage("photo.jpg");
        image.display(); //Загрузка. Показ
        image.display(); //Просто показ

        // + Контроль доступа к объекту.
        // - Увеличивает время отклика.
    }
}
