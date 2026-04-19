package ru.myHashMapTest;

import org.junit.jupiter.api.Test;
import ru.myHashMap.MyHashMap;

import java.util.HashMap;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class myHashMapTest {
    @Test
    public void testPutAndGet() {
        assertEquals(1, putAndGet().get("one"));
        assertEquals(2, putAndGet().get("two"));
    }

    public MyHashMap<String, Integer> putAndGet() {
        MyHashMap<String, Integer> test1 = new MyHashMap<>();
        test1.put("one", 1);
        test1.put("two", 2);
        test1.put("three", 3);
        return test1;
    }

    @Test
    public void testUpdate() {
        MyHashMap<String, Integer> test1 = new MyHashMap<>();
        test1.put("key", 10);
        Integer oldValue = test1.get("key");
        test1.put("key", 20);
        assertEquals(20, test1.get("key"));
        assertEquals(10, oldValue);
    }

    @Test
    void NullKey() {
        MyHashMap<String, Integer> test1 = new MyHashMap<>();
        test1.put(null, 1);
        assertEquals(1, test1.get(null));

        test1.put(null, 200);
        assertEquals(200, test1.get(null));
    }

    @Test
    void NullValue() {
        MyHashMap<String, Integer> test1 = new MyHashMap<>();
        test1.put("key", null);
        assertEquals(null, test1.get("key"));

        test1.put("key", 200);
        assertEquals(200, test1.get("key"));
    }

    @Test
    void collisionTEst() {
        MyHashMap<BadHash, String> test1 = new MyHashMap<>();
        for(int i = 0; i < 20; i++) {
            test1.put(new BadHash(i), "value " + i);
            System.out.println("put key: " + new BadHash(i) + " and value: " + i);
            System.out.println(test1.size());
        }
        System.out.println(test1.size());

        for(int i = 0; i < 20; i++) {
            assertEquals("value " + i, test1.get(new BadHash(i)));
        }

        assertEquals(20, test1.size());
    }

    static class BadHash {
        int id;
        BadHash(int id) { this.id = id; }
        @Override
        public int hashCode() { return 42; }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof BadHash)) return false;
            return id == ((BadHash) o).id;
        }
    }

    @Test
    void removeTest() {
        MyHashMap<Integer, String> test1 = new MyHashMap<>();
        test1.put(1, "one");
        test1.put(2, "two");
        test1.put(3, "three");

        assertEquals("one", test1.remove(1));
        System.out.println(test1.size());
        assertEquals("two", test1.remove(2));
        System.out.println(test1.size());
    }

    @Test
    void testRemoveNonExistent() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("one", 1);

        assertNull(map.remove("two"));
        assertEquals(1, map.size());
    }

    @Test
    void testResize() {
        MyHashMap<Integer, Integer> map = new MyHashMap<>(4, 0.75f);

        for (int i = 0; i < 20; i++) {
            map.put(i, i * 10);
        }

        for (int i = 0; i < 20; i++) {
            assertEquals(i * 10, map.get(i));
        }

        assertEquals(20, map.size());
    }

    @Test
    void testIntegerKeys() {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(100, "one hundred");
        map.put(200, "two hundred");
        map.put(300, "three hundred");

        assertEquals("one hundred", map.get(100));
        assertEquals("two hundred", map.get(200));
    }

    @Test
    void testCustomObjectKeys() {
        MyHashMap<Person, String> map = new MyHashMap<>();
        Person alice = new Person("Alice", 25);
        Person bob = new Person("Bob", 30);

        map.put(alice, "Engineer");
        map.put(bob, "Designer");

        assertEquals("Engineer", map.get(alice));
        assertEquals("Designer", map.get(bob));
    }

    static class Person {
        String name;
        int age;
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;
            Person p = (Person) o;
            return age == p.age && Objects.equals(name, p.name);
        }
    }

    

    @Test
    void testPerformance() {
        MyHashMap<Integer, Integer> myMap = new MyHashMap<>();
        HashMap<Integer, Integer> javaMap = new HashMap<>();

        int elements = 100_000;

        // Тест вставки
        long start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            myMap.put(i, i);
        }
        long myPutTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            javaMap.put(i, i);
        }
        long javaPutTime = System.nanoTime() - start;

        System.out.println("MyHashMap put time: " + myPutTime / 1_000_000 + " ms");
        System.out.println("Java HashMap put time: " + javaPutTime / 1_000_000 + " ms");

        // Тест поиска
        start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            myMap.get(i);
        }
        long myGetTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < elements; i++) {
            javaMap.get(i);
        }
        long javaGetTime = System.nanoTime() - start;

        System.out.println("MyHashMap get time: " + myGetTime / 1_000_000 + " ms");
        System.out.println("Java HashMap get time: " + javaGetTime / 1_000_000 + " ms");
    }
}
