package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility.CheckOrder;

public class BudgetChecker extends OrderProcessor {
    @Override
    public boolean chek(Order order) {
        System.out.println("Проверка суммы заказа...");

        if (order.getPrice() > 5000) {
            System.out.println("Требуется предоплата!");
            return false;
        }
        System.out.println("Все ок!");
        return checkNext(order);

    }
}
