package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility.ExampleOnRefactoringGuru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DemoTest {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    public static void init() {
        server = new Server();
        server.registers("admin@example.com", "admin_pass");
        server.registers("user228@example.com", "user228_pass");

        Middleware middleware = Middleware.link(
                new ThrottlingMiddleware(2),
                new UserExistsMiddleware(server),
                new RoleCheckMiddleware()
        );

        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean success;
        do {
            System.out.println("Введите email: ");
            String email = reader.readLine();
            System.out.println("Введите пароль: ");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);
    }
}
