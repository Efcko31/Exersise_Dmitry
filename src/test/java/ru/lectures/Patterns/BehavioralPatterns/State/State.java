package ru.lectures.Patterns.BehavioralPatterns.State;

public interface State {
    // Состояние - позволяет объекту менять поведение при изменении внутреннего состояния.
    void handle(Context context);



}
