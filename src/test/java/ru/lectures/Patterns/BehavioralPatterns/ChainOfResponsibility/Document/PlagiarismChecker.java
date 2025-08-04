package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility.Document;

public class PlagiarismChecker extends MiddlewareForDoc {
    @Override
    public boolean check(Document document) {
        String textForExamplePlagiarismChecker = "Проверка на плагиат";
        if (document.getText().equalsIgnoreCase(textForExamplePlagiarismChecker)) {
            System.out.println("Плагиат не пройден!");
            return false;
        }
        return checkNext(document);
    }
}
