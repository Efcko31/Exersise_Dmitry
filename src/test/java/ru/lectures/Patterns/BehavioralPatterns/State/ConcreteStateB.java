package ru.lectures.Patterns.BehavioralPatterns.State;

public class ConcreteStateB implements State {
    @Override
    public void handle(Context context) {
        System.out.println("Обработка в состоянии B -> Переключаем на состояние A");
        context.setState(new ConcreteStateA());  // Меняем состояние обратно
    }
}
