package ru.myHashMap;

import java.io.Serializable;
import java.util.*;

public class MyHashMap<K, V> extends AbstractMap<K, V> implements
        Map<K, V>, Cloneable, Serializable {

    //СДЕЛАНО БЕЗ TreeNode!

    static final int DEF_INITIAL_CAPACITY = 1 << 4; // ака 16
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final float DEFAULT_LOAD_FACTOR = 0.75f; // стандартный коэф увеличения.
    static final int TREEIFY_THRESHOLD = 8; // Список -> дерево
    static final int UNTREEIFY_THRESHOLD = 6; // дерево -> список
    static final int MIN_TREEIFY_CAPACITY = 64; // минимальный размер всего массива для дерева

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
    transient Set<Map.Entry<K, V>> entrySet;
    // нужен для перебора, вызывает итератор.
    transient Set<K> keySet;
    transient Collection<V> values;
    transient int size; // размер заполненных ячеек.
    transient int modCount; // количество изменений этого hashMap
    int threshold; // порог для увеличения размера (capacity * loadFactor). Capacity = 16, loadFactor = 0.75
    //тогда threshold = 12 (на 13-м бдует resize)
    final float loadFactor; //коэф загрузки (по стандарту 0.75).
    //То есть при каком заполнении объёма произойдет увеличение размера массива.

    public MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Начальная емкость меньше нуля: " + initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY) initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Неверный коэз загрузки: " + loadFactor);

        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public int size() {
        return size;
    }

    static final int hash(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Override
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> es;
        return (es = entrySet) == null ? (entrySet = new EntrySet()) : es;
    }

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K, V>[] tab;
        Node<K, V> p;
        int n;
        int i;

        if ((tab = table) == null || (n = tab.length) == 0) {
            n = (tab = resize()).length;
        }
        if ((p = tab[i = (n - 1) & hash]) == null) {
            tab[i] = newNode(hash, key, value, null);
        } else {
            Node<K, V> e;
            K k;
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) {
                //срвниваем Хэши и значиние ключа по ссылки ИЛИ по значению
                e = p;
            } else {
                for (int binCount = 0; ; ++binCount) { //проходим во всем узлам списка
                    if ((e = p.next) == null) {
                        p.next = new Node<>(hash, key, value, null);
                        // if (binCount >=TREEIFY_THRESHOLD - 1)
                        // treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) {
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null) {
                    e.value = value;
                }
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold) {
            System.out.println("Увеличиваем size до: " + size);
            resize();
        }
        afterNodeInsertion(evict);
        return null;
    }

    public V get(Object key) {
        Node<K, V> e;
        return (e = getNode(key)) == null ? null : e.value;
    }

    final Node<K, V> getNode(Object key) {
        Node<K, V>[] tab;
        Node<K, V> first, e;
        int n, hash;
        K k;

        if ((tab = table) != null && (n = tab.length) > 0 && (first = tab[(n - 1) & (hash = hash(key))]) != null) {
            if (first.hash == hash && ((k = first.key) == key || (key != null && key.equals(k)))) return first;
            if ((e = first.next) != null) {
                //if (first instanceof HashMap.TreeNode)
                //return ((HashMap.TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }

    public boolean containsKey(Object key) {
        return getNode(key) != null;
    }

    public V remove(Object key) {
        MyHashMap.Node<K, V> e;
        return (e = removeNode(hash(key), key, null, false, true)) == null ? null : e.value;
    }

    final MyHashMap.Node<K, V> removeNode(int hash, Object key, Object value, boolean matchValue, boolean movable) {
        MyHashMap.Node<K, V>[] tab;
        MyHashMap.Node<K, V> p;
        int n;
        int index;
        if ((tab = table) != null && (n = tab.length) > 0 && (p = tab[index = (n - 1) & hash]) != null) {
            MyHashMap.Node<K, V> node = null, e;
            K k;
            V v;
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) node = p;
            else if ((e = p.next) != null) {
                //if (p instanceof MyHashMap.TreeNode)
                //   node = ((MyHashMap.TreeNode<K, V>) p).getTreeNode(hash, key);
                // else {
                do {
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                        node = e;
                        break;
                    }
                    p = e;
                } while ((e = e.next) != null);
                //}
            }
            if (node != null && (!matchValue || (v = node.value) == value || (value != null && value.equals(v)))) {
                // if (node instanceof HashMap.TreeNode)
                //   ((MyHashMap.TreeNode<K, V>) node).removeTreeNode(this, tab, movable);
                /*else*/
                if (node == p) tab[index] = node.next;
                else p.next = node.next;
                ++modCount;
                --size;
                afterNodeRemoval(node);
                return node;
            }
        }
        return null;
    }

    final Node<K, V>[] resize() {
        Node<K, V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap;
        int newThr = 0;

        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                // если мы достигли максимальной емкости, то присваиваем значение максимальное для Integer
                return oldTab;
            } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap > DEF_INITIAL_CAPACITY) {
                newThr = oldThr << 1; // удваивает порог (с емкостью)
            }
        } else if (oldThr > 0) {
            newCap = oldThr;
        } else {
            newCap = DEF_INITIAL_CAPACITY;
            newThr = (int) (DEF_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        }

        if (newThr == 0) {
            float ft = (float) newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ? (int) ft : Integer.MAX_VALUE);
        }

        threshold = newThr;
        Node<K, V>[] newTab = new Node[newCap];
        table = newTab;

        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                MyHashMap.Node<K, V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null) {
                        newTab[e.hash & (newCap - 1)] = e;
                        //else if (e instanceof HashMap.TreeNode) todo Доделать с деревьями
                        //((HashMap.TreeNode<K, V>) e).split(this, newTab, j, oldCap);
                    } else { // preserve order
                        MyHashMap.Node<K, V> loHead = null, loTail = null;
                        // low - это старый связаный список, а head и tail - голова и хвост соответственно
                        MyHashMap.Node<K, V> hiHead = null, hiTail = null;
                        //hi - это НОВЫЙ связаный список. lo - остается, а hi переезжает на новый индекс.
                        MyHashMap.Node<K, V> next;
                        do { //здесь идет распределение в зависимости от ключевого бита
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null) loHead = e;
                                else loTail.next = e;
                                loTail = e;
                            } else {
                                if (hiTail == null) hiHead = e;
                                else hiTail.next = e;
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


    public void clear() {
        MyHashMap.Node<K,V>[] tab;
        modCount++;
        if ((tab = table) != null && size > 0) {
            size = 0;
            for (int i = 0; i < tab.length; ++i)
                tab[i] = null;
        }
    }
    //              *** ИТЕРАТОРЫ ***

    @Override
    public Set<K> keySet() {
        Set<K> ks = keySet;
        if (ks == null) {
            ks = new KeySet();
            keySet = ks;
        }
        return ks;
    }

    final class KeySet extends AbstractSet<K> {
        public final int size() { return size; }
        public final void clear() {MyHashMap.this.clear();}
        public final Iterator<K> iterator() {
            return new KeyIterator();
        }
        public final boolean contains(Object o) { return containsKey(o); }
        public final boolean remove(Object key) {
            return removeNode(hash(key), key, null, false, true) != null;
        }
    }

    final class KeyIterator extends HashIterator implements Iterator<K> {
        public final K next() { return nextNode().key; }
    } // ИТЕРАТОР по ключам

    final class ValueIterator extends HashIterator implements Iterator<V> {
        public final V next() { return nextNode().value; }
    }// по значениями

    final class EntryIterator extends HashIterator implements Iterator<Map.Entry<K,V>> {
        public final Map.Entry<K,V> next() { return nextNode(); }
    } // по парам

    abstract class HashIterator {
        Node<K,V> next;        // следующий элемент
        Node<K,V> current;     // текущий элемент
        int index;             // текущий индекс в таблице

        HashIterator() {
            Node<K,V>[] t = table;
            int i = 0;
            while (t != null && i < t.length && (next = t[i++]) == null);
            index = i;
        }

        public final boolean hasNext() {
            return next != null;
        }

        final Node<K,V> nextNode() {
            Node<K,V>[] t = table;
            Node<K,V> e = next;
            if (e == null)
                throw new NoSuchElementException();

            // Ищем следующий узел
            if ((next = (current = e).next) == null && t != null) {
                // Переходим к следующей непустой корзине
                while (index < t.length && (next = t[index++]) == null);
            }
            return e;
        }

        public final void remove() {
            Node<K,V> p = current;
            if (p == null)
                throw new IllegalStateException();
            current = null;
            removeNode(p.hash, p.key, null, false, false);
        }
    }

    //Вспомогательные методы...
    void afterNodeAccess(Node<K, V> p) {
    }

    void afterNodeInsertion(boolean evict) {
    }

    void afterNodeRemoval(MyHashMap.Node<K, V> p) {
    }

    //todo просто заглушка пока что
    final class EntrySet extends AbstractSet<Map.Entry<K,V>> {
        public final int size() { return size; }
        public final void clear() { MyHashMap.this.clear(); }
        public final Iterator<Map.Entry<K,V>> iterator() {
            return new EntryIterator();
        }
        public final boolean contains(Object o) {
            if (!(o instanceof Map.Entry<?, ?> e))
                return false;
            Object key = e.getKey();
            MyHashMap.Node<K,V> candidate = getNode(key);
            return candidate != null && candidate.equals(e);
        }

        public final boolean remove(Object o) {
            if (o instanceof Map.Entry<?, ?> e) {
                Object key = e.getKey();
                Object value = e.getValue();
                return removeNode(hash(key), key, value, true, true) != null;
            }
            return false;
        }

        //public final Spliterator<Map.Entry<K,V>> spliterator()

        //public final void forEach(Consumer<? super Map.Entry<K,V>> action)


    }

    MyHashMap.Node<K, V> newNode(int hash, K key, V value, MyHashMap.Node<K, V> next) {
        return new MyHashMap.Node<>(hash, key, value, next);
    }





}
