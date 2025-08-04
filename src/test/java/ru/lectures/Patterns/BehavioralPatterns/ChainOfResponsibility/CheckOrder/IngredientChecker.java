package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility.CheckOrder;

import java.util.List;

public class IngredientChecker extends OrderProcessor {
    @Override
    public boolean chek(Order order) {
        List<String> warehouse = List.of("молоко", "макароны", "паста", "бекон", "картошка", "грибы");
        System.out.println("Проверка наличия ингридиентов...");

        if (warehouse.containsAll(order.getIngredients())) {
            System.out.println("Ингридиенты в наличии");
            return checkNext(order);
        }
        System.out.println("Не хватает ингридиетов!");
        return false;
    }
}
