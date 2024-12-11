package ru.Oop.LinkedListByEfckoAllType.interfac;

import java.util.Stack;

public class LinkedListByEfckoTypeImpl<T> implements LinkedListByEfckoType<T> {

    private ElementByEfckoGeneric<T> head;
    private int size = 0;
    private final String MESSAGE = "Указанный индекс выходит за размер массива: %d"; // шаблон сообщения который можно переиспользовать

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T data) {
        add(size(), data);
        return true;
    }

    @Override
    public void add(int index, T data) throws IndexOutOfBoundsException {
        checkForIndexInRange(index);
        ElementByEfckoGeneric<T> addElement = new ElementByEfckoGeneric<>(data);
        ElementByEfckoGeneric<T> element = head;

        if (head == null || index == 0) {
            addElement.next = head;
            head = addElement;
            size++;
        } else {
            int i = 0;
            while (i + 1 != index) {
                element = element.next;
                i++;
            }
            if (i == size - 1) {
                element.next = addElement;
                size++;
            } else {
                addElement.next = element.next;
                element.next = addElement;
                size++;
            }
        }
    }

    public void addAll(T...  elements) {
        for (T element : elements) {
            add(element);
        }
    }

    @Override
    public ElementByEfckoGeneric<T> getElement(int index) {
        checkForIndexInRange(index);
        ElementByEfckoGeneric<T> element = head;
        for (int i = -1; i < index; i++) {
            if (i + 1 == index) {
                return element;
            }
            element = element.next;
        }
        return null;
    }

    @Override
    public T get(int index) {
        checkForIndexInRange(index);
        ElementByEfckoGeneric<T> element = head;
        for (int i = -1; i < index; i++) {
            if (i + 1 == index) {
                return element.data;
            }
            element = element.next;
        }
        return null;
    }

    @Override
    public T set(int index, T element) {
        checkForIndexInRange(index);
        ElementByEfckoGeneric<T> x = getElement(index);
        T OldVal = x.getData();
        x.setData(element);
        return OldVal;
    }

    @Override
    public T remove(int index) {
        checkForIndexInRange(index);
        ElementByEfckoGeneric<T> element = head;

        if (index == 0) {
            head = element.next;
            element.next = null;
            size--;
            return element.data;
        } else {
            for (int i = 0; i < index; i++) {
                if (i + 1 == index) {
                    ElementByEfckoGeneric<T> removeElement = element.next;
                    element.next = removeElement.next;
                    removeElement.next = null;
                    size--;
                    return removeElement.data;
                }
                element = element.next;
            }
        }
        return null;
    }

    @Override
    public int indexOf(T data) {
        int index = 0;

        for (ElementByEfckoGeneric<T> e = head; e != null; e = e.next) {
            if (e.data == null && data == null ||
                    e.data != null && e.data.equals(data)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public void checkForIndexInRange(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(String.format(MESSAGE, size));
        }
    }
}
