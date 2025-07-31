package ru.lectures.Patterns.CreationalPatterns.FactoryMethod.ItalianRestaurant;

public class FactoryMethod {
    //Делегировать создание объектов подклассами, чтобы основной код не зависел от конкретных классов.
    public static void main(String[] args) {


        ItalianRestaurant smallItaly = new ItalianRestaurant();
        smallItaly.serveDish();

        JapaneseRestaurant sushiWood = new JapaneseRestaurant();
        sushiWood.serveDish();
    }
}
