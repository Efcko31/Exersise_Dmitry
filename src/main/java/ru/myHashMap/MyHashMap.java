package ru.myHashMap;

import java.io.Serializable;
import java.util.*;

public class MyHashMap<K, V> extends AbstractMap<K, V>
        implements Map<K, V>, Cloneable, Serializable {

    static final int DEF_INITIAL_CAPACITY = 1 << 4; // ака 16
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final float DEFAULT_LOAD_FACTOR = 0.75f; // стандартный коэф увеличения.
    static final int TREEIFY_THRESHOLD = 8; // Список -> дерево
    static final int UNTREEIFY_THRESHOLD = 6; // дерево -> список
    static final int MIN_TREEIFY_CAPACITY = 64; // минимальный размер всего массива для дерева

    public MyHashMap(float loadFactor) {
        this.loadFactor = loadFactor;
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public static void main(String[] args) {
            HashMap<Integer, String> map = new HashMap<>();
            map.put(1, "one");
            map.put(2, "two");
            map.put(3, "three");
            String key = "Hello";
            int h;
            System.out.print("key: " + key + "; key.hashCode = ");
            System.out.println(key.hashCode());

            System.out.print("h >>> 16: ");
            System.out.println(key.hashCode() >>> 16);

            System.out.print("hash(Object key) = (h) ^ (h >>> 16) = ");
            System.out.println((h = key.hashCode()) ^ (h >>> 16));

        }
    }

    //все transient потому что не надо сериализовывать это дело.
    transient Node<K, V>[] table; // Физическое хранилище данных. Размер - степень двойки.
    transient Set<Map.Entry<K, V>> entrySet; // нужен для перебора, вызывает итератор.
    transient int size; // размер заполненных ячеек.
    transient int modCount; // количество изменений этого hashMap
    int threshold; // порог для увеличения размера (capacity * loadFactor). Capacity = 16, loadFactor = 0.75
    //тогда threshold = 12 (на 13-м бдует resize)
    final float loadFactor; //коэф загрузки (по стандарту 0.75).
    //То есть при каком заполнении объёма произойдет увеличение размера массива.

    static final int hash(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return Set.of();
    }

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K, V>[] tab;
        Node<K, V> p;
        int n;
        int i;

        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if((p = tab[i = (n - 1) & hash]) == null)
    }

    final Node<K, V>[] resize() {
        Node<K, V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap = 0;
        int newThr = 0;

        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                // если мы достигли максимальной емкости, то присваиваем значение максимальное для Integer
                return oldTab;
            } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap > DEF_INITIAL_CAPACITY) {
                newThr = oldThr << 1; // удваивает порог (с емкостью)
            } else if (oldThr > 0) {
                newCap = oldThr;
            } else {
                newCap = DEF_INITIAL_CAPACITY;
                newThr = (int) (DEF_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
            }
        }

        if (newThr == 0) {
            float ft = (float) newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ?
                    (int) ft : Integer.MAX_VALUE);
        }

        threshold = newThr;
        Node<K, V>[] newTab = new Node[newCap];
        table = newTab;

        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                MyHashMap.Node<K, V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    //else if (e instanceof HashMap.TreeNode) todo Доделать с деревьями
                        //((HashMap.TreeNode<K, V>) e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        MyHashMap.Node<K, V> loHead = null, loTail = null;
                        // low - это старый связаный список, а head и tail - голова и хвост соответственно
                        MyHashMap.Node<K, V> hiHead = null, hiTail = null;
                        //hi - это НОВЫЙ связаный список. lo - остается, а hi переезжает на новый индекс.
                        MyHashMap.Node<K, V> next;
                        do { //здесь идет распределение в зависимости от ключевого бита
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            } else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) { // подчищаем хвосты (обрезаем)
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) { // подчищаем хвосты (обрезаем)
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }
}
