package ru.Oop.LinkedListByEfcko;

public class ListByEfckoAllType<E> {
    private LinkedListByEfckoAllType head;
    private LinkedListByEfckoAllType tail;

    public void addFront(E data) {
        LinkedListByEfckoAllType element = new LinkedListByEfckoAllType();
        element.data = data;

        if (head == null) {
            head = element;
            tail = element;
        } else {
            element.next = head;
            head = element;
        }
    }

    public void addBack(E data) {
        LinkedListByEfckoAllType element = new LinkedListByEfckoAllType();
        element.data = data;

        if (tail == null) {
            head = element;
            tail = element;
        } else {
            tail.next = element;
            tail = element;
        }
    }

    public void print() {
        LinkedListByEfckoAllType i = head;
        if (i != null) {
            while (i.next != null) {
                System.out.print(i.data + " ");
                i = i.next;
            }
            System.out.print(i.data + ";");
        }
        System.out.println("Список пуст!");
    }


    public void deleteElement(E data) {

        if (head == null) {
            System.out.println("Список пуст!");
            return;
        }

        if (data.equals(head.data)) {
            head = head.next;
        }

        LinkedListByEfckoAllType i = head;
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

}
