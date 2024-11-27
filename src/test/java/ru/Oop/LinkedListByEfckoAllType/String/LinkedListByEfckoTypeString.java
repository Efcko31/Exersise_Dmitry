package ru.Oop.LinkedListByEfckoAllType.String;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LinkedListByEfckoTypeString {
    private ElementByEfckoTypeString<String> head;
    private int size = 0;
    private final String MESSAGE = "Указанный индекс выходит за размер массива";


    public int size() {
        return size;
    }


    public boolean add(String data) {
        add(size(), data);
        return true;
    }

    public void add(int index, String data) throws IndexOutOfBoundsException { //вопрос с clone
        checkForIndexInRangeToAdd(index);
        ElementByEfckoTypeString<String> addElement = new ElementByEfckoTypeString<>(data);
        ElementByEfckoTypeString<String> element = head;

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


    public ElementByEfckoTypeString<String> elementByEfcko(int index) { //аналог node
        checkForIndexInRangeToRemoveOrGet(index);
        ElementByEfckoTypeString<String> element = head;
        for (int i = -1; i < index; i++) {
            if (i + 1 == index) {
                return element;
            }
            element = element.next;
        }
        return null;
    }

    public String get(int index) {
        checkForIndexInRangeToRemoveOrGet(index);
        ElementByEfckoTypeString<String> element = head;
        for (int i = -1; i < index; i++) {
            if (i + 1 == index) {
                return element.data;
            }
            element = element.next;
        }
        return null;
    }

    public Object set(int index, String element) {
        checkForIndexInRangeToRemoveOrGet(index);
        ElementByEfckoTypeString<String> x = elementByEfcko(index);
        String OldVal = x.getData();
        x.setData(element);
        return OldVal;
    }

    public String remove(int index) {
        checkForIndexInRangeToRemoveOrGet(index);
        ElementByEfckoTypeString<String> element = head;

        if (index == 0) {
            head = element.next;
            element.next = null;
            size--;
            return element.data;
        } else {
            for (int i = 0; i < index; i++) {
                if (i + 1 == index) {
                    ElementByEfckoTypeString<String> removeElement = element.next;
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
    public int indexOf(String data) {
        int index = 0;
        if (data == null) {
            for (ElementByEfckoTypeString<String> e = head; e != null; e = e.next) {
                if (e.data == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (ElementByEfckoTypeString<String> e = head; e != null; e = e.next) {
                if (data.equals(e.data)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }


//    public void sort() { todo
//
//    }

    private void checkForIndexInRangeToAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(getMESSAGE());
        }
    }

    public void checkForIndexInRangeToRemoveOrGet(int index) {
        if (index < 0 || index >= size) {
            System.out.println(getMESSAGE());
            throw new IndexOutOfBoundsException();

        }
    }

//    private String outOfBoundMassage(int index) {
//        return String.format("Указанный индекс: %d выходит за размер массива: %d", index, size);
//    }

//
//    public boolean contains(String data) {
//        return indexOf(data) >= 0;
//    }
//
//    public int lastIndexOf(String data) {
//        int index = -1;
//        int i = 0;
//        if (data == null) {
//            for (ElementByEfckoTypeString<String> e = head; e != null; e = e.next) {
//                if (e.data == null) {
//                    index = i;
//                }
//                i++;
//            }
//        } else {
//            for (ElementByEfckoTypeString<String> e = head; e != null; e = e.next) {
//                if (data.equals(e.data)) {
//                    index = i;
//                }
//                i++;
//            }
//        }
//        return index;
//    }
}
