package ru.lectures.Patterns.BehavioralPatterns.State;

public class ConcreteStateA implements State {
    @Override
    public void handle(Context context) {
        System.out.println("Обработка в состоянии A -> Переключаем на состояние B");
        context.setState(new ConcreteStateB());  // Меняем состояние!
    }
}
