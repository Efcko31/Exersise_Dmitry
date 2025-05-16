package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility;

abstract class AbstractHandler implements Handler{
    private Handler next;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(String request) {
        if (next != null) {
            next.handleRequest(request); // Передаём запрос дальше
        } else {
            System.out.println("Запрос не обработан: " + request); // Конец цепочки
        }
    }
}
