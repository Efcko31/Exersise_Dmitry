package ru.lectures.Patterns.BehavioralPatterns.ChainOfResponsibility.CheckOrder;

public abstract class OrderProcessor {
    private OrderProcessor next;

    public static OrderProcessor link(OrderProcessor first, OrderProcessor... chains) {
        OrderProcessor head = first;
        for (OrderProcessor ord : chains) {
            head.next = ord;
            head = ord;
        }
        return first;
    }
    public abstract boolean chek(Order order);

    public boolean checkNext(Order order) {
        if (next == null) {
            return true;
        }
        return next.chek(order);
    }

}
