package ru.lectures.Patterns.BehavioralPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency {
    private List<ObserverInterface> observers = new ArrayList<>();

    public void observeAdd (ObserverInterface observer) {
        observers.add(observer);
    }

    public void notifyObserver(String news) {
        observers.forEach(observerInterface -> observerInterface.update(news));
    }
}
