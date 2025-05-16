package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility;

public class AdsHandler extends AbstractHandler {
    @Override
    public void handleRequest(String request) {
        if (request.contains("реклама")) {
            System.out.println("Рекламный фильтр: Перенаправлено в маркетинг.");
        } else {
            super.handleRequest(request);
        }
    }
}
