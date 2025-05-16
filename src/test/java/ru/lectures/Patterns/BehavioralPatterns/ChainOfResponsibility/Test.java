package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility;

public class Test {
    public static void main(String[] args) {

        Handler spamHandler = new SpamHandler();
        Handler complaintHandler = new ComplaintHandler();
        Handler adsHandler = new AdsHandler();

        spamHandler.setNext(complaintHandler);
        complaintHandler.setNext(adsHandler);

        spamHandler.handleRequest("Это спам!"); // Остановится на SpamHandler
        spamHandler.handleRequest("У меня жалоба на сервис"); // Остановится на ComplaintHandler
        spamHandler.handleRequest("Реклама нового продукта"); // Остановится на AdsHandler
        spamHandler.handleRequest("Обычный запрос"); // Не обработан никем
    }

}
