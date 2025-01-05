package ru.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LinkedListByEfckoTypeInteger {
    private ElementByEfckoTypeInteger head;
    private int size = 0;
    private final String MESSAGE = "Указанный индекс выходит за размер массива: %d";

    public int size() {
        return size;
    }

    public boolean add(Integer data) {
        add(size, data);
        return true;
    }

    public void add(int index, Integer data) throws IndexOutOfBoundsException {
        checkForIndexInRangeToAdd(index);
        ElementByEfckoTypeInteger addElement = new ElementByEfckoTypeInteger(data);
        ElementByEfckoTypeInteger element = head;

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

    public ElementByEfckoTypeInteger getElement(int index) {
        checkForIndexInRangeToAdd(index);
        ElementByEfckoTypeInteger element = head;
        for (int i = -1; i < index; i++) {
            if (i + 1 == index) {
                return element;
            }
            element = element.getNext();
        }
        return null;
    }

    public Integer get(int index) {
        checkForIndexInRangeToAdd(index);
        ElementByEfckoTypeInteger element = head;
        for (int i = -1; i < index; i++) {
            if (i + 1 == index) {
                return element.getData();
            }
            element = element.getNext();
        }
        return null;
    }

    public Integer set(int index, Integer element) {
        checkForIndexInRangeToAdd(index);
        ElementByEfckoTypeInteger x = getElement(index);
        Integer OldVal = x.getData();
        x.setData(element);
        return OldVal;
    }

    public Integer remove(int index) {
        checkForIndexInRangeToAdd(index);
        ElementByEfckoTypeInteger element = head;

        if (index == 0) {
            head = element.getNext();
            element.setNext(null);
            size--;
            return element.getData();
        } else {
            for (int i = 0; i < index; i++) {
                if (i + 1 == index) {
                    ElementByEfckoTypeInteger removeElement = element.getNext();
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

    public void sortNaturalOrder() {
        for (int i = 0; i < size(); i++) {
            Integer x = get(i);
            int j = i;
            while (j > 0 && get(j - 1) > x) {
                set(j, get(j - 1));
                --j;
            }
            set(j, x);
        }
    }

    public void sortReverseOrder() {
        for (int i = 0; i < size(); i++) {
            Integer x = get(i);
            int j = i;
            while (j > 0 && get(j - 1) < x) {
                set(j, get(j - 1));
                --j;
            }
            set(j, x);
        }
    }

    public int indexOf(Integer data) {
        int index = 0;
        if (data == null) {
            for (ElementByEfckoTypeInteger e = head; e != null; e = e.getNext()) {
                if (e.getData() == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (ElementByEfckoTypeInteger e = head; e != null; e = e.getNext()) {
                if (data.equals(e.getData())) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    private void checkForIndexInRangeToAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(String.format(MESSAGE, size));
        }
    }
//
//    public boolean contains(Integer data) {
//        return indexOf(data) >= 0;
//    }
//
//    public int lastIndexOf(Integer data) {
//        int index = -1;
//        int i = 0;
//        if (data == null) {
//            for (ElementByEfckoTypeInteger<Integer> e = head; e != null; e = e.next) {
//                if (e.data == null) {
//                    index = i;
//                }
//                i++;
//            }
//        } else {
//            for (ElementByEfckoTypeInteger<Integer> e = head; e != null; e = e.next) {
//                if (data.equals(e.data)) {
//                    index = i;
//                }
//                i++;
//            }
//        }
//        return index;
//    }

//    private String outOfBoundMassage(int index) {
//        return String.format("Указанный индекс: %d выходит за размер массива: %d", index, size);
//    }

    //    public boolean remove(ElementByEfcko<Integer> desiredElement) {
//        ElementByEfcko<Integer> element = head;
//
//        if (desiredElement.data.equals(element.data)) {
//            head = element.next;
//            element.next = null;
//            size--;
//            return true;
//        } else {
//            for (int i = 0; i < size; i++) {
//                if (element.next.data.equals(desiredElement.data)) {
//                    ElementByEfcko<Integer> removeElement = element.next;
//                    element.next = removeElement.next;
//                    removeElement.next = null;
//                    size--;
//                    return true;
//                }
//                element = element.next;
//            }
//        }
//        return false;
//    }

//    public boolean addAll(LinkedListByEfcko elements) { //
//        boolean modified = false;
//        LinkedListByEfcko clone = elements.clone();
//        add(clone.getHead().getData());
//        size += clone.size - 1;
//
//        return modified;
//    }

//    public LinkedListByEfcko clone() {
//        LinkedListByEfcko clone = new LinkedListByEfcko();
//        ElementByEfcko<Integer> copyElement = head;
//        ElementByEfcko<Integer> element = new ElementByEfcko<>(copyElement.data, null);
//
//
//        while (copyElement.hasNext()) {
//            clone.add(copyElement.getData());
//            copyElement = copyElement.next;
//            element = new ElementByEfcko<>(copyElement.data, null);
//        }
//        clone.add(element.data);
//        return clone;
//    }

    //    public boolean equals(LinkedListByEfcko elements) {
//        if (elements == this) {
//            return true;
//        }
//
//        ElementByEfcko<?> elem1 = new ElementByEfcko<>(null, head); //частичный принцип работы Iterator.
//        ElementByEfcko<?> elem2 = new ElementByEfcko<>(null, elements.head);
//        while (elem1.hasNext() && elem2.hasNext()) {
//            if (!(elem1.data == null ? elem2.data == null : elem1.equals(elem2))) {
//                return false;
//            }
//            elem1 = elem1.next;
//            elem2 = elem2.next;
//        }
//        return !(elem1.hasNext() || elem2.hasNext());
//    }

//        public void clear() {
//            ElementByEfcko<?> it = head;
//            ElementByEfcko<?> next = it.next;
//            head = null;
//
//            while (it.hasNext() || next.hasNext()) {
//                it.next = null;
//                it.data = null;
//                size--;
//                if (next.hasNext()) {
//                    it = next.next;
//                }
//
//                next.next = null;
//                next.data = null;
//                size--;
//                if (it.hasNext()) {
//                    next = it.next;
//                }
//            }
//
//            it.data = null;
//            next.data = null;
//            size--;
//        }

//    public boolean isEmpty() {
//        return head == null;
//    }

}
