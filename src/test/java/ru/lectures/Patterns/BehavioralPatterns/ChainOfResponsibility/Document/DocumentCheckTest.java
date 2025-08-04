package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility.Document;

public class DocumentCheckTest {
    public static void main(String[] args) {
        MiddlewareForDoc validator = MiddlewareForDoc.link(
                new SpellChecker(),
                new PlagiarismChecker(),
                new FormatChecker()
        );

        validator.check(new Document("Проверка на плагиат", "PDF"));
        validator.check(new Document("Текст для полного прохождения", "DOC"));
        validator.check(new Document("Тест неверный формат", "JPG"));
        validator.check(new Document("Тест на спец символы?!ю.", "PDF"));
        validator.check(new Document("Т9ест на цифры девять 9", "PDF"));
    }
}
