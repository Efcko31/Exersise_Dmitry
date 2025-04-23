package ru.LinkedListByEfckoAllType.interfac;

import org.junit.jupiter.api.Test;
import ru.Impl.LinkedListByEfckoTypeImpl;
import ru.Oop.Animals.Animal.Animal;
import ru.Oop.Animals.Animal.OthersAnimals.Bear;
import ru.Oop.Animals.Animal.TheFelineFamily.Felines;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static ru.Oop.Animals.Animal.TheCanineFamily.Canines.*;
import static ru.Oop.Animals.Animal.TheFelineFamily.Felines.*;

public class ListTypeAnimalsTest {
    @Test
    void checkAddAnElementToLinkedListByEfckoTypeImpl() {
        assertArrayEquals(new String[]{"Барбариска", "Бусенка", "Барсик", "Миша", "Шарик", "Тузик"}, addElementsToArray());
    }

    public String[] addElementsToArray() {


        Bear grizzly = new Bear("Гризли",
                "Миша",
                "м",
                5,
                270,
                "Темный",
                new ArrayList<>(),
                "Дикий. На прививки реагирует аггресивно. Найден в сети ресторанов КФС.");

        LinkedListByEfckoTypeImpl<Animal> animal2024years = new LinkedListByEfckoTypeImpl<>();
        animal2024years.add(bosenka);
        animal2024years.add(barsik);
        animal2024years.add(sharic);
        animal2024years.add(tuzic);
        animal2024years.add(2, grizzly);
        animal2024years.add(0, Felines.barbarisca);

        String[] ListAnimals = new String[animal2024years.size()];

        for (int i = 0; i < animal2024years.size(); i++) {
            ListAnimals[i] = animal2024years.get(i).getName();
        }
        return ListAnimals;
    }

    @Test
    void checkReceiptAnItemFromLinkedList() {
        Animal[] animals = new Animal[]{bosenka, barsik, sharic, masya, dimka};

        assertEquals("Бусенка", getAnItemFromList(animals, 0));
        assertEquals("Дымка", getAnItemFromList(animals, 4));
        assertEquals("Шарик", getAnItemFromList(animals, 2));
        assertThrows(IndexOutOfBoundsException.class, () -> getAnItemFromList(new Animal[]{}, 12));
        assertThrows(IndexOutOfBoundsException.class, () -> getAnItemFromList(new Animal[]{}, -12));
    }

    public String getAnItemFromList(Animal[] animal, int indexGet) throws RuntimeException {

        LinkedListByEfckoTypeImpl<Animal> list1 = new LinkedListByEfckoTypeImpl<>();
        addList(list1, animal);

        return list1.get(indexGet).getName();
    }

    @Test
    void checkingReplacementAnItemInLinkedList() {
        Animal[] animals = new Animal[]{bosenka, stefa, sharic, zefir, dimka};

        assertEquals("Было: Бусенка, стало: Барбариска", replacesAnItemInListByIndex(
                animals, 0, Felines.barbarisca));
        assertEquals("Было: Стефа, стало: Гаврик", replacesAnItemInListByIndex(
                animals, 1, gavric));
        assertEquals("Было: Шарик, стало: Стиф", replacesAnItemInListByIndex(
                animals, 2, stif));
        assertEquals("Было: Зефир, стало: Шишуня", replacesAnItemInListByIndex(
                animals, 3, shishunya));
        assertEquals("Было: Дымка, стало: Барсик", replacesAnItemInListByIndex(
                animals, 4, Felines.barsik));
        assertThrows(IndexOutOfBoundsException.class, () -> replacesAnItemInListByIndex(
                animals, 12, Felines.barbarisca));
        assertThrows(IndexOutOfBoundsException.class, () -> replacesAnItemInListByIndex(
                animals, -12, Felines.barbarisca));
    }

    public String replacesAnItemInListByIndex(Animal[] animal, int indexSet, Animal animalForSet)
            throws RuntimeException {

        LinkedListByEfckoTypeImpl<Animal> list1 = new LinkedListByEfckoTypeImpl<>();
        addList(list1, animal);

        return String.format("Было: %s, стало: %s",
                list1.set(indexSet, animalForSet).getName(),
                list1.get(indexSet).getName());

    }

    @Test
    void checkingDeletionAnItemFromLinkedList() {
        Animal[] animals = new Animal[]{bosenka, stefa, sharic, zefir, dimka};

        assertArrayEquals(new String[]{"Стефа", "Шарик", "Зефир", "Дымка"}, removesAnItemFromTheListByIndex(
                animals, 0));
        assertArrayEquals(new String[]{"Бусенка", "Шарик", "Зефир", "Дымка"}, removesAnItemFromTheListByIndex(
                animals, 1));
        assertArrayEquals(new String[]{"Бусенка", "Стефа", "Зефир", "Дымка"}, removesAnItemFromTheListByIndex(
                animals, 2));
        assertArrayEquals(new String[]{"Бусенка", "Стефа", "Шарик", "Дымка"}, removesAnItemFromTheListByIndex(
                animals, 3));
        assertArrayEquals(new String[]{"Бусенка", "Стефа", "Шарик", "Зефир"}, removesAnItemFromTheListByIndex(
                animals, 4));
        assertThrows(IndexOutOfBoundsException.class, () -> removesAnItemFromTheListByIndex(animals, -12));
        assertThrows(IndexOutOfBoundsException.class, () -> removesAnItemFromTheListByIndex(animals, 12));
    }

    public String[] removesAnItemFromTheListByIndex(Animal[] animal, int indexRemove) throws RuntimeException {

        LinkedListByEfckoTypeImpl<Animal> list1 = new LinkedListByEfckoTypeImpl<>();
        addList(list1, animal);
        list1.remove(indexRemove);

        String[] animalArray = new String[list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            animalArray[i] = list1.get(i).getName();
        }

        return animalArray;

    }

    @Test
    void checkGetIndexAnElement() {
        LinkedListByEfckoTypeImpl<Animal> animals = new LinkedListByEfckoTypeImpl<>();
        animals.addAll(bosenka,stefa, sharic, shishunya, dimka);

        assertEquals(0, animals.indexOf(bosenka));
        assertEquals(1, animals.indexOf(stefa));
        assertEquals(2, animals.indexOf(sharic));
        assertEquals(3, animals.indexOf(shishunya));
        assertEquals(4, animals.indexOf(dimka));
        assertEquals(-1, animals.indexOf(gavric));
        assertEquals(-1, animals.indexOf(barsik));
    }

    public void addList(LinkedListByEfckoTypeImpl<Animal> list, Animal[] animals) {
        for (Animal n : animals) {
            list.add(n);
        }
    }
}
