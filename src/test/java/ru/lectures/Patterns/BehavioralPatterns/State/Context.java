package ru.lectures.Patterns.BehavioralPatterns.State;

public class Context {
    private State state;

    void setState(State state) {
        this.state = state;
        System.out.println("Текущее состояние: " + state.getClass().getSimpleName());
    }

    void request() {
        state.handle(this);  // Делегируем обработку текущему состоянию
    }
}
