package ru.lectures.Patterns.CreationalPatterns.FactoryMethod;

public class FactoryMethod {
    //Делегировать создание объектов подклассами, чтобы основной код не зависел от конкретных классов.
    public static void main(String[] args) {


        ItalianRestaurant smallItaly = new ItalianRestaurant();
        smallItaly.serveDish();

        JapaneseRestaurant sushyWood = new JapaneseRestaurant();
        sushyWood.serveDish();
    }
}
