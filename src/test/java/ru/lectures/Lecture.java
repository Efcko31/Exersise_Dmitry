package ru.lectures;


import org.junit.jupiter.api.Test;

import java.util.List;


public class Lecture {

    @Test
    void forEachExample() {
        List<Integer> someCollection = List.of(12314, 12313, 4, 67, 25, 747, 47, 5474, 45, 56, 6, 36, 6, 75, 567, 3, 7);
//        Collection<Integer> someCollection = List.of(12314, 12313, 4, 67, 25, 747, 47, 5474, 45, 56, 6, 36, 6, 75, 567, 3, 7);// может быть люба коллекция, но не укаждой колелеции есть метод get


        for (int i = 0; i < someCollection.size(); i++) {
            System.out.print(someCollection.get(i));
        } //первый подход
        System.out.println("");

        for (Integer i : someCollection) {
            System.out.print(i);
        } // второй подход
        System.out.println("");


        someCollection.stream().forEach(i -> System.out.print(i)); //третий подход
        // i - элеемнт списка
        //System.out.println(i) - код который выполняется над i
        System.out.println("");

        someCollection.stream().forEach(System.out::print); //подход 3.5  - reference link
        //System.out::println) -- расшифроватеся как метод 3, не работает если аргументов больше чем один
        System.out.println("");

        someCollection.forEach(System.out::print);
        someCollection.forEach(System.out::print);
        someCollection.forEach(System.out::print);

        for (int i = 0; i < someCollection.size(); i++) {
            System.out.print(someCollection.get(i) + " ");
        } //первый подход
        System.out.println("");

        for (Integer i : someCollection) {
            System.out.print(i + " ");
        } // второй подход
        System.out.println("");


        someCollection.stream().forEach(i -> System.out.print(i + " ")); //третий подход
        // i - элеемнт списка
        //System.out.println(i) - код который выполняется над i
        System.out.println("");

//        someCollection.stream().forEach(System.out::print + " "); //я не могу добавить новый аругменты
        //System.out::println) -- расшифроватеся как метод 3, не работает если аргументов больше чем один
        System.out.println("");


        //todo вывести новое число = старое + 5
        someCollection.stream().forEach(i -> {
            var newI = i + 5;
            System.out.print(newI);
        }); //третий подход


    }

    @Test
    void forFilterExample() {
        List<Integer> someCollection = List.of(12314, 12313, 4, 67, 25, 747, 47, 5474, 45, 56, 6, 36, 6, 75, 567, 3, 7);

        //todo найти элементы меньше 10, а потом их вывести на экран

        for (Integer i : someCollection) {
            if (i < 10) {
                System.out.print(i);
            }
        }
        System.out.println("");


        someCollection.stream()
                .filter(i -> i < 10)
                .forEach(System.out::print);
        System.out.println("");


        System.out.println("значения меньше 10 " + someCollection.stream()
                .anyMatch(i -> i < 10));
        System.out.println("");


        //todo превратить список из интов в стринги
        List<String> stringCollecton = someCollection.stream().map(Object::toString).toList();

        //todo сортировка
        someCollection.stream()
                .filter(i -> i < 50)
                .sorted((o1, o2) -> o1 < o2 ? 1 : 0)
                .forEach(System.out::print);
    }
}
