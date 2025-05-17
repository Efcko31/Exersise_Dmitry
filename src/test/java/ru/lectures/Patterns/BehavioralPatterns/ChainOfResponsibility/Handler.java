package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility;

public interface Handler {
    void handleRequest(String request);
    void setNext(Handler next);
}
