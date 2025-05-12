package ru.lectures.Patterns.CreationalPatterns.Builder;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String dough;
    private String sauce;
    private List<String> toppings = new ArrayList<>();

    public void setDough(String dough) {
        this.dough = dough;
    }
    public void setSauce(String sauce) {
        this.sauce = sauce;
    }
    public void addTopping(String topping) {
        toppings.add(topping);
    }

    @Override
    public String toString() {
        return String.format("Пицца авторская\nтесто: %s;\nсоус: %s\nдобавки: %s", dough, sauce, toppings.toString());
    }
}
