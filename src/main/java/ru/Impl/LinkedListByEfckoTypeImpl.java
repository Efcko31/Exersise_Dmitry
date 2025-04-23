package ru.Impl;


public class LinkedListByEfckoTypeImpl<T> implements LinkedListByEfckoType<T> {

    private ElementByEfckoGeneric<T> head;
    private int size = 0;
    private final static String MESSAGE = "Указанный индекс выходит за размер массива: %d";

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T data) {
        add(size, data);
        return true;
    }

    @Override
    public void add(int index, T data) throws IndexOutOfBoundsException {
        checkForIndexInRange(index);
        ElementByEfckoGeneric<T> addElement = new ElementByEfckoGeneric<>(data);
        ElementByEfckoGeneric<T> element = head;

        if (head == null || index == 0) {
            addElement.setNext(head);
            head = addElement;
            size++;
        } else {
            int i = 0;
            while (i + 1 != index) {
                element = element.getNext();
                i++;
            }
            if (i == size - 1) {
                element.setNext(addElement);
                size++;
            } else {
                addElement.setNext(element.getNext());
                element.setNext(addElement);
                size++;
            }
        }
    }

    public void addAll(T... elements) {
        ElementByEfckoGeneric<T> element = head;
        int j = 0;

        if (head != null) {
            while (element.hasNext()) {
                element = element.getNext();
            }
        } else {
            head = new ElementByEfckoGeneric<>(elements[j]);
            element = head;
            j++;
        }

        for (int i = j; i < elements.length; i++) {
            element.setNext(new ElementByEfckoGeneric<>(elements[i]));
            element = element.getNext();
            size++;
        }
    }

    @Override
    public ElementByEfckoGeneric<T> getElement(int index) {
        checkForIndexInRange(index);
        ElementByEfckoGeneric<T> element = head;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                return element;
            }
            element = element.getNext();
        }
        return null;
    }

    @Override
    public T get(int index) {
        checkForIndexInRange(index);
        ElementByEfckoGeneric<T> element = head;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                return element.getData();
            }
            element = element.getNext();
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
            head = element.getNext();
            element.setNext(null);
            size--;
            return element.getData();
        } else {
            for (int i = 0; i < index; i++) {
                if (i + 1 == index) {
                    ElementByEfckoGeneric<T> removeElement = element.getNext();
                    element.setNext(removeElement.getNext());
                    removeElement.setNext(null);
                    size--;
                    return removeElement.getData();
                }
                element = element.getNext();
            }
        }
        return null;
    }

    @Override
    public int indexOf(T data) {
        int index = 0;

        for (ElementByEfckoGeneric<T> e = head; e != null; e = e.getNext()) {
            if (e.getData() == null && data == null ||
                    e.getData() != null && e.getData().equals(data)) {
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
