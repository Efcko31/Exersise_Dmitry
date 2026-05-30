package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility.Document;

import ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility.ExampleOnRefactoringGuru.Middleware;

public abstract class MiddlewareForDoc {
    private MiddlewareForDoc next;

    public static MiddlewareForDoc link(MiddlewareForDoc first, MiddlewareForDoc... chain) {
        MiddlewareForDoc head = first;
        for (MiddlewareForDoc nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;

        }
        return first;
    }

    public abstract boolean check(Document document);

    public boolean checkNext (Document document) {
        if (next == null) {
            return true;
        }
        return next.check(document);
    }

}
