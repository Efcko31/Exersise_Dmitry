package ru.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

public class MyArrayListInteger<E> {

    private static final int SOFT_MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;
    private final String MESSAGE = "Указанный индекс выходит за размер массива: %d";

    private static final int DEF_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEF_EMPTY_ELEMENTDATA = {};

    transient Object[] elementData;
    private int size;

    public MyArrayListInteger(int initCap) {
        if (initCap > 0) {
            this.elementData = new Integer[initCap];
        } else if (initCap == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Неверный размер: " + initCap);
        }
    }

    public MyArrayListInteger() {
        this.elementData = DEF_EMPTY_ELEMENTDATA;
    }

    public MyArrayListInteger(Collection<? extends E> c) {
    }

    E elementData(int index) {
        return (E) elementData[index];
    }

    public void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format(MESSAGE, size));
        }
    }

    private void add(E e, Object[] elementData, int s) {
        if (elementData.length == size) {
            elementData = grow();
        }
        elementData[s] = e;
        size = s + 1;
    }

    public boolean add(E element) {
        add(element, elementData, size);
        return true;
    }

    public void add(E element, int index) {
        checkIndex(index);
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.elementData).length)
            elementData = grow();
        System.arraycopy(elementData, index, elementData, index + 1, s - index);
        elementData[index] = element;
        size = s + 1;
    }

    public E get(int index) {
        checkIndex(index);
        return elementData(index);
    }

    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    public int indexOf(Object o) {
        return indexOfRange(o, 0, size);
    }

    int indexOfRange(Object o, int start, int end) {
        Object[] es = elementData;
        if (o == null) {
            for (int i = start; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public E removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            Object[] es = elementData;
            E oldValue = (E) es[0];
            fastRemove(es, 0);
            return oldValue;

        }
    }

    public E removeLast() {
        int last = size - 1;
        if (last < 0) {
            throw new NoSuchElementException();
        } else {
            Object[] es = elementData;
            E oldValue = (E) es[last];
            fastRemove(es, last);
            return oldValue;

        }
    }

    public E remove(int index) {
        checkIndex(index);
        Object[] es = elementData;
        E oldValue = (E) es[index];
        fastRemove(es, index);
        return oldValue;

    }

    public boolean remove(Object o) {
        final Object[] es = elementData;
        final int size = this.size;
        int i = 0;
        found:
        {
            if (o == null) {
                for (; i < size; i++) {
                    if (es[i] == null)
                        break found;
                }
            } else {
                for (; i < size; i++) {
                    if (o.equals(es[i]))
                        break found;
                }
            }
            return false;
        }
        fastRemove(es, i);
        return true;
    }

    public int size() {
        return this.size;
    }

    //метод для увеличения размера массива, в случае если мы знаем,
    //что количество добавляемых элементов больше чем размер массива в целом
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elementData.length && !(elementData == DEF_EMPTY_ELEMENTDATA
                && minCapacity <= DEF_CAPACITY)) {
            grow(minCapacity);
        }
    }

    private Object[] grow(int minCap) {
        int oldCap = elementData.length;
        if (oldCap > 0 || elementData != DEF_EMPTY_ELEMENTDATA) {
            int newCapacity = newLength(oldCap, minCap - oldCap, oldCap >> 1);
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = new Object[Math.max(DEF_CAPACITY, minCap)];
        }
    }

    private Object[] grow() {
        return grow(size + 1);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        final Object[] es = elementData;
        for (int i = 0; i < size; i++) {
            es[i] = null;
        }
        size = 0;
    }

    public E set(int index, E element) {
        checkIndex(index);
        Object[] es = elementData;
        E oldValue = (E) es[index];
        elementData[index] = element;
        return oldValue;
    }

    @Override
    public String toString() {
        final Object[] es = elementData;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) sb.append(", ");
            sb.append(es[i] == null ? "null" : es[i].toString());
        }
        return sb.append("]").toString();
    }

    private static int newLength(int oldLength, int minGrowth, int prefGrowth) {
        int preferredLength = oldLength + Math.max(minGrowth, prefGrowth);
        if (0 < preferredLength && preferredLength <= SOFT_MAX_ARRAY_LENGTH) {
            return preferredLength;
        } else {
            int minLength = oldLength + minGrowth;
            if (minLength < 0) {
                throw new OutOfMemoryError("Требуемая длинна массива" + oldLength + "+" + minGrowth +
                        " слишком велика");
            } else if (minLength <= SOFT_MAX_ARRAY_LENGTH) {
                return SOFT_MAX_ARRAY_LENGTH;
            } else {
                return minLength;
            }
        }
    }

    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i) {
            System.arraycopy(es, i + 1, es, i, newSize - i);
            //метод хранится в недрах JVM. Переписывать/переделывать под свой ArrayList не стал.
        }
        es[size = newSize] = null;
    }

    public static void main(String[] args) {
    }
}
