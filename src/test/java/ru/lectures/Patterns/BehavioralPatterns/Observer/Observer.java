package ru.lectures.Patterns.BehavioralPatterns.Observer;

public class Observer {
    // Наблюдатель - Объект (Subject) уведомляет подписчиков (Observers) об изменениях своего состояния.
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        agency.observeAdd(new NewsChannel());
        agency.notifyObserver("Java 21 - БЫТЬ!");
    }

//   + Гибкость (можно добавлять/удалять подписчиков).
//   - Подписчики не знают друг о друге (может быть неочевидно, кто обрабатывает событие).


}
