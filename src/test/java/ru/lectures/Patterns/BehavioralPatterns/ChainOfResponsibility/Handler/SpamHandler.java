package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility.Handler;

public class SpamHandler extends AbstractHandler {
    @Override
    public void handleRequest(String request) {
        if (request.contains("спам")) {
            System.out.println("Спам-фильтр: Запрос заблокирован.");
        } else {
            super.handleRequest(request); // Передаём следующему
        }
    }
}