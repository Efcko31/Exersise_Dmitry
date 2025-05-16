package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility;

public class ComplaintHandler extends AbstractHandler {
    @Override
    public void handleRequest(String request) {
        if (request.contains("жалоба")) {
            System.out.println("Обработчик жалоб: Запрос передан менеджеру.");
        } else {
            super.handleRequest(request); // Передаём следующему
        }
    }
}