package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility.ExampleOnRefactoringGuru;

//Программное обеспечение для проверки ролей
public class RoleCheckMiddleware extends Middleware {

    @Override
    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("Привет админ!");
            return true;
        }
        System.out.println("Привет " + email + "!");
        return chekNext(email, password);
    }
}
