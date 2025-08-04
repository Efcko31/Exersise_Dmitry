package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility.ExampleOnRefactoringGuru;

import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class Server {
    private Map<String, String> users = new HashMap<>();
    @Setter
    private Middleware middleware;

    public boolean logIn(String email, String password) {
        if (middleware.check(email, password)) {
            System.out.println("Авторизация прошла успешно!");
            return true;
        }
        return false;
    }
    public void registers(String email, String password) {
        users.put(email, password);
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return users.get(email).equals(password);
    }
}
