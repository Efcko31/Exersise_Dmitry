package ru.lectures.Patterns.BehavioralPatterns.Observer;

public class NewsChannel implements ObserverInterface {
    @Override
    public void update (String news) {
        System.out.println("Новость: " + news);
    }
}
