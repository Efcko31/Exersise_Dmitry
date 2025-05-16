package ru.lectures.Patterns.BehavioralPatterns.State;

public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new ConcreteStateA());  // Начальное состояние — A

        // Цикл для демонстрации переключений
        for (int i = 0; i < 3; i++) {
            context.request();
        }
    }
}
