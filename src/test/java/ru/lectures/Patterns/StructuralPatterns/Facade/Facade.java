package ru.lectures.Patterns.StructuralPatterns.Facade;

public class Facade {
    // Предоставляет простой интерфейс к сложной системе.
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }

    // + Упрощает работу со сложными системами.
    // - Может стать «божественным объектом».
}
