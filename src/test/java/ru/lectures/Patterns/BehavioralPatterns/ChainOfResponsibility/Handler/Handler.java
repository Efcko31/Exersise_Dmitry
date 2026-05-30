package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility.Handler;

public interface Handler {
    void handleRequest(String request);
    void setNext(Handler next);
}
