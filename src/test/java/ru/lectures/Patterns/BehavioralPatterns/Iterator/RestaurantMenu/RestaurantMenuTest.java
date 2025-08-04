package ru.lectures.Patterns.BehavioralPatterns.Iterator.RestaurantMenu;

import java.util.Iterator;

public class RestaurantMenuTest {
    public static void main(String[] args) {
        RestaurantMenu menu = new RestaurantMenu();
        Iterator<MenuItem> iterator = menu.createIterator();

        while(iterator.hasNext()) {
            MenuItem item = iterator.next();
            System.out.println(item.getName() + " - " + item.getPrice() + " руб.");
        }
    }
}
