package ru.lectures.Patterns.BehavioralPatterns.Iterator.RestaurantMenu;

import java.util.Iterator;

public class ArrayMenuIterator implements Iterator<MenuItem> {
    private MenuItem[] items;
    private int position = 0;

    public ArrayMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public MenuItem next() {
        if (!hasNext()) throw new RuntimeException();
        return items[position++];
    }

}
