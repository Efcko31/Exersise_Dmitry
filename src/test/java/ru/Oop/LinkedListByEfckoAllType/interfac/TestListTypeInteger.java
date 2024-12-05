package ru.Oop.LinkedListByEfckoAllType.interfac;

import org.junit.jupiter.api.Test;
import ru.Oop.Animals.Animal.Animal;

public class TestListTypeInteger {

    @Test
    void testInteger(){
        LinkedListByEfckoTypeImpl<Integer> list= null;

        list.remove(2);
    }

    @Test
    void testDouble(){
        LinkedListByEfckoTypeImpl<Double> list= null;

        list.remove(2);
    }

    @Test
    void testAnimal(){
        LinkedListByEfckoTypeImpl<Animal> list= null;

        list.remove(2);
    }
}
