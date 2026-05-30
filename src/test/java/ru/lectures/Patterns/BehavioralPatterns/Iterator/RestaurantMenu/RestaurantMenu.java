package ru.lectures.Patterns.BehavioralPatterns.Iterator.RestaurantMenu;

import java.util.Iterator;

public class RestaurantMenu {
    private MenuItem[] breakfastItems;

    public RestaurantMenu() {
        breakfastItems = new MenuItem[3];
        breakfastItems[0] = new MenuItem("Омлет", 180.0);
        breakfastItems[1] = new MenuItem("Блинчики", 200.0);
    }

    public Iterator<MenuItem> createIterator() {
        return new ArrayMenuIterator(breakfastItems);
    }
}
