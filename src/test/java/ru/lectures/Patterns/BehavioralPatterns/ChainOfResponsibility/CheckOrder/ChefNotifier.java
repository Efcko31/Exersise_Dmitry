package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility.CheckOrder;

public class ChefNotifier extends OrderProcessor {
    @Override
    public boolean chek(Order order) {
        System.out.println("Все отлично! Заказ передан повару");
        return checkNext(order);
    }
}
