package ru.Oop.DequeByEfcko;

import lombok.Data;


@Data
public class DequeByEfckoTypeInteger {
    private ElementDequeIntegerByEfcko<Integer> head;
    private ElementDequeIntegerByEfcko<Integer> last;
    private int size = 0;
    private final String MESSAGE = String.format("Указанный индекс выходит за размер массива: %d", size);


    public int size() {
        return size;
    }


    public boolean add(Integer data) {
        add(size(), data);
        return true;
    }

    public void add(int index, Integer data) throws IndexOutOfBoundsException { //вопрос с clone
        checkForIndexInRangeToAdd(index);
        ElementDequeIntegerByEfcko<Integer> addElement = new ElementDequeIntegerByEfcko<>(data);
        ElementDequeIntegerByEfcko<Integer> element = head;

        if (head == null || index == 0) {
            addElement.next = head;
            head = addElement;
            last = addElement;
            size++;
        } else if (index == size) {
            element.next = addElement;
            addElement.prev = element;
            last = addElement;
            size++;

        } else {
            int i = 0;
            while (i + 1 != index) {
                element = element.next;
                i++;
            }
            addElement.next = element.next;
            addElement.prev = element;
            element.next.prev = addElement;
            element.next = addElement;
            size++;
        }
    }


    public ElementDequeIntegerByEfcko<Integer> elementByEfcko(int index) { //аналог node
        checkForIndexInRangeToRemoveOrGet(index);
        ElementDequeIntegerByEfcko<Integer> element = head;
        for (int i = -1; i < index; i++) {
            if (i + 1 == index) {
                return element;
            }
            element = element.next;
        }
        return null;
    }

    public Integer get(int index) {
        checkForIndexInRangeToRemoveOrGet(index);
        ElementDequeIntegerByEfcko<Integer> element = head;
        for (int i = -1; i < index; i++) {
            if (i + 1 == index) {
                return element.data;
            }
            element = element.next;
        }
        return null;
    }

    public Integer set(int index, Integer element) {
        checkForIndexInRangeToRemoveOrGet(index);
        ElementDequeIntegerByEfcko<Integer> x = new ElementDequeIntegerByEfcko(index);
        Integer OldVal = x.getData();
        x.setData(element);
        return OldVal;
    }

    public Integer remove(int index) {
        checkForIndexInRangeToRemoveOrGet(index);
        ElementDequeIntegerByEfcko<Integer> element = head;

        if (index == 0) {
            head = element.next;
            head.prev = null;
            element.next = null;
            size--;
            return element.data;
        } else {
            int i = 0;
            while (i + 1 != index) {
                element = element.next;
                i++;
            }
            ElementDequeIntegerByEfcko<Integer> removeElement = element.next;
            element.next = removeElement.next;
            removeElement.next = null;
            size--;
            return removeElement.data;
//            for (int i = 0; i < index; i++) {
//                if (i + 1 == index) {
//                    ElementDequeIntegerByEfcko<Integer> removeElement = element.next;
//                    element.next = removeElement.next;
//                    removeElement.next = null;
//                    size--;
//                    return removeElement.data;
//                }
//                element = element.next;
//            }
        }

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
        //return numbersList;
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
        //return numbersList;
    }

    private void checkForIndexInRangeToAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(getMESSAGE());
        }
    }

    public void checkForIndexInRangeToRemoveOrGet(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(getMESSAGE());
        }
    }

    public int indexOf(Integer data) {
        int index = 0;
        if (data == null) {
            for (ElementDequeIntegerByEfcko<Integer> e = head; e != null; e = e.next) {
                if (e.data == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (ElementDequeIntegerByEfcko<Integer> e = head; e != null; e = e.next) {
                if (data.equals(e.data)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }
}
