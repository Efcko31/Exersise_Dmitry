package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility.Document;

public class FormatChecker extends MiddlewareForDoc {
    @Override
    public boolean check(Document document) {
        if (document.getFormat().equals("PDF") || document.getFormat().equals("DOC")) {
            System.out.println("Все проверки пройдены, так держать!");
            return checkNext(document);
        }
        System.out.println("Неверный формат документа!");
        return false;
    }
}
