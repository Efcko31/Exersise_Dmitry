package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility.ExampleOnRefactoringGuru;

//У пользователя существует промежуточное программное обеспечение
public class UserExistsMiddleware extends Middleware {
    private Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    @Override
    public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("Этот адрес электронной почты не зарегистрирован!");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("Неверный пароль!");
            return false;
        }
        return chekNext(email, password);
    }
}
