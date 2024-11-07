package ru.Oop.LinkedListByEfckoAllType;

public class LinkedListByEfcko<E> {
    private ElementByEfcko<?> head;
    private int size = 0;


    public int size() {
        return size;
    }

    public boolean add(ElementByEfcko<?> element) {
        add(size(), element);
        return true;
    }

    public void add(int index, ElementByEfcko<?> addElement) throws IndexOutOfBoundsException { //вопрос с clone
        checkForIndexInRangeToAdd(index);
        ElementByEfcko<?> element = head;

        if (head == null || index == 0) {
            addElement.next = head;
            head = addElement;
            size++;
        } else {
            for (int i = 0; i < index; i++) {
                if (i + 1 == index) {
                    if (i == size - 1) {
                        element.next = addElement;
                        size++;
                    } else {
                        addElement.next = element.next;
                        element.next = addElement;
                        size++;
                    }
                }
                element = element.next;
            }
        }
    }

    public boolean addAll(LinkedListByEfcko<? extends E> elements) { //
        boolean modified = false;
        LinkedListByEfcko<?> clone = elements.clone();
        add(clone.head);
        size += clone.size - 1;

        return modified;
    }

    public ElementByEfcko<?> elementByEfcko(int index) { //аналог node
        checkForIndexInRangeToRemoveOrGet(index);
        ElementByEfcko<?> element = head;
        for (int i = -1; i < index; i++) {
            if (i + 1 == index) {
                return element;
            }
            element = element.next;
        }
        return null;
    }


    public E get(int index) {
        checkForIndexInRangeToRemoveOrGet(index);
        ElementByEfcko<?> element = head;
        for (int i = -1; i < index; i++) {
            if (i + 1 == index) {
                return (E) element.data;
            }
            element = element.next;
        }
        return (E) "Элемент не найден";
    }

    public E set(int index, E element) {
        checkForIndexInRangeToRemoveOrGet(index);
        ElementByEfcko x = elementByEfcko(index);
        E OldVal = (E) x.data;
        x.data =  element;
        return OldVal;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public E remove(int index) {
        checkForIndexInRangeToRemoveOrGet(index);
        ElementByEfcko<?> element = head;

        if (index == 0) {
            head = element.next;
            element.next = null;
            size--;
            return (E) element.data;
        } else {
            for (int i = 0; i < index; i++) {
                if (i + 1 == index) {
                    ElementByEfcko<?> removeElement = element.next;
                    element.next = removeElement.next;
                    removeElement.next = null;
                    size--;
                    return (E) element.data;
                }
                element = element.next;
            }
        }
        return (E) "Элемент не наден!";
    }

    public boolean remove(ElementByEfcko<E> desiredElement) {
        ElementByEfcko<?> element = head;

        if (desiredElement.data.equals(element.data)) {
            head = element.next;
            element.next = null;
            size--;
            return true;
        } else {
            for (int i = 0; i < size; i++) {
                if (element.next.data.equals(desiredElement.data)) {
                    ElementByEfcko<?> removeElement = element.next;
                    element.next = removeElement.next;
                    removeElement.next = null;
                    size--;
                    return true;
                }
                element = element.next;
            }
        }
        return false;
    }

    public void clear() {
        ElementByEfcko<?> it = head;
        ElementByEfcko<?> next = it.next;
        head = null;

        while (it.hasNext() || next.hasNext()) {
            it.next = null;
            it.data = null;
            size--;
            if (next.hasNext()) {
                it = next.next;
            }

            next.next = null;
            next.data = null;
            size--;
            if (it.hasNext()) {
                next = it.next;
            }
        }

        it.data = null;
        next.data = null;
        size--;
    }

    public LinkedListByEfcko<?> clone() {
        LinkedListByEfcko<?> clone = new LinkedListByEfcko<>();
        ElementByEfcko<?> copyElement = head;
        ElementByEfcko<?> element = new ElementByEfcko<>(copyElement.data, null);


        while (copyElement.hasNext()) {
        clone.add(element);
        copyElement = copyElement.next;
        element = new ElementByEfcko<>(copyElement.data, null);
        }
        clone.add(element);
        return clone;


    }

    public boolean equals(LinkedListByEfcko<?> elements) {
        if (elements == this) {
            return true;
        }
//        if (!(elements instanceof LinkedListByEfcko)) {
//            return false;
//        }

        ElementByEfcko<?> elem1 = new ElementByEfcko<>(null, head); //частичный принцип работы Iterator.
        ElementByEfcko<?> elem2 =  new ElementByEfcko<>(null, elements.head);
        while (elem1.hasNext() && elem2.hasNext()) {
            if (!(elem1.data == null ? elem2.data == null : elem1.equals(elem2))){
                return false;
            }
            elem1 = elem1.next;
            elem2 = elem2.next;
        }
        return !(elem1.hasNext() || elem2.hasNext()) ;
    }

    public boolean contains(E data) {
        return indexOf(data) >= 0;

    }

    public int indexOf(E data) {
        int index = 0;
        if (data == null) {
            for (ElementByEfcko<?> e = head; e != null; e = e.next) {
                if (e.data == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (ElementByEfcko<?> e = head; e != null; e = e.next) {
                if (data.equals(e.data)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

//    public void sort() {
//
//    }

    private void checkForIndexInRangeToAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundMassage(index));
        }
    }

    public void checkForIndexInRangeToRemoveOrGet(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundMassage(index));
        }
    }

    private String outOfBoundMassage(int index) {
        return "Указанный индекс: " + index + " выходит за размер массива: " + size;
    }
}
