package ru.lectures.Patterns.CreationalPatterns.Builder.Pizza;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    @Setter
    private String dough;
    @Setter
    private String sauce;
    private List<String> toppings = new ArrayList<>();

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    @Override
    public String toString() {
        return String.format("Пицца авторская\nтесто: %s;\nсоус: %s\nдобавки: %s", dough, sauce, toppings.toString());
    }
}
