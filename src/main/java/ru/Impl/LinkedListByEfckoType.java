package ru.Impl;

public interface LinkedListByEfckoType <T> {
    int size();
    boolean add(T data);
    void add(int index, T data);
    ElementByEfckoGeneric<T> getElement(int index);
    T get(int index);
    T set(int index, T element);
    T remove(int index);
    int indexOf(T data);
    void checkForIndexInRange(int index);
}
