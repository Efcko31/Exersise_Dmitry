package ru.MyLinkedList.MyLinkedListString;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ElementByEfckoTypeString<E> {
    private String data;
    private ElementByEfckoTypeString<String> next;

    public ElementByEfckoTypeString(String data) {
        this.data = data;
    }

    public boolean hasNext() {
        return next != null;
    }

    @Override
    public String toString() {
        return data;
    }
}
