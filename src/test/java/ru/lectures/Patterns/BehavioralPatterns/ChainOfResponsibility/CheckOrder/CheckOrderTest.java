package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility.CheckOrder;

import java.util.List;

public class CheckOrderTest {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = OrderProcessor.link(new IngredientChecker(), new BudgetChecker(), new ChefNotifier());
        orderProcessor.chek(new Order("Паста Карбонара", 3500, List.of("паста", "бекон")));
        System.out.println("-----------------------------------------------------");
        orderProcessor.chek(new Order("Картошка с грибами", 3500, List.of("картошка", "грибы", "масло")));
        System.out.println("-----------------------------------------------------");
        orderProcessor.chek(new Order("Молоко с трюфелями", 5500, List.of("молоко", "грибы")));

    }
}
