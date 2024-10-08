package ru.Oop.LinkedListByEfcko;

import java.util.Objects;

public class ListByEfckoTypeInteger {
    private LinkedListByEfckoTypeInteger head;
    private LinkedListByEfckoTypeInteger tail;

    public void addFront(int data) {
        LinkedListByEfckoTypeInteger element = new LinkedListByEfckoTypeInteger();
        element.data = data;

        if (head == null) {
            head = element;
            tail = element;
        } else {
            element.next = head;
            head = element;
        }
    }

    public void addBack(Integer data) {
        LinkedListByEfckoTypeInteger element = new LinkedListByEfckoTypeInteger();
        element.data = data;

        if (tail == null) {
            head = element;
            tail = element;
        } else {
            tail.next = element;
            tail = element;
        }
    }

    public void deleteElementByValue(Integer data) {
        if (head == null) {
            System.out.println("Список пуст!");
            return;
        }

        if (data.equals(head.data)) {
            head = head.next;
            return;
        }

        LinkedListByEfckoTypeInteger i = head;
        while (i.next != null) {
            if (data.equals(i.next.data)) {
                if (i.next == tail) {
                    tail = i;
                }
                i.next = i.next.next;
                return;
            }
            i = i.next;
        }
    }

    public void print() {
        LinkedListByEfckoTypeInteger i = head;
        if (i != null) {
            while (i.next != null) {
                System.out.print(i.data + " ");
                i = i.next;
            }
            System.out.print(i.data + ";\n");
        } else {
            System.out.println("Список пуст!");
        }
    }

    public int getElement(Integer index) {
        LinkedListByEfckoTypeInteger i = head;
        int j = 0;
        while (i.next != null) {
            if (j == index) {
                return i.data;
            }

        }
        return -1;
    }
}
